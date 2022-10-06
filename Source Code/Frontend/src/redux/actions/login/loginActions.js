import {
  LOGIN_ERROR,
  LOGIN_SUCCESS,
  LOGOUT,
} from "../../../constants/reducerConstants";

export function loginSuccess(loggedInUser) {
  return {
    type: LOGIN_SUCCESS,
    loggedInUser,
  };
}

export function loginError(error) {
  return {
    type: LOGIN_ERROR,
    error,
  };
}

export function logout() {
  console.log("in logout");
  return {
    type: LOGOUT,
  };
}
