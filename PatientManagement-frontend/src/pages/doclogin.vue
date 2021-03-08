<template>
  <div>
    <navbar />
    <h1>Welcome Doctor</h1>
      <table style="width:100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Contact</th>
            <th>Age</th>
            <th>Gender</th>
            <th>issue</th>
            <th>Month</th>
            <th>Cosultation </th>
        </tr>
      <tr v-for ='(res, index) in results' :key="res.doctorId">
      <td>{{res.id}}</td>
      <td>{{res.patientName}}</td>
      <td>{{res.patientContact}}</td>
      <td>{{res.age}}</td>
      <td>{{res.gender}}</td>
      <td>{{res.issue}}</td>
      <td>
        <label for="month">Month</label>
        <select name="month" id="month" v-model="month[index]" placeholder="Select Month">
         <option value="january">January</option>
         <option value="february">February</option>
         <option value="march">March</option>
         <option value="april">April</option>
         <option value="may">May</option>
         <option value="june">June</option>
         <option value="july">July</option>
         <option value="august">August</option>
         <option value="september">September</option>
         <option value="october">October</option>
         <option value="november">November</option>
         <option value="december">December</option>
        </select></td>
      <td><button @click="consultationEnd(res.id, index)" class="btn endconsult">consultation end</button></td>
      </tr>

      </table>
      <div>
        <br>
        <br>
      <label for="searchString"><b>Previous Patients Records</b></label>
      <br>
      <input type="text" placeholder="Search.." name="searchString" class="search" v-model="searchString">
      <button type="submit" style="font-size: 20px;" @click="searchQuery"><i class="fa fa-search"></i></button>
      </div>
      <table v-show="histShow">
      <tr>
            <th>History Id</th>
            <th>Patient Id</th>
            <th>Doctor Id</th>
            <th>Patient Name</th>
            <th>Doctor Name</th>
            <th>Month</th>
            <th>Issue</th>
        </tr>
      <tr v-for="i in search" :key="i.id">
        <td>{{i.historyId}}</td>
         <td>{{i.patientId}}</td>
         <td>{{i.doctorId}}</td>
         <td>{{i.patientName}}</td>
         <td>{{i.doctorName}}</td>
         <td>{{i.month}}</td>
         <td>{{i.issue}}</td>
      </tr>
      </table>
      <div>
        <br><br>
      <router-link to ="/login"><button type='button' class=""><i class="fa fa-sign-out"></i> Logout</button></router-link>
      </div>
  </div>
</template>

<script>
import navbar from '@/components/navbar.vue'
import axios from 'axios'
export default {
  name: 'doclogin',
  components: {
    navbar: navbar
  },
  data () {
    return {
      results: [],
      doctorId: '',
      res: [],
      month: [],
      patientId: '',
      monthsend: '',
      hist: [],
      histShow: false,
      searchString: '',
      search: ''
    }
  },
  methods: {
    consultationEnd (id, index) {
      const obj = {
        doctorId: this.doctorId,
        patientId: id,
        month: this.month[index]
      }
      axios.put('http://10.177.68.61:8801/doctor/endConsultation/', obj).then((res) => {
        console.log('response..', res)
      })
    },
    history () {
      this.histShow = true
      this.patientId = localStorage.getItem('id')
      axios.get('http://10.177.68.61:8801/doctor/getPatientsHistory/' + this.doctorId).then((output) => {
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
    searchQuery () {
      this.histShow = true
      axios.get('http://10.177.68.61:8800/search/recordsFromHistory/' + this.searchString).then((output) => {
        console.log(output)
        localStorage.setItem('details', output.data)
        this.search = output.data
        console.log(this.search)
        this.search.array.forEach(e => {
          this.search.push(e)
        })
      })
        .catch((error) => {
          console.log(error)
        })
    }
  },
  mounted () {
    this.doctorId = localStorage.getItem('id')
    axios.get('http://10.177.68.61:8801/doctor/patientList/' + this.doctorId).then((result) => {
      console.log(result)
      localStorage.setItem('details', result.data)
      this.results = result.data
    })
      .catch((error) => {
        console.log(error)
      })
  },
  created () {
    if (localStorage.getItem('sessionStatus') !== '200') {
      this.$router.push('/login')
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
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color:#aaaaaa;
  color: white;
}
.endconsult {
  border-color: #4CAF50;
  color: green;
}

.endconsult:hover {
  background-color: #4CAF50;
  color: white;
}
.btn {
  border: 2px solid black;
  background-color: white;
  color: black;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
}
.search {
  width: auto;
  padding: 15px;
  margin: 5px 0 22px 0;
  background-color: whitesmoke;
}
</style>
