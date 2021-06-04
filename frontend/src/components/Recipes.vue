<template>
  <el-row>
    <el-row>
      <Header />
    </el-row>
    <el-row>
      <h1>Receitas</h1>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-input v-model="search" size="mini" placeholder="Type to search" />
      </el-col>
      <el-col :span="4" :offset="12">
        <el-button
          class="btnRecipe"
          @click="$router.push({ name: '/createRecipe' })"
          >Cadastrar receita</el-button
        >
      </el-col>
      <el-row style="margin: 24px">
        <h2>Receitas</h2>
      </el-row>
      <el-table
        :data="
          tableData.filter(
            data =>
              !search || data.name.toLowerCase().includes(search.toLowerCase()),
          )
        "
        style="width: 100%"
      >
        <el-table-column label="Date" prop="date"> </el-table-column>
        <el-table-column label="Name" prop="name"> </el-table-column>
        <el-table-column align="right">
          <template slot="header"> </template>
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
              >Edit</el-button
            >
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)"
              >Delete</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </el-row>
  </el-row>
</template>

<script>
import Header from './Header.vue';

export default {
  name: 'Recipes',
  components: {
    Header,
  },
  data() {
    return {
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'John',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Morgan',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Jessy',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ],
      search: '',
    };
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
  },
};
</script>


<style scoped>
.btnRecipe {
  background-color: #f88836;
  color: #fff;
}

h1 {
  color: #535353;
  max-width: 17rem;
  border-bottom: 4px solid #f88836;
  margin: 30px;
}

h2 {
  color: #535353;
}
</style>
