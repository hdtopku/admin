<script setup>
import {ref} from 'vue'
import {getMenuTree} from "@/api/menu/index.js";
import MenuForm from "@/views/system/menu/MenuForm.vue";

const queryForm = ref({
  menuName: '',
  perms: '',
  pageNum: 1,
  pageSize: 10
})
const total = ref(0)

const handleQuery = () => {

}
const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`)
}
const handleAdd = () => {
  dialogVisible.value = true
}
const dialogVisible = ref(false)
const formTitle = ref('新增菜单')
const handleClose = () => {
  dialogVisible.value = false
}

const menuTree = ref([])
const loading = ref(false)
const queryMenuTree = () => {
  loading.value = true
  getMenuTree().then(res => {
    menuTree.value = res
    loading.value = false
  }).catch(() => {
    loading.value = false
  })
}
queryMenuTree()
let MenuFormRef = null
const setRefAction = (ref) => {
  MenuFormRef = ref
}
const handleSubmit = () => {

}
</script>

<template>
  <div>
    <el-dialog v-model="dialogVisible"
               :before-close="handleClose"
               :title="formTitle"
               center
               class="!p-10"
               width="80%"
    >
      <MenuForm :ref="setRefAction" :menuTree="menuTree"></MenuForm>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleSubmit">
            提交
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
  <el-form :inline="true" :model="queryForm" class="flex justify-end" size="large">
    <el-form-item label="菜单名称">
      <el-input v-model="queryForm.menuName"/>
    </el-form-item>
    <el-form-item label="权限名称">
      <el-input v-model="queryForm.perms"/>
    </el-form-item>
  </el-form>
  <!-- 功能按钮 -->
  <div class="flex justify-between mb-4">
    <div v-if="menuTree.length">
      <el-button type="primary" @click="handleAdd">新增</el-button>
      <el-button type="danger" @click="handleRemove(0)">删除</el-button>
    </div>
    <div>
      <el-button type="primary" @click="handleQuery">搜索</el-button>
    </div>
  </div>
  <el-table :data="menuTree" border default-expand-all row-key="id">
    <el-table-column type="selection" width="40"/>
    <el-table-column label="序号" type="index" width="55"/>
    <el-table-column label="菜单名称" prop="menuName" width="150"/>
    <el-table-column label="权限名称" prop="perms" width="150"/>
    <el-table-column label="组件路径" prop="path" width="150"/>
    <el-table-column label="组件名称" prop="componentPath" width="150"/>
    <el-table-column label="备注" prop="remark" width="150"/>
    <el-table-column label="创建时间" prop="createTime" width="150"/>
    <el-table-column label="修改时间" prop="updateTime" width="150"/>
    <el-table-column fixed="right" label="操作" width="150">
      <template #default="scope">
        <!-- v-if和v-show区别 -->
        <el-button v-if="scope.row.menuType !== 2" link size="small" type="primary">新增</el-button>
        <el-button link size="small" type="success" @click="handleEdit(scope.row.id)">修改</el-button>
        <el-button link size="small" type="danger" @click="handleRemove(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <!-- 分页 -->
  <div class="flex justify-end mt-4 mr-4">
    <el-pagination v-model:current-page="queryForm.pageNum" v-model:page-size="queryForm.pageSize"
                   :page-sizes="[10, 20, 30, 40, 50]" :total="total" layout="total, sizes, prev, pager, next, jumper"
                   @size-change="handleSizeChange" @current-change="handleCurrentChange"/>
  </div>
</template>

<style scoped>

</style>