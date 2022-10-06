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

export function createServiceSuccess(serviceResponse) {
  return {
    type: CREATE_SERVICE_SUCCESS,
    serviceResponse,
  };
}

export function createServiceError(error) {
  return {
    type: CREATE_SERVICE_ERROR,
    error,
  };
}

export function updateServiceSuccess(serviceUpdateResponse) {
  return {
    type: UPDATE_SERVICE_SUCCESS,
    serviceUpdateResponse,
  };
}

export function updateServiceError(error) {
  return {
    type: UPDATE_SERVICE_ERROR,
    error,
  };
}

export function fetchServicesSuccess(services) {
  return {
    type: FETCH_SERVICES_SUCCESS,
    services,
  };
}

export function fetchServicesError(error) {
  return {
    type: FETCH_SERVICES_ERROR,
    error,
  };
}

export function fetchSPBySTSuccess(responseSPByST) {
  return {
    type: FETCH_SERVICE_PROVIDER_BY_TYPE_SUCCESS,
    responseSPByST,
  };
}

export function fetchSPBySTError(error) {
  return {
    type: FETCH_SERVICE_PROVIDER_BY_TYPE_ERROR,
    error,
  };
}
