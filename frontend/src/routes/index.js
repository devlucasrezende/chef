import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/recipes',
      name: '/recipes',
      component: () => import('../components/Recipes.vue'),
    },
    {
      path: '/createRecipe',
      name: '/createRecipe',
      component: () => import('../components/CreateRecipe.vue'),
    },
  ],
});
