<template>
    <div class="topnav">
      <a><router-link to="/">HOME</router-link></a>
      <a><router-link to="/scooters/overview31">SCOOTERS</router-link></a>
      <a href="#about">MY TRIPS</a>
      <a href="#about">MY ACCOUNT</a>
      <div class="rightnav">
        <a href="#about">SIGN UP</a>
        <a href="#about">LOG IN</a>
      </div>
    </div>
</template>
<script>
export default {
  name: "NavBar"
}
</script>


<style scoped>

  .topnav {
    overflow: hidden;
    background-color: #333;
  }

  .topnav a {
    float: left;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
  }
  .rightnav{
    float: right;
  }

  .topnav a:hover {
    background-color: #ddd;
    color: black;
  }



</style>