<script setup>

import useMenuStore from "@/stores/menu.js";
import {useRouter} from "vue-router";

const menuStore = useMenuStore()
const menuList = menuStore.menuList
const router = useRouter()
const handleClick = (menu) => {
  router.push(menu.path)
}
</script>

<template>
  <el-menu class="min-h-screen" active-text-color="#ffd04b"
           background-color="#545c64" text-color="#fff">
    <template v-for="menu in menuList">
      <el-sub-menu :index="menu.path" v-if="menu.children.length">
        <template #title>
          <span>{{ menu.menuName }}</span>
        </template>
        <el-menu-item @click="handleClick(item)" :index="item.path" v-for="item in menu.children"> {{
            item.menuName
          }}
        </el-menu-item>
      </el-sub-menu>
      <el-menu-item v-else :index="menu.path" @click="handleClick(menu)">{{ menu.menuName }}</el-menu-item>
    </template>
  </el-menu>

</template>
