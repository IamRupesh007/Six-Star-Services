import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";

import { deleteData, fetchAll } from "../../redux/services/services";
import CustomTable from "../../components/table";
import {
  ADMIN,
  CUSTOMER,
  SERVICE_PROVIDER,
  SERVICE_REQUEST,
} from "../../constants/otherConstants";

const headerServices = [
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

const headerUser = [
  {
    headerName: "First Name",
    field: "firstName",
  },
  {
    headerName: "Middle Name",
    field: "middleName",
  },
  {
    headerName: "Last Name",
    field: "lastName",
  },
  {
    headerName: "Phone Number",
    field: "phoneNumber",
  },
  {
    headerName: "Registered Email ",
    field: "email",
  },
];

const headerServiceProvider = [
  {
    headerName: "Service Provider Name",
    field: "serviceProviderName",
  },
  ...headerUser,

  {
    headerName: "Service Type Provided",
    field: "serviceTypes",
  },
];

const ViewUserAndServices = (props) => {
  const [data, setData] = useState([]);
  const [label, setLabel] = useState("");

  const [headers, setHeaders] = useState(headerUser);

  useEffect(() => {
    const { allData, fetchAll } = props;

    if (Object.keys(allData).length === 0) {
      fetchAll();
    }
  }, []);

  useEffect(() => {
    const { allData, dataType } = props;

    if (Object.keys(allData).length > 0) {
      const { serviceProviders, customers, admins, serviceRequests } = allData;

      switch (dataType) {
        case CUSTOMER:
          setLabel("All Customers");
          setData(customers);
          setHeaders(headerUser);
          break;
        case SERVICE_PROVIDER:
          setData(serviceProviders);
          setLabel("All Service Providers");
          setHeaders(headerServiceProvider);
          break;
        case ADMIN:
          setData(admins);
          setLabel("All Admins");
          setHeaders(headerUser);
          break;
        case SERVICE_REQUEST:
          setData(serviceRequests);
          setLabel("All Service Requests");
          setHeaders(headerServices);
          break;
      }
    }
  }, [props.allData, props]);

  useEffect(() => {
    const { fetchAll, delRes } = props;
    if (Object.keys(delRes).length > 0) {
      fetchAll();
    }
  }, [props.delRes]);

  const { user, dataType, deleteData } = props;

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
        dataType={dataType}
        deleteData={deleteData}
      />
      <br />
    </>
  );
};

const mapStateToProps = (state) => ({
  allData: state.fetchAllReducer.allData,
  delRes: state.deleteDataReducer.delRes,
});

const mapDispatchToProps = (dispatch) =>
  bindActionCreators({ fetchAll, deleteData }, dispatch);

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ViewUserAndServices);
