<template>
  <el-row>
    <el-row>
      <Header />
    </el-row>
    <div v-for="item in tableData" :key="item.id">
      <el-dialog :title="item.nome" :visible.sync="dialogFormVisible">
        <p>Descrição: {{ item.categorias }}</p>
        <p>Tempo de preparo</p>
        <p>Rendimento</p>
        <p>Descrição: {{ item.descricao }}</p>
        <p>Ingredientes</p>
        <p>Modo de preparo</p>
      </el-dialog>
    </div>
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
            !search || data.nome.toLowerCase().includes(search.toLowerCase()),
        )
      "
      style="width: 100%"
      height="500"
    >
      <el-table-column label="Nome da Receita" prop="nome" />
      <el-table-column label="Tempo de Preparo " prop="tempoDePreparo" />
      <el-table-column label="Categoria" :prop="getCategory()" />
      <el-table-column label="Chef" prop="chef" />
      <el-table-column label="Rendimento" prop="rendimento" />
      <el-table-column label="Ações">
        <template slot-scope="scope">
          <el-dropdown @command="handleAction">
            <el-button size="mini" type="primary"
              >Ações <i class="el-icon-arrow-down el-icon--right"
            /></el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item icon="el-icon-view" command="see">
                Visualizar</el-dropdown-item
              >
              <el-dropdown-item icon="el-icon-edit-outline" command="edit">
                Editar</el-dropdown-item
              >
              <el-dropdown-item
                icon="el-icon-close"
                @click.native.prevent="handleDelete(scope.$index, scope.row)"
              >
                Remover</el-dropdown-item
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
      tableData: [
        {
          descricao: null,
        },
      ],

      search: null,
      dialogFormVisible: false,
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

    getCategory() {
      return 'ok';
    },

    handleDelete(index, row) {
      const deleteBy = (index, row);
      try {
        ApiService.delete(deleteBy.id).then(res => {
          console.log(res);
        });
      } catch (e) {
        console.log(e);
        console.log(deleteBy);
      }
    },

    handleAction(command) {
      if (command === 'see') {
        this.dialogFormVisible = true;
      }
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
