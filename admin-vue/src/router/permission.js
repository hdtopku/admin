import router from "@/router/index.js";
import useMenuStore from "@/stores/menu.js";
import Layout from "@/layouts/Index.vue";
import {getToken} from "@/utils/auth/index.js"
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

const whiteList = ['/login', '/404', '/error']

let routeList

router.beforeEach((to, from, next) => {
    if (whiteList.indexOf(to.path) !== -1) {
        next()
        return
    }
    const menuStore = useMenuStore()
    menuStore.lastPage=to.path
    if(!getToken()?.length) {
        next(`/login`)
        return
    }
    NProgress.start()
    if (!routeList) {
        routeList = menuStore.getRouteList()
        if (routeList?.length) {
            router.addRoute(
                {
                    component: Layout,
                    path: "/",
                    name: "Layout",
                    children: routeList
                }
            )
            next(to)
            return
        }
    }
    next()
})
router.afterEach((to, from) => {
    NProgress.done()
    const menuStore = useMenuStore()
    if (to.name?.length && to.path?.length) {
        menuStore.addTab(to.name)
    }
    if(to.path?.length) {
        menuStore.setBreadcrumbList(to.path)
    }
})