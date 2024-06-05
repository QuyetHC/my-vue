<template>
  <v-card class="mx-auto" width="300">
    <v-list v-model:opened="open" v-if="isAdmin">
      <v-list-group value="admins">
        <template v-slot:activator="{ props }">
          <v-list-item v-bind="props" title="Dữ liệu khách hàng"></v-list-item>
        </template>
        <v-list-item
          v-for="([title, icon, route], i) in admins"
          :key="i"
          :prepend-icon="icon"
          :title="title"
          :value="title"
          :href="route"
        ></v-list-item>
      </v-list-group>
      <v-list-group value="cruds">
        <template v-slot:activator="{ props }">
          <v-list-item v-bind="props" title="Thông tin vay nợ"></v-list-item>
        </template>
        <v-list-item
          v-for="([title, icon, route], i) in cruds"
          :key="i"
          :prepend-icon="icon"
          :title="title"
          :value="title"
          :href="route"
        ></v-list-item>
      </v-list-group>
      <v-list-group value="cruds">
        <template v-slot:activator="{ props }">
          <v-list-item v-bind="props" title="Báo cáo tín dụng"></v-list-item>
        </template>
        <v-list-item
          v-for="([title, icon, route], i) in reports"
          :key="i"
          :prepend-icon="icon"
          :title="title"
          :value="title"
          :href="route"
        ></v-list-item>
      </v-list-group>
      <v-list-item @click="logout">
        <v-list-item-icon>
          <v-icon>mdi-logout</v-icon><v-list-item-title>Đăng xuất</v-list-item-title>
        </v-list-item-icon>
      </v-list-item>
    </v-list>
    <v-list v-model:opened="open" v-else>
      <v-list-group value="detail">
        <template v-slot:activator="{ props }">
          <v-list-item v-bind="props" title="Thông tin chi tiết"></v-list-item>
        </template>

        <v-list-item
          v-for="([title, icon, route], i) in detail"
          :key="i"
          :prepend-icon="icon"
          :title="title"
          :value="title"
          :href="route"
        ></v-list-item>
      </v-list-group>
      <v-list-item @click="logout">
        <v-list-item-icon>
          <v-icon>mdi-logout</v-icon><v-list-item-title>Đăng xuất</v-list-item-title>
        </v-list-item-icon>
      </v-list-item>
    </v-list>
  </v-card>
</template>
<script>
import SessionService from '../stores/SessionService.js'
export default {
  data: () => ({
    open: ['Users'],
    admins: [
      ['Thông tin khách hàng', 'mdi-account-multiple-outline', '/'],
      ['Số dư', 'mdi-cog-outline', '/balance']
    ],
    cruds: [
      ['Chi tiết vay nợ', 'mdi-plus-outline', '/margin'],
      ['Dữ liệu chuyển đổi', 'mdi-file-outline', '/transfer']
    ],
    reports: [
      ['Báo cáo phân bổ', 'mdi-plus-outline', '/reportcredit'],
      ['Điểm tín dụng trung bình', 'mdi-file-outline', '/avgcredit']
    ],
    detail: [],
    // detail: [
    //   ['Thông tin chi tiết', 'mdi-account-multiple-outline', `/detail/${this.userRole.custid}`],
    //   ['Thông tin chi tiết số dư', 'mdi-cog-outline', '/transfer']
    // ],
    isAdmin: false,
    isTwo: false
  }),
  methods: {
    async checkUserRole() {
      try {
        const userRole = SessionService.getItem('userData')
        if (userRole.role === '1') {
          this.isAdmin = true
        } else if (userRole.role === '2') {
          this.isTwo = true
          this.detail = [
            ['Thông tin chi tiết', 'mdi-account-multiple-outline', `/detail/${userRole.custid}`],
            ['Thông tin số dư', 'mdi-cog-outline', '/transfer']
          ]
        }
      } catch (error) {
        console.error('Error occurred while checking user role:', error)
      }
    },
    async logout() {
      try {
        // Xóa tên người dùng khỏi localStorage
        SessionService.removeItem('userData')
        // Chuyển hướng người dùng đến trang login hoặc trang chính
        window.location.href = 'http://localhost:5173/login'
      } catch (error) {
        console.error('Error occurred during logout:', error)
      }
    }
  },
  created() {
    this.checkUserRole()
  }
}
</script>
