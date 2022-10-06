import {
  CREATE_SERVICE_ERROR,
  CREATE_SERVICE_SUCCESS,
  FETCH_SERVICES_SUCCESS,
  FETCH_SERVICES_ERROR,
  FETCH_SERVICE_PROVIDER_BY_TYPE_SUCCESS,
  FETCH_SERVICE_PROVIDER_BY_TYPE_ERROR,
  UPDATE_SERVICE_SUCCESS,
  UPDATE_SERVICE_ERROR,
} from "../../../constants/reducerConstants";

const initialServiceState = {
  serviceResponse: [],
  error: null,
};

export function createServiceReducer(state = initialServiceState, action) {
  const { type, serviceResponse, error } = action;
  switch (type) {
    case CREATE_SERVICE_SUCCESS:
      return { ...state, serviceResponse };
    case CREATE_SERVICE_ERROR:
      return { ...state, error };
    default:
      return { ...state };
  }
}
const initialFetchServicesState = {
  services: [],
  error: null,
};

export function fetchServicesReducer(
  state = initialFetchServicesState,
  action
) {
  const { type, services, error } = action;
  switch (type) {
    case FETCH_SERVICES_SUCCESS:
      return { ...state, services };
    case FETCH_SERVICES_ERROR:
      return { ...state, error };
    default:
      return { ...state };
  }
}
const initialResponseSPByST = {
  responseSPByST: [],
  error: null,
};

export function fetchSPBySTReducer(state = initialResponseSPByST, action) {
  const { type, responseSPByST, error } = action;
  switch (type) {
    case FETCH_SERVICE_PROVIDER_BY_TYPE_SUCCESS:
      return { ...state, responseSPByST };
    case FETCH_SERVICE_PROVIDER_BY_TYPE_ERROR:
      return { ...state, error };
    default:
      return { ...state };
  }
}
const initialUpdateResponse = {
  serviceUpdateResponse: [],
  error: null,
};

export function updateServiceReducer(state = initialUpdateResponse, action) {
  const { type, serviceUpdateResponse, error } = action;
  switch (type) {
    case UPDATE_SERVICE_SUCCESS:
      return { ...state, serviceUpdateResponse };
    case UPDATE_SERVICE_ERROR:
      return { ...state, error };
    default:
      return { ...state };
  }
}
