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
  data: () => ({
    itemsPerPage: 5,
    headers: [
      { title: 'BAD', key: 'calories', align: 'end' },
      { title: 'LOAN', key: 'fat', align: 'end' },
      { title: 'MORTDUE', key: 'carbs', align: 'end' },
      { title: 'VALUE', key: 'protein', align: 'end' },
      { title: 'YOJ', key: 'iron', align: 'end' },
      { title: 'DEROG', key: 'iron', align: 'end' },
      { title: 'DELINQ', key: 'iron', align: 'end' },
      { title: 'CLAGE', key: 'iron', align: 'end' },
      { title: 'NINQ', key: 'iron', align: 'end' },
      { title: 'CLNO', key: 'iron', align: 'end' },
      { title: 'DEBTINC', key: 'iron', align: 'end' },
      { title: 'REASON', key: 'iron', align: 'end' },
      { title: 'JOB', key: 'iron', align: 'end' }
    ],
    serverItems: [],
    loading: true,
    totalItems: 0
  }),
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
