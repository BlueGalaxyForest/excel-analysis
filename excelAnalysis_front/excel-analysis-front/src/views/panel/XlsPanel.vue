<template>
  <div class="main xls-panel">XLSPanel</div>
  <div ref="chartRef" style="width: 100%; height: 400px"></div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from "vue";
import * as echarts from "echarts";
const chartRef = ref(null);

onMounted(() => {
  initChart();
});

const initChart = () => {
  // 使用 ECharts 初始化图表
  const chart = echarts.init(chartRef.value);

  // 配置图表选项
  const options = {
    // 需要根据你的需求配置具体的图表选项
    // 例如：title, xAxis, yAxis, series 等
    title: {
      text: "ECharts Example",
    },
    xAxis: {
      data: ["Category 1", "Category 2", "Category 3", "Category 4"],
    },
    yAxis: {
      type: "value",
    },
    series: [
      {
        name: 'Series 1',
        type: 'bar',
        data: [25, 40, 60, 80],
      },
      {
        name: "Series 1",
        type: "bar",
        data: ['字符串1', '字符串2', "字符串3", "字符串4"],
      },
    ],
  };

  // 使用配置项渲染图表
  chart.setOption(options);
};
</script>

<style scoped></style>
