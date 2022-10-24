import { createApp } from 'vue'
import { router } from './router'
import App from './App33.vue'
import './assets/css/styles.css'
import './vendor/bootstrap/css/bootstrap.css'

createApp(App).use(router).mount('#app');
