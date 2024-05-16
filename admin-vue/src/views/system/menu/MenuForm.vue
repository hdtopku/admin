<script setup xmlns="http://www.w3.org/1999/html">
import {ref} from 'vue'
import SvgIcon from "@/components/SvgIcon/index.vue";
import IconSelect from "@/views/system/menu/IconSelect.vue";

const props = defineProps({
  menuTree: {}
})
const form = ref({
  id: '',
  parentId: '',
  menuName: "",
  path: "",
  componentPath: "",
  perms: "",
  icon: "",
  menuType: 0,
  sort: 0,
  status: 0,
  remark: "",
})
const menuTypeOptions = [{
  label: '菜单',
  value: 0
}, {
  label: '目录',
  value: 1
}, {
  label: '按钮',
  value: 2
}]

const menuSelectData = ref([])
const menuSelect = []
const dfs = (menu) => {
  const menuData = {
    label: menu.menuName,
    value: menu.id,
    children: []
  }
  if (menu.children) {
    for (const item of menu.children) {
      menuData.children.push(dfs(item))
    }
  }
  return menuData
}
for (const item of props.menuTree) {
  menuSelect.push(dfs(item))
}
menuSelectData.value = menuSelect
const formRef = ref(null)
defineExpose({
  getForm: () => form.value,
  form,
  formRef
})
</script>

<template>
  <el-form ref="formRef" :model="form" class="grid grid-cols-1 md:grid-cols-2 md:gap-4" label-width="auto" size="large">
    <el-form-item label="上级菜单">
      <el-tree-select
          v-model="form.parentId"
          :data="menuSelectData"
          :render-after-expand="false"
          placeholder="请选择上级级菜单"
      ></el-tree-select>
    </el-form-item>
    <el-form-item label="菜单类型">
      <el-select v-model.number="form.menuType" placeholder="请选择菜单类型">
        <el-option v-for="item in menuTypeOptions" :key="item.value" :label="item.label"
                   :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="菜单图标">
      <el-popover
          content="请输入图标名称"
          placement="bottom-start"
          trigger="click"
          width="400"
      >
        <template #reference>
          <el-input v-model="form.icon" placeholder="请输入图标名称">
            <template #prefix>
              <svg-icon v-if="form.icon" slot="prefix" :name="form.icon" height="18px" width="18px"></svg-icon>
              <el-icon v-else class="el-input__icon">
                <search/>
              </el-icon>
            </template>
          </el-input>
        </template>
        <IconSelect ref="IconSelectRef" v-model="form.icon" :active-icon="form.icon"
                    @selected="icon=>form.icon=icon"/>
      </el-popover>
    </el-form-item>
    <el-form-item label="菜单名称">
      <el-input v-model="form.menuName" placeholder="请输入菜单名称"></el-input>
    </el-form-item>
    <el-form-item label="路由地址">
      <el-input v-model="form.path" placeholder="路由地址"></el-input>
    </el-form-item>
    <el-form-item label="组件地址">
      <el-input v-model="form.componentPath" placeholder="组件地址"></el-input>
    </el-form-item>
    <el-form-item label="权限标识">
      <el-input v-model="form.perms" placeholder="权限标识"></el-input>
    </el-form-item>
    <el-form-item label="备注">
      <el-input v-model="form.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="排序">
      <el-input-number v-model="form.sort"/>
    </el-form-item>
    <el-form-item label="状态">
      <el-switch v-model="form.status" active-color="#13ce66" active-text="已启用" inactive-color="#ff4949"
                 inactive-text="已禁用" inline-prompt>
      </el-switch>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>