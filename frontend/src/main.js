import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import locale from 'element-ui/lib/locale/lang/pt-br';

import App from './App.vue';
import router from './routes';

Vue.config.productionTip = false;

Vue.use(ElementUI, { locale });

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');
