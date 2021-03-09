import { createApp } from "vue";
import App from "./App.vue";
import store from "./store";
import router from "./router";
import * as VeeValidate from "vee-validate";
import { library } from "@fortawesome/fontawesome-svg-core";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import {
  faHome,
  faUser,
  faUserPlus,
  faSignInAlt,
  faSignOutAlt
} from "@fortawesome/free-solid-svg-icons";

library.add(faHome, faUser, faUserPlus, faSignInAlt, faSignOutAlt);

createApp(App)
  .use(router)
  .use(store)
  .use(VeeValidate)
  .component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
