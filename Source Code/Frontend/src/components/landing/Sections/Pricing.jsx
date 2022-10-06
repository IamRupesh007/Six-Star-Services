import React from "react";
import styled from "styled-components";
// Components
import PricingTable from "../Elements/PricingTable";

export default function Pricing() {
  return (
    <Wrapper id="pricing">
      <div className="whiteBg">
        <div className="container">
          <HeaderInfo>
            <h1 className="font40 extraBold">Check Our Pricing</h1>
            <p className="font13">
              We provid Best pricing Services...
            </p>
          </HeaderInfo>
          <TablesWrapper className="flexSpaceNull">
            <TableBox>
              <PricingTable
                icon="roller"
                price="₹ 15000"
                title="Starter"
               // text="We provided in this plan renew complete electric fiting (underground) and all plumbing problem.   ."
                offers={[
                  { name: "Electric", cheked: true },
                  { name: "Plumbing", cheked: true },
                  { name: "Paint ", cheked: false },
                  { name: "Interior-Design", cheked: false },
                  { name: "Architect", cheked: false },
                  { name: "Contractor", cheked: false},
                ]}
                action={() => alert("Register first to get offer")}
              />
            </TableBox>
            <TableBox>
              <PricingTable
                icon="monitor"
                price="₹ 65000"
                title="Basic"
                //text="We provided in this plan ."
                offers={[
                  { name: "Electric", cheked: true },
                  { name: "Plumbing", cheked: true },
                  { name: "Paint ", cheked: true },
                  { name: "Interior-Design", cheked: false },
                  { name: "Architect", cheked: false },
                  { name: "Contractor", cheked: false},
                ]}
                action={() => alert("Register first to get offer")}
              />
            </TableBox>
            <TableBox>
              <PricingTable
                icon="monitor"
                price="₹ 3.5 lac"
                title="Golden"
               // text="We provided all type of services in this plan."
                offers={[
                  { name: "Electric", cheked: true },
                  { name: "Plumbing", cheked: true },
                  { name: "Paint ", cheked: true },
                  { name: "Interior-Design", cheked: true },
                  { name: "Architect", cheked: true},
                  { name: "Contractor", cheked: true},
                ]}
                action={() => alert("Register first to get offer")}
              />
            </TableBox>
          </TablesWrapper>
        </div>
      </div>
    </Wrapper>
  );
}

const Wrapper = styled.section`
  width: 100%;
  padding: 50px 0;
`;
const HeaderInfo = styled.div`
  margin-bottom: 50px;
  @media (max-width: 860px) {
    text-align: center;
  }
`;
const TablesWrapper = styled.div`
  @media (max-width: 860px) {
    flex-direction: column;
  }
`;
const TableBox = styled.div`
  width: 31%;
  @media (max-width: 860px) {
    width: 100%;
    max-width: 370px;
    margin: 0 auto
  }
`;




