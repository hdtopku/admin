import request from "@/utils/request.js";

export const getSelfMenu = ()=>{
    return request({
        url: '/ums/menu/self',
        method: 'get'
    })
}
export const getSelfInfo = ()=>{
    return request({
        url: '/ums/sys/user/self',
        method: 'get'
    })
}