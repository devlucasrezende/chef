<template>
  <div id="app">
    <CreateRecipe />
  </div>
</template>

<script>
import CreateRecipe from './components/CreateRecipe.vue';

export default {
  name: 'App',
  components: {
    CreateRecipe,
  },
};
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  font-family: 'Lexend', sans-serif;
}
</style>
