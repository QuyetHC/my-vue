import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BalanceView from '../views/BalanceView.vue'
import TransferView from '../views/TransferView.vue'
import MarginView from '../views/MarginDetailView.vue'
import LoginView from '../views/LoginView.vue'
import CustDetail from '@/views/CustDetail.vue'
import CreditScoreDashboard from '@/views/CreditScoreDashboard.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/',
      name: 'main',
      component: HomeView,
      meta: { requiresAuth: true } // Thêm thuộc tính meta để xác định cần phải đăng nhập hay không
    },
    {
      path: '/home',
      name: 'home',
      component: HomeView,
      meta: { requiresAuth: true }
    },
    {
      path: '/balance',
      name: 'balance',
      component: BalanceView,
      meta: { requiresAuth: true }
    },
    {
      path: '/transfer',
      name: 'transfer',
      component: TransferView,
      meta: { requiresAuth: true }
    },
    {
      path: '/margin',
      name: 'margin',
      component: MarginView,
      meta: { requiresAuth: true }
    },
    {
      path: '/reportcredit',
      name: 'reportcredit',
      component: CreditScoreDashboard,
      meta: { requiresAuth: true }
    },
    {
      path: '/detail/:custid',
      name: 'detail',
      component: CustDetail,
      props: true,
      meta: { requiresAuth: true }
    }
  ]
})

router.beforeEach((to, from, next) => {
  const isAuthenticated = checkIfUserIsAuthenticated(); // Hàm này kiểm tra xem người dùng có được xác thực không

  if (to.meta.requiresAuth && !isAuthenticated) {
    next({ name: 'login' }); // Chuyển hướng đến trang đăng nhập nếu không được xác thực và trang yêu cầu đăng nhập
  } else {
    next(); // Cho phép điều hướng tiếp theo nếu được xác thực hoặc không yêu cầu xác thực
  }
})

function checkIfUserIsAuthenticated() {
  // Kiểm tra trạng thái đăng nhập từ session
  const sessionUser = sessionStorage.getItem('userData'); 
  console.log(sessionUser);
  return sessionUser !== null; 
}

export default router
