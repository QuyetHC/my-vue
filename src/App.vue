
<template>
  <v-layout class="rounded rounded-md" style="display: flex">
    <v-main
      class="d-flex align-center justify-center bg-black"
      style="min-height: 700px"
      theme="dark"
    >
      <RouterView
        :class="{ 'router-view-expanded': !drawerOpen }"
        class="d-flex align-center justify-center bg-black"
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
