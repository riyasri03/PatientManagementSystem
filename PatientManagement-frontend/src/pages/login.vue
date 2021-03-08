<template>
<div>
<div id='login' class='bg-img'>
  <navbar />
        <div class="container">
        <h1>Login</h1>
        <div style="font-size: 100px;">
          <i class="fa fa-user-circle fa-10x"></i>
        </div>
        <i class="fa fa-user icon"></i>
        <label for="email"><b> Email</b></label>
        <br>
        <input type='text' name='email' v-model='email' placeholder="Email" label="email" />
        <br>
        <i class="fa fa-key icon"></i>
        <label for="psw"><b> Password</b></label>
        <br>
        <input type='password' name='password' v-model='password' placeholder="Password" label="password" />
        <br>
          <p>Please select your Role:</p>
          <input type="radio" id="Doctor" v-model="role" value="Doctor" name='Doctor'>
          <label for="Doctor">Doctor</label><br>
          <input type="radio" id="Patient" v-model="role" value="Patient" name='Patient'>
          <label for="Patient">Patient</label><br>
          <input type="radio" id="nurse" v-model="role" value="nurse" name='nurse'>
          <label for="other">Nurse</label>
          <br>
          <br>
        <button type='button' v-on:click='onsubmit' class="btn login">Login</button>
        <br>
        <div class="g-signin2" data-onsuccess="onSignIn"></div>
        </div>
    </div>
    <div class="footer">
          <p>Contact: 8563749284 for more Information and Emergency</p>
         </div>
     </div>
</template>

<script>
import navbar from '@/components/navbar.vue'
import axios from 'axios'
export default {
  name: 'login',
  components: {
    navbar: navbar
  },
  data () {
    return {
      email: '',
      password: '',
      role: []
    }
  },
  methods: {
    onsubmit () {
      console.log('In submit')
      const obj = {
        email: this.email,
        password: this.password,
        role: this.role
      }
      axios.post('http://10.177.68.61:8801/login/', obj).then((res) => {
        console.log('response..', res)
        localStorage.setItem('id', res.data.id)
        const det = res.data.id
        const sts = res.data.status
        localStorage.setItem('sessionStatus', sts)
        if (this.role === 'Doctor' && det !== -1 && sts !== 400) this.$router.push('/doclogin')
        else if (this.role === 'Patient' && det !== -1 && sts !== 400) this.$router.push('/userlogin')
        else if (this.role === 'nurse' && sts === 200) this.$router.push('/nurselogin')
        else alert('wrong Uername or Password!!')
      })
    },
    onSignIn (googleUser) {
      console.log('fdfgdfs')
      var idToken = googleUser.getAuthResponse().id_token
      console.log(idToken)
    }
  }
}
</script>

<style scoped>
.bg-img {
  /* The image used */
  background-image: url("https://www.apollohospitals.com/images/patient-care/speak-patient.jpg");

  min-height: 800px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
input[type=text], input[type=password] {
  width: auto;
  padding: 15px;
  margin: 5px 0 22px 0;
  background: black;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #fff;
  outline: none;
}
.container {
  position: absolute;
  right: 90px;
  margin: 50px;
  width: 300px;
  padding: 20px;
  background-color: white;
  opacity: 0.6;
  color:black;
  border-radius: 20px;
}
.footer {
  background-color: #aaaaaa;
  padding: 5px;
}
.btn {
  border: none;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  border-radius: 10px;
}
.login {background-color: #4CAF50;} /* Green */
.login:hover {background-color: #46a049;}
 body {
   margin: 0%;

}
.g-signin2 {
  margin: 5px;
  margin-left: 90px;
}
</style>
