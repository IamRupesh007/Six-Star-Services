import { Visibility, VisibilityOff } from "@mui/icons-material";
import {
  Alert,
  AlertTitle,
  Button,
  IconButton,
  InputAdornment,
  Typography,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import { ValidatorForm, TextValidator } from "react-material-ui-form-validator";
import { Link } from "react-router-dom";
import {
  ADMIN,
  CUSTOMER,
  SERVICE_PROVIDER,
} from "../../constants/otherConstants";
import "./style.css";

const Login = (props) => {
  const [label, setLabel] = useState("Customer");
  const [imageClass, setImageClass] = useState("login_customer_image");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [redirectRegister, setRedirectRegister] = useState({
    message: "To register",
    to: "/register",
  });
  const [redirectUserType, setRedirectUserType] = useState({
    message: "To login as a Service Provider",
    to: "/login/service",
  });

  useEffect(() => {
    const { userType } = props;

    switch (userType) {
      case CUSTOMER:
        setImageClass("login_customer_image");
        setLabel("Customer");
        break;
      case ADMIN:
        setImageClass("login_admin_image");
        setLabel("Admin");
        break;
      case SERVICE_PROVIDER:
        setRedirectRegister({
          message: "To register as a Service Provider",
          to: "/register/service",
        });
        setRedirectUserType({
          message: "To login as a Customer",
          to: "/login",
        });
        setImageClass("login_service_image");
        setLabel("Service Provider");
        break;
      default:
        setImageClass("login_customer_image");
        setLabel("Customer");
        break;
    }
  }, [props.userType]);

  const onSubmit = (e) => {
    e.preventDefault();
    const { onSubmit } = props;
    onSubmit(email, password);
  };
  const { message } = props;
  return (
    <div className="login_container">
      <div className="half">
        <div className="login_form">
          <ValidatorForm
            style={{ border: "transparent" }}
            noValidate
            validated={"true"}
            onSubmit={onSubmit}
          >
            <Typography
              className="login_form_heading"
              variant="h6"
              component="h6"
            >
              {label} Login
            </Typography>

            <TextValidator
              id="emailLogin"
              name="email"
              value={email}
              label="Email"
              fullWidth={true}
              onChange={(e) => {
                setEmail(e.target.value);
              }}
              validators={["required", "isEmail"]}
              errorMessages={["Username is required", "Invalid email entered"]}
              variant="outlined"
              required
            />
            <br />
            <br />
            <TextValidator
              id="passwordLogin"
              name="password"
              value={password}
              label="Password"
              variant="outlined"
              fullWidth={true}
              validators={["required"]}
              errorMessages={["Password is required."]}
              required
              type={showPassword ? "text" : "password"}
              onChange={(e) => setPassword(e.target.value)}
              InputProps={{
                endAdornment: (
                  <InputAdornment position="end">
                    <IconButton
                      value="isPasswordShown"
                      aria-label="Toggle password visibility"
                      onClick={() => setShowPassword(!showPassword)}
                    >
                      {showPassword ? <VisibilityOff /> : <Visibility />}
                    </IconButton>
                  </InputAdornment>
                ),
              }}
            />
            <br />

            <Button variant="contained" type="submit">
              Login
            </Button>

            <Typography>
              <br />
              {redirectRegister.message}
              <Link to={redirectRegister.to}>&nbsp; click here</Link>
            </Typography>
            <br />
            <Typography>
              {redirectUserType.message}
              <Link to={redirectUserType.to}>&nbsp; click here</Link>
            </Typography>

            <br />
            {message && (
              <div className="login_alert">
                <Alert severity={"error"}>
                  <AlertTitle>{"Oops !!"}</AlertTitle>
                  <p>Some thing went wrong, this can be a reason:- {message}</p>
                </Alert>
                <br />
                <br />
              </div>
            )}
          </ValidatorForm>
        </div>
      </div>
      <div className="half">
        <div className={imageClass}></div>
      </div>
    </div>
  );
};

export default Login;
