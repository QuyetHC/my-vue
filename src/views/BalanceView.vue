
<template>
    <v-app>
      <Header @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header>
      <v-container fluid>
        <h1 class="mb-4 d-flex align-center justify-center">Số dư</h1>
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
           { title: 'Số tài khoản', key: 'acctno', align: 'end' },
           { title: 'Tiểu khoản', key: 'afacctno', align: 'end' },
           { title: 'Chứng khoán', key: 'codeId', align: 'end' },
           { title: 'Số dư tiền', key: 'trade', align: 'end' },
           { title: 'Số dư chứng khoán', key: 'costprice', align: 'end' },
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
        const response = await axios.get('http://localhost:8080/getsema');
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
  