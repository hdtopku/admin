<script setup>

import useMenuStore from "@/stores/menu.js";
import {useRouter} from "vue-router";
import SvgIcon from "@/components/SvgIcon/index.vue";
const menuStore = useMenuStore()
const {menuList} = menuStore

const router = useRouter()
const handleClick = (menu) => {
  router.push(menu.path)
}
console.log(router.currentRoute.value.path)
</script>

<template>
  <el-menu :default-active="router.currentRoute.value.path" class="min-h-screen" active-text-color="#ffd04b"
           background-color="#545c64" text-color="#fff">
    <template v-for="menu in menuList">
      <el-sub-menu :index="menu.path" v-if="menu.children.length">
        <template #title>
          <svg-icon
              slot="prefix"
              :name="menu.icon"
              width="18px"
              height="18px"
              class="mr-2"
          />
          <span>{{ menu.menuName }}</span>
        </template>
        <el-menu-item @click="handleClick(item)" :index="item.path" v-for="item in menu.children">
          <svg-icon
              v-if="item.icon"
              slot="prefix"
              :name="item.icon"
              width="18px"
              height="18px"
              class="mr-2"
          />
          {{
            item.menuName
          }}
        </el-menu-item>
      </el-sub-menu>
      <el-menu-item v-else :index="menu.path" @click="handleClick(menu)">
        <svg-icon
            v-if="menu.icon"
            slot="prefix"
            :name="menu.icon"
            width="18px"
            height="18px"
            class="mr-2"
        />
        {{ menu.menuName }}</el-menu-item>
    </template>
  </el-menu>

</template>
