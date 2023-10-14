<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/viewQuotations.css">
<jsp:include page="navbarforadmin.jsp" />
<meta charset="UTF-8">
<title>Furniture Quotations | All</title>
</head>
<body>
<br><br>
	
	<br><br>
	<div class="details"> 
	<h2 align="center" style="color: white">All Your Quotations</h2>
	<table align = "center" border="1" id = "quotsTable">
		<thead>
			<tr>
				<th>Quotation ID</th>
				<th>Date</th>
				<th>Customer Name</th>
				<th>Mobile Number</th>
				<th>Address</th>
				<th>Contact Person</th>
				<th>Finalized Amount</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="quotation" items="${allQuotationsList}">
				<tr><td>${quotation.id}</td>
				<td>${quotation.date}</td>
				<td>${quotation.name}</td>
				<td>${quotation.contactNumber}</td>
				<td>${quotation.address}</td>
				<td>${quotation.contactPerson}</td>
				<td>${quotation.finalizedAmount}</td>
				<td>
					<a href="/designer/printImportsQuotation/${quotation.id}" target="_blank" style="color: lime;">
						<span class="material-symbols-outlined" style="font-size: 30px;">
							print
						</span></a> &nbsp;
					<a href="/designer/viewImportsQuotation/${quotation.id}" style="color: yellow;">
						<span class="material-symbols-outlined" style="font-size: 30px;">
								edit
							</span></a>&nbsp;
				</td></tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	
	<script type="text/javascript">
		new DataTable("#quotsTable", {
			order : [0, 'desc'],
		})
		
	</script>
	<br><br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>