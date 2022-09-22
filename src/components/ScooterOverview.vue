<template>
  <table ref="scooter_table" id="scooter_table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Tag</th>
        <th>Status</th>
        <th>GPS location</th>
        <th>Mileage</th>
        <th>Battery charge</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(scooter) in scooters" :key="scooter.id">
        <td>{{scooter.id}}</td>
        <td>{{scooter.tag}}</td>
        <td>{{scooter.status}}</td>
        <td>{{scooter.gpsLocation}}</td>
        <td>{{scooter.mileage}}</td>
        <td>{{scooter.batteryCharge}}</td>
      </tr>
    </tbody>
  </table>
  <div class="u-align-left">
    <a href="#/overview" class="btn btn-outline-secondary">Overview</a>
  </div>
</template>

<script>
export default {
  name: "ScooterOverview",

  created() {
    this.importRandLoc()

    this.last_id = 30000;

    for (let i=0; i<8; i++) {
      this.scooters.push(Scooter.createSampleScooter(this.nextId()))
    }
  },

  methods: {
    nextId() {
      return this.last_id + this.scooters.length;
    },

    importRandLoc() {
      // Import random-location module
      let recaptchaScript = document.createElement('script')
      recaptchaScript.setAttribute('src', 'https://unpkg.com/random-location/dist/randomLocation.umd.js')
      document.head.appendChild(recaptchaScript)
    }
  },

  data() {
    return {
      scooters: [],
    }
  },
}

import Scooter from "@/models/scooter";
</script>

<style scoped>
  table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
  }

  td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }

  tr:nth-child(even) {
    background-color: #dddddd;
  }
</style>