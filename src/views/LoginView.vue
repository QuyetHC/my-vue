<template>
  <div class="login-container">
    <v-form class="login" ref="form" v-model="valid" lazy-validation>
      <h1 id="login" class="mb-4">Login</h1>
      <v-text-field
        v-model="input.username"
        :counter="5"
        :rules="nameRules"
        label="Username"
        name="username"
        required
        class="mb-4"
      ></v-text-field>
      <v-text-field
        v-model="input.password"
        type="password"
        :counter="4"
        :rules="passRules"
        label="Password"
        required
        class="mb-4"
      ></v-text-field>
      <v-btn class="mr-4" :disabled="!valid" @click="attemptLogin()"> Login </v-btn>
    </v-form>
  </div>
</template>

<script lang="ts">
// import router from '../router'
import axios from 'axios'
export default {
  data() {
    return {
      valid: true,
      input: {
        username: '',
        password: ''
      },
      nameRules: [
        (v) => !!v || 'Name is required',
        (v) => (v && v.length >= 5) || 'Name must be less than 5 characters'
      ],
      passRules: [
        (v) => !!v || 'Pass is required',
        (v) => (v && v.length >= 4) || 'Name must be less than 4 characters or number.'
      ]
    }
  },
  methods: {
    async attemptLogin() {
      try {
        
        const response = await axios.post(`http://localhost:8080/getlogin?username=${this.input.username}&passwd=${this.input.password}`);
        const username = response.data.username;
        localStorage.setItem("username", username);
        console.log(username)
        window.location.href = "http://localhost:5173/";
      } catch (error) {
        console.error('Error occurred during login:', error)
      }
    }
  //   async attemptLogin() {
  // try {
  //   // Kiểm tra tên người dùng và mật khẩu có phù hợp hay không
  //   if (this.input.username === 'admin' && this.input.password === 'admin') {
  //     // Đăng nhập thành công, lưu tên người dùng vào localStorage và chuyển hướng đến trang home
  //     localStorage.setItem("username", this.input.username);
  //     window.location.href = "http://localhost:5173/";
  //   } else {
  //     // Đăng nhập không thành công, hiển thị thông báo lỗi
  //     console.error('Invalid username or password');
  //   }
  // } catch (error) {
  //   console.error('Error occurred during login:', error);
  // }

  }
}
</script>

<style scoped>
.login {
  text-align: center;
  margin-top: 15%;
  width: 300px;
}
.login-container {
  background-color: darkkhaki !important;
  padding: 20px;
  margin-top: 150px !important;
  border-radius: 10px;
}
</style>
