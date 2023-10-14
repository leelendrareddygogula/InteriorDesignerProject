<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="../css/datatables.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous"> 
<link rel="stylesheet" href="../css/designerSideImages.css">
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<title>Designs | All</title>
</head>
<body>
	<br/><br/><br/><br/>
	<h3 align="center"><b>All Your Images</b></h3>
	<br/><br/>
	
    <div class="did-floating-label-content">
		  <input class="did-floating-input" id="searchInput" name="newcomponent" required="required" type="text" placeholder=" ">
		  <label class="did-floating-label">Search</label>
	</div>

	<div id="imageContainer" class="row row-cols-1 row-cols-md-3 g-4">
       <c:forEach items="${allimages}" var="image">
		<div class="card">
			<img src="/designer/displayImage?iid=${image.id}" class="card-img-top" alt="${image.name}">
			<div class="card-body">
			    <h5 class="card-title"><b>Name: </b>${image.name}</h5>
			    <p class="card-text"><b>Type: </b>${image.type}</p>
			    <p class="card-text"><b>ID: </b>${image.id}</p>
			    <a href="/designer/deleteImage?imgid=${image.id}" class="btn btn-danger">Delete image</a>
			</div>
			<div class="card-footer">
                <small class="text-body-secondary">Image Uploaded on ${image.dateUploaded}</small>
              </div>
		</div>
       </c:forEach>
    </div>
	<br/><br/>
	
	
<script>
$(document).ready(function() {
    $('#searchInput').on('keyup', function() {
        const searchText = $(this).val().toLowerCase();
        
        $('.card').each(function() {
            const cardName = $(this).find('.card-title').text().toLowerCase();
            const cardType = $(this).find('.card-text').text().toLowerCase();
            const uploadedOn = $(this).find('.text-body-secondary').text();
            if (cardName.includes(searchText) || cardType.includes(searchText) || uploadedOn.includes(searchText)) {
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