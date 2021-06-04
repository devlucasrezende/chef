<template>
  <el-row>
    <el-col :span="20">
      <el-header>
        <img
          :src="require('../assets/logo.png')"
          alt="logo"
          @click="$router.push({ name: '/' })"
        />
      </el-header>
    </el-col>
    <el-col class="user" :span="4">
      <el-avatar :size="30" :src="require('../assets/logo.png')"></el-avatar>
      <p style="width: 100px">Daniel Vidal Pizzaiolo</p>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'Header',
};
</script>

<style scoped>
.el-header {
  background: #f88836;
}

.user {
  background: #f88836;
  height: 60px;
  display: flex;
}

.el-avatar {
  margin-top: 1rem;
  display: flex;
  flex-direction: column;
}

img {
  max-width: 115px;
  max-height: 101px;
  filter: brightness(0) invert(1);
  cursor: pointer;
}

p {
  margin: auto;
}
</style>
