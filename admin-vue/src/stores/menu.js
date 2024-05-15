import {ref} from 'vue'
import {defineStore} from 'pinia'
const modules = import.meta.glob('../views/**/*.vue')

const useMenuStore = defineStore('menu', () => {
        const menuList = ref([])
        const routeList = ref([])
        const tabList = ref([])
        const activeTab = ref('')

        const setMenuList = (list) => {
            menuList.value = list
            getRouteList()
        }
        const getRouteList = () => {
            routeList.value = []
            dfs(menuList.value)
            return routeList.value
        }
        const dfs = (menuList) => {
            menuList.forEach(item => {
                if (item.path?.length && item.menuType === 1) {
                    let routerInfo = {
                        name: item.menuName,
                        path: item.path,
                        meta: {title: item.menuName},
                        // 设置组件
                        component: modules[`../views${item.path}.vue`]
                    }
                    routeList.value.push(routerInfo)
                }
                item.children?.length && dfs(item.children)
            })
        }
        const addTab = (tabName) => {
            const routeIdx = routeList.value.findIndex(item=>item.name===tabName)
            if(routeIdx===-1) return
            const tabPath = routeList.value[routeIdx].path
            const idx=tabList.value.findIndex(item=>item.name===tabName)
            if(idx>-1) tabList.value.splice(idx,1)
            tabList.value.unshift({label:tabName,name:tabName, key: tabPath})
            while(tabList.value.length>4) {
                tabList.value.pop()
            }
            activeTab.value=tabName
        }
        const removeTab = (tabName) => {
            const idx = tabList.value.findIndex((item)=>item.name===tabName)
            if (idx > -1) {
                if(tabList.value[idx].name===activeTab.value) {
                    if(idx===0) activeTab.value=tabList.value[idx+1].name
                    else if (idx > 0) activeTab.value = tabList.value[idx - 1].name
                    else activeTab.value = tabList.value[idx].name
                }
                tabList.value.splice(idx, 1)
            }
        }
        return {
            menuList,
            setMenuList,
            routeList,
            getRouteList,
            tabList,
            addTab,
            removeTab,
            activeTab
        }
    }, {
        persist:
            {
                storage: localStorage
            }
    }
)
export default useMenuStore