import {
  fetchAllSuccess,
  fetchAllError,
  deleteDataSuccess,
  deleteDataError,
} from "../actions/admin/adminActions";
import {
  fetchSPBySTSuccess,
  fetchSPBySTError,
  createServiceSuccess,
  createServiceError,
  fetchServicesSuccess,
  fetchServicesError,
  updateServiceSuccess,
  updateServiceError,
} from "../actions/customer/servicesActions";
import { loginSuccess, loginError } from "../actions/login/loginActions";
import {
  registerSuccess,
  registerError,
} from "../actions/login/registerActions";
import { axiosAPI } from "./config";

export const login = (req) => {
  const { userUrl, email, password } = req;
  return (dispatch) => {
    axiosAPI
      .get(`${userUrl}/login/${email}/${password}`)
      .then((res) => res.data)
      .then((res) => dispatch(loginSuccess(res)))
      .catch((error) => dispatch(loginError(error)));
  };
};

export const register = (request) => {
  console.log(request);
  const { userUrl, req } = request;
  return (dispatch) => {
    axiosAPI
      .post(`${userUrl}/create`, req)
      .then((res) => res.data)
      .then((res) => dispatch(registerSuccess(res)))
      .catch((error) => dispatch(registerError(error)));
  };
};
/**
 * fetching service providers by service type
 */
export const fetchSPByST = (serviceType) => {
  return (dispatch) => {
    axiosAPI
      .get(`provider/get/${serviceType}`)
      .then((res) => res.data)
      .then((res) => dispatch(fetchSPBySTSuccess(res)))
      .catch((error) => dispatch(fetchSPBySTError(error)));
  };
};
/**
 * fetching service request for users and service providers
 */
export const fetchServiceRequestsById = (userUrl, id) => {
  return (dispatch) => {
    axiosAPI
      .get(`service-request/${userUrl}/${id}`)
      .then((res) => res.data)
      .then((res) => dispatch(fetchServicesSuccess(res)))
      .catch((error) => dispatch(fetchServicesError(error)));
  };
};

export const createService = (request) => {
  return (dispatch) => {
    axiosAPI
      .post(`service-request/create`, request)
      .then((res) => res.data)
      .then((res) => dispatch(createServiceSuccess(res)))
      .catch((error) => dispatch(createServiceError(error)));
  };
};

export const updateService = (id) => {
  return (dispatch) => {
    axiosAPI
      .put(`service-request/done/${id}`)
      .then((res) => res.data)
      .then((res) => dispatch(updateServiceSuccess(res)))
      .catch((error) => dispatch(updateServiceError(error)));
  };
};

export const fetchAll = () => {
  return (dispatch) => {
    axiosAPI
      .get(`user/all`)
      .then((res) => res.data)
      .then((res) => dispatch(fetchAllSuccess(res)))
      .catch((error) => dispatch(fetchAllError(error)));
  };
};

export const deleteData = (req) => {
  const { url, id } = req;
  return (dispatch) => {
    axiosAPI
      .delete(`${url}/remove/${id}`)
      .then((res) => res.data)
      .then((res) => dispatch(deleteDataSuccess(res)))
      .catch((error) => dispatch(deleteDataError(error)));
  };
};
