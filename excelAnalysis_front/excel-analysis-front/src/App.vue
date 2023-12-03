<script setup lang="ts">
import { ElButton } from "element-plus";
import Selector from "./views/selector/Selector.vue"; // 请确保路径正确
</script>

<template>
  <div class="app flex">
    <div class="left-side">
      <Selector></Selector>
    </div>
    <div class="right-side">
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped lang="scss">
.app {
  border: 1px solid red;
  .right-side{
    border: 1px solid blue;
    width: 500px;
    display: flex;
    justify-content: center;
  }
}
</style>
