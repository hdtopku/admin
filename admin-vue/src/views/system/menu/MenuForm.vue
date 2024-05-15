<script setup xmlns="http://www.w3.org/1999/html">
import {ref} from 'vue'

const dialogVisible = ref(true)
const formTitle = ref('新增菜单')
const handleClose = () => {
  dialogVisible.value = false
}
const form = ref({
  id: 0,
  parentId: "1",
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
defineExpose({
  showModal: (isEdit = false) => {
    dialogVisible.value = true
    isEdit ? formTitle.value = '编辑菜单' : formTitle.value = '新增菜单'
  }
})
const menuSelectData = [
  {
    value: '1',
    label: '系统管理',
    children: [
      {
        value: '1-1',
        label: '用户管理',
        children: [],
      },
      {
        value: '1-2',
        label: '角色管理',
        children: [],
      },
      {
        value: '1-3',
        label: '菜单管理',
        children: [],
      },
    ],
  },
  {
    value: '2',
    label: '工具管理',
    children: [
      {
        value: '2-1',
        label: '代码生成',
        children: [
          {
            value: '2-1-1',
            label: 'Level three 2-1-1',
          },
        ],
      },
    ],
  },
]

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

</script>

<template>
  <el-button plain @click="dialogVisible = true">
    Click to open the Dialog
  </el-button>
  <el-dialog v-model="dialogVisible"
             :before-close="handleClose"
             :title="formTitle"
             class="!p-10"
             width="80%"
  >
    <el-form :model="form" class="grid grid-cols-1 md:grid-cols-2 md:gap-4" label-width="auto" size="large">
      <el-form-item label="上级菜单">
        <el-tree-select
            v-model="form.parentId"
            :data="menuSelectData"
            :render-after-expand="false"
            placeholer="请选择上级菜单"
        ></el-tree-select>
      </el-form-item>
      <el-form-item label="菜单类型">
        <el-select v-model.number="form.menuType" placeholder="请选择菜单类型">
          <el-option v-for="item in menuTypeOptions" :key="item.value" :label="item.label"
                     :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="菜单图标">
        <el-input v-model="form.icon" placeholder="请选择菜单图标"></el-input>
      </el-form-item>
      <el-form-item label="菜单名称">
        <el-input v-model="form.icon" placeholder="请输入菜单名称"></el-input>
      </el-form-item>
      <el-form-item label="路由地址">
        <el-input v-model="form.icon" placeholder="路由地址"></el-input>
      </el-form-item>
      <el-form-item label="组件地址">
        <el-input v-model="form.icon" placeholder="组件地址"></el-input>
      </el-form-item>
      <el-form-item label="权限标识">
        <el-input v-model="form.icon" placeholder="权限标识"></el-input>
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
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogVisible = false">
          Confirm
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>

</style>