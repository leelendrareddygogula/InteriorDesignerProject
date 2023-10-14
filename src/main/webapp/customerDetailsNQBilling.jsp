<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>External Billing | Customer Details</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/cdnqb.css">
</head>
<body>
	<br>
	<center>
		<div class="card">
		<h2 align="center">Enter Customer Details</h2>
			<form action="/designer/saveNQBillingAndCustomer" method="post">
				
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter Customer Name: </label></td>
					<input class="did-floating-input" type="text" name="customername" placeholder="Name" required="required">
				</div><br>
				
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter mobile number: </label></td>
					<input class="did-floating-input" type="number" name="customermobile" placeholder="Mobile Number" required="required">
				</div><br>
				
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter Contact Person Name: </label></td>
					<input class="did-floating-input" type="text" name="customerreffered" placeholder="Contaceted Person">
				</div><br>
				
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter PAN or GSTIN: </label></td>
					<input class="did-floating-input" type="text" name="customergstin" placeholder="GST NO">
				</div><br>
				
				<div class="nameinput">
					<label style="margin-top: 2.5%;">Enter GST percentage: </label></td>
					<input class="did-floating-input" type="number" name="customergstpercent" required="required" placeholder="enter 0 if not applicable">
				</div><br>
				
				<div class="selectinput2">
					<label style="margin-top: 1.5%;">Select Billing Method:</label></td>
					<div class="custom-select" >
					  <select name="customerbillingmethod" required="required">
						    <option>---select---</option>
						    <option value="Cash">Cash</option>
							<option value="Cheque">Cheque</option>
							<option value="Card">Card</option>8
							<option value="UPI">UPI - PhonePe/GPay/Paytm/Bharatpe/Amazon Pay etc</option>
							<option value="Internet Banking">Internet Banking</option>
					  </select>
					</div>
				</div><br>
					<br>
					<center>
						<button class="generate-continue" type="submit">
							<span class="material-symbols-outlined" style="font-size:30px;">
								receipt_long
							</span>
							<div style="padding: 5%;">
								Save Bill
							</div>
						</button>
					</center>
				</form>
				<br>
			<center>
				<button class="generate-add"><a href="/designer/nonQuotationBill">
						<span class="material-symbols-outlined" style="font-size:32px;">
							close
						</span>
						<div style="padding: 25%;">
							Clear
						</div></a>
					</button>
			</center>
		</div>
	</center>
	<br><br><br>
</body>

<script>
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


<jsp:include page="footerforall.jsp" />
</html>