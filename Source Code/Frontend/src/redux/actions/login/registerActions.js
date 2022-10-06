import {
  REGISTER_ERROR,
  REGISTER_SUCCESS,
} from "../../../constants/reducerConstants";

export function registerSuccess(registerResponse) {
  return {
    type: REGISTER_SUCCESS,
    registerResponse,
  };
}

export function registerError(error) {
  return {
    type: REGISTER_ERROR,
    error,
  };
}
