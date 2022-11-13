<template>
  <HeaderComp></HeaderComp>
  <NavBar></NavBar>
  <router-view></router-view>
</template>
<script>

import NavBar from "@/components/NavBar";
import HeaderComp from "@/components/Header";
import Scooter from "@/models/scooter";
import {ScooterAdaptor} from "@/services/ScooterAdaptor";
const BACKEND_URL  = "http://localhost:8085"

export default {
  name: 'App',
  components: {
    NavBar,
    HeaderComp,
  },
  provide(){
    return{
      scooterService: new ScooterAdaptor(BACKEND_URL + "/scooters", Scooter.copyConstructer())
    }
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
