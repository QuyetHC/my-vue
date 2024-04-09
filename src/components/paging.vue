<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="text-center">
    <v-pagination v-model="page" :length="3" rounded="circle"></v-pagination>
  </div>
</template>
<script>
export default {
  data() {
    return {
      page: 1
    }
  }
}
</script>
