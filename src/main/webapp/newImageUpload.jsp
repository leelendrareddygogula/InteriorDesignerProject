<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="../css/newImageUpload.css">	
<head>
<meta charset="UTF-8">
<title>Image | upload</title>
<jsp:include page="navbarforadmin.jsp" />
</head>
<body>
	<form action="/designer/addImage" method="post" enctype="multipart/form-data">
		<center>
			<div class="card" align="center">
				<h2 align="center">Upload a Image</h2>
				<h3 align="center" style="color: green"> <c:out value="${imagemsg}"></c:out> </h3>
				<h3 align="center" style="color: red"> <c:out value="${ermsg}"></c:out> </h3>
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter description:</label>
					<input class="did-floating-input" type="text" placeholder="Description ..." required="required" name="designname" pattern="[0-9a-zA-Z ]+" title="Special Characters not Allowed">
				</div>
				<br>
				<div class="selectinput">
					<label style="margin-top: 1.5%;">Select image type:</label>
					<div class="custom-select" >
					  <select name="imagedesignType" required="required">
					    <option value="">---select---</option>
					    <c:forEach items="${imageTypesList}" var="item">
							<option value="${item.name}">${item.name}</option>
						</c:forEach>
					  </select>
					</div>
				</div>
				<br>
				<div class="imageupload">
					<label>Upload image:</label>
					<input type="file" style="margin-left: 6%;" required="required" name="designimage" accept="image/*" id="designimage">
				</div>
				<br>
				<div class="submitbutton">
					<button class="button-57" role="button" type="submit">
						<span class="text">Upload Image</span>
						<span class="material-symbols-outlined">upload</span>
					</button>
				</div>
			</div>
		</center>
		
	</form>
	
	
	<script type="text/javascript">
		var uploadField = document.getElementById("designimage");
		uploadField.onchange = function() {
		    if(this.files[0].size > 1048570){
		       alert("File size is too big, Try with image size less than 1 MB");
		       this.value = "";
		    };
		};
		
		
		var x, i, j, l, ll, selElmnt, a, b, c;
		/*look for any elements with the class "custom-select":*/
		x = document.getElementsByClassName("custom-select");
		l = x.length;
		for (i = 0; i < l; i++) {
		  selElmnt = x[i].getElementsByTagName("select")[0];
		  ll = selElmnt.length;
		  /*for each element, create a new DIV that will act as the selected item:*/
		  a = document.createElement("DIV");
		  a.setAttribute("class", "select-selected1");
		  a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
		  x[i].appendChild(a);
		  /*for each element, create a new DIV that will contain the option list:*/
		  b = document.createElement("DIV");
		  b.setAttribute("class", "select-items select-hide");
		  for (j = 1; j < ll; j++) {
		    /*for each option in the original select element,
		    create a new DIV that will act as an option item:*/
		    c = document.createElement("DIV");
		    c.innerHTML = selElmnt.options[j].innerHTML;
		    c.addEventListener("click", function(e) {
		        /*when an item is clicked, update the original select box,
		        and the selected item:*/
		        var y, i, k, s, h, sl, yl;
		        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
		        sl = s.length;
		        h = this.parentNode.previousSibling;
		        for (i = 0; i < sl; i++) {
		          if (s.options[i].innerHTML == this.innerHTML) {
		            s.selectedIndex = i;
		            h.innerHTML = this.innerHTML;
		            y = this.parentNode.getElementsByClassName("same-as-selected");
		            yl = y.length;
		            for (k = 0; k < yl; k++) {
		              y[k].removeAttribute("class");
		            }
		            this.setAttribute("class", "same-as-selected");
		            break;
		          }
		        }
		        h.click();
		    });
		    b.appendChild(c);
		  }
		  x[i].appendChild(b);
		  a.addEventListener("click", function(e) {
		      /*when the select box is clicked, close any other select boxes,
		      and open/close the current select box:*/
		      e.stopPropagation();
		      closeAllSelect(this);
		      this.nextSibling.classList.toggle("select-hide");
		      this.classList.toggle("select-arrow-active");
		    });
		}
		function closeAllSelect(elmnt) {
		  /*a function that will close all select boxes in the document,
		  except the current select box:*/
		  var x, y, i, xl, yl, arrNo = [];
		  x = document.getElementsByClassName("select-items");
		  y = document.getElementsByClassName("select-selected");
		  xl = x.length;
		  yl = y.length;
		  for (i = 0; i < yl; i++) {
		    if (elmnt == y[i]) {
		      arrNo.push(i)
		    } else {
		      y[i].classList.remove("select-arrow-active");
		    }
		  }
		  for (i = 0; i < xl; i++) {
		    if (arrNo.indexOf(i)) {
		      x[i].classList.add("select-hide");
		    }
		  }
		}
		/*if the user clicks anywhere outside the select box,
		then close all select boxes:*/
		document.addEventListener("click", closeAllSelect);
		
	</script>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>