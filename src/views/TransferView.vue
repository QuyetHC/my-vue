<template>
  <v-app>
    <Header @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header>
    <v-container :class="drawerOpen ? 'with-drawer' : 'without-drawer'" fluid>
      <h1 class="mb-4 d-flex align-center justify-center">Số dư</h1>
      <v-btn prepend-icon="$vuetify" variant="tonal" 
      style="margin-left: 85%; margin-bottom: 20px;"
      @click="onDataConvertClick">
        Chuyển đổi dữ liệu
      </v-btn>
      <v-data-table
        v-model:items-per-page="itemsPerPage"
        :headers="headers"
        :items="serverItems"
        :items-length="totalItems"
        :loading="loading"
        item-value="name"
        @update:options="loadItems"
        theme="dark"
      ></v-data-table>
    </v-container>
  </v-app>
</template>

<script>
import axios from 'axios'
import Header from '../components/Header.vue'
export default {
  components: {
    // eslint-disable-next-line vue/no-reserved-component-names
    Header
  },
  data() {
    return {
      itemsPerPage: 5,
      headers: [
        { title: 'Mã khách hàng', key: 'custid', align: 'center' },
        { title: 'Giá trị khoản vay', key: 'loan', align: 'center' },
        { title: 'Giá trị tài sản đảm bảo được định giá', key: 'mortdue', align: 'center' },
        { title: 'Giá trị tài sản hiện tại', key: 'value', align: 'center' },
        { title: 'Số lượng báo cáo vỡ nợ', key: 'derog', align: 'center' },
        { title: 'Số lượng hạn mức tín dụng', key: 'clno', align: 'center' },
        { title: 'Chỉnh sửa', key: 'yoj', align: 'center' },
        { title: 'Loại công việc', key: 'job', align: 'center' },
        { title: 'Giá trị tín dụng chưa thanh toán', key: 'delinq', align: 'center' },
        { title: 'Mục đích vay', key: 'reason', align: 'center' },
        { title: 'Số lượng yêu cầu tín dụng gần đây', key: 'ninq', align: 'center' },
        { title: 'Tỷ lệ nợ/thu nhập', key: 'debtinc', align: 'center' }
      ],
      serverItems: [],
      loading: true,
      totalItems: 0,
      drawerOpen: false
    }
  },
  mounted() {
    this.loadData();
  },
  methods: {
    async loadData() {
      try {
        this.loading = true;
        const response = await axios.get('http://localhost:8080/getsema');
        this.serverItems = response.data;
        this.loading = false;
      } catch (error) {
        console.error('Error fetching data:', error);
        this.loading = false;
      }
    },
    async onDataConvertClick() {
      try {
        this.loading = true;
        const response = await axios.post('http://127.0.0.1:5000/score');
        const detail = response.data
        console.log('Detail of item:', detail)
        // this.$router.push({ name: 'home' });
        this.loading = false;
      } catch (error) {
        console.error('Error converting data:', error);
        this.loading = false;
      }
    }
  },
};
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