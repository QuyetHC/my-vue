// store/index.js
import { createStore } from 'vuex';

export default createStore({
  state: {
    isLoggedIn: false
  },
  mutations: {
    setLoggedIn(state, value) {
      state.isLoggedIn = value;
    }
  },
  actions: {
    login({ commit }, { username, password }) {
      // Thực hiện xác thực tại đây
      if (username === 'admin' && password === 'admin') {
        commit('setLoggedIn', true);
        return true;
      } else {
        return false;
      }
    },
    logout({ commit }) {
      commit('setLoggedIn', false);
    }
  },
  modules: {}
});
