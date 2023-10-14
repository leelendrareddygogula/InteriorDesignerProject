<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/addImageType.css">
<link rel="stylesheet" href="https://cdn.materialdesignicons.com/3.6.95/css/materialdesignicons.min.css">
<title>Images | Type</title>
</head>
<body>
	<br>
	<br>
	<br>
	<h2 align="center">Add New Image Type</h2>
	<h3 align="center" style="color: red"> <c:out value="${msg}"></c:out> </h3>
	<form action="/designer/addImageType" method="post" class="in-details">
		<div class="did-floating-label-content">
		  <input class="did-floating-input" name="newcomponent" required="required" type="text" placeholder=" " pattern="[0-9a-zA-Z ]+" title="Special Characters not Allowed">
		  <label class="did-floating-label">Add Your Component Name</label>
		</div>
		<button class="button-89" type="submit" role="button">Add Item</button>
	</form>
	&nbsp;
	
	<div class="details"> 
	<h2 align="center" style="color: white"> Items Available </h2>
		<table align = "center" border="1" id="imageTypeTable">
		<thead>
			<tr>
				<td><b>ID</b></td>
				<td><b>Component Name</b></td>
				<td><b>Operation</b></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${designtypes}" var="des">
				<tr>
					<td> <c:out value="${des.id}"></c:out> </td>
					<td><c:out value="${des.name}"></c:out></td>
					<td class="delbutton"><a href= "/designer/deleteComponent?compid=${des.id}">
						<button class="btn btn-delete">
						  <span class="mdi mdi-delete mdi-24px"></span>
						  <span class="mdi mdi-delete-empty mdi-24px"></span>
						  <span>Delete</span>
						</button></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
	<br/>
	<br/>
	<br/>
	<script type="text/javascript">
		new DataTable("#imageTypeTable", {
			order : [0, 'desc']
		});
	</script>
</body>
<jsp:include page="footerforall.jsp" />
</html>