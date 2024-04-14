<template>
  <div>
    <div class="detail-view px-4 sm:px-0">
      <h3 class="text-base font-semibold leading-7 text-gray-900">Thông tin chi tiết khách hàng</h3>
    </div>
    <div class="mt-6 border-t border-gray-100">
      <dl class="divide-y divide-gray-100">
        <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
          <dt class="text-sm font-medium leading-6 text-gray-900">Mã khách hàng</dt>
          <dd class="mt-1 text-sm leading-6 text-gray-700 sm:col-span-2 sm:mt-0">{{ custid }}</dd>
        </div>
        <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
          <dt class="text-sm font-medium leading-6 text-gray-900">Số tài khoản</dt>
          <dd class="mt-1 text-sm leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
            {{ customerDetail.custodycd }}
          </dd>
        </div>
        <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
          <dt class="text-sm font-medium leading-6 text-gray-900">Họ tên</dt>
          <dd class="mt-1 text-sm leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
            {{ customerDetail.fullName }}
          </dd>
        </div>
        <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
          <dt class="text-sm font-medium leading-6 text-gray-900">Địa chỉ</dt>
          <dd class="mt-1 text-sm leading-6 text-gray-700 sm:col-span-2 sm:mt-0">{{ customerDetail.addr }}</dd>
        </div>
        <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
          <dt class="text-sm font-medium leading-6 text-gray-900">CMND</dt>
          <dd class="mt-1 text-sm leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
            {{ customerDetail.idCode }}
          </dd>
        </div>
        <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
          <dt class="text-sm font-medium leading-6 text-gray-900">Loại khách hàng</dt>
          <dd class="mt-1 text-sm leading-6 text-gray-700 sm:col-span-2 sm:mt-0">{{ customerDetail.custtype }}</dd>
        </div>
      </dl>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  props: ['custid'],
  data() {
    return {
      customerDetail: null
    };
  },
  async created() {
    // Gọi API để lấy chi tiết khách hàng khi component được tạo
    try {
      const response = await axios.get(`http://localhost:8080/getcust?cusitd=${this.custid}`);
      this.customerDetail = response.data[0];
      console.log('rass' + JSON.stringify(this.customerDetail))
    } catch (error) {
      console.error('Error fetching customer detail:', error);
    }
  }
}
</script>
<style>
</style>