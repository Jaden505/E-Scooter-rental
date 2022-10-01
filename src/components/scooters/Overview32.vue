<template>
  <div id="scooter_ids" ref="scroll">
    <table class="rwd-table" id="scooter_ids_table" ref="table_scooters">
      <thead>
      <tr>
        <th>Tag</th>
      </tr>
      </thead>
      <tbody id="scooter_ids_body">
      <tr v-for="(scooter) in scooters" :key="scooter.id" class="scooter_id" v-on:click="this.selected_scooter=scooter" :class="{selectID: selected_scooter===scooter}">
        <td>{{scooter.tag}}</td>
      </tr>
      </tbody>
    </table>
  </div>

  <button v-on:click="this.newScooter();" class="buttonScooter">New scooter</button>

  <p v-if="this.selected_scooter == null">Select a scooter from the list at the left</p>

  <Detail32 v-else :scooter="selected_scooter" :scooters="scooters" @delScooter="this.delScooter()" />
</template>

<script>
import Detail32 from "@/components/scooters/Detail32";

export default {
  name: "OverView32",
  components: {
    Detail32
  },

  mounted() {
    // Import random-location module
    let recaptchaScript = document.createElement('script')
    recaptchaScript.setAttribute('src', 'https://unpkg.com/random-location/dist/randomLocation.umd.js')
    document.head.appendChild(recaptchaScript)
  },

  data() {
    return {
      scooters: [],
      selected_scooter: null,
    }
  },

  created() {
    this.importRandLoc()

    this.last_id = 30000;
    for (let i=0; i<20; i++) {
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
    },

    newScooter() {
      let new_scooter = Scooter.createSampleScooter(this.nextId());
      this.scooters.push(new_scooter);

      setTimeout(f => this.selectNewScooter(new_scooter), 100);
    },

    selectNewScooter(new_scooter) {
      this.selected_scooter = new_scooter;

      // Scroll to bottom
      this.$refs.scroll.scrollTop = this.$refs.scroll.scrollHeight;
    },

    delScooter() {
      this.scooters.splice(this.scooters.indexOf(this.selected_scooter), 1);
      this.selected_scooter = null;
    }
  }
}

import Scooter from "@/models/scooter";
</script>

<style scoped>


#scooter_ids {
  position: absolute;
  max-height: 40%;
  overflow-y: scroll;
}

#scooter_ids th {
  width: 30%;
}

.scooter_id {
  cursor: pointer;
  width: 100%;
}

.scooter_id:hover {
  background-color: darkgrey;
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
  width: 80%;
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

.buttonScooter{
  isplay: inline-block;
  margin-bottom: 0;
  touch-action: manipulation;
  cursor: pointer;
  border: white;
  border-radius: 5px;
  padding: 4px 8px;
  font-size: 30px;
  color: white;
  margin: 8px;
  background: #46637f;
}


</style>