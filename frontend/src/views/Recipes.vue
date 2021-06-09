<template>
  <el-row>
    <el-row>
      <Header />
    </el-row>
    <el-row>
      <el-col :span="12">
        <h1>Receitas</h1>
      </el-col>
      <el-col :span="12">
        <el-breadcrumb
          separator-class="el-icon-caret-right"
          style="margin: 40px; position: absolute; right: 0"
        >
          <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
          <el-breadcrumb-item>Receitas</el-breadcrumb-item>
        </el-breadcrumb>
      </el-col>
    </el-row>
    <el-row :gutter="12">
      <el-col :span="6">
        <el-input v-model="search" placeholder="Pesquisar" />
      </el-col>
      <el-col :span="2">
        <el-button type="primary" icon="el-icon-search"> Pesquisar</el-button>
      </el-col>
      <el-col :span="4" :offset="12">
        <el-button
          icon="el-icon-plus"
          type="primary"
          @click="$router.push({ name: '/createrecipe' })"
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
      height="500"
    >
      <el-table-column label="Nome da Receita" prop="nome" sortable="">
      </el-table-column>
      <el-table-column label="Tempo de Preparo " prop="tempoDePreparo">
      </el-table-column>
      <el-table-column label="Categoria" prop="categorias" sortable="">
      </el-table-column>
      <el-table-column label="Chef" prop="chef" sortable=""> </el-table-column>
      <el-table-column label="Rendimento" prop="rendimento" sortable="">
      </el-table-column>
      <el-table-column label="Ações">
        <template slot-scope="scope">
          <el-dropdown>
            <el-button
              size="mini"
              type="primary"
              @click="handleDelete(scope.$index, scope.row)"
              >Ações <i class="el-icon-arrow-down el-icon--right"
            /></el-button>

            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>
                <i class="el-icon-view" /> Visualizar</el-dropdown-item
              >
              <el-dropdown-item
                ><i class="el-icon-edit-outline" /> Editar</el-dropdown-item
              >
              <el-dropdown-item
                ><i class="el-icon-close" /> Remover</el-dropdown-item
              >
            </el-dropdown-menu>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>
    <el-row>
      <el-col>
        <el-pagination
          background
          small
          layout="prev, pager, next"
          :total="500"
          style="position: absolute; right: 2rem; margin-top: 2rem"
        >
        </el-pagination>
      </el-col>
    </el-row>
  </el-row>
</template>

<script>
import Header from '../components/Header.vue';
import ApiService from '../services/ApiService';

export default {
  name: 'Recipes',
  components: {
    Header,
  },
  data() {
    return {
      tableData: [],
      search: '',
    };
  },
  mounted() {
    this.retrieveRecipes();
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },

    retrieveRecipes() {
      ApiService.getAll()
        .then(res => {
          this.tableData = res.data;
          console.log(res.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    handleDelete(index, row) {
      console.log(index, row);
    },
  },
};
</script>


<style scoped>
h1 {
  max-width: 17rem;
  border-bottom: 4px solid #f88836;
  margin: 30px;
}
</style>
