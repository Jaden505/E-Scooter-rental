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

      <tr><input type="text" :value="scooter.tag"></tr>
      <tr>
        <select :value="scooter.status">
          <option disabled selected value></option>
          <option value="IDLE">IDLE</option>
          <option value="INUSE">INUSE</option>
          <option value="MAINTENANCE">MAINTENANCE</option>
        </select>
      </tr>
      <tr><input type="number" :value="scooter.batteryCharge"></tr>
      <tr><input type="text" :value="scooter.gpsLocation"></tr>
      <tr><input type="number" :value="scooter.mileage"></tr>
    </th>
    </tbody>
  </table>

  <button v-on:click="this.delScooter();" class="delScooter">Delete scooter</button>
</template>

<script>
export default {
  name: "DetailOverview",
  props: ['scooter'],

  methods: {
    delScooter() {
      this.scooters.splice(this.scooters.indexOf(this.selected_scooter), 1);

      this.displayDetails(null);
    },
  }
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