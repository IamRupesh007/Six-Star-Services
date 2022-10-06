import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import RegistrationForm from "../../components/registration";
import { CUSTOMER, SERVICE_PROVIDER } from "../../constants/otherConstants";
import { register } from "../../redux/services/services";

const RegistrationScreen = (props) => {
  const { userType } = props;
  let title = "";

  const onSubmit = (req) => {
    const { userType, register } = props;

    let userUrl = "user";
    if (userType === SERVICE_PROVIDER) {
      userUrl = "provider";
    }
    register({ userUrl, req });
  };

  const [error, setError] = useState(false);

  const [message, setMessage] = useState("");

  useEffect(() => {
    const { error, response } = props;

    if (error) {
      setMessage(error.message);
      setError(true);
    }
    setTimeout(() => {
      setMessage("");
      setError(false);
    }, 5000);

    if (Object.keys(response).length > 0) {
      setMessage("Registration Successful");
    }
    setTimeout(() => {
      setMessage("");
    }, 10000);
  }, [props.error, props.response]);

  switch (userType) {
    case CUSTOMER:
      title = "Customer";
      break;
    case SERVICE_PROVIDER:
      title = "Service Provider";
      break;
    default:
      title = "Customer";
      break;
  }
  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>{title} Registration</title>
      </Helmet>
      <RegistrationForm
        message={message}
        error={error}
        onSubmit={onSubmit}
        userType={userType}
      />
    </>
  );
};

const mapStateToProps = (state) => ({
  error: state.registerReducer.error,
  response: state.registerReducer.registerResponse,
});

const mapDispatchToProps = (dispatch) =>
  bindActionCreators({ register }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(RegistrationScreen);
