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

export default {
  name: "ScooterOverview",

  mounted() {
    const scooter_table = this.$scooter_table;

    // Import random-location module
    let recaptchaScript = document.createElement('script')
    recaptchaScript.setAttribute('src', 'https://unpkg.com/random-location/dist/randomLocation.umd.js')
    document.head.appendChild(recaptchaScript)
  },

  created() {
    this.scooters = [];
    this.last_id = 30000;

    for (let i=0; i<8; i++) {
      this.scooters.push(Scooter.createSampleScooter(this.nextId()))
    }

    console.log(this.scooters)
  },

  methods: {
    nextId() {
      return this.last_id + this.scooters.length;
    }
  }
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