<template>
  <div class="main uploader">
    <el-upload
      class="upload-demo"
      drag
      :action="uploadUrl"
      :multiple="false"
      :before-upload="beforeUpload"
    >
      <el-icon class="el-icon--upload"><upload-filled /></el-icon>
      <div class="el-upload__text">拖拽文件到此处或 <em>点击上传</em></div>
    </el-upload>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from "vue";
import { ElUpload, ElIcon } from "element-plus";
import { UploadFilled } from "@element-plus/icons-vue";
import { ElMessage } from "element-plus";

const uploadUrl = "http://localhost:9000/api/upload";

const beforeUpload = (file: File) => {
  console.log("文件上传之前-->", uploadUrl);

  // 获取文件扩展名
  const extension = file.name.split(".").pop()?.toLowerCase();

  // 判断文件是否为Excel格式（示例中假设是.xlsx格式）
  if (extension === "xlsx") {
    return true; // 允许上传
  } else {
    // 提示用户上传的文件格式不正确
    // 这里可以根据你的需求使用 ElMessageBox 等 Element Plus 的组件来展示错误信息
    // 示例中直接在控制台输出错误信息
    console.error("只能上传Excel格式的文件（.xlsx）");
    ElMessage({
      showClose: true,
      message: "Oops!只能上传Excel文件哦~",
      type: "error",
    });
    return false; // 阻止上传
  }
};
</script>

<style scoped></style>
