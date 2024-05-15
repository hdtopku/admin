<script setup>
import {ref} from "vue";
import {ArrowDown} from "@element-plus/icons-vue";
import router from "@/router/index.js";
import {removeToken} from "@/utils/auth/index.js";
import useUserStore from "@/stores/user";
import useMenuStore from "@/stores/menu";

const userStore = useUserStore()
const menuStore = useMenuStore()
const breadcrumbList = menuStore.breadcrumbList
const handleLogout = () => {
  removeToken()
  router.push('/login')
}
const showBreadcrumb=ref(true)
</script>

<template>
  <div class="flex items-center justify-between px-4 py-2 bg-white border-b border-gray-200">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item v-if="showBreadcrumb" v-for="(item,index) in breadcrumbList" :key="index">{{ item }}</el-breadcrumb-item>
    </el-breadcrumb>
    <div>
      <el-dropdown>
        <span class="flex items-center gap-2 cursor-pointer outline-none">
          <span><span class="text-xs">欢迎您，</span><span
              class="text-md font-bold text-gray-600">{{ userStore.userInfo.username }}</span></span>
      <el-image
          class="w-10 h-10 rounded-full object-fill cursor-pointer hover:opacity-80 transition-opacity duration-300 ease-in-out"
          src="https://picsum.photos/200"></el-image>
          <el-icon><ArrowDown/></el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item @click="handleLogout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>
