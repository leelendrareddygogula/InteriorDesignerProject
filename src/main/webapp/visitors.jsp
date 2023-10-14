<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/visitors.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,200" />
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<title>Visitors</title>
</head>
<body>
	<br></br>
	<h1 align="center">Visitors</h1>
	<br></br>
	<div class="details">
		<center>
			<h2>People to contact: </h2>
			<table align="center" border="1" id="notContactedTable">
				<thead>
				<tr>
					<th>Name</th>
					<th>Contact</th>
					<th>Language</th>
					<th>Date Visited</th>
					<th>Operations</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${uncontactedList}" var = "cust">
					<tr>
						<td>${cust.name}</td>
						<td>${cust.mobile}</td>
						<td>${cust.language}</td>
						<td>${cust.dateQuotatedOn}</td>
						<td>
							<a href="/designer/changeOnlineCustomerStatus/${cust.id}">
								<span class="material-symbols-outlined" style="color: lime; font-size: 30px;">
									call
								</span>
							</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</center>
	</div>
	
	
	<br/><br/>
	
	<div class="details">
		<center>
			<h2>People already contacted: </h2>
			<table align="center" border="1" id="contatedTable">
				<thead>
				<tr>
					<th>Name</th>
					<th>Contact</th>
					<th>Language</th>
					<th>Date Visited</th>
					<th>Operations</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${contactedList}" var = "cust">
					<tr>
						<td>${cust.name}</td>
						<td>${cust.mobile}</td>
						<td>${cust.language}</td>
						<td>${cust.dateQuotatedOn}</td>
						<td>
							<a href="/designer/changeOnlineCustomerStatus/${cust.id}">
							<span class="material-symbols-outlined" style="color: yellow; font-size: 30px;">
								phone_disabled
							</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="/designer/deleteOnlineCustomer/${cust.id}">
							<span class="material-symbols-outlined" style="color: Red; font-size: 30px;">
								delete_forever
							</span>
							</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</center>
	</div>
	<br></br><br></br>
	
	<script type="text/javascript">
		new DataTable("#notContactedTable", {
			order:[4, 'desc']
		});
		new DataTable("#contatedTable", {
			order:[4, 'desc']
		});
	</script>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>