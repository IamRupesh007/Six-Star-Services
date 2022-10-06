import React from "react";
import styled from "styled-components";
// Components
import ProjectBox from "../Elements/ProjectBox";
import FullButton from "../Buttons/FullButton";
// Assets
import ProjectImg1 from "../../../assets/img/projects/1.jpg";
import ProjectImg2 from "../../../assets/img/projects/2.jpg";
import ProjectImg3 from "../../../assets/img/projects/3.webp";
import ProjectImg4 from "../../../assets/img/projects/4.jpg";
import ProjectImg5 from "../../../assets/img/projects/5.jpg";
import ProjectImg6 from "../../../assets/img/projects/6.jpg";
import AddImage2 from "../../../assets/img/add/AY.jpg";

export default function Projects() {
  return (
    <Wrapper id="projects">
      <div className="whiteBg">
        <div className="container">
          <HeaderInfo>
            <h1 className="font40 extraBold">Our Awesome Projects</h1>
            <p className="font13">
            We are currently running several projects in the fastest growing neighborhoods, affordable housing projects, ultra-luxury skyscrapers, small offices and large business centers.
            <br/>
            Our projects are spread across the Mumbai Metropolitan Region (MMR) and Pune Region.
            </p>
          </HeaderInfo>
          <div className="row textCenter">
            <div className="col-xs-12 col-sm-4 col-md-4 col-lg-4">
              <ProjectBox
                img={ProjectImg1}
                title=" Dombavli Project"
                text="Dombavli East ,Beyond Thane , Thane, Maharashtra."
                
               
              />
            </div>
            <div className="col-xs-12 col-sm-4 col-md-4 col-lg-4">
              <ProjectBox
                img={ProjectImg2}
                title="Manjari Project"
                text="Keshav Nagar, Manjari Budruk, Mundhwa Pune, Maharashtra."
               
              />
            </div>
            <div className="col-xs-12 col-sm-4 col-md-4 col-lg-4">
              <ProjectBox
                img={ProjectImg3}
                title="Bandra West Project"
                text="Bandra West, Western Suburbs, Mumbai, Maharashtra."
                
              />
            </div>
          </div>
          <div className="row textCenter">
            <div className="col-xs-12 col-sm-4 col-md-4 col-lg-4">
              <ProjectBox
                img={ProjectImg4}
                title="Kalyan Project"
                text="Kalyan West, Mumbai Beyond Thane, Mumbai, Maharashtra."
                
              />
            </div>
            <div className="col-xs-12 col-sm-4 col-md-4 col-lg-4">
              <ProjectBox
                img={ProjectImg5}
                title="Hinjewadi Project"
                text="Phase-3, Hinjewadi, Pune, Maharashtra."
                
              />
            </div>
            <div className="col-xs-12 col-sm-4 col-md-4 col-lg-4">
              <ProjectBox
                img={ProjectImg6}
                title="Juhu Project"
                text="Gulmohar Colony, Juhu, Mumbai South West, Mumbai, Maharashtra."
                
              />
            </div>
          </div>
          <div className="row flexCenter">
            <div style={{ margin: "50px 0", width: "200px" }}>
          
            </div>
          </div>
        </div>
      </div>
      <div className="lightBg">
        <div className="container">
          <Advertising className="flexSpaceCenter">
            <AddLeft>
              ,<AddLeftInner>
                <ImgWrapper className="flexCenter">
                  <img className="radius8" src={AddImage2} alt="add" />
                </ImgWrapper>
              </AddLeftInner>
            </AddLeft>
            <AddRight>
              <h4 className="font15 Bold">A few words about company</h4>
              <h2 className="font40 extraBold">Six Star Services</h2>
              <h2 className="font15 semiBold" >We are providing Budget-Friendly Home Services office</h2>
              <p className="font12">
              We are a new Company Which provided services like plumbing, electrical, painter,Interior-Design, Architect, Contractor to renovation thir old house and also we provided new house build in Mumbai and pune. Six Star Services are services provider company that has completed over 50 projects in the city. We are currently providing  several services in new townships in the fastest growing neighborhoods, affordable housing projects, ultra-luxury skyscrapers, small offices and large business centers. Our projects are spread across the Mumbai Metropolitan Region (MMR) and Pune Region 
              </p>
              {/*<ButtonsRow className="flexNullCenter" style={{ margin: "30px 0" }}>
                <div style={{ width: "190px" }}>
                  <FullButton title="Get Started" action={() => alert("clicked")} />
                </div>
                <div style={{ width: "190px", marginLeft: "15px" }}>
                  <FullButton title="Contact Us" action={() => alert("clicked")} border />
                </div>
  </ButtonsRow>*/}
            </AddRight>
          </Advertising>
        </div>
      </div>
    </Wrapper>
  );
}

const Wrapper = styled.section`
  width: 100%;
`;
const HeaderInfo = styled.div`
  @media (max-width: 860px) {
    text-align: center;
  }
`;
const Advertising = styled.div`
  padding: 100px 0;
  margin: 100px 0;
  position: relative;
  @media (max-width: 1160px) {
    padding: 60px 0 40px 0;
  }
  @media (max-width: 860px) {
    flex-direction: column;
    padding: 0 0 30px 0;
    margin: 80px 0 0px 0;
  }
`;
const ButtonsRow = styled.div`
  @media (max-width: 860px) {
    justify-content: space-between;
  }
`;
const AddLeft = styled.div`
  position: relative;
  width: 50%;
  p {
    max-width: 475px;
  }
  @media (max-width: 860px) {
    width: 80%;
    order: 2;
    text-align: center;
    h2 {
      line-height: 3rem;
      margin: 15px 0;
    }
    p {
      margin: 0 auto;
    }
  }
`;
const AddRight = styled.div`
  width: 50%;
  @media (max-width: 860px) {
    width: 80%;
    order: 2;
  }
`;
const AddLeftInner = styled.div`
  width: 100%;
  position: absolute;
  top: -300px;
  left: 0;
  @media (max-width: 1190px) {
    top: -250px;
  }
  @media (max-width: 920px) {
    top: -200px;
  }
  @media (max-width: 860px) {
    order: 1;
    position: relative;
    top: -60px;
    left: 0;
  }
`;
const ImgWrapper = styled.div`
  width: 100%;
  padding: 0 15%;
  img {
    width: 100%;
    height: auto;
  }
  @media (max-width: 400px) {
    padding: 0;
  }
`;
