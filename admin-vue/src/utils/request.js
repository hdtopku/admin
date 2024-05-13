import axios from 'axios'
import {ElMessage} from "element-plus";
import router from '@/router'
import {getToken, removeToken} from "@/utils/auth";

const request = axios.create({
    baseURL: import.meta.env.VITE_APP_API_URL,
    withCredentials: false,
    timeout: 6000,
    headers: {
        'Content-Type': 'application/json;charset=utf-8',
    }
})
request.interceptors.request.use(
    config => {
        const token = getToken("token")
        token && (config.headers['Authorization'] = token)
        return config
    },
    error => {
        return Promise.reject(new Error(error.message))
    }
)
request.interceptors.response.use(
    response => {
        let {msg, data, code} = response.data;
        if (code === 200) {
            return data;
        } else if (code===500) {
            ElMessage.error(msg)
        } else if (code === 401) {
            ElMessage.error("请先登录")
            window.sessionStorage.clear()
            router.push('/login')
        } else if (code===403) {
            ElMessage.error("权限不足")
        } else {
            ElMessage.error(`服务异常：${msg}`)
        }
        return Promise.reject(new Error(msg))
    },
    error => {
        if (error.message.includes("401")) {
            removeToken("token")
            ElMessage.error("请先登录")
        } else if (error.message.includes("403")) {
            ElMessage.error("权限不足")
        } else if (error.message.includes("500")) {
            ElMessage.error("服务异常，请稍后再试")
        } else if (error.message.includes('timeout')) {
            ElMessage.error('请求超时，请稍后再试')
        } else if (error.message.includes('Network Error')) {
            ElMessage.error('网络连接错误，请检查网络连接')
        } else if (error.message.includes('Request failed with status code')) {
            ElMessage.error(`服务异常：${error.message}`)
        } else {
            ElMessage.error(`网络错误：${error.message}`)
        }
        return Promise.reject(new Error(error.message))
    }
)

export default request