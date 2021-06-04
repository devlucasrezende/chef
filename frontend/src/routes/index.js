import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: '/SignIn',
      component: () => import('../views/SignIn.vue'),
    },
    {
      path: '/recipes',
      name: '/recipes',
      component: () => import('../views/Recipes.vue'),
    },
    {
      path: '/createrecipe',
      name: '/createrecipe',
      component: () => import('../views/CreateRecipe.vue'),
    },
  ],
});
