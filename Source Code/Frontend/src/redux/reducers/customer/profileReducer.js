import {
  FETCH_PROFILE_ERROR,
  FETCH_PROFILE_SUCCESS,
} from "../../../constants/reducerConstants";

const initialState = {
  profile: {},
  error: null,
};

export function fetchProfileReducer(state = initialState, action) {
  const { type, profile, error } = action;
  switch (type) {
    case FETCH_PROFILE_SUCCESS:
      return { ...state, profile };
    case FETCH_PROFILE_ERROR:
      return { ...state, error };
    default:
      return { ...state };
  }
}
