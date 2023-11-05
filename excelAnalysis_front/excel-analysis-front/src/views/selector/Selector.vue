<template>
  <div class="main">
    <div
      :class="{ row: true, active: activeIndex === index }"
      v-for="(item, index) in options"
      :key="index"
      @click="onClick(index)"
    >
      {{ item }}
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from "vue";
let activeIndex = ref(0); // 初始化为-1，表示没有选中任何项

const options: string[] = ["Excel分析", "xls分析"];

const onClick = (index: number) => {
  activeIndex.value = index; // 更新activeIndex的值，表示当前选中的项的索引
};
</script>

<style scoped lang="scss">
.main {
  width: 200px;
  min-height: 500px;
  background-color: pink;
  background: linear-gradient(45deg, #009fcc, #77ddff);
  .row {
    border: 1px solid red;
    display: flex;
    justify-content: center;
    padding: 10px 0;
    cursor: pointer;
    &:hover {
      color: #7b68ee;
      background: linear-gradient(to right, #1e90ff, #afeeee);
    }
  }
}

.active {
  color: #7b68ee;
  background: linear-gradient(to right, #1e90ff, #afeeee);
}
</style>
