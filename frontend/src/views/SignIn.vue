<template>
  <el-row ref="require('../assets/background.png')" class="container">
    <div class="form">
      <img src="../assets/logo.png" alt="" />
      <label>E-mail</label>
      <el-input v-model="mail" placeholder="daniel@youxgroup"></el-input>
      <label>Senha</label>
      <el-input type="password" placeholder="Digite sua Senha" />
      <button type="submit" @click="$router.push({ name: '/recipes' })">
        Entrar
      </button>
      <div class="ctr">
        <span>
          Não tem conta?
          <span class="toClick">Cadastre-se</span>
        </span>
      </div>
      <br />
      <div class="ctr">
        <span class="toClick" @click="$router.push({ name: '/Forgot' })"
          >Esqueci minha senha</span
        >
      </div>
    </div>
  </el-row>
</template>

<script>
export default {
  name: 'SignIn',
  data() {
    return {
      mail: '',
    };
  },

  methods: {
    redirect() {},
  },
};
</script>

<style scoped>
.container {
  display: flex;
  height: 100vh;
  align-items: stretch;
}

.ctr {
  display: flex;
  justify-content: center;
  margin-top: 15px;
}

.toClick {
  color: #db6e20;
  cursor: pointer;
}

.form {
  display: flex;
  flex-direction: column;
  padding: 50px;
  margin: 50px auto;
  max-width: 280px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.6);
}

img {
  margin-bottom: 10rem;
  image-rendering: optimizeQuality;
}

label {
}

el-input {
  border: #808080;
  height: 35px;
  margin-top: 15px;
  margin-bottom: 15px;
}

button {
  background: #ff892a;
  border: 0;
  border-radius: 5px;
  color: #fff;
  font-size: 18px;
  height: 45px;
  cursor: pointer;
}

.toClick:hover {
  color: #ff892a;
}

a {
  text-decoration: none;
  font-size: 18px;
  color: #ff892a;
}

a:hover {
  color: #db6e20;
}

button:hover {
  background: #db6e20;
}
</style>
