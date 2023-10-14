<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback | Individual</title>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/individualFeedback.css">
<jsp:include page="navbarforadmin.jsp" />
<nav style="margin-top: 0.5%;">
        <ul class="navbar">
          <li class="dropdown">
              <a href="/designer/feedbackdasboard">Feedback Dashboard</a>
          </li>
          <li class="dropdown">
              <a href="/designer/individualfeedback">Individual Feedback</a>
          </li>
        </ul>
    </nav>
</head>
<body>
	<br></br>
	<h2 align="center">Individual Feedback</h2>
	<br></br>
	<div class="details">
		<table id="feedbackTable" border="1">
			<thead>
				<tr>
					<th>Quality of Work</th>
					<th>Colour Precesion</th>
					<th>Available and Implemented Designs</th>
					<th>Changes that were communicated</th>
					<th>Company Communication</th>
					<th>Project Timeline</th>
					<th>Comments</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerFeedbackList}" var="feedback">
					<tr>
						<td>${feedback.quality}</td>
						<td>${feedback.colourPrecesion}</td>
						<td>${feedback.designRating}</td>
						<td>${feedback.changesRating}</td>
						<td>${feedback.communication}</td>
						<td>${feedback.timeLine}</td>
						<td>
							<c:if test="${feedback.comments.length() == 0}">No Comments</c:if>
							<c:if test="${feedback.comments.length() != 0}">${feedback.comments}</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br></br><br></br>
	
	<script type="text/javascript">
		new DataTable("#feedbackTable");
	</script>
</body>
<jsp:include page="footerforall.jsp" />
</html>