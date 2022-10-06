import {
  FETCH_PROFILE_ERROR,
  FETCH_PROFILE_SUCCESS,
} from "../../../constants/reducerConstants";

export function fetchProfileSuccess(profile) {
  return {
    type: FETCH_PROFILE_SUCCESS,
    profile,
  };
}

export function fetchProfileError(error) {
  return {
    type: FETCH_PROFILE_ERROR,
    error,
  };
}
