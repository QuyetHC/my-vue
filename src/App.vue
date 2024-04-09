<template>
  <v-layout class="rounded rounded-md" style="width: 100%; display: flex">
    <Header @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header>
    <v-main class="d-flex align-center justify-center mt-5 bg-black" style="min-height: 300px">
      <RouterView
        :class="{ 'router-view-expanded': !drawerOpen }"
        class="d-flex align-center justify-center mt-5 bg-black"
      />
    </v-main>
  </v-layout>
</template>

<!-- eslint-disable no-unused-vars -->
<script>
import { RouterView } from 'vue-router'
import Header from './components/Header.vue'
import { ref } from 'vue'

export default {
  components: {
    // eslint-disable-next-line vue/no-reserved-component-names
    Header
  },
  setup() {
    const drawerOpen = ref(true)

    const toggleDrawer = () => {
      drawerOpen.value = !drawerOpen.value
    }

    return {
      drawerOpen,
      toggleDrawer
    }
  }
}
</script>

<style scoped></style>
