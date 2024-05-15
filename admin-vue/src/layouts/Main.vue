<script setup>
import { ref,watch,nextTick } from "vue";
import useMenuStore from "@/stores/menu.js";
import router from "@/router/index.js";
const menuStore = useMenuStore()
const editableTabs = menuStore.tabList
const showTabs = ref(true)
watch(editableTabs, () => {
  showTabs.value = false
  nextTick(() => {
    showTabs.value = true
  })
})
const handleClick = (tab) => {
  menuStore.sortTab=false
  router.push({
    path: menuStore.tabList[tab.index].key,
  })
}
</script>

<template>
  <el-tabs
      v-if="showTabs"
      v-model="menuStore.activeTab"
      type="card"
      :closable="editableTabs.length>1"
      @tab-remove="menuStore.removeTab"
      @tab-click="handleClick"
  >
    <el-tab-pane
        v-for="item in editableTabs"
        :label="item.label"
        :key="item.key"
        :name="item.name"
    >
      <router-view/>
    </el-tab-pane>
  </el-tabs>
</template>