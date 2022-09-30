<template>
  <table ref="scooter_details" id="scooter_details">
    <thead>
    <tr>
      <th>Scooter details</th>
    </tr>
    </thead>
    <tbody>
    <!--  v-model & sub component  -->
    <th id="detail_labels">
      <tr>Tag: </tr>
      <tr>Status: </tr>
      <tr>Battery Charge (%): </tr>
      <tr>GPS Location: </tr>
      <tr>Total Mileage (km): </tr>
    </th>
    <th>

      <tr><input type="text" v-model="scooter_d.tag"></tr>
      <tr>
        <select v-model="scooter_d.status">
          <option disabled selected value></option>
          <option value="IDLE">IDLE</option>
          <option value="INUSE">INUSE</option>
          <option value="MAINTENANCE">MAINTENANCE</option>
        </select>
      </tr>
      <tr><input type="number" v-model="scooter_d.batteryCharge"></tr>
      <tr><input type="text" v-model="scooter_d.gpsLocation.longitude"></tr>
      <tr><input type="number" v-model="scooter_d.mileage"></tr>
    </th>
    </tbody>
  </table>

  <button v-on:click="$emit('delScooter')" class="delScooter">Delete scooter</button>
</template>

<script>
export default {
  name: "DetailOverview",
  props: ['scooter', 'scooters'],

  watch: {
    scooter: function(newVal) {
      this.scooter_d = newVal;
    },
    scooters: function(newVal) {
      this.scooters_d = newVal;
    }
  },

  data() {
    return {
      scooters_d: this.scooters,
      scooter_d: this.scooter,
    }
  },
}
</script>

<style scoped>
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