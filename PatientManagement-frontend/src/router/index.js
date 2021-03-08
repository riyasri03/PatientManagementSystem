import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '@/pages/home.vue'
import login from '@/pages/login.vue'
import registration from '@/pages/registration.vue'
import nurselogin from '@/pages/nurselogin.vue'
import doclogin from '@/pages/doclogin.vue'
import userlogin from '@/pages/userlogin.vue'
import payment from '@/pages/payment.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    name: 'home',
    component: home
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/registration',
    name: 'registration',
    component: registration
  },
  {
    path: '/doclogin',
    name: 'doclogin',
    component: doclogin
  },
  {
    path: '/userlogin',
    name: 'userlogin',
    component: userlogin
  },
  {
    path: '/nurselogin',
    name: 'nurselogin',
    component: nurselogin
  },
  {
    path: '/payment',
    name: 'payment',
    component: payment
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
