<template>
  <div id="scooter_ids" ref="scroll">
    <table class="rwd-table" id="scooter_ids_table" ref="table_scooters">
      <thead>
      <tr>
        <th>Tag</th>
      </tr>
      </thead>
      <tbody id="scooter_ids_body">
      <tr v-for="(scooter) in scooters" :key="scooter.id" class="scooter_id" v-on:click="onSelect(scooter)" :class="{selectID: selected_scooter===scooter}">
        <td>{{scooter.tag}}</td>
      </tr>
      </tbody>
    </table>
  </div>

  <button v-on:click="this.newScooter();" class="buttonScooter">New scooter</button>

  <p v-if="this.selected_scooter == null">Select a scooter from the list at the left</p>

  <Detail34 v-else :scooter_d="selected_scooter" @delScooter="this.delScooter()" />
</template>

<script>
import Detail34 from "@/components/scooters/Detail34";

export default {
  name: "OverView34",
  components: {
    Detail34
  },

  watch: {
    '$route'() {
      this.selected_scooter = this.findSelectedFromRouteParam();
    }
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

      this.selected_scooter = new_scooter;

      // Scroll to bottom
      setTimeout(f => this.$refs.scroll.scrollTop = this.$refs.scroll.scrollHeight, 100);
    },

    delScooter() {
      this.scooters.splice(this.scooters.indexOf(this.selected_scooter), 1);
      this.selected_scooter = null;
    },

    onSelect(scooter) {
      if (scooter != null && scooter !== this.selected_scooter) {
        this.$router.push(this.$route.matched[0].path + "/" + scooter.id);
      }
      else if (this.selected_scooter != null) {
        this.selected_scooter = null;
        this.$router.push("/scooters/overview34")
      }
    },

    findSelectedFromRouteParam() {
      let id = this.$route.params.id;
      return this.scooters.find(function (scooter) {
        if (id == scooter.id) {return scooter;}
      })
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

.selectID {
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


@media only screen and (max-width: 600px) {
  #scooter_ids {
    position: absolute;
    max-height: 23%;
    margin-top: 162px;
  }
}
</style>