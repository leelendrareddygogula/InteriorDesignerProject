<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<jsp:include page="homenavbar.jsp" />
<link rel="stylesheet" href="../css/sidenav.css">
<link rel="stylesheet" href="../css/clientImages.css">

<title>Our Designs | ${thisDesign}</title>
</head>
<body>
<br><br>
<span style="padding-left: 2%;font-size:30px;cursor:pointer" onclick="openNav()">&#9776; &nbsp; Our Designs</span><br>
	<h1 align="center" style="color: #3aa6b9; font-size: 40px;"> <c:out value="${thisDesign}"></c:out> </h1>
	<br><br>

	<div id="mySidenav" class="sidenav">
	  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	  <a href="/">Home</a></br>
		<c:forEach items="${allImageTypes}" var="type">
			<a href="/images/${type}">View <c:out value="${type}"></c:out> </a><br/>
		</c:forEach>
	</div>
	
	
	
	<div id="imageContainer" class="row row-cols-1 row-cols-md-3 g-4" style="width: 98%; margin-left: 2%;">
       <c:forEach items="${typeDesigns}" var="design">
		<div class="card" style="width: 20rem; margin-left: 2%; margin-right: 1%; background: #efb358;">
			<img src="/image/view?image=${design.id}" class="card-img-top" alt="${design.name}" style="margin-top: 3.5%;">
			<div class="card-body">
			    <h5 class="card-title"><b>Name: </b> ${design.name} </h5>
			</div>
		</div>
       </c:forEach>
    </div>
	<br></br>
	
	
</body>

<script>
		function openNav() {
		  document.getElementById("mySidenav").style.width = "250px";
		}
		
		function closeNav() {
		  document.getElementById("mySidenav").style.width = "0";
		}
	</script>

<jsp:include page="footerforall.jsp" />
</html>