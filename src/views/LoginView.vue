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
import SessionService from '../stores/SessionService.js';
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
        const response = await axios.post(
          `http://localhost:8080/getlogin?username=${this.input.username}&passwd=${this.input.password}`
        )
        const userData = response.data.loginList[0];
        SessionService.setItem('userData', userData)
        console.log(userData)
        if (userData.role === '1') {
          // Nếu là admin, chuyển hướng tới trang admin
          this.$router.push('/')
        } else if (userData.role === '2') {
          // Nếu là user, chuyển hướng tới trang detail
          this.$router.push(`/detail/${userData.custid}`)
        }
      } catch (error) {
        console.error('Error occurred during login:', error)
      }
    }
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
