<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>External Billing | New Component</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="/css/annqbc.css" />
<jsp:include page="navbarforadmin.jsp" />
</head>
<body>
	<br></br>
	<h3><a href="/designer/viewNQBill/${billId}" style="display: flex;
	    text-decoration: none;
	    align-items: self-end;
	    margin-left: 2%;
	    font-size: 23px;
	    color: #110ec1;">
		<span class="material-symbols-outlined" >
			navigate_before
		</span>
		<div>
			Back to bill
		</div>
		</a></h3>
	<center>
	<div class="card">
	<h2 align="center">Enter Values</h2>
		<form action="/designer/saveNQBillComponent/${billId}" method="post">
			<table>
				<tr>
					<td>Enter Component Name: </td>
					<td> <input type="text" required="required" name="nqcompname"> </td>
				</tr>
				<tr>
					<td> Enter Value:  </td>
					<td> <input type="text" required="required" name="nqcompvalue"> </td>
				</tr>
				<tr>
					<td colspan="2"><center style="margin-top: 5%;">
					<button type="submit" style="display: flex; padding-right: 5%;">
						<span class="material-symbols-outlined">
							save
						</span>
						<div style="padding: 9%;">
							Save
						</div>
					</button></center></td>
				</tr>
			</table>
		</form>
	</div>
	</center>
	
	</br></br>
	<br></br>
</body>
<jsp:include page="footerforall.jsp" />
</html>