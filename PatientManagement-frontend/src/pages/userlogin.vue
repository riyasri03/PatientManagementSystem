<template>
  <div>
    <navbar />
    <br>
    <br>
      <label id="seltext" for="selection">Select your perferred Doctor</label>
      <table style="width:100%">
        <tr>
             <th>Doctor Id</th>
            <th>Doctor Name</th>
            <th>Doctor Contact</th>
            <th>Doctor Email</th>
            <th>Select Doctor</th>
        </tr>
        <tr v-for = 'res in results' :key="res.patientId">
      <td>{{res.doctorId}}</td>
      <td>{{res.doctorName}}</td>
      <td>{{res.doctorContact}}</td>
      <td>{{res.doctorEmail}}</td>
      <td><button :disabled="validated ? '' : disabled" @click="checkSelected(res.doctorId, res.doctorName)" >Select Doctor</button></td>
       </tr>
      </table>
      <br>
      <br>
      <div id="issue">
      <label for="Issue"> Please Enter your Medical Concern </label>
      <input type="text" name="issue" v-model="issue">
      </div>
      <div>
       <br>
       <br>
       <button @click="history" class="btn payment"> History</button>
       <table v-show="histShow">
       <tr>
            <th>Doctor Name</th>
            <th>Doctor Contact</th>
            <th>Issue</th>
            <th>Month</th>
        </tr>
       <tr v-for="data in hist" :key="data.id">
         <td>{{data.doctorName}}</td>
         <td>{{data.doctorContact}}</td>
         <td>{{data.issue}}</td>
         <td>{{data.month}}</td>
        </tr>
      </table>
       </div>
       <br><br>
        <div><button v-if="this.results !== '' " class="btn payment" @click="makePayment">Make Payment</button></div>
       <router-link to ="/login"><button type='button' class=" btn payment"><i class="fa fa-sign-out"></i> Logout</button></router-link>
     </div>
</template>

<script>
import navbar from '@/components/navbar.vue'
import axios from 'axios'
import jsPDF from 'jspdf'
export default {
  name: 'userlogin',
  components: {
    navbar: navbar
  },
  data () {
    return {
      results: [],
      patientId: '',
      doctorId: '',
      hist: [],
      histShow: false,
      validated: false,
      issue: '',
      doctorName: '',
      paymentHist: ''
    }
  },
  created () {
    if (localStorage.getItem('sessionStatus') !== '200') {
      this.$router.push('/login')
    }
  },
  mounted () {
    this.patientId = localStorage.getItem('id')
    axios.get('http://10.177.68.61:8801/patient/doctorList').then((results) => {
      console.log(results)
      localStorage.setItem('details', results.data)
      this.results = results.data
    })
      .catch((error) => {
        console.log(error)
      })
  },
  methods: {
    checkSelected (id, docname) {
      this.validated = true
      const obj = {
        doctorId: id,
        issue: this.issue,
        doctorName: docname
      }
      axios.put('http://10.177.68.61:8801/patient/makePayment/' + this.patientId, obj).then((results) => {
        console.log('Success')
        console.log(results)
        localStorage.setItem('details', results.data)
        this.results = results.data
        if (this.results === '') {
          alert('You have already booked a doctor!')
        }
        console.log(results)
      })
        .catch((error) => {
          console.log(error)
        })
    },
    history () {
      this.histShow = true
      this.patientId = localStorage.getItem('id')
      axios.get('http://10.177.68.61:8801/patient/getPatientsHistory/' + this.patientId).then((output) => {
        console.log(output)
        localStorage.setItem('details', output.data)
        this.hist = output.data
        console.log(this.hist)
        this.hist.array.forEach(e => {
          this.hist.push(e)
        })
      })
        .catch((error) => {
          console.log(error)
        })
    },
    // selectDoctor () {
    //   this.docId=localStorage.getItem('id')
    //   axios.post('')

    // }
    makePayment () {
      this.patientId = localStorage.getItem('id')
      // eslint-disable-next-line new-cap
      const doc = new jsPDF()
      // let pdf = ''
      // const str = JSON.stringify(this.results)
      console.log(this.results)
      // for (const i in str) {
      //   const res = this.str[i]
      //   pdf = pdf + res.invoiceId
      // }

      // doc.text(str, 10, 10)
      // doc.text(JSON.stringify(this.results), 15, 15)
      doc.text('Invoice Id: ' + this.results.invoiceId, 65, 20)
      doc.text('Doctor Name: ' + this.results.doctorName, 65, 30)
      doc.text('patient Name: ' + this.results.patientName, 65, 40)
      doc.text('Doctor Contact: ' + this.results.doctorContact, 65, 50)
      doc.text('!!!PAYMENT SUCCESSFUL!!! ', 65, 80)
      doc.text('!!!AMOUNT PAID => 500!!!', 65, 100)
      doc.save('temp.pdf')
      this.$router.push('/payment')
    }
  }
}
</script>

<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: inherit;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color:#aaaaaa;
  color: white;
}
.payment {
  border-color: #4CAF50;
  color: green;
  border-radius: 10px;
}

.payment:hover {
  background-color: #4CAF50;
  color: white;
}
.btn {
  border: 2px solid black;
  background-color: white;
  color: black;
  padding: 10px 18px;
  font-size: 16px;
  cursor: pointer;
}
#seltext{
  font-family: "Lucida Console", "Courier New", monospace;
  font-weight: bold;
  font-size: 30px;
}
input[type=text]{
  width: auto;
  padding: 10px;
  margin: 5px 0 30px 0;
  background: whitesmoke;
}

input[type=text]:focus{
  background-color: #fff;
  outline: none;
}
#issue{
  font-family: "Lucida Console", "Courier New", monospace;
  font-weight: bold;
  font-size: 20px;
}
</style>
