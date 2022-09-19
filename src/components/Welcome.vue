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

  <div id="middle">
    <h1>Photo Gallary:</h1>
    <div class="row">
      <div class="column">
        <img src="../assets/images/scooter1.jpeg" style="width:100%">
        <img src="../assets/images/scooter2.jpeg" style="width:100%">
        <img src="../assets/images/scooter3.jpeg" style="width:100%">

      </div>
      <div class="column">
        <img src="../assets/images/scooter4.jpeg" style="width:100%">
        <img src="../assets/images/scooter5.png" style="width:100%">
      </div>
    </div>
  </div>

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
    text-align:center;
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

  .row {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    padding: 0 4px;
  }

  .column {
    -ms-flex: 25%;
    flex: 25%;
    max-width: 25%;
    padding: 0 4px;
  }

  .column img {
    margin-top: 8px;
    vertical-align: middle;
    width: 100%;
  }

  /* Responsive layout - makes a two column-layout instead of four columns */
  @media screen and (max-width: 800px) {
    .column {
      -ms-flex: 50%;
      flex: 50%;
      max-width: 50%;
    }
  }

  /* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
  @media screen and (max-width: 600px) {
    .column {
      -ms-flex: 100%;
      flex: 100%;
      max-width: 100%;
    }
  }

  #middle {
    padding-left: 25%;
  }

  /* Responsive layout - puts left side of page above */
  @media screen and (max-width: 600px) {
    #left-side {
      width: 100%;
      padding-bottom: 50px;
    }

    .select {
      display: block;
      margin: auto;
    }
  }
</style>
