<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="../css/datatables.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous"> 
<link rel="stylesheet" href="../css/newimportItemUpload.css">	
<jsp:include page="navbarforadmin.jsp" />
<head>
<meta charset="UTF-8">
<title>Furniture | New Item</title>
</head>
<body>
<br/><br/>
	<form action="/designer/addImportItem" method="post"
		enctype="multipart/form-data">
		<center>
			<div class="card1" align="center">
				<br>
				<h2 align="center">Add New Item</h2>
				<h3 align="center" style="color: green"> <c:out value="${msg}"></c:out> </h3>
				<br>
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter ID/Reference Number:</label>
					<input class="did-floating-input" type="text" placeholder="" required="required" name="imgid">
				</div>
				<br>
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter Name:</label>
					<input class="did-floating-input" type="text" placeholder="" required="required" name="imgname">
				</div>
				<br><br>
				<div class="imageupload">
					<label>Upload image:</label>
					<input type="file" style="margin-right: -8.5%;" required="required" name="imgfile" id="imgfile" accept="image/*">
				</div>
				<br><br>
				<div class="submitbutton">
					<button class="button-57" role="button" type="submit">
						<span class="text">Upload Image</span>
						<span class="material-symbols-outlined">upload</span>
					</button>
				</div>
			</div>
		</center>
	</form>
	<br/><br/>
	
<div class="did-floating-label-content1">
		  <input class="did-floating-input1" id="searchInput1" name="newcomponent" required="required" type="text" placeholder=" ">
		  <label class="did-floating-label1">Search</label>
	</div>

	<div id="imageContainer" class="row row-cols-1 row-cols-md-3 g-4">
       <c:forEach items="${importsList}" var="i">
		<div class="card">
			<img src="/designer/viewImportImage/${i.id}" class="card-img-top" alt="${image.name}">
			<div class="card-body">
			    <h5 class="card-text"><b>Name: </b>${i.name}</h5>
			    <p class="card-text"><b>ID: </b>${i.id}</p>
			    <a href="/designer/deleteImportItem?id=${i.id}" class="btn btn-danger">Delete image</a>
			</div>
		</div>
       </c:forEach>
    </div>
	<br/><br/>



	<script type="text/javascript">
		var uploadField = document.getElementById("imgfile");
		uploadField.onchange = function() {
		    if(this.files[0].size > 1048570){
		       alert("File size is too big, Try with image size less than 1 MB");
		       this.value = "";
		    };
		};
		
		
	$(document).ready(function() {
	    $('#searchInput1').on('keyup', function() {
	        const searchText = $(this).val().toLowerCase();
	        
	        $('.card').each(function() {
	            const cardType = $(this).find('.card-text').text().toLowerCase();
	            if (cardType.includes(searchText)) {
	                $(this).show();
	            } else {
	                $(this).hide();
		            }
		        });
		    });
		});
	</script>

</body>
<jsp:include page="footerforall.jsp" />
</html>