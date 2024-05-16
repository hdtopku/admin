import {ref} from 'vue'
import {defineStore} from 'pinia'
import router from "@/router/index.js";

const modules = import.meta.glob('../views/**/*.vue')

const useMenuStore = defineStore('menu', () => {
    const menuList = ref([])
    const routeList = ref([])
    const tabList = ref([])
    const activeTab = ref('')
    const breadcrumbList = ref([])
    const sortTab = ref(true)
    const lastPage = ref('/')
    const setMenuList = (list) => {
        menuList.value = list
        getRouteList()
    }
    const getRouteList = () => {
        routeList.value = []
        const dfs = (menuList) => {
            menuList.forEach(item => {
                if (item.path?.length && item.menuType === 1) {
                    const component = item.path.split('/').filter(i => i.length > 0).join('/')
                    let routerInfo = {
                        name: item.menuName,
                        path: item.path,
                        meta: {title: item.menuName, keepAlive: item.keepAlive},
                        // 设置组件
                        component: modules[`../views/${component}.vue`]
                    }
                    routeList.value.push(routerInfo)
                }
                item.children?.length && dfs(item.children)
            })
        }
        dfs(menuList.value)
        return routeList.value
    }

    const addTab = (tabName) => {
        const routeIdx = routeList.value.findIndex(item => item.name === tabName)
        if (routeIdx === -1) return
        const tabPath = routeList.value[routeIdx].path
        const idx = tabList.value.findIndex(item => item.name === tabName)
        if (idx > -1) {
            if(sortTab.value) {
                tabList.value.splice(idx, 1)
                tabList.value.unshift({label: tabName, name: tabName, key: tabPath})
            }
        } else {
            tabList.value.unshift({label: tabName, name: tabName, key: tabPath})
        }
        sortTab.value=true
        while (tabList.value.length > 4) {
            tabList.value.pop()
        }
        activeTab.value = tabName
    }
    const removeTab = (tabName) => {
        const idx = tabList.value.findIndex((item) => item.name === tabName)
        if (idx > -1) {
            if (tabList.value[idx].name === activeTab.value) {
                if (idx === 0) activeTab.value = tabList.value[idx + 1].name
                else if (idx > 0) activeTab.value = tabList.value[idx - 1].name
                else activeTab.value = tabList.value[idx].name
            }
            sortTab.value = false
            const routIdx = routeList.value.findIndex((item) => item.name === activeTab.value)
            router.push(routeList.value[routIdx].path)
            tabList.value.splice(idx, 1)
        }
    }

    const setBreadcrumbList = (path) => {
        const breadcrumbMap = new Map()
        const dfs = (menuList, menuNameList) => {
            menuList.forEach(item => {
                menuNameList.push(item.menuName)
                breadcrumbMap.set(item.path, [...menuNameList])
                item.children?.length && dfs(item.children, menuNameList)
                menuNameList.pop()
            })
        }
        dfs(menuList.value, [])
        breadcrumbList.value.length = 0
        breadcrumbList.value.push(...(breadcrumbMap.get(path) || []))
    }
    return {
        menuList,
        setMenuList,
        routeList,
        getRouteList,
        tabList,
        addTab,
        removeTab,
        activeTab,
        breadcrumbList,
        setBreadcrumbList,
        sortTab,
        lastPage,
    }
    }, {persist: {storage: localStorage}}
)
export default useMenuStore