import {getSelfInfo} from "@/api/user/index.js";
import {defineStore} from 'pinia'
import {ref} from 'vue'

const useUserStore = defineStore('user', () => {
    const userInfo = ref({})
    const getUserInfo = async () => {
        userInfo.value = await getSelfInfo()
    }
    return {
        userInfo,
        getUserInfo
    }
}, {
    persist: {storage: localStorage}
})
export default useUserStore