<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <v-app-bar theme="dark">
    <v-app-bar-nav-icon @click="toggleDrawer"></v-app-bar-nav-icon>

    <v-app-bar-title>Application</v-app-bar-title>
  </v-app-bar>
  <v-navigation-drawer :width="299" v-model="drawer" theme="dark">
    <ListViewNav></ListViewNav>
  </v-navigation-drawer>
</template>

<script setup>
import { ref, watch, defineProps, defineEmits } from 'vue';
// eslint-disable-next-line no-unused-vars
import ListViewNav from '../components/ListViewNav.vue'
const props = defineProps({
  drawerOpen: {
    type: Boolean,
    required: true
  }
});
const emit = defineEmits(['drawerToggle']);

const drawer = ref(props.drawerOpen);

watch(() => props.drawerOpen, (newVal) => {
  drawer.value = newVal;
});

const toggleDrawer = () => {
  emit('drawerToggle', !drawer.value);
};
</script>

