import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";

import {
  fetchServiceRequestsById,
  updateService,
} from "../../redux/services/services";
import { CUSTOMER, SERVICE_PROVIDER } from "../../constants/otherConstants";
import CustomTable from "../../components/table";

const headers = [
  {
    headerName: "Status",
    field: "status",
  },
  {
    headerName: "Created On",
    field: "createDate",
    type: "date",
  },
  {
    headerName: "Modified On",
    field: "modifyDate",
    hidden: true,
    type: "date",
  },
  {
    headerName: "Completed On",
    field: "completionDate",
    type: "date",
  },
  {
    headerName: "Service Type",
    field: "serviceType",
  },

  {
    headerName: "Service Request For",
    field: "customerName",
  },
  {
    headerName: "Service Provider Name",
    field: "serviceProviderName",
  },
];

const ViewServices = (props) => {
  console.log("hello");
  const [data, setData] = useState([]);
  const [label, setLabel] = useState("");

  useEffect(() => {
    const { user, fetchServiceRequestsById, services } = props;

    const { role, id, firstName } = user;
    setLabel("Service Requests raised by " + firstName);
    let userUrl = "";
    if (role === CUSTOMER) {
      userUrl = "user_requests";
    }
    if (role === SERVICE_PROVIDER) {
      userUrl = "sp_requests";
    }

    fetchServiceRequestsById(userUrl, id);
  }, []);

  useEffect(() => {
    const { services } = props;
    if (data !== services) {
      setData(services);
    }
  }, [props.services]);

  useEffect(() => {
    const { user, fetchServiceRequestsById, serviceUpdateResponse } = props;

    const { role, id, firstName } = user;
    setLabel("Service Requests raised by " + firstName);
    let userUrl = "";
    if (role === CUSTOMER) {
      userUrl = "user_requests";
    }
    if (role === SERVICE_PROVIDER) {
      userUrl = "sp_requests";
    }

    fetchServiceRequestsById(userUrl, id);
  }, [props.serviceUpdateResponse]);

  const { user, updateService } = props;
  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>{label}</title>
      </Helmet>
      <CustomTable
        data={data}
        headers={headers}
        label={label}
        user={user}
        updateService={updateService}
      />
    </>
  );
};

const mapStateToProps = (state) => ({
  services: state.fetchServicesReducer.services,
  serviceUpdateResponse: state.updateServiceReducer.serviceUpdateResponse,
});

const mapDispatchToProps = (dispatch) =>
  bindActionCreators({ fetchServiceRequestsById, updateService }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(ViewServices);
