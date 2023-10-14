<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quotation | Modification</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/mqc.css">
</head>
<body>
	
	<h3><a href="/designer/viewQuotation/${quotComponent.quotationId}" style="display: flex;
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
		<h2 align="center">Please Enter Details</h2>
			<form action="/designer/saveModifiedComponent/${quotComponent.componentId}/${quotComponent.quotationId}" method="post">
				<table>
					<tr>
						<td>Component Name: </td>
						<td> <input type="text" value="${quotComponent.name}" readonly="readonly"> </td>
					</tr>
					<tr>
						<td>Enter height: </td>
						<td><input type="number" name="compheight" placeholder="Enter ${quotComponent.height} if no changes" required="required"></td>
					</tr>
					<tr>
						<td>Enter width: </td>
						<td><input type="number" name="compwidth" placeholder="Enter ${quotComponent.width} if no changes" required="required"></td>
					</tr>
					<tr>
						<td>Enter quantity: </td>
						<td><input type="number" name="compquantity" placeholder="Enter ${quotComponent.quantity} if no changes" required="required"></td>
					</tr>
					<tr>
						<td>Enter price: </td>
						<td><input type="number" name="compprice" placeholder="Enter ${quotComponent.price} if no changes" required="required"></td>
					</tr>
				</table>
				<br>
				<center>
						<button class="generate-continue">
						<span class="material-symbols-outlined">
							save
							</span>
							<div style="padding: 5%;">
							 Save </div>
						</button>
				</center>
				
			</form>
		</div>
	</center>
	
	<br/><br/>
	<br/>
</body>
<jsp:include page="footerforall.jsp" />
</html>