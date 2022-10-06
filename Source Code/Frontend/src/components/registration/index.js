import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Visibility, VisibilityOff } from "@mui/icons-material";

import {
  Button,
  Typography,
  IconButton,
  InputAdornment,
  Alert,
  AlertTitle,
} from "@mui/material";
import "./style.css";

import { ValidatorForm, TextValidator } from "react-material-ui-form-validator";
import {
  ARCHITECT,
  CONTRACTOR,
  CUSTOMER,
  ELECTRIC,
  INTERIOR_DESIGN,
  PAINT,
  PLUMBING,
  SERVICE_PROVIDER,
} from "../../constants/otherConstants";
import SelectValidatorCustom from "../../utils/components/SelectValidatorCustom";

const userForm = [
  {
    value: "firstName",
    label: "First Name",
    validators: ["required"],
    errorMessages: ["First name is required"],
    required: true,
  },
  {
    value: "middleName",
    label: "Middle Name",
    validators: [],
    errorMessages: [],
    required: false,
  },
  {
    value: "lastName",
    label: "Last Name",
    validators: ["required"],
    errorMessages: ["Last name is required"],
    required: true,
  },
  {
    value: "phoneNumber",
    label: "Phone",
    validators: [],
    errorMessages: [],
    required: false,
  },

  {
    value: "email",
    label: "Email",
    validators: ["required", "isEmail"],
    errorMessages: ["Email is required", "Enter valid email"],
    required: true,
  },
  {
    value: "password",
    label: "Password",
    validators: ["required"],
    errorMessages: ["Password is required"],
    required: true,
  },
  {
    value: "addressLine1",
    label: "Address Line 1",
    validators: ["required"],
    errorMessages: ["Address Line 1 is required"],
    required: true,
  },
  {
    value: "addressLine2",
    label: "Address Line 2",
    validators: [],
    errorMessages: [],
    required: false,
  },

  {
    value: "city",
    label: "City",
    validators: ["required"],
    errorMessages: ["City is required"],
    required: true,
  },
  {
    value: "state",
    label: "State",
    validators: ["required"],
    errorMessages: ["State is required"],
    required: true,
  },
];

