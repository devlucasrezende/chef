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
        <el-input v-model="search" size="mini" placeholder="Pesquisar" />
      </el-col>
      <el-col :span="4" :offset="12">
        <el-button
          class="btnRecipe"
          @click="$router.push({ name: '/createRecipe' })"
          >Cadastrar receita</el-button
        >
      </el-col>
    </el-row>
    <el-row style="margin: 24px">
      <h2>Receitas</h2>
    </el-row>
    <el-table
      :data="
        tableData.filter(
          data =>
            !search ||
            data.recipes.toLowerCase().includes(search.toLowerCase()),
        )
      "
      style="width: 100%"
    >
      <el-table-column label="Nome da Receita" prop="recipes" sortable="">
      </el-table-column>
      <el-table-column label="Tempo de Preparo " prop="prep" sortable="">
      </el-table-column>
      <el-table-column label="Categoria" prop="category" sortable="">
      </el-table-column>
      <el-table-column label="Chef" prop="chef" sortable=""> </el-table-column>
      <el-table-column label="Rendimento" prop="yield" sortable="">
      </el-table-column>
      <el-table-column label="Ações">
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
          recipes: 'Pizza de calabresa',
          prep: '40 minutos',
          category: 'Salgado, Fast Food',
          chef: 'Daniel Vidal',
          yield: '8 Porçoes',
        },
        {
          recipes: 'Pizza de mussarela',
          prep: '40 minutos',
          category: 'Salgado, Fast Food',
          chef: 'Thiago',
          yield: '8 Porçoes',
        },
        {
          recipes: 'Strogonoff',
          prep: '30 minutos',
          category: 'Almoço',
          chef: 'Tobias',
          yield: '5 Porçoes',
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
