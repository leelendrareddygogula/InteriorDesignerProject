<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/materialsAndQperations.css">
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<title>Customer Quotation</title>
</head>
<body>
	<br></br>
	<center>
	<div class="card">
	<h2 align="center">Add New Component</h2>
		<form action="/designer/saveNewMaterial" method="post">
			<table>
				<tr>
					<td><b>Enter Type: </b></td>
					<td> <input type="text" name="materialname" required="required"> </td>
				</tr>
				<tr>
					<td><b>Enter Price: </b></td>
					<td> <input type="number" name="materialprice" required="required"> </td>
				</tr>
				<tr>
					<td><b>Does price vary with measurements?</b></td>
					<td style="font-size: 20px;">
						<input type="radio" name="materialtype" required="required" value="Yes"><label for="Yes">Yes</label>
						<input type="radio" name="materialtype" required="required" value="No"><label for="No">No</label>
					</td>
				</tr>
			</table>
			<br>
			<center>
			<button type="submit" style="display: flex;
									    padding-right: 5%;
									    background: green;
									    color: white;
									    border-radius: 30px;
									    font-size: 20px;">
				<span class="material-symbols-outlined" style="font-size: 33px;">
					add_circle
				</span>
				<div style="padding: 9%;">
					Add
				</div>
			</button></center></td>
		</form>
	</div>
	</center>
	
	<br/><br/>
	<div class="details">
		<table align="center" border="1" id="materialsTable">
			<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Changes with Dimensions</th>
				<th>Operations</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${materialList}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>
						<c:if test="${item.variesWithMeasurements==true}">Yes</c:if>
						<c:if test="${item.variesWithMeasurements==false}">No</c:if>
					</td>
					<td> <a href="/designer/deleteMaterial/${item.id}"><span class="material-symbols-outlined" style="color: red; font-size: 30px;">
							Delete
						</span></a> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<br></br>
	<br/>
	
	<script type="text/javascript">
		new DataTable("#materialsTable", {
			order:[]
		});
	</script>
</body>
<jsp:include page="footerforall.jsp" />
</html>