import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'

import Home from '@/components/Home'
import Welcome from '../components/Welcome'
import UserList from '../admin/UserList'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/Login'
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      component: Home,
      redirect: '/welcome',
      children: [
        {path: '/welcome', component: Welcome},
        {path: '/user', component: UserList}
      ],
    },
  ]
})
