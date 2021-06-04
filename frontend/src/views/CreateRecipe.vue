<template>
  <el-row>
    <el-row>
      <Header />
    </el-row>
    <el-row>
      <h1>Cadastrar receita</h1>
    </el-row>
    <el-row>
      <el-form
        ref="ruleForm"
        :model="ruleForm"
        :rules="rules"
        label-position="top"
        label-width="150px"
        class="form"
      >
        <el-col :span="12" :xs="6" :xl="12">
          <el-row>
            <el-form-item label="Nome da receita" prop="name">
              <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
          </el-row>
          <el-row :gutter="18">
            <el-col :span="12">
              <el-form-item label="Tempo de preparo" prop="time">
                <el-time-select
                  v-model="ruleForm.time"
                  :picker-options="{
                    start: '00:15',
                    step: '00:15',
                    end: '05:00',
                  }"
                  placeholder="Tempo de Preparo"
                >
                </el-time-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="Rendimento" prop="ren">
                <el-select v-model="ruleForm.ren" placeholder="Unidade(s)">
                  <el-option
                    v-for="ren in rendimentos"
                    :key="ren.value"
                    :label="ren.label"
                    :value="ren.value"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-form-item label="Categorias" prop="categorias">
              <el-col :span="12">
                <el-checkbox-group v-model="ruleForm.categorias">
                  <el-checkbox label="Salgado" name="type"></el-checkbox>
                  <el-checkbox label="Doce" name="type"></el-checkbox>
                  <el-checkbox label="Vegano" name="type"></el-checkbox>
                  <el-checkbox label="Salada" name="type"></el-checkbox>
                  <el-checkbox label="Almoço" name="type"></el-checkbox>
                  <el-checkbox label="Jantar" name="type"></el-checkbox>
                  <el-checkbox label="Sobremesa" name="type"></el-checkbox>
                  <el-checkbox label="Fit" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-col>
            </el-form-item>
          </el-row>
          <el-row :gutter="10">
            <h2>Ingredientes</h2>
            <el-col :span="8">
              <el-form-item label="Nome do ingrediente" prop="ing">
                <el-input v-model="ruleForm.ing"></el-input></el-form-item
            ></el-col>
            <el-col :span="10" :offset="1">
              <el-form-item label="Quantidade" prop="un">
                <el-input v-model="ruleForm.un">
                  <el-select
                    slot="append"
                    v-model="ruleForm.unidade"
                    placeholder="unidades(s)"
                    class="unSelect"
                  >
                    <el-option label="gramas" value="gramas"></el-option>
                    <el-option label="ml" value="ml"></el-option>
                    <el-option label="kg" value="kg"></el-option>
                  </el-select>
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="2" :offset="1">
              <el-button class="btnAdd" @click="addIng()"
                ><i class="el-icon-plus" />Adicionar</el-button
              >
            </el-col>
          </el-row>
          <el-table :data="tableData" max-height="500" style="width: auto">
            <el-table-column fixed prop="ing" label="Ingrediente" width="auto">
            </el-table-column>
            <el-table-column prop="amount" label="Quantidade" width="auto">
            </el-table-column>
            <el-table-column label="Remover" width="120">
              <template slot-scope="scope">
                <el-button
                  type="text"
                  size="small"
                  @click.native.prevent="deleteRow(scope.$index, tableData)"
                >
                  Remove
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-col>
        <el-col :span="12" :xs="6" :xl="12">
          <el-row class="form">
            <h3>Modo de preparo</h3>
            <el-row>
              <el-col :span="16">
                <p style="margin-bottom: 1rem">Passo {{ passN }}:</p>
                <el-input v-model="pass"></el-input>
              </el-col>
              <el-col :span="2">
                <el-button class="btnAdd2" @click="addPass()"
                  ><i class="el-icon-plus" />Adicionar</el-button
                >
              </el-col>
            </el-row>
            <el-table :data="passTable" max-height="500">
              <el-table-column prop="pass" width="auto"> </el-table-column>

              <el-table-column label="Remover" width="auto">
                <template slot-scope="scope">
                  <el-button
                    type="text"
                    size="small"
                    @click.native.prevent="deleteRow(scope.$index, passTable)"
                  >
                    Remove
                  </el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-row>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="12" :offset="1" style="margin-top: 30px">
        <el-button @click="$router.push({ name: '/' })">Cancelar</el-button>
      </el-col>
      <el-col :span="8" :offset="2">
        <el-button class="btnReg" @click="handleSubmit()">Cadastrar</el-button>
      </el-col>
    </el-row>
  </el-row>
