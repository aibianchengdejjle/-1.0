// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// 添加全局样式
import './assets/css/global.css'
import './plugins/element.js'
// 导入iconfront
import './assets/font/iconfont.css'

// 导入跨域请求
import axios from 'axios'
Vue.config.productionTip = false
// 给http请求挂在axios
Vue.prototype.$http = axios
// 设置访问根路径
axios.defaults.baseURL = 'http://localhost:9000/'
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
