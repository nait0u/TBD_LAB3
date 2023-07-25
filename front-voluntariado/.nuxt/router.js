import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _dc89b6fe = () => interopDefault(import('..\\pages\\getById.vue' /* webpackChunkName: "pages/getById" */))
const _07cc4c9c = () => interopDefault(import('..\\pages\\listaEmergencia.vue' /* webpackChunkName: "pages/listaEmergencia" */))
const _79509c2c = () => interopDefault(import('..\\pages\\listaHabilidades.vue' /* webpackChunkName: "pages/listaHabilidades" */))
const _5f10cb62 = () => interopDefault(import('..\\pages\\login.vue' /* webpackChunkName: "pages/login" */))
const _1fb0946a = () => interopDefault(import('..\\pages\\registroEmergencia.vue' /* webpackChunkName: "pages/registroEmergencia" */))
const _450bb622 = () => interopDefault(import('..\\pages\\registroInstitucion.vue' /* webpackChunkName: "pages/registroInstitucion" */))
const _8adead98 = () => interopDefault(import('..\\pages\\registroUsuario.vue' /* webpackChunkName: "pages/registroUsuario" */))
const _41c3cfdc = () => interopDefault(import('..\\pages\\updateById.vue' /* webpackChunkName: "pages/updateById" */))
const _59aa1caa = () => interopDefault(import('..\\pages\\vistaMapa.vue' /* webpackChunkName: "pages/vistaMapa" */))
const _d52daf6a = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/getById",
    component: _dc89b6fe,
    name: "getById"
  }, {
    path: "/listaEmergencia",
    component: _07cc4c9c,
    name: "listaEmergencia"
  }, {
    path: "/listaHabilidades",
    component: _79509c2c,
    name: "listaHabilidades"
  }, {
    path: "/login",
    component: _5f10cb62,
    name: "login"
  }, {
    path: "/registroEmergencia",
    component: _1fb0946a,
    name: "registroEmergencia"
  }, {
    path: "/registroInstitucion",
    component: _450bb622,
    name: "registroInstitucion"
  }, {
    path: "/registroUsuario",
    component: _8adead98,
    name: "registroUsuario"
  }, {
    path: "/updateById",
    component: _41c3cfdc,
    name: "updateById"
  }, {
    path: "/vistaMapa",
    component: _59aa1caa,
    name: "vistaMapa"
  }, {
    path: "/",
    component: _d52daf6a,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
