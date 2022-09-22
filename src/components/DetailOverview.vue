<template>
  <table ref="scooter_ids" id="scooter_ids">
    <thead>
      <tr>
        <th>Tag</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(scooter) in scooters" :key="scooter.id" v-on:click="selected_scooter=scooter; displayDetails()">
        <td>{{scooter.tag}}</td>
      </tr>
    </tbody>
  </table>

  <table ref="scooter_details" id="scooter_details">
    <thead>
    <tr>
      <th>Scooter details</th>
    </tr>
    </thead>
    <tbody>
    <th id="detail_labels">
      <tr>Tag: </tr>
      <tr>Status: </tr>
      <tr>Battery Charge (%): </tr>
      <tr>GPS Location: </tr>
      <tr>Total Mileage (km): </tr>
    </th>
    <th>
      <tr><input type="text" name="Tag" ></tr>
      <tr>
        <select id="Status">
          <option>IDLE</option>
          <option>INUSE</option>
          <option>MAINTENANCE</option>
        </select>
      </tr>
      <tr><input type="number" name="BatteryCharge" ></tr>
      <tr><input type="text" name="GpsLocation" ></tr>
      <tr><input type="number" name="Mileage" ></tr>
    </th>

    </tbody>
  </table>
</template>

<script>
export default {
  name: "DetailOverview",

  created() {
    this.importRandLoc()

    this.last_id = 30000;
    for (let i=0; i<8; i++) {
      this.scooters.push(Scooter.createSampleScooter(this.nextId()))
    }
  },

  data() {
    return {
      scooters: [],
      selected_scooter: null,
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
    },

    displayDetails() {
    },
  }
}

import Scooter from "@/models/scooter";
</script>

<style scoped>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  position: fixed;
}

#scooter_ids {
  width: 30%;
}

#scooter_details {
  margin-left: 30%;
  float: right;
  width: 70%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

#detail_labels tr {
  text-align: right;
}
</style>