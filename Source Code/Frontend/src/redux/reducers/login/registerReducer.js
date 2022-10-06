import {
  REGISTER_ERROR,
  REGISTER_SUCCESS,
} from "../../../constants/reducerConstants";

const initialState = {
  registerResponse: {},
  error: null,

};

export function registerReducer(state = initialState, action) {
  const { type, registerResponse, error } = action;
  switch (type) {
    case REGISTER_SUCCESS:
      return { ...initialState, registerResponse };
    case REGISTER_ERROR:
      return { ...initialState, error };

    default:
      return { ...state };
  }
}
