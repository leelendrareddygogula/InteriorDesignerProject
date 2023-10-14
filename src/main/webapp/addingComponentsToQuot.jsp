<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quotation | New Item</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/addingComponentsToQuot.css">
</head>
<body>
	
	<h1 align="center">Enter details to add</h1>
	<h3><a href="/designer/viewQuotation/${quotId}" style="display: flex;
	    text-decoration: none;
	    align-items: self-end;
	    margin-left: 2%;
	    font-size: 23px;
	    color: #110ec1;">
		<span class="material-symbols-outlined" >
			navigate_before
		</span>
		<div>
			Back to all Components
		</div>
		</a></h3>
	<center>
		<div class="card">
			<form action="/designer/saveComponentToQuotation/${quotId}" method="post">
				<table align = "center">
					<tr>
						<td> Enter the name of component: </td>
						<td> <input type="text" name="compname" required="required" > </td>
					<tr>
					<tr>
						<td> Enter the height (in inches): </td>
						<td> <input type="number" name="compheight" required="required" placeholder="-1 if not applicable"> </td>
					<tr>
					<tr>
						<td> Enter the width (in inches): </td>
						<td> <input type="number" name="compwidth" required="required" placeholder="-1 if not applicable"> </td>
					<tr>
					<tr>
						<td> Enter the quantity: </td>
						<td> <input type="number" name="compquantity" required="required" > </td>
					<tr>
					<tr>
						<td> Enter the price (in rupees): </td>
						<td> <input type="number" name="compprice" required="required" > </td>
					<tr>
				</table>
				<br></br>
				<center>
					<button class="generate-add">Add component</button>
				</center>
				
			</form>
		</div>
	</center>
	<br/><br/>
	<br/><br/>
</body>
<jsp:include page="footerforall.jsp" />
</html>