import router from "@/router/index.js";
import useMenuStore from "@/stores/menu.js";
import Layout from "@/layouts/Index.vue";

// const whitelisted = ['/404', '/error']

let routeList

router.beforeEach((to, from, next) => {
    if (!routeList) {
        const menuStore = useMenuStore()
        routeList = menuStore.getRouteList()
        if (routeList?.length) {
            router.addRoute(
                {
                    component: Layout,
                    path: "/",
                    children: routeList
                }
            )
            next(to)
        }
    } else {
        // if (!to.matched.length) {
        //     next({path: '/404'})
        // }
    }
    next()
})
router.afterEach((to, from)=>{
    if(to.name?.length && to.path?.length) {
        const menuStore = useMenuStore()
        menuStore.addTab(to.name)
    }
})