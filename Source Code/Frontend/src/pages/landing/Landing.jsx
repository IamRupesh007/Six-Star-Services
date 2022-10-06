import React from "react";
// Sections
import TopNavbar from "../../components/landing/Nav/TopNavbar";
import Header from "../../components/landing/Sections/Header";
import Services from "../../components/landing/Sections/Services";
import Projects from "../../components/landing/Sections/Projects";
import Blog from "../../components/landing/Sections/Blog";
import Pricing from "../../components/landing/Sections/Pricing";
import Contact from "../../components/landing/Sections/Contact";
import Footer from "../../components/landing/Sections/Footer"

export default function Landing() {
  return (
    <>
      <TopNavbar />
      <Header />
      <Services />
      <Projects />
      <Blog />
      <Pricing />
      <Contact />
      <Footer />
    </>
  );
}


