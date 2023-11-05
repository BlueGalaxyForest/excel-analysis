import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router'
import Uploader from '../views/uploader/Uploader.vue'
import ExcelPanel from '../views/panel/ExcelPanel.vue'
import XlsPanel from '../views/panel/XlsPanel.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/uploader' // 将根路径重定向到 '/uploader'
  },
  {
    path: '/uploader',
    component: Uploader
  },
  {
    path: '/panel/excel',
    component: ExcelPanel
  },
  {
    path: '/panel/xls',
    component: XlsPanel
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
