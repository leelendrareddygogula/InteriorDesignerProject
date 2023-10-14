<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/quotationImages.css">
<jsp:include page="navbarforadmin.jsp" />
<title>Quotation Images | Add</title>
</head>
<body>
	<br><br>
	<h2 align="center">Quotation Images</h2>
	<br>
	<center>
		<div class="card">
		<h2 align="center" style="color: green">Add New Image</h2>
			<form action="/designer/saveQuotationImage" method="post" enctype="multipart/form-data">
				<table align = "center">
					<tr>
						<td>Enter description: </td>
						<td> <input type="text" name="imagename" required="required" placeholder="Description..."> </td>
					</tr>
					<tr>
						<td>Upload Image: </td>
						<td> <input type="file" required="required" name="imagefile" accept="image/*" id="imagefile"> </td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<center>
							<button type="submit" class="addcomponent"> 
								<span class="material-symbols-outlined">
									add_photo_alternate
								</span>
								<div>
									Add Image
								</div>
							</button>
						</center>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</center>
	<br/><br/>
	
	<div class="details">
	<h2 align="center" style="color: yellow">Quotation Images</h2>
		<table align = "center" border="1" id="quotationImagesTable">
			<thead>
			<tr>
				<th>Description</th>
				<th>Uploaded On</th>
				<th>Image</th>
				<th>Operations</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allImages}" var="image">
				<tr>
					<td> ${image.name} </td>
					<td>${image.uploadedDate}</td>
					<td> <img src="/designer/quotationImage?id=${image.id}" width="auto" height="150px"> </td>
					<td> <a href="/designer/deleteQuotationImage/${image.id}">
						<span class="material-symbols-outlined" style="color: Red; font-size: 35px;">
							delete
						</span>
						</a> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	<script type="text/javascript">
		var uploadField = document.getElementById("imagefile");
		uploadField.onchange = function() {
		    if(this.files[0].size > 1048570){
		       alert("File size is too big, Try with image size less than 1 MB");
		       this.value = "";
		    };
		};
	</script>
	<script type="text/javascript">
		new DataTable("#quotationImagesTable");
	</script>
	<br></br>
</body>
<jsp:include page="footerforall.jsp" />
</html>