</template>

<script>
import Header from '../components/Header.vue';
// import axios from 'axios';

export default {
  name: 'CreateRecipe',
  components: { Header },
  data() {
    return {
      tableData: [],
      passTable: [],
      pass: [],
      passN: '',

      rendimentos: [
        {
          value: '1 Porção',
          label: '1 Porção',
        },
        {
          value: '2 Porções',
          label: '2 Porções',
        },
        {
          value: '3 Porções',
          label: '3 Porções',
        },
        {
          value: '4 Porções',
          label: '4 Porções',
        },
        {
          value: '5 Porções',
          label: '5 Porções',
        },
        {
          value: '6 Porções',
          label: '6 Porções',
        },
        {
          value: '7 Porções',
          label: '7 Porções',
        },
        {
          value: '8 Porções',
          label: '8 Porções',
        },
      ],
      rend: '',

      ruleForm: {
        name: '',
        time: '',
        ren: '',
        categorias: [],
        ing: '',
        unidade: '',
        un: '',
        preparo: '',
      },

      rules: {
        name: [
          {
            required: true,
            message: 'Nome da receita obrigatório',
            trigger: 'blur',
          },
          {
            min: 3,
            max: 20,
            message: 'Deve conter de 3 a 20 caracteres',
            trigger: 'blur',
          },
        ],
        time: [
          {
            required: true,
            message: 'Tempo de preparo obrigatório',
            trigger: 'change',
          },
        ],
        ren: [
          {
            required: true,
            message: '',
            trigger: 'blur',
          },
        ],
        categorias: [
          {
            type: 'array',
            required: true,
            message: 'Por favor selecione pelo menos um',
            trigger: 'change',
          },
        ],
        ing: [
          {
            required: true,
            message: 'Ingrediente obrigatório',
            trigger: 'blur',
          },
        ],
        un: [
          {
            required: true,
            message: 'Quantidade obrigatória',
            trigger: 'blur',
          },
        ],
      },
    };
  },
  methods: {
    resetForm(ruleForm) {
      this.$refs[ruleForm].resetFields();
    },
    deleteRow(index, rows) {
      rows.splice(index, 1);
    },
    addIng() {
      const { un, ing, unidade } = this.ruleForm;
      const amount = `${un} ${unidade}`;
      this.tableData.push({ un, ing, amount });
    },

    addPass() {
      const { pass } = this;
      this.passTable.push({ pass });
    },

    handleSubmit() {
      // const passT = this.passTable;
      // const amount = `${un} ${unidade}`;
      // const data = JSON.stringify({ tableData: this.tableData });

      // const data = {
      //   nome: name,
      // };

      // axios.post('/receitas', data).then(() => alert('ok'));

      this.$notify({
        title: 'Success',
        message: 'This is a success message',
        type: 'success',
      });
    },
  },
};
</script>

<style scoped>
.el-header {
  background: #f88836;
}

.user {
  display: flex;
  width: auto;
}

.form {
  margin-left: 2rem;
}

.form2 {
}

.unSelect {
  width: 8rem;
}

.btnAdd {
  margin-top: 49px;
  background-color: #f88836;
  color: #fff;
}

.btnAdd2 {
  margin-top: 2.1rem;
  margin-left: 2rem;
  background-color: #f88836;
  color: #fff;
}

.btnReg {
  background-color: #f88836;
  color: #fff;
  margin-top: 30px;
}

.btnAdd:hover {
  background-color: #ff892a;
}

img {
  max-width: 115px;
  max-height: 101px;
  filter: brightness(0) invert(1);
  cursor: pointer;
}

h1 {
  color: #535353;
  max-width: 17rem;
  border-bottom: 4px solid #f88836;
  margin: 30px;
}

h2 {
  color: #535353;
  margin-bottom: 1rem;
}

h3 {
  color: #535353;
  margin-bottom: 1rem;
}
p {
  font-size: 14px;
  color: #535353;
}
</style>
