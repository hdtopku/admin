import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: '首页',
            component: () => import('@/layouts/Index.vue'),
            children: [
                {
                    path: '/index',
                    component: () => import('@/views/index.vue'),
                }
            ]
        },
        {
            path: '/login',
            name: '登录',
            component: () => import('@/views/login.vue')
        }
    ]
})

export default router
