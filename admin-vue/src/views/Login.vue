<script setup>
import {ref} from 'vue'
import {ElButton} from 'element-plus'
import {login} from '@/api/auth'
import {setToken} from '@/utils/auth'

const loginForm = ref({
  username: 'admin',
  password: '123456',
  rememberMe: false
})
const handleLogin = async() => {
  const token =await login(loginForm.value)
  setToken("token", token)
}
const forgotPassword = () => {
  console.log('forgot password')
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
              <i-ep-user/>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" v-model="loginForm.password" placeholder="Password">
            <template #prefix>
              <i-ep-lock/>
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
          <i-ep-ChromeFilled/>
          <i-ep-ElemeFilled/>
          <i-ep-WindPower/>
        </div>
        <el-form-item>
          <el-button class="w-full" type="primary" @click="handleLogin">登录</el-button>
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