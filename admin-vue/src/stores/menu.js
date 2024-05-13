import {ref} from 'vue'
import {defineStore} from 'pinia'

const useMenuStore = defineStore('menu', () => {
        const menuList = ref([])
        const setMenuList = (list) => {
            menuList.value = list
        }
        return {
            menuList,
            setMenuList
        }
    }, {
        persist:
            {
                storage: localStorage
            }
    }
)
export default useMenuStore