<template>
  <div>
  <div class="bg-img">
      <navbar />
      <div>
        </div>
</div>
<div class="footer">
  <p>Contact: 8563749284 for more Information and Emergency </p>
</div>
  </div>
</template>

<script>
import navbar from '@/components/navbar.vue'
export default {
  name: 'home',
  components: {
    navbar: navbar
  }
}
</script>

<style>
body {
  margin: 0%;
}
.footer {
  background-color: #aaaaaa;
  padding: 3px;
}
.bg-img {
  background-image: url("https://www.apollohospitals.com/images/patient-care/banner/edoc-patient-care.png");
  min-height: 1000px;
  width: 100%;
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
</style>
