<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback | Dashboard</title>
<script src="/js/piecharts.js"></script>
<link rel="stylesheet" href="/css/feedbackDashboard.css">
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
<body style="background: white">
	<br></br>
	<h2 align="center">Feedback Dashboard</h2>
	<br></br>
	<div class="display">
		<div id="QualityPieChart"></div>
		<div id="ColourPrecesionPieChart"></div>
		<div id="DesignPieChart"></div>
		<div id="CommunicationPieChart"></div>
		<div id="ChangesPieChart"></div>
		<div id="TimeLinePieChart"></div>
	</div>
	<br/><br/>
	
	<script type="text/javascript">
		// Load google charts
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawChart);
		
		// Draw the chart and set the chart values
		function drawChart() {
		  var dataQualityRating = google.visualization.arrayToDataTable([
		  ['Component', 'Rating'],
		  ['Rated 1', ${qualityRating1}],
		  ['Rated 2', ${qualityRating2}],
		  ['Rated 3', ${qualityRating3}],
		  ['Rated 4', ${qualityRating4}],
		  ['Rated 5', ${qualityRating5}]
		]);
		
		  // Optional; add a title and set the width and height of the chart
		  var optionsQualityRating = {'title':'Quality', 'width':550, 'height':400};
		
		  // Display the chart inside the <div> element with id="piechart"
		  var colourPresicionChart = new google.visualization.PieChart(document.getElementById('QualityPieChart'));
		  colourPresicionChart.draw(dataQualityRating, optionsQualityRating);
		}
	</script>
	
	
	<script type="text/javascript">
	// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	// Draw the chart and set the chart values
	function drawChart() {
	  var dataColourPresionRating = google.visualization.arrayToDataTable([
	  ['Component', 'Rating'],
	  ['Rated 1', ${colourPrecesionRating1}],
	  ['Rated 2', ${colourPrecesionRating2}],
	  ['Rated 3', ${colourPrecesionRating3}],
	  ['Rated 4', ${colourPrecesionRating4}],
	  ['Rated 5', ${colourPrecesionRating5}]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var optionsColourPresisionRating = {'title':'Colour Presicion', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var qualityChart = new google.visualization.PieChart(document.getElementById('ColourPrecesionPieChart'));
	  qualityChart.draw(dataColourPresionRating, optionsColourPresisionRating);
	}
	</script>
	
	<script type="text/javascript">
	// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	// Draw the chart and set the chart values
	function drawChart() {
	  var dataDesignRating = google.visualization.arrayToDataTable([
	  ['Component', 'Rating'],
	  ['Rated 1', ${designRating1}],
	  ['Rated 2', ${designRating2}],
	  ['Rated 3', ${designRating3}],
	  ['Rated 4', ${designRating4}],
	  ['Rated 5', ${designRating5}]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var optionsDesignRating = {'title':'Designs', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var designRatingChart = new google.visualization.PieChart(document.getElementById('DesignPieChart'));
	  designRatingChart.draw(dataDesignRating, optionsDesignRating);
	}
	</script>
	
	<script type="text/javascript">
	// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	// Draw the chart and set the chart values
	function drawChart() {
	  var dataCommunicationRating = google.visualization.arrayToDataTable([
	  ['Component', 'Rating'],
	  ['Rated 1', ${communicationRating1}],
	  ['Rated 2', ${communicationRating2}],
	  ['Rated 3', ${communicationRating3}],
	  ['Rated 4', ${communicationRating4}],
	  ['Rated 5', ${communicationRating5}]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var optionsCommunicationRating = {'title':'Communication', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var communicationRatingChart = new google.visualization.PieChart(document.getElementById('CommunicationPieChart'));
	  communicationRatingChart.draw(dataCommunicationRating, optionsCommunicationRating);
	}
	</script>
	
	<script type="text/javascript">
	// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	// Draw the chart and set the chart values
	function drawChart() {
	  var dataChangesRating = google.visualization.arrayToDataTable([
	  ['Component', 'Rating'],
	  ['Rated 1', ${changesRating1}],
	  ['Rated 2', ${changesRating2}],
	  ['Rated 3', ${changesRating3}],
	  ['Rated 4', ${changesRating4}],
	  ['Rated 5', ${changesRating5}]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var optionsChangesRating = {'title':'Changes Done', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var changesRatingChart = new google.visualization.PieChart(document.getElementById('ChangesPieChart'));
	  changesRatingChart.draw(dataChangesRating, optionsChangesRating);
	}
	</script>
	
	<script type="text/javascript">
	// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	// Draw the chart and set the chart values
	function drawChart() {
	  var dataTimelineRating = google.visualization.arrayToDataTable([
	  ['Component', 'Rating'],
	  ['Everything was completed with in the promised date', ${timeLine1}],
	  ['Almost work is completed within the promised date with minor works to be done', ${timeLine2}],
	  ['Only some part of the work was completed and remaining need to be completed even after promised date', ${timeLine3}],
	  ['Work was stopped in between', ${timeLine4}]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var optionsTimeLine = {'title':'Project Timeline', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var timeLineChart = new google.visualization.PieChart(document.getElementById('TimeLinePieChart'));
	  timeLineChart.draw(dataTimelineRating, optionsTimeLine);
	}
	</script>
	
		
	<br/><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>