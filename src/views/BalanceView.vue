
<template>
    <v-app>
      <Header @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header>
      <v-container :class="drawerOpen ? 'with-drawer' : 'without-drawer'" fluid>
        <h1 class="mb-4 d-flex align-center justify-center" style="padding-top: 60px;">Số dư</h1>
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
           { title: 'Mã khách hàng', key: 'custid', align: 'end' },
           { title: 'Số tài khoản', key: 'acct', align: 'end' },
           { title: 'Giá trị tài sản hiện tại', key: 'value', align: 'end' },
           { title: 'Số lượng hạn mức tín dụng', key: 'clno', align: 'end' },
           { title: 'Tỷ lệ nợ/thu nhập', key: 'debtnic', align: 'end' },
           { title: 'Giá trị tín dụng chưa thanh toán', key: 'delinq', align: 'end' },
      ],
      serverItems: [],
      loading: true,
      totalItems: 0,
    };
  },
  mounted() {
    this.loadData();
  },
  methods: {
    async loadData() {
      try {
        this.loading = true;
        const response = await axios.get('http://localhost:8080/getbance');
        this.serverItems = response.data;
        this.loading = false;
      } catch (error) {
        console.error('Error fetching data:', error);
        this.loading = false;
      }
    },
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