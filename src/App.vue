
<template>
  <v-layout class="rounded rounded-md" style="display: flex">
    <!-- Sử dụng Header component chỉ khi isLoggedIn là true -->
    <!-- <Header @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header> -->
    <v-main
      class="d-flex align-center justify-center mt-2 bg-black"
      style="min-height: 700px"
      theme="dark"
    >
      <RouterView
        :class="{ 'router-view-expanded': !drawerOpen }"
        class="d-flex align-center justify-center mt-5 bg-black"
      />
    </v-main>
  </v-layout>
</template>

<script>
// import LoginView from './views/LoginView.vue';
// import Header from './components/Header.vue'; 

export default {
}
</script>

<style>
</style>
