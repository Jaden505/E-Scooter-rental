<template>
  <div id="scooter_ids" ref="scroll">
    <table id="scooter_ids_table" ref="table_scooters">
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

  <button v-on:click="this.newScooter();" class="newScooter">New scooter</button>

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

.scooter_id {
  cursor: pointer;
  width: 100%;
}

.scooter_id:hover {
  background-color: darkgrey;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

.selectID {
  background-color: darkgrey;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>