const serviceTypes = [
  { label: "Plumbing", value: PLUMBING },
  { label: "Electric", value: ELECTRIC },
  { label: "Contractor", value: CONTRACTOR },
  { label: "Interior Design", value: INTERIOR_DESIGN },
  { label: "Paint", value: PAINT },
  { label: "Architect", value: ARCHITECT },
];
const RegistrationForm = (props) => {
  const [regForm, setRegForm] = useState({
    user: {
      firstName: "",
      middleName: "",
      lastName: "",
      phoneNumber: "",
      email: "",
      addressLine1: "",
      addressLine2: "",
      city: "",
      state: "",
      role: "",
    },
    password: "",
    serviceProvider: {
      serviceProviderName: "",
      serviceTypes: [""],
    },
  });
  const [imageClass, setImageClass] = useState("login_customer_image");
  const [label, setLabel] = useState("Customer");
  const [showPassword, setShowPassword] = useState(false);
  const [loginTo, setLoginTo] = useState("/login");

  useEffect(() => {
    const { userType } = props;

    switch (userType) {
      case CUSTOMER:
        setImageClass("reg_customer_image");
        setLabel("Customer");
        break;
      case SERVICE_PROVIDER:
        setImageClass("reg_service_image");
        setLabel("Service Provider");
        setLoginTo("/login/service");
        break;
      default:
        setImageClass("reg_customer_image");
        setLabel("Customer");
        break;
    }
  }, [props.userType]);

  const onChange = (e) => {
    const { name, value } = e.target;
    if (name === "password") {
      setRegForm({ ...regForm, password: value });
    } else if (name === "serviceProviderName") {
      const { serviceProvider } = regForm;
      serviceProvider.serviceProviderName = value;
      setRegForm({ ...regForm, serviceProvider });
    } else if (name === "serviceTypes") {
      const { serviceProvider } = regForm;
      serviceProvider.serviceTypes[0] = value;
      setRegForm({ ...regForm, serviceProvider });
    } else {
      const { user } = regForm;
      user[name] = value;
      setRegForm({ ...regForm, user });
    }
  };

  const onSubmit = (e) => {
    e.preventDefault();
    const { onSubmit, userType } = props;
    const { user, password, serviceProvider } = regForm;
    if (userType === CUSTOMER) {
      user.role = CUSTOMER;
      onSubmit({ user, password });
    } else {
      user.role = SERVICE_PROVIDER;
      onSubmit({ user, password, serviceProvider });
    }
  };

  const { userType, message, error } = props;

  return (
    <div className="reg_container">
      <div className="half">
        <div className="reg_form">
          <ValidatorForm
            style={{ border: "transparent" }}
            noValidate
            validated={"true"}
            onSubmit={onSubmit}
          >
            <Typography
              className="reg_form_heading"
              variant="h6"
              component="h6"
            >
              {label} Registration
            </Typography>
            <div className={"reg_form_grid"}>
              {userType === SERVICE_PROVIDER && (
                <>
                  <div>
                    <TextValidator
                      name={"serviceProviderName"}
                      value={regForm.serviceProvider["serviceProviderName"]}
                      label={"Service Provider Name"}
                      fullWidth={true}
                      onChange={onChange}
                      validators={["required"]}
                      errorMessages={["Service Provder Name is required"]}
                      variant="outlined"
                      required
                    />
                    <br />
                  </div>
                  <div>
                    <SelectValidatorCustom
                      options={serviceTypes}
                      fullWidth={true}
                      name={"serviceTypes"}
                      inputLabel={"Select Service Type  *"}
                      value={regForm.serviceProvider.serviceTypes[0]}
                      onChange={onChange}
                      validators={["required"]}
                      errorMessages={["this field is required"]}
                      variant="outlined"
                      required
                    />
                  </div>
                </>
              )}
              {/* Forms fields to create user */}
              {userForm.map((x, i) => {
                return (
                  <div key={i}>
                    <TextValidator
                      name={x.value}
                      value={
                        x.value === "password"
                          ? regForm[x.value]
                          : regForm.user[x.value]
                      }
                      type={
                        x.value !== "password"
                          ? "text"
                          : showPassword
                          ? "text"
                          : "password"
                      }
                      label={x.label}
                      fullWidth={true}
                      onChange={onChange}
                      validators={x.validators}
                      errorMessages={x.errorMessages}
                      variant="outlined"
                      required={x.required}
                      InputProps={
                        x.value === "password"
                          ? {
                              endAdornment: (
                                <InputAdornment position="end">
                                  <IconButton
                                    value="isPasswordShown"
                                    aria-label="Toggle password visibility"
                                    onClick={() =>
                                      setShowPassword(!showPassword)
                                    }
                                  >
                                    {showPassword ? (
                                      <VisibilityOff />
                                    ) : (
                                      <Visibility />
                                    )}
                                  </IconButton>
                                </InputAdornment>
                              ),
                            }
                          : {}
                      }
                    />
                    <br />
                  </div>
                );
              })}
            </div>
            <br />
            <Button variant="contained" type="submit">
              Register Now
            </Button>
            <br />
            <br />
            {message && (
              <>
                <Alert severity={error ? "error" : "success"}>
                  <AlertTitle>{error ? "Oops !!" : "Good Job !!!"}</AlertTitle>
                  <p>
                    {error ? (
                      `Some thing went wrong, this can be a reason:-${message}`
                    ) : (
                      <span>
                        {`Good Job !! ${message}, to login,`}
                        <Link to={loginTo}>click here</Link>
                      </span>
                    )}
                  </p>
                </Alert>
                <br />
                <br />
              </>
            )}

            <Typography>
              Already registered? <Link to={loginTo}>Click here to login</Link>
            </Typography>
          </ValidatorForm>
        </div>
      </div>
      <div className="half">
        <div className={imageClass}></div>
      </div>
    </div>
  );
};

export default RegistrationForm;
