<template>
  <nav class='navbar'>
      <ul>
      <li><router-link to ="/home" ><i class="fa fa-home"></i> Home</router-link></li>
      <li><router-link to ="/login"><i class="fa fa-user"></i> Login</router-link></li>
      <li><router-link to ="/registration"><i class="fa fa-clipboard"></i> New Patient</router-link></li>
      <li><a v-on:click='onsubmit'><i class="fa fa-phone"></i> Contact Us</a></li>
      <li id="emergency" style="color : red"><a v-on:click='onsubmit'><i class="fa fa-ambulance"></i> Emergency</a></li>
      </ul>

  </nav>
</template>

<script>
export default {
  name: 'navbar',
  methods: {
    onsubmit () {
      window.scrollTo(0, document.body.scrollHeight)
    }
  }
}
</script>

<style>
.navbar {
    height: 50px;
}
a{
    margin: 10px;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #aaaaaa;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color:#a4ebf3;
}
#emergency {
 color: red;
 float: right;
}

/* .active {
  background-color: greenyellow;
} */
</style>
