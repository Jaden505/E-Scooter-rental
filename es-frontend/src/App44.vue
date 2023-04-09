<template>
    <HeaderComp></HeaderComp>
    <NavBar></NavBar>
    <router-view></router-view>
</template>
<script>

import NavBar from "@/components/NavBarSb";
import HeaderComp from "@/components/HeaderSb";
import Scooter from "@/models/scooter";
import {ScooterAdaptor} from "@/services/ScooterAdaptor";
import {SessionSbService} from "@/services/session-sb-service";
import {shallowReactive} from "vue";
import{FetchInterceptor} from "@/interceptions /FetchInterceptor";

const BACKEND_URL  = "http://localhost:8085"

export default {
    name: 'App - 44',
    components: {
        NavBar,
        HeaderComp,
    },
    provide() {
        this.theSessionService = shallowReactive(
            new SessionSbService(BACKEND_URL + "/authentication/", "JWT-token"));
      this.theSessionService = new FetchInterceptor(this.theSessionService, this.$router)
        return {
            scooterService: new ScooterAdaptor(BACKEND_URL + "/scooters/", Scooter.copyConstructer()),
            sessionService: this.theSessionService
        }
    },
  unmounted() {
    this.theFetchInterceptor.unregister();
  },

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
