import { Button } from "@mui/material";
import React from "react";
import { Link, useNavigate } from "react-router-dom";

import "./style.css";
import {
  ADMIN,
  CUSTOMER,
  SERVICE_PROVIDER,
} from "../../constants/otherConstants";

const headerItems = [
  { label: "Create Service Request", path: "/create-service" },
  { label: "View Service Requests", path: "/view-services" },
  { label: "My Profile", path: "/profile" },
];

const headerItemsService = [
  { label: "View Service Requests", path: "/view-services" },
  { label: "My Profile", path: "/profile" },
];

const headerItemsAdmin = [
  { label: "View Users", path: "/view-users" },
  { label: "View Service Providers", path: "/view-service-providers" },
  { label: "View Service Requests", path: "/view-service-reqs" },
  { label: "View Admins", path: "/view-admins" },
  { label: "My Profile", path: "/profile" },
];

const Header = (props) => {
  const { user, logout } = props;
  const navigate = useNavigate();
  let headers = [];
  switch (user.role) {
    case CUSTOMER:
      headers = headerItems;
      break;
    case SERVICE_PROVIDER:
      headers = headerItemsService;
      break;
    case ADMIN:
      headers = headerItemsAdmin;
      break;
  }
  const onLogoutClick = () => {
    logout();
    navigate(0);
  };

  return (
    <div className="header">
      <div>CW Services</div>
      <div className="header_menu">
        {headers.map((item, key) => {
          return (
            <Link
              key={key}
              to={item.path}
              style={{ color: "white", textDecoration: "none" }}
            >
              <div className="header_item">
                <Button type="button" variant="outlined">
                  {item.label}
                </Button>
              </div>
            </Link>
          );
        })}
        <Button type="button" variant="contained" onClick={onLogoutClick}>
          Logout
        </Button>
      </div>
    </div>
  );
};

export default Header;
