<script setup>
import {useRoute} from "vue-router";
import {ArrowDown} from "@element-plus/icons-vue";

const path = useRoute().path
</script>

<template>
  <div class="flex items-center justify-between px-4 py-2 bg-white border-b border-gray-200">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
    </el-breadcrumb>
    <div>
      <el-dropdown>
        <span class="flex items-center gap-2 cursor-pointer outline-none">
          <span class="font-bold">张三</span>
      <el-image
          class="w-10 h-10 rounded-full object-fill cursor-pointer hover:opacity-80 transition-opacity duration-300 ease-in-out"
          src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"></el-image>
          <el-icon><ArrowDown/></el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<style scoped>

</style>