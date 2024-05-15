import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

import App from './App.vue'
import router from './router'
import './router/permission.js'
import SvgIcon from './components/SvgIcon'
import 'virtual:svg-icons-register'


const app = createApp(App)
const pinia =createPinia()
pinia.use(piniaPluginPersistedstate)
app.use(pinia)
app.use(router)
app.component('svg-icon', SvgIcon)

app.mount('#app')
