<script setup>
import {nextTick, onMounted, ref} from 'vue'
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

const menuList = ref([{
  menuName: '菜单管理',
  perms: "system:menu:list",
  path: "/system/menu/list",
  componentPath: "systemMenu",
  createTime: "2021-11-11 11:11:11",
  updateTime: "2021-11-11 11:11:11",
  remark: "备注",
  children: []
}, {
  menuName: '菜单管理',
  perms: "system:menu:list",
  path: "/system/menu/list",
  componentPath: "systemMenu",
  createTime: "2021-11-11 11:11:11",
  updateTime: "2021-11-11 11:11:11",
  remark: "备注",
  children: []
}])
const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`)
}
const menuFormRef = ref(null)

const handleAdd = () => {
  menuFormRef.value.showModal()
}
onMounted(async () => {
  await nextTick()

})
</script>

<template>
  <MenuForm ref="menuFormRef"></MenuForm>
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
    <div>
      <el-button type="primary" @click="handleAdd">新增</el-button>
      <el-button type="danger" @click="handleRemove(0)">删除</el-button>
    </div>
    <div>
      <el-button type="primary" @click="handleQuery">搜索</el-button>
    </div>
  </div>
  <el-table :data="menuList" border>
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