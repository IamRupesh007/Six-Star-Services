import {
  FETCH_ALL_SUCCESS,
  FETCH_ALL_ERROR,
  DELETE_DATA_SUCCESS,
  DELETE_DATA_ERROR
} from "../../../constants/reducerConstants";

export function fetchAllSuccess(allData) {
  return {
    type: FETCH_ALL_SUCCESS,
    allData,
  };
}

export function fetchAllError(error) {
  return {
    type: FETCH_ALL_ERROR,
    error,
  };
}
export function deleteDataSuccess(delRes) {
  return {
    type: DELETE_DATA_SUCCESS,
    delRes,
  };
}

export function deleteDataError(error) {
  return {
    type: DELETE_DATA_ERROR,
    error,
  };
}
