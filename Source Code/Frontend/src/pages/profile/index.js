import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import {
  CUSTOMER,
  SERVICE_PROVIDER,
  ADMIN,
} from "../../constants/otherConstants";
import { register } from "../../redux/services/services";
import { Typography } from "@mui/material";
import "./style.css";

const Profile = (props) => {
  const { user } = props;

  const labelUser = {
    firstName: "First Name",
    middleName: "Middle Name",
    lastName: "Last Name",
    phoneNumber: "Phone Number",
    email: "Regsisted Email ",
    addressLine1: "Address Line 1",
    addressLine2: "Address Line 2",
    firstName: "First Name",
    city: "City",
    state: "State",
  };
  const labelSp = {
    ...labelUser,
    serviceProviderName: "Service Provider Name",
    serviceTypes: "Service Type Provided",
  };
  let label = {};
  let title = "";

  switch (user.role) {
    case CUSTOMER:
      label = labelUser;
      title = "Customer";
      break;
    case SERVICE_PROVIDER:
      label = labelSp;
      title = "Service Provider";
      break;
    case ADMIN:
      label = labelUser;
      title = "Admin";
      break;
  }

  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>My Profile</title>
      </Helmet>
      <div className="profile_container">
        <Typography variant="h6" component="h6">
          Hello {title}
        </Typography>
        <br />
        <div className="profile_items">
          {Object.keys(label).map((item, i) => {
            return (
              <div key={i}>
                <Typography>
                  {label[item]}: {user[item]}
                </Typography>
              </div>
            );
          })}
        </div>
      </div>
    </>
  );
};

const mapStateToProps = (state) => ({});

const mapDispatchToProps = (dispatch) => bindActionCreators({}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(Profile);
