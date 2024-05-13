import request from "@/utils/request.js";

export const getSelfMenu = ()=>{
    return request({
        url: '/ums/menu/self',
        method: 'get'
    })
}