import { Routes, Route, useNavigate } from "react-router-dom";
import "./App.css";
import Header from "./components/header";
import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import { useEffect } from "react";
import { logout } from "./redux/actions/login/loginActions";
import Routings from "./route";
import React from "react";
import Helmet from "react-helmet";
import { ADMIN, CUSTOMER, SERVICE_PROVIDER } from "./constants/otherConstants";

const App = (props) => {
  const navigate = useNavigate();

  useEffect(() => {
    const { loggedInUser } = props;
    if (Object.keys(loggedInUser).length > 0) {
      const { role } = loggedInUser;
      if (role === CUSTOMER) {
        navigate("/create-service");
      }
      if (role === SERVICE_PROVIDER) {
        navigate("/view-services");
      }
      if (role === ADMIN) {
        navigate("/view-users");
      }
    }
  }, [props.loggedInUser]);
  const { isLoggedIn, loggedInUser } = props;
  return (
    <>
      {isLoggedIn && <Header user={loggedInUser} logout={logout} />}
      <Helmet>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
          href="https://fonts.googleapis.com/css2?family=Khula:wght@400;600;800&display=swap"
          rel="stylesheet"
        />
      </Helmet>
      <Routings user={loggedInUser} isLoggedIn={isLoggedIn} />
    </>
  );
};

const mapStateToProps = (state) => ({
  loggedInUser: state.loginReducer.loggedInUser,
  isLoggedIn: state.loginReducer.isLoggedIn,
});

const mapDispatchToProps = (dispatch) =>
  bindActionCreators({ logout }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(App);
