<script setup>
import Aside from './Aside.vue'
import Header from './Header.vue'
import Main from './Main.vue'
</script>

<template>
  <el-container class="h-screen">
    <el-aside width="200px">
      <Aside class="h-full"/>
    </el-aside>
    <el-container>
      <el-header><Header/></el-header>
      <el-main class="!pt-0 relative">
        <Main/>
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.el-header {
  height: auto;
}
</style>