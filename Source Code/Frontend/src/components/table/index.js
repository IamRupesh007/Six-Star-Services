import React, { useState } from "react";
import { styled } from "@mui/material/styles";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import {
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
  Typography,
} from "@mui/material";
import "./style.css";
import DeleteIcon from "@mui/icons-material/Delete";
import DoneOutlineIcon from "@mui/icons-material/DoneOutline";
import CheckCircleOutlineIcon from "@mui/icons-material/CheckCircleOutline";
import CheckCircleIcon from "@mui/icons-material/CheckCircle";
import {
  ADMIN,
  SERVICE_PROVIDER,
  SERVICE_REQUEST,
  CUSTOMER,
} from "../../constants/otherConstants";

// or
import { IconButton } from "@mui/material";
const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  "&:nth-of-type(odd)": {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  "&:last-child td, &:last-child th": {
    border: 0,
  },
}));

const CustomizedTables = (props) => {
  const { headers, data, label, user, dataType } = props;

  const { role } = user;

  const [message, setMessage] = useState("");
  const [open, setOpen] = useState(false);
  const [delReq, setDelReq] = useState({ url: "", id: "" });
  const [updateId, setUpdateId] = useState(0);
  const [action, setAction] = useState("");

  const handleClose = () => {
    setOpen(false);
  };

  const onDeletButtonClick = (e, row) => {
    if (dataType === CUSTOMER || dataType === ADMIN) {
      const { firstName, lastName, id } = row;
      setMessage(
        `Are you sure you want to delete the user named ${firstName} ${firstName}? All of thier service request will be deleted !!!`
      );
      setDelReq({ url: "user", id });
    }
    if (dataType === SERVICE_PROVIDER) {
      const { serviceProviderName, id } = row;
      setMessage(
        `Are you sure you want to delete the service provider named ${serviceProviderName}? All of thier service request will be deleted !!!`
      );
      setDelReq({ url: "provider", id });
    }

    if (dataType === SERVICE_REQUEST) {
      const { customerName, id } = row;
      setMessage(
        `Are you sure you want to delete the service request for customer ${customerName}?`
      );
      setDelReq({ url: "service-request", id });
    }

    setOpen(true);
    setAction("delete");
  };

  const onUpdateButtonClick = (e, row) => {
    setOpen(true);
    setAction("update");
    const { customerName, id } = row;
    setMessage(
      `Are you sure you want to mark the service request for customer ${customerName} as done?`
    );
    setUpdateId(id);
  };

  const handleConfirm = () => {
    setOpen(false);
    if (action === "delete") {
      const { deleteData } = props;
      deleteData(delReq);
    } else {
      const { updateService } = props;
      updateService(updateId);
    }
  };

  return (
    <div className={"table_container"}>
      <Typography className="reg_form_heading" variant="h6" component="h6">
        {label}:
      </Typography>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 600 }} aria-label="customized table">
          <TableHead>
            <TableRow>
              <StyledTableCell>S. No.</StyledTableCell>
              {headers.map((data, i) => {
                return (
                  <StyledTableCell key={i}>{data.headerName}</StyledTableCell>
                );
              })}
              {role === ADMIN && <StyledTableCell>Delete ?</StyledTableCell>}
              {role === SERVICE_PROVIDER && (
                <StyledTableCell>Mark as Done ?</StyledTableCell>
              )}
            </TableRow>
          </TableHead>
          <TableBody>
            {data.map((row, x) => (
              <StyledTableRow key={x}>
                <StyledTableCell align="left" key={x}>
                  {x + 1}
                </StyledTableCell>
                {headers.map((data, i) => {
                  return (
                    <StyledTableCell align="left" key={i}>
                      {row[data.field]}
                    </StyledTableCell>
                  );
                })}
                {role === ADMIN && (
                  <StyledTableCell>
                    <IconButton
                      type="button"
                      onClick={(e) => {
                        onDeletButtonClick(e, row);
                      }}
                    >
                      <DeleteIcon />
                    </IconButton>
                  </StyledTableCell>
                )}
                {role === SERVICE_PROVIDER &&
                  (row.status === "PENDING" ? (
                    <StyledTableCell>
                      <IconButton
                        type="button"
                        onClick={(e) => {
                          onUpdateButtonClick(e, row);
                        }}
                      >
                        <CheckCircleOutlineIcon />
                      </IconButton>
                    </StyledTableCell>
                  ) : (
                    <>
                      <StyledTableCell>
                        <DoneOutlineIcon />
                      </StyledTableCell>
                    </>
                  ))}
              </StyledTableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle id="alert-dialog-title">{"Confirm"}</DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
            {message}
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button onClick={handleConfirm} autoFocus>
            Agree
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};

export default CustomizedTables;
