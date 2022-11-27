<template>
    <div class="topnav">
      <router-link to="/">HOME</router-link>

      <div class="dropdown">
        <button class="dropbtn">SCOOTERS</button>
        <div class="dropdown-content">
          <a><router-link to="/scooters/overview31">All scooters</router-link></a>
          <a><router-link to="/scooters/overview32">Scooters edit (comp)</router-link></a>
          <a><router-link to="/scooters/overview33">Scooters edit (router)</router-link></a>
          <a><router-link to="/scooters/overview34">Scooters edit (managed)</router-link></a>
          <a><router-link to="/scooters/overview34">Scooters edit (guarded)</router-link></a>
          <a><router-link to="/scooters/overview37">Scooters edit (REST-backend)</router-link></a>
          <a><router-link to="/scooters/overview37">Scooters edit (Cached backend)</router-link></a>
        </div>
      </div>

      <a>MY TRIPS</a>
      <a>MY ACCOUNT</a>
      <div class="rightnav">
        <a href="/sign-up">SIGN UP</a>
        <a href="/sign-in">LOG IN</a>
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

  /* Dropdown Button */
  .dropbtn {
    float: left;
    background-color: #333;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
  }

  /* The container <div> - needed to position the dropdown content */
  .dropdown {
    position: relative;
    display: inline-block;
  }

  /* Dropdown Content (Hidden by Default) */
  .dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
  }

  /* Links inside the dropdown */
  .dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
  }

  /* Change color of dropdown links on hover */
  .dropdown-content a:hover {background-color: #ddd;}

  /* Show the dropdown menu on hover */
  .dropdown:hover .dropdown-content {display: block;}

  /* Change the background color of the dropdown button when the dropdown content is shown */
  .dropdown:hover .dropbtn {background-color: #ddd; color: black;}

</style>