<template>
  <Header @drawerToggle="toggleDrawer" :drawerOpen="drawerOpen"></Header>
  <div
    class="mx-auto flex-column"
    style="
      width: 500px;
      background-color: #e2e2e2 !important;
      color: #318ac6 !important;
      border-radius: 15px;
    "
  >
    <div class="info-header font-weight-black text-center pt-4">Thông tin chi tiết</div>

    <div style="background-color: aliceblue; width: 500px; border-radius: 15px;">
      <div class="pt-4 text-center">
        <span style="color: black; display: block">Mã khách hàng: </span> {{ custid }}
      </div>
      <div class="pt-4 text-center">
        <span style="color: black; display: block">Số tài khoản:</span>
        {{ customerDetail.custodycd }}
      </div>
      <div class="pt-4 text-center">
        <span style="color: black; display: block">Họ tên:</span> {{ customerDetail.fullName }}
      </div>
      <div class="pt-4 text-center">
        <span style="color: black; display: block">Địa chỉ:</span> {{ customerDetail.addr }}
      </div>
      <div class="pt-4 text-center">
        <span style="color: black; display: block">CMND:</span> {{ customerDetail.idCode }}
      </div>
      <div class="pt-4 text-center pb-4">
        <span style="color: black; display: block">Loại khách hàng:</span>
        {{ customerDetail.custtype }}
      </div>
    </div>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import axios from 'axios'
export default {
  components: {
    // eslint-disable-next-line vue/no-reserved-component-names
    Header
  },
  props: ['custid'],
  data() {
    return {
      customerDetail: null
    }
  },
  async created() {
    // Gọi API để lấy chi tiết khách hàng khi component được tạo
    try {
      const response = await axios.get(`http://localhost:8080/getcust?cusitd=${this.custid}`)
      this.customerDetail = response.data[0]
      console.log('rass' + JSON.stringify(this.customerDetail))
    } catch (error) {
      console.error('Error fetching customer detail:', error)
    }
  }
}
</script>
<style>
.info-header {
  background-color: #e2e2e2;
  color: #318ac6;
  padding: 10px;
  width: 500px;
  border-radius: 15px;
}
</style>
