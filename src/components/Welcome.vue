<template>
  <div id="left-side">
    <label for="standard-select" >Select a brand</label>
    <div class="select">
      <select id="standard-select">
        <option value="ecooter">Ecooter</option>
        <option value="niu">NIU</option>
        <option value="agm">AGM</option>
        <option value="kymco">Kymco</option>
        <option value="btc">BTC</option>
      </select>
    </div>

    <h1>Availability</h1>
    <p>Leidseplein: <b>12</b></p>
    <p>Rembrandtplein: <b>23</b></p>
    <p>Centraal station: <b>8</b></p>
  </div>

  <div id="middle"></div>
  <div id="right-side"></div>
</template>

<script>
export default {
  name: 'WelcomePage'
}
</script>

<style scoped>
  #left-side {
    float: left;
    padding-left: 2%;
    padding-top: 2%;
    width: 20%;
  }

  .select {
    margin-bottom: 70px;
  }

  label {
    font-size: 22px;
  }

  p {
    font-size: 20px;
  }
</style>
