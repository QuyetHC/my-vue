<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <v-app-bar theme="dark">
    <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

    <v-app-bar-title>Application</v-app-bar-title>
  </v-app-bar>
  <v-navigation-drawer :width="299" v-model="drawer" theme="dark">
    <ListViewNav></ListViewNav>
  </v-navigation-drawer>
</template>

<script setup>
import { ref } from 'vue'
// eslint-disable-next-line no-unused-vars
import ListViewNav from '../components/ListViewNav.vue'
const drawer = ref(null)
</script>

<script>
export default {
  data: () => ({ drawer: null })
}
</script>
