import {
  FETCH_ALL_SUCCESS,
  FETCH_ALL_ERROR,
  DELETE_DATA_SUCCESS,
  DELETE_DATA_ERROR
} from "../../../constants/reducerConstants";

const initialState = {
  allData: {},
  error: null,
};

export function fetchAllReducer(state = initialState, action) {
  const { type, allData, error } = action;
  switch (type) {
    case FETCH_ALL_SUCCESS:
      return { ...state, allData };
    case FETCH_ALL_ERROR:
      return { ...state, error };
    default:
      return { ...state };
  }
}
const initialDelState = {
  delRes: {},
  error: null,
};

export function deleteDataReducer(state = initialDelState, action) {
  const { type, delRes, error } = action;
  switch (type) {
    case DELETE_DATA_SUCCESS:
      return { ...initialDelState, delRes };
    case DELETE_DATA_ERROR:
      return { ...initialDelState, error };
    default:
      return { ...state };
  }
}
