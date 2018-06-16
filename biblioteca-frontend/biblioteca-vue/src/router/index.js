import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/components/Welcome'
import Aluno from '@/components/Aluno'
import Curso from '@/components/Curso'
import Item from '@/components/Item'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome
    },
    {
      path: '/aluno',
      name: 'Aluno',
      component: Aluno
    },
    {
      path: '/curso',
      name: 'Curso',
      component: Curso
    },
    {
      path: '/item',
      name: 'Item',
      component: Item
    }
  ]
})
