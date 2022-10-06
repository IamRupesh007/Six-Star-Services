import React, { useEffect, useState } from "react";
import { bindActionCreators } from "redux";
import Login from "../../components/login";
import { connect } from "react-redux";
import { login } from "../../redux/services/services";
import {
  ADMIN,
  CUSTOMER,
  SERVICE_PROVIDER,
} from "../../constants/otherConstants";
import { Helmet } from "react-helmet";

const LoginScreen = (props) => {
  const { userType } = props;

  const onSubmit = (email, password) => {
    const { userType, login } = props;
    let userUrl = "user";
    if (userType === SERVICE_PROVIDER) {
      userUrl = "provider";
    }
    const req = { userUrl, email, password };
    login(req);
  };
  let title = "";
  switch (userType) {
    case CUSTOMER:
      title = "Customer";
      break;
    case SERVICE_PROVIDER:
      title = "Service Provider";
      break;
    case ADMIN:
      title = "Admin";
      break;
  }

  const [message, setMessage] = useState("");
  useEffect(() => {
    const { error } = props;
    if (error) {
      setMessage(error.message);
    }
    setTimeout(() => {
      setMessage("");
    }, 5000);
  }, [props.error]);

  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>{title} Login</title>
      </Helmet>
      <Login message={message} userType={userType} onSubmit={onSubmit} />
    </>
  );
};

const mapStateToProps = (state) => ({
  error: state.loginReducer.error,
});

const mapDispatchToProps = (dispatch) =>
  bindActionCreators({ login }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(LoginScreen);
