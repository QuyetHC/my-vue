<template>
    <div>
      <Pie ref="chart" :data="localChartData" :options="chartOptions" />
    </div>
  </template>
  
  <script>
  import { Pie } from 'vue-chartjs';
  import { Chart as ChartJS, Title, Tooltip, Legend, ArcElement, CategoryScale, LinearScale } from 'chart.js';
  
  ChartJS.register(Title, Tooltip, Legend, ArcElement, CategoryScale, LinearScale);
  
  export default {
    name: 'PieChart',
    props: {
      chartData: {
        type: Object,
        required: true,
        default: () => ({ labels: [], datasets: [] }) // Đảm bảo chartData luôn có datasets
      },
      chartOptions: {
        type: Object,
        required: false,
        default: () => ({
          responsive: true,
          maintainAspectRatio: false
        })
      }
    },
    components: {
      Pie
    },
    data() {
      return {
        localChartData: {} // Khởi tạo localChartData
      };
    },
    mounted() {
      this.localChartData = JSON.parse(JSON.stringify(this.chartData)); // Clone chartData thành localChartData
      this.renderChart();
    },
    watch: {
      chartData(newChartData) {
        this.localChartData = JSON.parse(JSON.stringify(newChartData)); // Update localChartData khi chartData thay đổi từ bên ngoài
      }
    },
    methods: {
      renderChart() {
        this.$refs.chart.renderChart(this.localChartData, this.chartOptions);
      }
    }
  };
  </script>
  