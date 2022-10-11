<template>
  <button v-on:click="$emit('delScooter')" class="buttonScooter">Delete scooter</button>
  <div class="container">
    <form>
      <div class="group">
        <input type="text" v-model="scooter.tag" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Tag:</label>
      </div>

      <div class="group">
        <select v-model="scooter.status">
          <option disabled selected value></option>
          <option value="IDLE">IDLE</option>
          <option value="INUSE">INUSE</option>
          <option value="MAINTENANCE">MAINTENANCE</option>
        </select>
        <span class="highlight"></span>
        <span class="bar"></span>
      </div>

      <div class="group">
        <input type="text" v-model="scooter.batteryCharge" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Battery charge:</label>
      </div>
      <div class="group">
        <input type="text" v-model="scooter.gpsLocation.longitude" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>GPS Location:</label>
      </div>

      <div class="group">
        <input type="text"  v-model="scooter.mileage" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Total Mileage (km):</label>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "DetailOverview32",
  props: ['scooter_d'],

  watch: {
    scooter_d: function(newVal) {
      this.scooter = newVal;
    },
  },

  data() {
    return {
      scooter: this.scooter_d,
    }
  },
}
</script>

<style scoped>
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



.group 			  {
  position:relative;
  margin-bottom:45px;
}
input 				{
  font-size:18px;
  padding:10px 10px 10px 5px;
  display:block;
  width:300px;
  border:none;
  border-bottom:1px solid #757575;
}
input:focus 		{ outline:none; }

/* LABEL ======================================= */
label 				 {
  color:#999;
  font-size:18px;
  font-weight:normal;
  position:absolute;
  pointer-events:none;
  left:5px;
  top:10px;
  transition:0.2s ease all;
  -moz-transition:0.2s ease all;
  -webkit-transition:0.2s ease all;
}

/* active state */
input:focus ~ label, input:valid ~ label 		{
  top:-20px;
  font-size:14px;
  color:#5264AE;
}

/* BOTTOM BARS ================================= */
.bar 	{ position:relative; display:block; width:300px; }
.bar:before, .bar:after 	{
  content:'';
  height:2px;
  width:0;
  bottom:1px;
  position:absolute;
  background:#5264AE;
  transition:0.2s ease all;
  -moz-transition:0.2s ease all;
  -webkit-transition:0.2s ease all;
}
.bar:before {
  left:50%;
}
.bar:after {
  right:50%;
}

/* active state */
input:focus ~ .bar:before, input:focus ~ .bar:after {
  width:50%;
}

/* HIGHLIGHTER ================================== */
.highlight {
  position:absolute;
  height:60%;
  width:100px;
  top:25%;
  left:0;
  pointer-events:none;
  opacity:0.5;
}

input:focus ~ .highlight {
  -webkit-animation:inputHighlighter 0.3s ease;
  -moz-animation:inputHighlighter 0.3s ease;
  animation:inputHighlighter 0.3s ease;
}

@-webkit-keyframes inputHighlighter {
  from { background:#5264AE; }
  to 	{ width:0; background:transparent; }
}
@-moz-keyframes inputHighlighter {
  from { background:#5264AE; }
  to 	{ width:0; background:transparent; }
}
@keyframes inputHighlighter {
  from { background:#5264AE; }
  to 	{ width:0; background:transparent; }
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


@media (min-width: 1200px){
  .container {
    width: 320px;
    margin-top: 62px;
  }
}

@media only screen and (max-width: 600px) {
  #scooter_ids{
    position: absolute;
    max-height: 23%;
    margin-top: 162px;
  }


  .container {
    width: 320px;
    margin-top: 337px;
  }
}
</style>