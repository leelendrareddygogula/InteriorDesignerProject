<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="headerforall.jsp" />
<link rel="stylesheet" href="/css/navbarforadmin.css">
   <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" /> <nav>
        <ul class="navbar">
          <li class="dropdown">
            <a href="/designer/designerHome" class="dropbtn">Home</a>
          </li>
          <li class="dropdown">
              <a href="#" class="dropbtn">Images</a>
              <div class="dropdown-content">
                  <a href="/designer/addNewImageType">Add Image type</a>
                  <a href="/designer/imageupload">Insert new image</a>
                  <a href="/designer/viewAllImages">View All Images</a>
              </div>
          </li>
          <li class="dropdown">
              <a href="#" class="dropbtn">Quotation</a>
              <div class="dropdown-content">
                  <a href="/designer/newQuotation">Generate New Quotation</a>
                  <a href="/designer/allQuotations">View All Quotations</a>
                  <a href="/designer/newQuotationImage">Add Quotation Image</a>
                  <a href="/designer/printQuotationImages" target="_blank">Print Quotation Images</a>
              </div>
          </li>
          <li class="dropdown">
              <a href="#" class="dropbtn">Furniture Quotation</a>
              <div class="dropdown-content">
				<a href="/designer/importItem">New Furniture Item</a>
				<a href="/designer/generateImportsQuotation">Generate Furniture Quotation</a>
                  <a href="/designer/allImportsQuotations">View All Furniture Quotations</a>
              </div>
          </li>
          <li class="dropdown">
              <a href="#" class="dropbtn">Billing</a>
              <div class="dropdown-content">
                  <a href="/designer/generateBill">Generate New Bill</a>
                  <a href="/designer/allYourQuotationBills">View All Bills</a>
              </div>
          </li>
          <li class="dropdown">
              <a href="#" class="dropbtn">External Billing</a>
              <div class="dropdown-content">
                  <a href="/designer/nonQuotationBill">Generate Non-Quotation Bill</a>
                  <a href="/designer/allNQBills">View All Non Quotation Bills</a>
              </div>
          </li>
          <li class="dropdown">
              <a href="#" class="dropbtn">Customer Quotation</a>
              <div class="dropdown-content">
                  <a href="/designer/materials">Add Quotation Prices</a>
                  <a href="/designer/getOnlineCustomersList">Customer Visits</a>
              </div>
          </li>
          <li class="dropdown">
              <a href="/designer/feedbackdasboard" class="dropbtn">Feedback</a>
          </li>
          <li class="logout">
            <button class="logout-btn" onclick="window.location.href = '/logout';"> <span class="material-symbols-outlined">logout</span> Logout</button>
          </li>
        </ul>
    </nav>

</head>
<body>

</body>
</html>