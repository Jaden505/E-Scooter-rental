<template>
  <HeaderComp></HeaderComp>
  <NavBar></NavBar>
  <component :is="currentView" />
</template>

<script>
import WelcomePage from './components/Welcome.vue'
import HeaderComp from './components/Header.vue'
import NavBar from "@/components/NavBar";
import ScooterOverview from "@/components/ScooterOverview";
import Overview32 from "@/components/Overview32";

const routes = {
  '/': WelcomePage,
  '/scooters': ScooterOverview,
  '/overview': Overview32,
}

export default {
  name: 'App',
  components: {
    NavBar,
    HeaderComp,
    WelcomePage
  },
  data() {
    return {
      currentPath: window.location.hash
    }
  },
  computed: {
    currentView() {
      return routes[this.currentPath.slice(1) || '/']
    }
  },
  mounted() {
    window.addEventListener('hashchange', () => {
      this.currentPath = window.location.hash
    })
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
