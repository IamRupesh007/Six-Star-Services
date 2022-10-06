import { Route, Routes } from "react-router-dom";
import React from "react";
import {
  ADMIN,
  CUSTOMER,
  SERVICE_PROVIDER,
  SERVICE_REQUEST,
} from "./constants/otherConstants";
import ViewUserAndServices from "./pages/viewAllData";
import LoginScreen from "./pages/login";
import RegistrationScreen from "./pages/registration";
import Profile from "./pages/profile";
import CreateService from "./pages/createServiceRequest";
import ViewServices from "./pages/viewServiceRequests";
import Landing from "./pages/landing/Landing";
export const Routings = (props) => {
  const { isLoggedIn, user } = props;
  console.log(user, "inside route");
  if (!isLoggedIn) {
    return (
      <>
        <Routes>
          <Route path="*" element={<Landing />} />
          <Route path="/" element={<Landing />} />
          <Route path="/login">
            <Route
              path="/login"
              element={<LoginScreen userType={CUSTOMER} />}
            />
            <Route
              path="/login/admin"
              element={<LoginScreen userType={ADMIN} />}
            />
            <Route
              path="/login/service"
              element={<LoginScreen userType={SERVICE_PROVIDER} />}
            />
          </Route>
          <Route path="/register">
            <Route
              path="/register"
              element={<RegistrationScreen userType={CUSTOMER} />}
            />
            <Route
              path="/register/service"
              element={<RegistrationScreen userType={SERVICE_PROVIDER} />}
            />
          </Route>
          <Route path="/404" element={() => <h1>404</h1>} />
        </Routes>
      </>
    );
  }

  const { role } = user;
  if (role === CUSTOMER) {
    return (
      <>
        <Routes>
          <Route
            path="/create-service"
            element={<CreateService user={user} />}
          />
          <Route path="/view-services" element={<ViewServices user={user} />} />
          <Route path="/profile" element={<Profile user={user} />} />
        </Routes>
      </>
    );
  }

  if (role === SERVICE_PROVIDER) {
    return (
      <>
        <Routes>
          <Route path="/view-services" element={<ViewServices user={user} />} />
          <Route path="/profile" element={<Profile user={user} />} />
        </Routes>
      </>
    );
  }

  if (role === ADMIN) {
    return (
      <>
        <Routes>
          <Route
            path="/view-users"
            element={<ViewUserAndServices user={user} dataType={CUSTOMER} />}
          />
          <Route
            path="/view-service-providers"
            element={
              <ViewUserAndServices user={user} dataType={SERVICE_PROVIDER} />
            }
          />
          <Route
            path="/view-admins"
            element={<ViewUserAndServices user={user} dataType={ADMIN} />}
          />
          <Route
            path="/view-service-reqs"
            element={
              <ViewUserAndServices user={user} dataType={SERVICE_REQUEST} />
            }
          />
          <Route path="/profile" element={<Profile user={user} />} />
        </Routes>
      </>
    );
  }
};
export default Routings;
