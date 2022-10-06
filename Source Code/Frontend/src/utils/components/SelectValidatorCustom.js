import React from "react";

import { ValidatorComponent } from "react-material-ui-form-validator";
import { FormControl, InputLabel, MenuItem, Select } from "@mui/material";

class SelectValidatorCustom extends ValidatorComponent {
  renderValidatorComponent() {
    const {
      errorMessages,
      validators,
      requiredError,
      validatorListener,
      options = [],
      inputLabel,
      inputLabelId,
      value,
      ...rest
    } = this.props;

    return (
      <div>
        <FormControl variant="outlined" style={{ width: "100%" }}>
          <InputLabel id={inputLabelId}>{inputLabel}</InputLabel>
          <Select
            labelId={inputLabelId}
            label={inputLabel}
            value={value}
            ref={(r) => {
              this.input = r;
            }}
            {...rest}
          >
            <MenuItem value="">
              <em>None</em>
            </MenuItem>
            {options.map((item, x) => {
              return (
                <MenuItem key={x} value={item.value}>
                  {item.label}
                </MenuItem>
              );
            })}
          </Select>
          {this.errorText()}
        </FormControl>
      </div>
    );
  }

  errorText() {
    const { isValid } = this.state;
    if (isValid) {
      return null;
    }
    return <div style={{ color: "red" }}>{this.getErrorMessage()}</div>;
  }
}

export default SelectValidatorCustom;
