<template>
  <div>
    <h1>Báo cáo chấm điểm tín dụng</h1>
    <div>
      <h2>Tổng số lượng khách hàng: {{ totalCustomers }}</h2>
      <h2>Điểm tín dụng trung bình: {{ averageCreditScore }}</h2>
    </div>
    <div class="charts">
      <BarChart :chart-data="barChartData" v-if="barChartData" />
      <PieChart :chart-data="pieChartData" v-if="pieChartData" />
    </div>
    <p v-if="!barChartData || !pieChartData">Loading...</p>
  </div>
</template>

<script>
import axios from 'axios';
import BarChart from '@/components/BarChart.vue';
import PieChart from '@/components/PieChart.vue';

export default {
  components: {
    BarChart,
    PieChart
  },
  data() {
    return {
      customers: [],
      barChartData: null,
      pieChartData: null
    };
  },
  computed: {
    totalCustomers() {
      return this.customers.length;
    },
    averageCreditScore() {
      const totalScore = this.customers.reduce((sum, customer) => sum + parseInt(customer.creditScore), 0);
      return this.totalCustomers > 0 ? (totalScore / this.totalCustomers).toFixed(2) : 0;
    }
  },
  watch: {
    customers(newCustomers) {
      this.updateChartData(newCustomers);
    }
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    async fetchData() {
      try {
        const response = await axios.get('http://localhost:8080/report');
        this.customers = response.data;
      } catch (error) {
        console.error('Lỗi khi lấy dữ liệu từ API:', error);
      }
    },
    updateChartData(customers) {
      const scoreRanges = {
        '300-499': 0,
        '500-599': 0,
        '600-699': 0,
        '700-799': 0,
        '800-850': 0
      };
      customers.forEach(customer => {
        const score = parseInt(customer.creditScore);
        if (score >= 300 && score <= 499) scoreRanges['300-499']++;
        else if (score >= 500 && score <= 599) scoreRanges['500-599']++;
        else if (score >= 600 && score <= 699) scoreRanges['600-699']++;
        else if (score >= 700 && score <= 799) scoreRanges['700-799']++;
        else if (score >= 800 && score <= 850) scoreRanges['800-850']++;
      });

      this.barChartData = {
        labels: Object.keys(scoreRanges),
        datasets: [
          {
            label: 'Số lượng khách hàng',
            backgroundColor: '#42A5F5',
            data: Object.values(scoreRanges)
          }
        ]
      };

      console.log('Bar Chart Data:', this.barChartData); // Kiểm tra dữ liệu biểu đồ

      this.pieChartData = {
        labels: Object.keys(scoreRanges),
        datasets: [
          {
            label: 'Tỷ lệ khách hàng',
            backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#FF9F40', '#4BC0C0'],
            data: Object.values(scoreRanges)
          }
        ]
      };

      console.log('Pie Chart Data:', this.pieChartData); // Kiểm tra dữ liệu biểu đồ
    }
  }
};
</script>

<style scoped>
h1, h2 {
  text-align: center;
}

.charts {
  display: flex;
  justify-content: space-around;
  align-items: center;
}
</style>
