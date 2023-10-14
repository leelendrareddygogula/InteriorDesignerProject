<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Billing | Modification</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/mbc.css">
</head>
<body>
	<br>
	
	<h3 class="backtobill"><a href="/designer/viewBill/${billComponent.billId}" style="display: flex;
	    text-decoration: none;
	    align-items: self-end;
	    margin-left: 2%;
	    font-size: 23px;
	    color: #110ec1;">
		<span class="material-symbols-outlined" >
			navigate_before
		</span>
		<div>
			Back to Bill
		</div>
		</a></h3>
	
		
	</div>
	<center>
		<div class="card">
		<h2 align="center">Enter Details</h2>
			<form action="/designer/saveModifiedBillComponent/${billComponent.billComponentId}/${billComponent.billId}" method="post">
				<table>
					<tr>
						<td>Component Name</td>
						<td> <input type="text" readonly="readonly" value="${billComponent.componentName}" name="componentName"> </td>
					</tr>
					<tr>
						<td>Enter Amount</td>
						<td> <input type="number" required="required" name = "modifiedAmount" placeholder="Previous: ${billComponent.amount}"></td>
					</tr>
				</table>
				
				<center>
				<button class="generate-continue" type="submit">
					<span class="material-symbols-outlined">
						attach_money
					</span>
					<div style="padding: 5%;">
						Continue
					</div>
				</button>
			</center>
				
			</form>
		</div>
	</center>
	<br/><br/>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>