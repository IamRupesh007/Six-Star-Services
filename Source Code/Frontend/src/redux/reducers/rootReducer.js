import { combineReducers } from "redux";
import { fetchAllReducer, deleteDataReducer } from "./admin/adminReducer";
import {
  fetchServicesReducer,
  createServiceReducer,
  fetchSPBySTReducer,
  updateServiceReducer,
} from "./customer/servicesReducer";
import { loginReducer } from "./login/loginReducer";
import { registerReducer } from "./login/registerReducer";

export default combineReducers({
  loginReducer,
  registerReducer,
  fetchServicesReducer,
  createServiceReducer,
  fetchSPBySTReducer,
  fetchAllReducer,
  deleteDataReducer,
  updateServiceReducer,
});
