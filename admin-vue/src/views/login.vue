<script setup>
import {ref} from 'vue'
import {ElButton, ElMessage} from 'element-plus'
import {login} from '@/api/auth'
import {setToken} from '@/utils/auth'
import {getSelfMenu} from "@/api/user";
import useMenuStore from "@/stores/menu";
import useUserStore from "@/stores/user";
import router from "@/router";
import {ChromeFilled, ElemeFilled, Lock, User, WindPower} from "@element-plus/icons-vue";

const loginForm = ref({
  username: 'admin',
  password: '123456',
  rememberMe: false
})
const isLoading = ref(false)
const handleLogin = async () => {
  isLoading.value = true
  login(loginForm.value).then(token=>{
    setToken(token)
    const userStore = useUserStore()
    userStore.getUserInfo()
    getSelfMenu().then((menuList)=>{
      const menuStore = useMenuStore();
      menuStore.setMenuList(menuList);
      router.push(menuStore.lastPage || '/')
      ElMessage.success('登录成功')
    })
  }).catch(() => {
    isLoading.value = false
  })
}
const forgotPassword = () => {
}
</script>

<template>
  <div class="login-container min-h-screen  flex justify-center items-center">
    <div class="w-10/12 md:w-8/12 lg:w-6/12 bg-gray-100 bg-opacity-50 backdrop-blur-lg shadow-lg rounded-lg p-8">
      <h2 class="text-3xl text-center mb-4">Admin</h2>
      <el-form size="large" :model="loginForm" ref="loginFormRef">
        <el-form-item>
          <el-input v-model="loginForm.username" placeholder="Username">
            <template #prefix>
              <User/>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" v-model="loginForm.password" placeholder="Password">
            <template #prefix>
              <Lock/>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <div class="flex justify-between w-full">
            <el-checkbox v-model="loginForm.rememberMe" label="记住我" size="large"/>
            <el-button type="danger" link size="large" @click="forgotPassword">忘记密码</el-button>
          </div>
        </el-form-item>
        <el-divider content-position="center">其他登录方式</el-divider>
        <div class="flex justify-center items-center mb-4 gap-10">
          <el-icon :size="25"><ChromeFilled/></el-icon>
          <el-icon :size="25"><ElemeFilled/></el-icon>
          <el-icon :size="25"><WindPower/></el-icon>
        </div>
        <el-form-item>
          <el-button class="w-full" type="primary" @click="handleLogin" :loading="isLoading">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.login-container {
  background: url('@/assets/background.svg') no-repeat center center;
}
</style>