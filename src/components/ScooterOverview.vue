<template>
  <table ref="scooter_table" id="scooter_table">
    <tr>
      <th>Id</th>
      <th>Tag</th>
      <th>Status</th>
      <th>GPS location</th>
      <th>Mileage</th>
      <th>Battery charge</th>
    </tr>
  </table>
</template>

<script>
import Scooter from '../models/scooter.js'

export default {
  name: "ScooterOverview",

  mounted() {
    const scooter_table = this.$scooter_table;
  },

  created() {
    this.scooters = [];
    this.last_id = 30000;

    for (let i=0; i<8; i++) {
      // this.scooters.push(Scooter.createSampleScooter(this.nextId()))
    }
  },

  methods: {
    nextId() {
      return this.last_id + this.scooters[this.scooters.length];
    }
  }
}
</script>

<style scoped>

</style>