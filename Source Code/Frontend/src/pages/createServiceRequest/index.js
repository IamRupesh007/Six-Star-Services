import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import CreateServiceForm from "../../components/createServiceRequestForm";
import { fetchSPByST, createService } from "../../redux/services/services";

const CreateService = (props) => {
  const [message, setMessage] = useState("");
  const [error, setError] = useState(false);

  useEffect(() => {
    const { error, serviceResponse } = props;

    if (error) {
      setMessage(error.message);
      setError(true);
    }
    setTimeout(() => {
      setMessage("");
      setError(false);
    }, 10000);

    if (Object.keys(serviceResponse).length > 0) {
      setMessage(serviceResponse.message);
    }
    setTimeout(() => {
      setMessage("");
    }, 10000);
  }, [props.error, props.serviceResponse]);

  const onServiceTypeSelect = (serviceType) => {
    const { fetchSPByST } = props;
    fetchSPByST(serviceType);
  };

  const { user, serviceProviders, createService } = props;

  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>Create Service Request</title>
      </Helmet>
      <CreateServiceForm
        user={user}
        serviceProviders={serviceProviders}
        onServiceTypeSelect={onServiceTypeSelect}
        createService={createService}
        message={message}
        error={error}
      />
    </>
  );
};

const mapStateToProps = (state) => ({
  serviceProviders: state.fetchSPBySTReducer.responseSPByST,
  serviceResponse: state.createServiceReducer.serviceResponse,
  error: state.createServiceReducer.error,
});

const mapDispatchToProps = (dispatch) =>
  bindActionCreators({ fetchSPByST, createService }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(CreateService);
