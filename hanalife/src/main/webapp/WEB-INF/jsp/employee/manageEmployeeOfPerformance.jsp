<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	google.load('visualization', '1', {
	
		'packages' : [ 'corechart' ]
	
			});
	
			google.setOnLoadCallback(drawChart2);
	 // 차트 그리기 함수
		function drawChart2() {
			//json 데이터 받아로기
			// dataType : "json" 결과값이 json 형식
			// async :false  비동기식 옵션을 끔(동기식)
			// ajax 는 비동기식이다. 즉 기본값이 비동기식 true 이다
			// 즉 차트가 그려지기 전에는 다른 작업은 하지 못한다.
			//responseText  : 서버의 응답 텍스트
				var jsonData = $.ajax({
				
				url : "${ pageContext.request.contextPath }/employeePerformance",
				
				dataType : "json",
				
				async : false
				
				}).responseText;
			//alert(jsonData);
			//json 데이터를 데이터 테이블로 변환
			var data = new google.visualization.DataTable(jsonData);
			
			// 차트 그리기 (PieChart, LineChart, ColumnChart)
			var chart = new google.visualization.ColumnChart(document
			
				.getElementById('chart_div'));
				
				//draw(데이터, 옵션)
				chart.draw(data, {
					width : 400,
					height : 240
			});
	
	 }
	 
	 
		google.setOnLoadCallback(drawChart3);
		 // 차트 그리기 함수
			function drawChart3() {
				//json 데이터 받아로기
				// dataType : "json" 결과값이 json 형식
				// async :false  비동기식 옵션을 끔(동기식)
				// ajax 는 비동기식이다. 즉 기본값이 비동기식 true 이다
				// 즉 차트가 그려지기 전에는 다른 작업은 하지 못한다.
				//responseText  : 서버의 응답 텍스트
					var jsonData = $.ajax({
					
					url : "${ pageContext.request.contextPath }/employeePerformance2",
					
					dataType : "json",
					
					async : false
					
					}).responseText;
				//alert(jsonData);
				//json 데이터를 데이터 테이블로 변환
				var data = new google.visualization.DataTable(jsonData);
				
				// 차트 그리기 (PieChart, LineChart, ColumnChart)
				var chart = new google.visualization.ColumnChart(document
				
					.getElementById('chart_div2'));
					
					//draw(데이터, 옵션)
					chart.draw(data, {
						width : 400,
						height : 240
				});
		
		 }
		 
			google.setOnLoadCallback(drawChart4);
				function drawChart4() {
						var jsonData = $.ajax({
						
						url : "${ pageContext.request.contextPath }/employeePerformance3",
						
						dataType : "json",
						
						async : false
						
						}).responseText;
					var data = new google.visualization.DataTable(jsonData);
					
					// 차트 그리기 (PieChart, LineChart, ColumnChart)
					var chart = new google.visualization.ColumnChart(document
					
						.getElementById('chart_div3'));
						
						//draw(데이터, 옵션)
						chart.draw(data, {
							width : 400,
							height : 240
					});
			
			 }
				
		$(document).ready(function() {
			let checkempno = $('#type option:selected').attr('value');
		})
	 
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
	<hr>
	<h2>성과관리 그래프</h2>
	<hr>	
	 <!-- 그래프 구현 부분 -->
	 <div class="w3-display-container " style="height:300px;">
		<div id="chart_div" class="w3-display-left w3-padding">
	 	</div>
		<div id="chart_div2" class="w3-display-middle w3-padding">
	 	</div>
		<div id="chart_div3" class="w3-display-right w3-padding">
	 	</div>
	 </div>
	 <button id="btn" type="button" onclick="drawChart2()">단기계약유지율</button>
	 <button id="btn" type="button" onclick="drawChart3()">월초계약집중율</button>
	 <button id="btn" type="button" onclick="drawChart4()">대리점운영지표</button>
		
	</section>
	
	<section>
		<hr>
		<h2>${ MM }월 성과관리입력</h2>
		<hr>
		<form action="${ pageContext.request.contextPath }/insertPerformanceManagement" method="post"  name="lform">
			<table border="1" class="w3-table">
				<tr>
	               <th width="10%">
	               		사원선택
	               </th>
	               <th width="10%">날짜</th>
	               <th width="15%">단기계약유지율</th>
	               <th width="15%">월초계약집중율</th>
	               <th width="10%">대리점운영지표</th>
	            </tr>
	            <tr>
	            	<td>
	            		<select name="empno">
							<option value="">사원선택</option>
							<c:forEach items="${ employeeList }" var="list" varStatus="loop">
								<option value="${ list.empno }" >${ list.name }&nbsp;${ list.rank }</option>
							</c:forEach>
						</select>
	            	</td>
	            	<td>
	            		<input type="date" name="date">
	            	</td>
	            	<td>
	            		<input type="text" name="contractManagement">
	            	</td>
	            	<td>
	            		<input type="text" name="contractRecruiting">
	            	</td>
	            	<td>
	            		<input type="text" name="agencyManagement">
	            	</td>
	            </tr>
			</table>
			<button type="submit" class="w3-button w3-green">성과관리입력</button>
		</form>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>