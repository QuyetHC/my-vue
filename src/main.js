import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

// Vuetify
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import 'vuetify/dist/vuetify.min.css'

import App from './App.vue'
import router from './router'

import { mdiFileOutline } from '@mdi/js'
import '@mdi/font/css/materialdesignicons.css'
const vuetify = createVuetify({
  components,
  directives
})

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(vuetify)
app.config.globalProperties.$icons = { mdiFileOutline }
app.mount('#app')
export default createVuetify({
  icons: {
    defaultSet: 'mdi'
  },
  theme: {
    dark: true,
  }
})
