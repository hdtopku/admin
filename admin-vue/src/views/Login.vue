<script setup>
import { ElButton } from 'element-plus'
</script>

<template>
  <div class="login-container flex justify-center items-center h-screen bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500">
    <el-button class="text-lg !text-red">我是 ElButton</el-button>
    <h1 class="text-3xl font-bold underline">
      Hello world!
    </h1>
  </div>
</template>

<style lang="scss" scoped>
.login-container{
  background: url("../assets/background.svg") no-repeat;
}
</style>