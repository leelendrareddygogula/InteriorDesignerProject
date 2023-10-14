<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAMS TROVE - Images</title>
<link rel="stylesheet" href="../css/printSelectedQuotaionImages.css">
</head>
<body>
	<h1 style="color: #a57c3e" align="center">VAMS TROVE</h1>
	<p align="center">
Flat no-2-1, Mouli Towers, 2nd Floor, 1st Block, 40-14-10E, Chandra Mouli Puram,</p>
<p align="center"> Benz Circle, Vijayawada, Andhra Pradesh 520010</p>
<p align="center"><b>GSTIN: 37ACCFA4901C1ZZ</b></p>
	<hr color="black"/><hr color="black"/>
	
	<h2 align="center">Sample Designs</h2>
	
	<table class="displaytable" align="center" border="1">
		<tr>
			<th>Name</th>
			<th>Image</th>
		</tr>
		<c:forEach var="image" items="${selectedImages}">
			<tr>
				<td>${image.name}</td>
				<td align="center" > <img src="/designer/quotationImage?id=${image.id}" style="aspect-ratio: auto; width: auto;"/></td>
			</tr>
		</c:forEach>
	</table>
	
	
	<div class="sign">
		<h3>__________________</h3>
		<p>Authorized Signature</p>
	</div>
	<br/><br/>
	<div align="center">
		<button class="printbutton" onclick="window.print()">Print</button>
	</div>
	
	<br><br><br><br>
	
	<br><br>
</body>
</html>