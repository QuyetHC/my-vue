
<template>
  <v-layout class="rounded rounded-md" style="display: flex">
    <!-- Sử dụng Header component chỉ khi isLoggedIn là true -->
    <Header v-if="isLoggedIn" @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header>
    <v-main
      class="d-flex align-center justify-center mt-2 bg-black"
      style="min-height: 300px"
      theme="dark"
    >
      <!-- Sử dụng LoginView component khi chưa đăng nhập -->
      <div v-if="!isLoggedIn">
        <LoginView/>
      </div>
      <!-- Sử dụng RouterView component khi đã đăng nhập -->
      <RouterView
        v-else
        @auth="setAuth"
        :class="{ 'router-view-expanded': !drawerOpen }"
        class="d-flex align-center justify-center mt-5 bg-black"
      />
    </v-main>
  </v-layout>
</template>

<script>
import LoginView from './views/LoginView.vue';
import Header from './components/Header.vue'; 
import { mapState } from 'vuex'; // Import mapState từ Vuex

export default {
  components: {
    LoginView,
    // eslint-disable-next-line vue/no-reserved-component-names
    Header
  },
  computed: {
    ...mapState(['isLoggedIn']), // Ánh xạ state isLoggedIn từ Vuex store
  },
  data() {
    return {
      drawerOpen: false,
    };
  },
  methods: {
    setAuth(authStatus) {
      this.$store.commit('setLoggedIn', authStatus); 
    },
    toggleDrawer() {
      this.drawerOpen = !this.drawerOpen; 
    }
  }
}
</script>

<style>
</style>
