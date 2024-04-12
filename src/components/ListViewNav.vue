<template>
  <v-card class="mx-auto" width="300">
    <v-list v-model:opened="open">
      <!-- <v-list-item prepend-icon="mdi-home" title="Home"></v-list-item> -->

      <v-list-group value="admins">
        <template v-slot:activator="{ props }">
          <v-list-item v-bind="props" title="Dữ liệu khách hàng"></v-list-item>
        </template>

        <v-list-item
          v-for="([title, icon, route], i) in admins"
          :key="i"
          :prepend-icon="icon"
          :title="title"
          :value="title"
          :href="route"
        ></v-list-item>
      </v-list-group>

      <v-list-group value="cruds">
        <template v-slot:activator="{ props }">
          <v-list-item v-bind="props" title="Vay nợ"></v-list-item>
        </template>

        <v-list-item
          v-for="([title, icon, route], i) in cruds"
          :key="i"
          :prepend-icon="icon"
          :title="title"
          :value="title"
          :href="route"
        ></v-list-item>
      </v-list-group>
      <v-list-item @click="logout">
        <v-list-item-icon>
          <v-icon>mdi-logout</v-icon><v-list-item-title>Đăng xuất</v-list-item-title>
        </v-list-item-icon>
      </v-list-item>
    </v-list>
  </v-card>
</template>
<script>
export default {
  data: () => ({
    open: ['Users'],
    admins: [
      ['Thông tin khách hàng', 'mdi-account-multiple-outline', '/'],
      ['Số dư', 'mdi-cog-outline', '/balance']
    ],
    cruds: [
      ['Chi tiết vay nợ', 'mdi-plus-outline', '/margin'],
      ['Dữ liệu chuyển đổi', 'mdi-file-outline', '/transfer']
    ]
  }),
  methods: {
    async logout() {
      try {
        // Sử dụng this.$store.dispatch thay vì hook useStore()
        await this.$store.dispatch('logout')
        console.log(this.$store.dispatch('logout'));
      } catch (error) {
        console.error('Error occurred during logout:', error)
      }
    }
  }
}
</script>
