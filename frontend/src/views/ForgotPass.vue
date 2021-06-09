<template>
  <el-row>
    <el-image
      style="height: 100vh; display: flex"
      :src="require('../assets/background.png')"
    />
    <el-form style="position: absolute; top: 20%; left: 37%">
      <el-image :src="require('../assets/logo.png')" />
      <h1>Esqueceu sua senha?</h1>
      <p>Informe seu e-mail e aguarde!</p>
      <p>Vamos enviar as instruções para recuperar sua senha.</p>
      <p>E-mail</p>
      <el-input v-model="recoveyEmail" placeholder="Informe seu e-mail" />
      <el-button type="primary"
        ><i class="el-icon-unlock" /> Recuperar senha</el-button
      >
      <br />
      <span style="cursor: pointer" @click="$router.push({ name: '/SignIn' })"
        >Retornar ao Login</span
      >
    </el-form>
  </el-row>
</template>

<script>
export default {
  name: 'ForgotPass',
  data() {
    return {
      recoveyEmail: null,
    };
  },
};
</script>

<style scoped></style>
