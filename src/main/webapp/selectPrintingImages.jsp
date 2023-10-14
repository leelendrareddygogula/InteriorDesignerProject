<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/selectPrintingImages.css">
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<title>Quotation Images | Printing</title>
</head>
<body>
<br></br>
	<h2 align="center">Select Images</h2>
	<h3 style="color: red; align: center;"><c:out value="${errmessage}"></c:out></h3>
	<br></br>
	<form action="/designer/quotationImagesPrinting" method="post">
	
		<div class="details">
			<table align="center" border="1" id="selectingImages">
				<thead>
				<tr>
					<th>Select</th>
					<th>Name</th>
					<th>Image</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="image" items="${images}">
					<tr>
						<td> <input type="checkbox" name="selectimage" value="${image.id}"> </td>
						<td>${image.name}</td>
						<td> <img src="/designer/quotationImage?id=${image.id}" width="auto" height="150px"> </td>
					</tr>
				</c:forEach>
				</tbody>
				<tr>
					<td colspan="3" align="center"> <button type="submit" id="checkBtn">Proceed</td>
				</tr>
			</table>
		</div>
	</form>
	
	<script type="text/javascript">
		new DataTable("#selectingImages");
		
		$(document).ready(function () {
		    $('#checkBtn').click(function() {
		        checked = $("input[type=checkbox]:checked").length;

		        if(!checked) {
		            alert("You must check at least one checkbox.");
		            return false;
		        }
		    });
		});
		
	</script>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>