<script setup>

</script>

<template>
  <router-view #default="{ Component, route }">
    <component :is="Component" v-if="!(route.meta.keepAlive ?? true)"/>
    <keep-alive v-else>
      <component
          :is="Component"
          :key="route.path"
      />
    </keep-alive>
  </router-view>
</template>