<template>
  <section class="u-align-center u-section-1">
    <h1>Scooters</h1>
    <table class="rwd-table">
      <tr>
        <th>ID</th>
        <th>Tag</th>
        <th>Status</th>
        <th>GPS location</th>
        <th>Battery charge</th>
      </tr>
      
      <tr v-for="(scooter) in scooters" :key="scooter.id">
        <td data-th="ID">{{scooter.id}}</td>
        <td data-th="Tag">{{scooter.tag}}</td>
        <td data-th="Status">{{scooter.status}}</td>
        <td data-th="Gpslocation">{{scooter.gpsLocation}}</td>
        <td data-th="Mileage">{{scooter.mileage}}</td>
        <td data-th="BatteryCharge">{{scooter.batteryCharge}}</td>
      </tr>

    </table>
    <div class="button">
      <a href="#/overview" id="detailStyle" class="btn btn-outline-secondary">Detail</a>
    </div>
  </section>
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


.rwd-table tr {
  border-top: 1px solid #ddd;
  border-bottom: 1px solid #ddd;
}
.rwd-table th {
  display: none;
}
.rwd-table td {
  display: block;
}
.rwd-table td:first-child {
  padding-top: 0.5em;
}
.rwd-table td:last-child {
  padding-bottom: 0.5em;
}
.rwd-table td:before {
  content: attr(data-th) ": ";
  font-weight: bold;
  width: 6.5em;
  display: inline-block;
}
@media (min-width: 480px) {
  .rwd-table td:before {
    display: none;
  }
}
.rwd-table th,
.rwd-table td {
  text-align: left;
}
@media (min-width: 480px) {
  .rwd-table th,
  .rwd-table td {
    display: table-cell;
    padding: 0.25em 0.5em;
  }
  .rwd-table th:first-child,
  .rwd-table td:first-child {
    padding-left: 0;
  }
  .rwd-table th:last-child,
  .rwd-table td:last-child {
    padding-right: 0;
  }
}

body {
  padding: 0 2em;
  font-family: Montserrat, sans-serif;
  -webkit-font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
  color: #444;
  background: #eee;
}

h1 {
  font-weight: normal;
  letter-spacing: -1px;
  color: #34495e;
}

.rwd-table {
  background: #34495e;
  color: #fff;
  border-radius: 0.4em;
  overflow: hidden;
  width: 60%;
}
.rwd-table tr {
  border-color: #46637f;
}
.rwd-table th,
.rwd-table td {
  margin: 0.5em 1em;
}
@media (min-width: 480px) {
  .rwd-table th,
  .rwd-table td {
    padding: 1em !important;
  }
}
.rwd-table th,
.rwd-table td:before {
  color: #dd5;
}



  table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
  }

  td, th {
    border: 1px solid #46637f;
    text-align: left;
    padding: 8px;
  }

  tr:nth-child(even) {
    background-color: #46637f;
  }

  #detailStyle{
    isplay: inline-block;
    margin-bottom: 0;
    touch-action: manipulation;
    cursor: pointer;
    background-image: none;
    padding: 8px 12px;
    font-size: 30px;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
    background: lightblue;
  }
</style>