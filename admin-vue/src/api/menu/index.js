import request from "@/utils/request.js";

export const getMenuTree = () => {
    return request({
        url: '/ums/menu/tree',
        method: 'get'
    })
}