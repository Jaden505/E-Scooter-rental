<template>
  <h1 style="    display: inline-block;">E-scooters Amsterdam</h1>
  <br>
  <h3 id="sub-header">The easiest way to explore Amsterdam!</h3>

  <img src="../assets/images/E-scooter-icon1.jpeg" id="header-icon1">
  <img src="../assets/images/Green-energy-icon.jpeg" id="header-icon2">
  <hr>
</template>

<script>
export default {
  name: "HeaderComp"
}
</script>

<style scoped>
  #header-icon1 {
    width: 25%;
    position: absolute;
    top: 0px;
    left: 0px;
  }

  #header-icon2 {
    width: 20%;
    position: absolute;
    top: 0px;
    right: 0px;
  }

  #sub-header {
    float: right;
    padding-right: 20%;
  }

  hr {
    margin-top: 160px;
  }
</style>