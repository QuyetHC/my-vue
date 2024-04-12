import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BalanceView from '../views/BalanceView.vue'
import TransferView from '../views/TransferView.vue'
import MarginView from '../views/MarginDetailView.vue'
import LoginView from '../views/LoginView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: '/',
      name: 'home',
      component: HomeView,
      beforeEnter: (to, from, next) => {
        if (sessionStorage.getItem("username") == null) next({ name: "login" });
        else next();
      },
      children: [
        {
          path: "/home",
          name: "home",
          component: HomeView,
        },
        {
          path: '/balance',
          name: 'balance',
          component: BalanceView
        },
        {
          path: '/transfer',
          name: 'transfer',
          component: TransferView
        },
        {
          path: '/margin',
          name: 'margin',
          component: MarginView
        }
      ],
    },
    
  ]
})

export default router
