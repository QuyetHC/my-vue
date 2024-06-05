<template>
  <v-app>
    <Header @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header>
    <v-container :class="drawerOpen ? 'with-drawer' : 'without-drawer'" fluid>
      <h1 class="mb-4 d-flex align-center justify-center" style="padding-top: 60px;">Thông tin khách hàng</h1>
      <v-data-table
        v-model:items-per-page="itemsPerPage"
        :headers="headers"
        :items="serverItems"
        :items-length="totalItems"
        :loading="loading"
        item-value="name"
        @update:options="loadItems"
        theme="dark"
      >
        <template v-slot:item="{ item }">
          <tr>
            <td class="align-center" style="text-align: center;">{{ item.custid }}</td>
            <td class="flex align-center" style="text-align: center;">{{ item.custodycd }}</td>
            <td class="flex align-center" style="text-align: center;">{{ item.fullName }}</td>
            <td class="flex align-center" style="text-align: center;">{{ item.addr }}</td>
            <td class="flex align-center" style="text-align: center;">{{ item.idCode }}</td>
            <td class="flex align-center" style="text-align: center;">{{ item.custtype }}</td>
            <td class="flex align-center" style="text-align: center;">{{ item.score }}</td>
            <td class="flex align-center" style="text-align: center;">
            <router-link :to="{ name: 'detail', params: { custid: item.custid }}">Chi tiết</router-link>
            </td>
          </tr>
        </template>
      </v-data-table>
    </v-container>
  </v-app>
</template>

<script>
import Header from '../components/Header.vue'
import axios from 'axios'
import SessionService from '../stores/SessionService';
export default {
  components: {
    // eslint-disable-next-line vue/no-reserved-component-names
    Header
  },
  data() {
    return {
      itemsPerPage: 6,
      headers: [
        { title: 'Mã khách hàng', key: 'custid', align: 'center' },
        { title: 'Số tài khoản', key: 'custodycd', align: 'center' },
        { title: 'Họ tên', key: 'fullName', align: 'center' },
        { title: 'Địa chỉ', key: 'addr', align: 'center' },
        { title: 'CMND', key: 'idCode', align: 'center' },
        { title: 'Loại khách hàng', key: 'custtype', align: 'center' },
        { title: 'Điểm tín dụng', key: 'score', align: 'center' },
        { title: 'Chỉnh sửa', key: 'edit', align: 'center' } // Thêm cột chỉnh sửa
      ],
      serverItems: [],
      loading: true,
      totalItems: 0,
      drawerOpen: false
    }
  },
  mounted() {
    this.loadData()
  },
  methods: {
    async loadData() {
      try {
        this.loading = true
        const response = await axios.get('http://localhost:8080/getcf')
        const userData = SessionService.getItem('userData');
        console.log('Welcome, ' + userData.username + '!')
        this.serverItems = response.data
        this.loading = false
      } catch (error) {
        console.error('Error fetching data:', error)
        this.loading = false
      }
    },
    async viewDetails(item) {
      try {
        // Gọi API để lấy thông tin chi tiết của mục
        const response = await axios.get(`http://localhost:8080/getcust?cusitd=${item.custid}`)
        const detail = response.data
        console.log('Detail of item:', detail)
        // Xử lý kết quả trả về từ API
        // this.$router.push({ name: 'detail', params: { custid: detail.custid } });
      } catch (error) {
        console.error('Error fetching detail:', error)
      }
    },
    toggleDrawer() {
      this.drawerOpen = !this.drawerOpen
    }
  }
}
</script>
<script setup>
import { ref } from 'vue';
const drawerOpen = ref(false);
const toggleDrawer = (isOpen) => {
  drawerOpen.value = isOpen;
};
</script>
<style scoped>
.with-drawer {
  margin-left: 299px;
  transition: margin-left 0.3s ease;
}
.without-drawer {
  margin-left: 0;
  transition: margin-left 0.3s ease;
}
</style>