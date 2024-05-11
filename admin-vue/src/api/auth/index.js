import request from "@/utils/request.js";

export function login(data) {
  return request({
    url: "/auth/login",
    method: "post",
    data
  });
}

export function logout() {
  return request({
    url: "/auth/logout",
    method: "post"
  });
}
