import {
  MODIFY_SERVICE_ERROR,
  MODIFY_SERVICE_SUCCESS,
} from "../../../constants/reducerConstants";

export function modifyServiceSuccess(serviceResponse) {
  return {
    type: MODIFY_SERVICE_SUCCESS,
    serviceResponse,
  };
}

export function modifyServiceError(error) {
  return {
    type: MODIFY_SERVICE_ERROR,
    error,
  };
}
