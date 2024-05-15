<script setup>
import { ref,watch,nextTick } from "vue";
import useMenuStore from "@/stores/menu.js";
const menuStore = useMenuStore()
const editableTabs = menuStore.tabList
const refreshTabs = ref(true)

watch(menuStore.tabList, () => {
  refreshTabs.value = false
  nextTick(() => {
    refreshTabs.value = true
  })
})
</script>

<template>
  <el-tabs
      v-if="refreshTabs"
      v-model="menuStore.activeTab"
      type="card"
      :closable="editableTabs.length>1"
      class="demo-tabs"
      @tab-remove="menuStore.removeTab"
  >
    <el-tab-pane
        v-for="item in editableTabs"
        :label="item.label"
        :key="item.key"
        :name="item.name"
    >
      {{ item.content }}
    </el-tab-pane>
  </el-tabs>
</template>

<style scoped>

</style>