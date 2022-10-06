import React, { useState, useEffect } from "react";
import { ValidatorForm, TextValidator } from "react-material-ui-form-validator";
import {
  Button,
  Typography,
  IconButton,
  InputAdornment,
  Alert,
  AlertTitle,
  FormControl,
  FormLabel,
  RadioGroup,
  Radio,
  FormControlLabel,
} from "@mui/material";
import "./style.css";
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
import { Link } from "react-router-dom";
const serviceTypes = [
  { label: "Plumbing", value: PLUMBING },
  { label: "Electric", value: ELECTRIC },
  { label: "Contractor", value: CONTRACTOR },
  { label: "Interior Design", value: INTERIOR_DESIGN },
  { label: "Paint", value: PAINT },
  { label: "Architect", value: ARCHITECT },
];

const CreateServiceForm = (props) => {
  const [serviceType, setServiceType] = useState("");
  const [serviceProviderId, setServiceProviderId] = useState(0);
  const [showMessage, setShowMessage] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name === "serviceType") {
      setShowMessage(true);
      setServiceType(value);
      const { onServiceTypeSelect } = props;
      onServiceTypeSelect(e.target.value);
    }
    if (name === "serviceProviderId") {
      setServiceProviderId(value);
    }
  };

  const handleSubmit = (e) => {
    const { user, createService } = props;
    const request = {
      status: "PENDING",
      createDate: new Date(),
      modifyDate: new Date(),
      completionDate: null,
      serviceType: serviceType,
      customerId: user.id,
      serviceProviderId: parseInt(serviceProviderId),
    };
    createService(request);
  };

  const { user, serviceProviders, message, error } = props;

  return (
    <div className="service_container">
      <div className="service_form">
        <Typography
          className="service_form_heading"
          variant="h6"
          component="h6"
        >
          Hello {user.firstName}, you can create service here !!
        </Typography>
        <FormControl onSubmit={handleSubmit}>
          <FormLabel id="service_type_select">
            First Select Service Type
          </FormLabel>
          <RadioGroup
            row
            aria-labelledby="service_type_select"
            name="serviceType"
            value={serviceType}
            onChange={handleChange}
          >
            {serviceTypes.map((x, y) => {
              return (
                <>
                  <FormControlLabel
                    key={y}
                    value={x.value}
                    control={<Radio />}
                    label={x.label}
                  />
                </>
              );
            })}
          </RadioGroup>
          {serviceProviders.length > 0 ? (
            <>
              <br />
              <FormLabel id="service_type_select">
                Now Select Service Provider
              </FormLabel>
              <br />
              <RadioGroup
                row
                name="serviceProviderId"
                value={serviceProviderId}
                onChange={handleChange}
              >
                <div className="service_info_grid">
                  {serviceProviders.map((x, y) => {
                    return (
                      <div className="service_info">
                        <FormControlLabel
                          key={y}
                          value={x.id}
                          control={<Radio />}
                          label={x.serviceProviderName}
                        />
                        <Typography>{x.phoneNumber}</Typography>
                        <Typography>{x.email}</Typography>
                      </div>
                    );
                  })}
                </div>
              </RadioGroup>
              <br />
            </>
          ) : (
            <>
              {showMessage ? (
                <>
                  <br />
                  {"Sorry, no service proider for this service type. "}
                </>
              ) : (
                <></>
              )}
            </>
          )}
          {serviceProviders.length > 0 && (
            <Button variant="contained" type="button" onClick={handleSubmit}>
              Create Request
            </Button>
          )}
          {message && (
            <>
              <br />
              <br />
              <Alert severity={error ? "error" : "success"}>
                <AlertTitle>{error ? "Oops !!" : "Good Job !!!"}</AlertTitle>
                <p>
                  {error ? (
                    `Some thing went wrong, this can be a reason:-${message}`
                  ) : (
                    <span>
                      {`Good Job !! ${message}, to view all request,`}
                      <Link to="/view-services">click here</Link>
                    </span>
                  )}
                </p>
              </Alert>
            </>
          )}
        </FormControl>
      </div>
    </div>
  );
};

export default CreateServiceForm;
