import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BalanceView from '../views/BalanceView.vue'
import TransferView from '../views/TransferView.vue'
import MarginView from '../views/MarginDetailView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
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
  ]
})

export default router
