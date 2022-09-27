<template>
  <div id="scooter_ids">
  <table  class="rwd-table" >
    <thead>
      <tr>
        <th>Tag</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(scooter) in scooters" :key="scooter.id" v-on:click="this.displayDetails(scooter); this.displaySelected($event.target)" class="scooter_id">
        <td>{{scooter.tag}}</td>
      </tr>
    </tbody>
  </table>
  </div>

  <button v-on:click="newScooter" class="newScooter">New scooter</button>
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
      <tr><input type="text" id="Tag"></tr>
      <tr>
        <select id="Status">
          <option disabled selected value></option>
          <option value="IDLE">IDLE</option>
          <option value="INUSE">INUSE</option>
          <option value="MAINTENANCE">MAINTENANCE</option>
        </select>
      </tr>
      <tr><input type="number" id="BatteryCharge"></tr>
      <tr><input type="text" id="GpsLocation"></tr>
      <tr><input type="number" id="Mileage"></tr>
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
    for (let i=0; i<20; i++) {
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

    displaySelected(elem) {
      if (this.selected_scooter != null) {
        this.selected_scooter.classList.remove("selectID");
      }

      this.selected_scooter = elem;
      elem.classList.add("selectID");
    },

    displayDetails(scooter) {
      document.getElementById("Tag").value = scooter.tag;
      document.getElementById("Status").value = scooter.status;
      document.getElementById("BatteryCharge").value = scooter.batteryCharge;
      document.getElementById("GpsLocation").value = scooter.gpsLocation["latitude"] + ", " + scooter.gpsLocation["longitude"];
      document.getElementById("Mileage").value = scooter.mileage;
    },

    newScooter() {
      let new_scooter = Scooter.createSampleScooter(this.nextId());
      this.scooters.push(new_scooter);

      this.displayDetails(new_scooter);

      // Get scooter element
      let table = document.getElementById("scooter_ids_table");
      let scooter_elem = table.lastElementChild.lastElementChild;

    },
  }
}

import Scooter from "@/models/scooter";
</script>

<style scoped>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
}

#scooter_ids {
  position: absolute;
  max-height: 40%;
  overflow-y: scroll;
}

#scooter_ids th {
  width: 30%;
}

.newScooter {
  position: absolute;
}

.scooter_id {
  cursor: pointer;
  width: 100%;
}

.scooter_id:hover {
  background-color: darkgrey;
}

/* Responsive layout - Puts edit field underneath id field */
@media screen and (max-width: 1000px) {
  #scooter_ids {
    position: static;
  }
}

#scooter_details {
  margin-left: 30%;
  float: right;
  width: 70%;
}


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
  margin: 8%;
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
  padding: 8px 12px;
  font-size: 30px;
  color: white;
  margin: 8px;
  background: #46637f;
}

#detail_labels tr {
  text-align: right;
}

.selectID {
  background-color: darkgrey;
}
</style>