<template>
  <el-row>
    <el-row>
      <Header />
    </el-row>
    <el-row>
      <el-col :span="12">
        <h1>Cadastrar receita</h1>
      </el-col>
      <el-col :span="12">
        <el-breadcrumb
          separator-class="el-icon-caret-right"
          style="margin: 40px; position: absolute; right: 0"
        >
          <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/recipes' }"
            >Receitas</el-breadcrumb-item
          >
          <el-breadcrumb-item>Cadastrar</el-breadcrumb-item>
        </el-breadcrumb>
      </el-col>
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
                    start: '00:00',
                    step: '00:01',
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
              <el-button
                icone="el-icon-plus"
                type="primary"
                class="btnAdd"
                @click="addIng()"
              >
                Adicionar</el-button
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
                  class="remove"
                  icon="el-icon-delete-solid"
                  @click.native.prevent="deleteRow(scope.$index, tableData)"
                >
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
                <el-input v-model="ruleForm.pass"></el-input>
              </el-col>
              <el-col :span="2">
                <el-button
                  icon="el-icon-plus"
                  type="primary"
                  class="btnAdd2"
                  @click="addPass()"
                >
                  Adicionar</el-button
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
                    class="remove"
                    icon="el-icon-delete-solid"
                    @click.native.prevent="deleteRow(scope.$index, passTable)"
                  >
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
        <el-button
          icon="el-icon-close"
          type="default"
          @click="$router.push({ name: '/recipes' })"
        >
          Cancelar</el-button
        >
      </el-col>
      <el-col :span="8" :offset="2">
        <el-button
          icon="el-icon-plus"
          type="primary"
          class="btnReg"
          @click="handleSubmit('ruleForm')"
        >
          Cadastrar</el-button
        >
      </el-col>
    </el-row>
  </el-row>
</template>

<script>
import Header from '../components/Header.vue';
import api from '../api';

export default {
  name: 'CreateRecipe',
  components: { Header },
  data() {
    return {
      tableData: [],
      passTable: [],
      passN: [],

      rendimentos: [
        {
          value: 1,
          label: '1 Porção',
        },
        {
          value: 2,
          label: '2 Porções',
        },
        {
          value: 3,
          label: '3 Porções',
        },
        {
          value: 4,
          label: '4 Porções',
        },
        {
          value: 5,
          label: '5 Porções',
        },
        {
          value: 6,
          label: '6 Porções',
        },
        {
          value: 7,
          label: '7 Porções',
        },
        {
          value: 8,
          label: '8 Porções',
        },
      ],

      ruleForm: {
        name: null,
        time: null,
        ren: null,
        categorias: [],
        pass: null,
        ing: null,
        unidade: null,
        un: null,
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
        pass: [
          {
            type: 'array',
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
    deleteRow(index, rows) {
      rows.splice(index, 1);
    },

    addIng() {
      const { un, ing, unidade } = this.ruleForm;
      const amount = `${un} ${unidade}`;
      this.tableData.push({ ing, amount });
    },

    addPass() {
      const { pass } = this.ruleForm;
      const i = this.passTable;

      this.passTable.push({ pass });
      this.passN.push(i.length);

      console.log(i.length);
    },

    handleSubmit(formName) {
      const { name, time, ren, categorias } = this.ruleForm;
      const data = {
        nome: name,
        tempoDePreparo: time,
        rendimento: ren,
        ing: this.tableData,
        pass: this.passTable,
        cat: categorias,
      };

      try {
        // eslint-disable-next-line consistent-return
        this.$refs[formName].validate(valid => {
          if (valid) {
            api.post('/receitas', data).then(() => {
              this.$notify({
                title: 'Sucesso',
                message: 'A receita foi criada com sucesso',
                type: 'success',
              });
              this.$refs[formName].resetFields();
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      } catch (e) {
        console.log(e);
      }
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style scoped>
.user {
  display: flex;
  width: auto;
}

.form {
  margin-left: 2rem;
}

.remove {
  color: #c53030;
}

.unSelect {
  width: 7.5rem;
  color: #db6e20;
}

.btnAdd {
  margin-top: 49px;
}

.btnAdd2 {
  margin-top: 2.1rem;
  margin-left: 2rem;
}

.btnReg {
  margin-top: 30px;
  position: absolute;
  right: 4rem;
}

h1 {
  max-width: 17rem;
  border-bottom: 4px solid #f88836;
  margin: 30px;
}

h2,
h3 {
  margin-bottom: 1rem;
}
</style>
