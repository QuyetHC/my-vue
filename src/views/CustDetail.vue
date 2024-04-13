<!-- <template>
    <div class="single-employee">
      <div>
        <h3>Thông tin khách hàng chi tiết</h3>
        <div class="card">
          <div class="card-body">
            <form class="form-inline">
              <div class="form-group">
                <v-text-field
                  v-model="info.id"
                  class="form-control ml-sm-2 mr-sm-4 my-2"
                  label="ID"
                  disabled="false"
                  required
                ></v-text-field>
              </div>
              <div class="form-group">
                <v-text-field
                  v-model="info.name"
                  :counter="20"
                  class="form-control ml-sm-2 mr-sm-4 my-2"
                  label="Name"
                  required
                ></v-text-field>
              </div>
              <div class="form-group">
                <v-text-field
                  v-model="info.age"
                  :rules="ageRules"
                  class="form-control ml-sm-2 mr-sm-4 my-2"
                  label="Age"
                  required
                ></v-text-field>
              </div>
              <div class="form-group">
                <v-text-field
                  v-model="info.salary"
                  class="form-control ml-sm-2 mr-sm-4 my-2"
                  label="Salary"
                  required
                ></v-text-field>
              </div>
              <div class="form-group">
                <v-select
                  class="form-control"
                  v-model="info.departmentId"
                  :items="Department"
                  item-text="name"
                  item-value="id"
                  label="Department"
                  required
                >
                </v-select>
              </div>
              <div class="ml-auto text-right">
                <v-btn @click="clickEdit(info)" depressed> Edit </v-btn>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      info: {
        id: '',
        name: '',
        age: '',
        salary: '',
        departmentId: ''
      },
      Department: [] // Assume you have the departments data populated here
    };
  },
  methods: {
    clickEdit(info) {
      axios.put('https://example.com/api/employee/' + info.id, info)
        .then(response => {
          console.log(response.data);
          // Handle success, maybe show a success message
        })
        .catch(error => {
          console.error('There was an error!', error);
          // Handle error, show an error message maybe
        });
    }
  }
}
</script> -->
