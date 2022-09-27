<template>
  <div id="scooter_ids">
  <table id="scooter_ids_table">
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

.selectID {
  background-color: darkgrey;
}
</style>