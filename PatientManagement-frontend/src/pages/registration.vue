<template>
  <div id="app" class="bg-img">
    <navbar />
    <form class="container" >
      <h1>New Patient Registration</h1>
      <div>
        <label for="Name">Name </label>
        <input type="text" name="name" v-model="name" placeholder="Name">
      </div>
      <div>
        <label for="email">Email </label>
        <input type="text" name="email" v-model="email" placeholder="Email">
      </div>
      <div>
        <label for="password">Password </label>
        <input name="password" v-model="password" placeholder="Password" type="password">
      </div>
      <div>
        <label for="gender">Gender</label>
        <br>
      <input type="radio" id="male" value="male" v-model="gender">
        <label for="male">Male</label>
        <br>
        <input type="radio" id="female" value="female" v-model="gender">
        <label for="female">Female</label>
        <br>
         <input type="radio" id="others" value="others" v-model="gender">
        <label for="others">Others</label>
     </div>
      <div>
        <label for="age">Age </label>
        <input name="age" v-model="age" placeholder="Age" type="number">
      </div>
      <div>
        <label for="address">Address </label>
        <textarea type="text" name="address" v-model="address" placeholder="Address"></textarea>
      </div>
      <div>
        <label for="contact">Contact </label>
        <input type="text" name="contact" v-model="contact" placeholder="Contact">
      </div>
      <div>
        <label for="emergencyContact">Emergency Contact </label>
        <input type="text" name="emergencyContact" v-model="emergencyContact" placeholder="Emergency contact">
      </div>
      <div>
        <label for="admissionMonth">Admission Month </label>
        <input type="text" name="admissionMonth" v-model="admissionMonth" placeholder="Admission month">
      </div>
      <div>
        <label for="height">Height </label>
        <input type="text" name="height" v-model="height" placeholder="Height">
      </div>
      <div>
        <label for="weight">Weight </label>
        <input type="text" name="weight" v-model="weight" placeholder="Weight">
      </div>
      <div>
        <label for="currentMedication">Current Medication </label>
        <select name="currentMedication" id="currentMedication" v-model="currentMedication" placeholder="Medication">
         <option value="yes">Yes</option>
         <option value="no">No</option>
        </select>
      </div>
      <br>
      <button @click.prevent="clicked" name="register" class="btn register">Register</button>
      <div>
         <p>Already have an account? <a href='/login'>Login in</a>.</p>
      </div>
    </form>
    <div class="footer">
  <p>Contact: 8563749284 for more Information and Emergency</p>
</div>
  </div>
</template>
<script>
import axios from 'axios'
import navbar from '@/components/navbar.vue'
export default {
  name: 'App',
  components: {
    navbar: navbar
  },
  data () {
    return {
      name: '',
      email: '',
      password: '',
      gender: [],
      age: '',
      address: '',
      contact: '',
      emergencyContact: '',
      admissionMonth: '',
      height: '',
      weight: '',
      currentMedication: []
    }
  },
  methods: {
    validate () {
      if (this.name === '') {
        alert('Name must be filled out')
        return false
      } else if (!this.ValidateEmail(this.email)) {
        alert('You have entered an invalid email address!')
        return false
      } else {
        return true
      }
    },
    ValidateEmail (mail) {
      return /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(mail)
    },
    clicked () {
      const body = {
        name: this.name,
        email: this.email,
        password: this.password,
        gender: this.gender,
        age: this.age,
        address: this.address,
        contact: this.contact,
        emergencyContact: this.emergencyContact,
        admissionMonth: this.admissionMonth,
        height: this.height,
        weight: this.weight,
        currentMedication: this.currentMedication
      }
      if (this.validate()) {
        axios.post('http://10.177.68.61:8801/patient/registration', body).then((res) => {
          console.log(res)
          const data = res.data
          if (data === '') {
            alert('User already exist')
          } else {
            this.$router.push('/login')
          }
        })
      }
    }
  }
}
</script>
<style scoped>
input[type=text], input[type=password], input[type=number], textarea, select {
  width: auto;
  padding: 10px;
  margin: 15px 0 20px 0;
  border: none;
  background: whitesmoke;
}

input[type=text]:focus, input[type=password]:focus, input[type=number], textarea, select{
  background-color: #fff;
  outline: none;
}
.container {
  background-position: center;
  right: 90px;
  margin: 50px;
  width: 400px;
  padding: 20px;
  background-color: #aaaaaa;
  opacity: 0.8;
  color:black;
  border-radius: 20px;
  text-align: center;
}
.bg-img {
  background-image: url("https://www.apollohospitals.com/images/patient-care/plus-image.jpg");
  min-height: 800px;
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
.btn {
  border: none;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  border-radius: 10px;
}
.register {background-color: #4CAF50;} /* Green */
.register:hover {background-color: #46a049;}
</style>
