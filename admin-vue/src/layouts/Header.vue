<script setup>
import {ArrowDown} from "@element-plus/icons-vue";
import router from "@/router/index.js";
import {removeToken} from "@/utils/auth/index.js";
import useUserStore from "@/stores/user";
import useMenuStore from "@/stores/menu";
import {nextTick, ref, watch} from "vue";

const menuStore = useMenuStore()
const editableTabs = menuStore.tabList
const showTabs = ref(true)
watch(editableTabs, () => {
  showTabs.value = false
  nextTick(() => {
    showTabs.value = true
  })
})
const userStore = useUserStore()
const breadcrumbList = menuStore.breadcrumbList
const handleLogout = () => {
  removeToken()
  router.push('/login')
}
const showBreadcrumb = ref(true)

const handleClick = (tab) => {
  menuStore.sortTab = false
  router.push({
    path: menuStore.tabList[tab.index].key,
  })
}
</script>

<template>
  <div
      class="header-container flex flex-col md:flex-row justify-between items-center py-2 mb-2 bg-white border-gray-200">
    <el-tabs v-if="showTabs"
             v-model="menuStore.activeTab"
             :closable="editableTabs.length>1"
             class="flex-1 self-start"
             type="card"
             @tab-remove="menuStore.removeTab"
             @tab-click="handleClick"
    >
      <el-tab-pane
          v-for="item in editableTabs"
          :key="item.key"
          :label="item.label"
          :name="item.name"
      >
      </el-tab-pane>
    </el-tabs>

    <el-dropdown class="self-end -order-1 md:order-none">
      <div class="flex items-center gap-2 cursor-pointer outline-none">
        <div class="flex flex-col justify-center items-center text-xs">欢迎您
          <div
              class="text-md font-bold text-gray-600">{{ userStore.userInfo.username }}
          </div>
        </div>
        <el-image
            class="w-10 h-10 rounded-full object-fill cursor-pointer hover:opacity-80 transition-opacity duration-300 ease-in-out"
            src="https://picsum.photos/200"></el-image>
        <el-icon>
          <ArrowDown/>
        </el-icon>
      </div>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item>个人中心</el-dropdown-item>
          <el-dropdown-item @click="handleLogout">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </div>
</template>
<style scoped>
:deep(.el-tabs__header) {
  margin: 0;
}
</style>
