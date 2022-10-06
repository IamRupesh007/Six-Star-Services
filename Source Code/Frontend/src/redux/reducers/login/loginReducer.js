import {
  LOGIN_ERROR,
  LOGIN_SUCCESS,
  LOGOUT,
} from "../../../constants/reducerConstants";

const initialState = {
  loggedInUser: {},
  error: null,
  isLoggedIn: false,
};

export function loginReducer(state = initialState, action) {
  const { type, loggedInUser, error } = action;
  switch (type) {
    case LOGIN_SUCCESS:
      return { ...initialState, loggedInUser, isLoggedIn: true };
    case LOGIN_ERROR:
      return { ...initialState, error };
    case LOGOUT:
      return { ...initialState };

    default:
      return { ...state };
  }
}
