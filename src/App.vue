<template>
  <HeaderComp></HeaderComp>
  <NavBar></NavBar>
  <WelcomePage></WelcomePage>

</template>

<script>
import WelcomePage from './components/Welcome.vue'
import HeaderComp from './components/Header.vue'
import NavBar from "@/components/NavBar";

export default {
  name: 'App',
  components: {
    NavBar,
    HeaderComp,
    WelcomePage
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
