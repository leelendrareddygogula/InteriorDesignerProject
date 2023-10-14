<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="homenavbar.jsp" />
<link rel="stylesheet" href="../css/sidenav.css">
<link rel="stylesheet" href="../css/home.css">
<title>Home</title>
</head>
<body>
<br>
	<span style="padding-left: 2%;font-size:30px;cursor:pointerfont-size:30px;cursor:pointer" onclick="openNav()">&#9776; Our Designs</span>
	
	<h4 align="center" style="color: blue;"> <c:out value="${feedbackMessage}"></c:out> </h4>
	<div class="buttons">
		<a href="/customer/quotation/new"><button>Try our quotation?</button></a><br/><br/>
		<a href="/customer/feedback"><button>Feedback us :-)</button></a>
	</div>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <c:forEach items="${allImageTypes}" var="type">
		<a href="/images/${type}">View <c:out value="${type}"></c:out> </a><br/>
	</c:forEach>
</div>
<br></br>
<div class="container"> 

	<div class="about">
		<h2>About Us</h2>
		
		<p>Founded in 2023, VAMS TROVE is a full-service interior design firm located in Vijayawada, Andhra Pradesh. We specialize in creating beautiful, functional, and stylish spaces that reflect our clients' unique needs and style.
		
		Our team of experienced designers has a passion for creating spaces that people love to live in. We believe that every space should be a reflection of the people who live there, and we work closely with our clients to understand their needs and goals.
		
		We offer a wide range of services, including:
		<ul>
			<li>Space planning and layout</li>
			<li>Color consultation</li>
			<li>Furniture selection</li>
			<li>Fabric and material selection</li>
			<li>Lighting design</li>
			<li>Window treatments</li>
			<li>Wall coverings</li>
			<li>Hardscaping</li>
			<li>Kitchen designs</li>
			<li>Hardware selection </li>
		</ul>
		
		We are committed to providing our clients with the highest level of service and attention to detail. We believe that every project is a collaboration, and we work closely with our clients to create spaces that they will love for years to come.
		</p>
	</div>

</div>

	<br><br><br><br>
</body>
<jsp:include page="footerforall.jsp" />

	<script>
		function openNav() {
		  document.getElementById("mySidenav").style.width = "250px";
		}
		
		function closeNav() {
		  document.getElementById("mySidenav").style.width = "0";
		}
	</script>
	
</html>