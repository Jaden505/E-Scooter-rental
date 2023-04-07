<template>

</template>


<script>
import HeaderSb from '@/components/HeaderSb.vue'
import NavBarComponent from '@/components/NavBarComponent.vue'
import {Scooter} from "@/models/Scooter";
import {Trip} from "@/models/Trip";
import {RestAdapterWithCache} from "@/models/RestAdapterWithCache";
import {reactive, shallowReactive} from "vue";
import {SessionSbService} from "@/service/SessionSbService";
import {FetchInterceptor} from "@/interceptors/FetchInterceptor";
const BACKEND_URL  = "http://localhost:8085"

export default {
  components: {
    HeaderSb, NavBarComponent
  },
  provide(){
    this.theSessionService = shallowReactive(new SessionSbService(BACKEND_URL+"/authentication", "JWT_ElectricScooter"));
    this.theFetchInterceptor = new FetchInterceptor(this.theSessionService, this.$router)
    return {
      scooterService : reactive(new RestAdapterWithCache(BACKEND_URL + "/scooters", Scooter.copyEntity)),
      tripService : reactive(new RestAdapterWithCache(BACKEND_URL + "/trips", Trip.copyEntity)),
      sessionService: this.theSessionService
    };
  },
  unmounted() {
    this.theFetchInterceptor.unregister();
  },
}

</script>

<style scoped>

</style>