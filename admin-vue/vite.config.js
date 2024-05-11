import {fileURLToPath, URL} from 'node:url'

import {defineConfig} from 'vite'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import ElementPlus from 'unplugin-element-plus/vite'
import Icons from 'unplugin-icons/vite'
import IconsResolver from 'unplugin-icons/resolver'
import Vue from '@vitejs/plugin-vue'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        Vue(),
        // 按需导入，自动导入
        AutoImport({
            // 自动导入 Vue 相关函数，如：ref, reactive, toRef 等
            imports: ['vue'],
            // 自动导入 Element Plus 相关函数，如：ElMessage, ElMessageBox... (带样式)
            resolvers: [
                ElementPlusResolver(),
                // 自动导入图标组件
                IconsResolver({
                    prefix: 'Icon',
                })
            ],
        }),
        Components({
            resolvers: [
                // 自动注册图标组件
                IconsResolver({
                    // 前缀（经测试，该选项无作用，图标依然只能通过 i-ep-xxx 调用）
                    // <el-icon><Lock /></el-icon>  这样按需引入的话，这种形式的el-icon code就用不了了
                    // 只能 <el-icon><i-ep-lock /></el-icon>
                    enabledCollections: ['ep'],
                }),
                // 自动导入 Element Plus 组件
                ElementPlusResolver({
                    importStyle: 'sass'
                })
            ],
        }),
        Icons({
            autoInstall: true,
        }),
        // 手动导入 el 组件，会自动添加对应的 css
        // 替换默认语言
        ElementPlus({
            defaultLocale: 'zh-cn',
            useSource: true
        }),
    ],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url))
        }
    },
    server: {
        port: 3000,
        proxy: {
            '/api': {
                target: 'http://localhost:8080/',
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, '')
            }
        },
    },
})
