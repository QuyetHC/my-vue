<template>
  <div>
    <Bar ref="chart" :data="localChartData" :options="chartOptions" />
  </div>
</template>

<script>
import { Bar } from 'vue-chartjs';
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js';

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale);

export default {
  name: 'BarChart',
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
    Bar
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
