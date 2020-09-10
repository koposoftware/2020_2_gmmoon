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
	
	$(document).ready(function() {
		
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
				
				
			$('#assignBtn').on('click', function() {
				//alert('클릭');
				
				//배열 초기화
				let checkArr = [];
				
				//선택된 사원의 사원번호값 가져오기
				let checkempno = $('#empno option:selected').attr('value');
				
				//선택된 날짜 값 가져오기
				let today = $('#insertDate').val();
				
				//체크된 값들을 배열에 저장
				$('input[name="performance"]:checked').each(function(i) {
					checkArr.push($(this).val());
				})
				
				//checkArr배열 뒤쪽에 사원번호값 넣기
				checkArr.push(checkempno);
				//checkArr베얄 뒤쪽에 오늘 날짜 넣기
				checkArr.push(today);
				//alert(checkArr);
				
				$.each(checkArr, function(index, item) {
				
					let inputArr = [];
					if(item == "1"){
						//alert("1번값존재");
						inputArr.push("1");
						inputArr.push(checkempno);
						inputArr.push(today);
						
						google.setOnLoadCallback(drawChart5);
						function drawChart5() {
								var jsonData = $.ajax({
								
								url : "${ pageContext.request.contextPath }/lookUpEmployeeManagement",
								type : 'post',
								data : {
									inputArr : inputArr,
								},
								dataType : "json",
								
								async : false
								
								}).responseText;
							var data = new google.visualization.DataTable(jsonData);
							
							// 차트 그리기 (PieChart, LineChart, ColumnChart)
							var chart = new google.visualization.LineChart(document
							
								.getElementById('chart_div4'));
								
								//draw(데이터, 옵션)
								chart.draw(data, {
									width : 400,
									height : 240
							});
					
					 }
						
					}
					
					if(item == "2"){
						//alert("2번값존재");
						inputArr.push("2");
						inputArr.push(checkempno);
						inputArr.push(today);
						
						google.setOnLoadCallback(drawChart6);
						function drawChart6() {
								var jsonData = $.ajax({
								
								url : "${ pageContext.request.contextPath }/lookUpEmployeeManagement",
								type : 'post',
								data : {
									inputArr : inputArr,
								},
								dataType : "json",
								
								async : false
								
								}).responseText;
							var data = new google.visualization.DataTable(jsonData);
							
							// 차트 그리기 (PieChart, LineChart, ColumnChart)
							var chart = new google.visualization.LineChart(document
							
								.getElementById('chart_div5'));
								
								//draw(데이터, 옵션)
								chart.draw(data, {
									width : 400,
									height : 240
							});
					
					 }
						
					}
					
					if(item == "3"){
						//alert("3번값존재");
						inputArr.push("3");
						inputArr.push(checkempno);
						inputArr.push(today);
						
						google.setOnLoadCallback(drawChart7);
						function drawChart7() {
								var jsonData = $.ajax({
								
								url : "${ pageContext.request.contextPath }/lookUpEmployeeManagement",
								type : 'post',
								data : {
									inputArr : inputArr,
								},
								dataType : "json",
								
								async : false
								
								}).responseText;
							var data = new google.visualization.DataTable(jsonData);
							
							// 차트 그리기 (PieChart, LineChart, ColumnChart)
							var chart = new google.visualization.LineChart(document
							
								.getElementById('chart_div6'));
								
								//draw(데이터, 옵션)
								chart.draw(data, {
									width : 400,
									height : 240
							});
					
					 }
						
					}
					
				})

					
				
			})
			
			$('#resetBtn').on('click', function() {
				//alert('리셋버튼입니다')
				
				//reset배열 초기화
				let resetArr = [];
				
				//체크된 값들을 배열에 저장
				$('input[name="performance"]:checked').each(function(i) {
					resetArr.push($(this).val());
				})
				
				$.each(resetArr, function(index, item) {
					if(item == "1"){
						$('#chart_div4').empty();
					}
					if(item == "2"){
						$('#chart_div5').empty();
					}
					if(item == "3"){
						$('#chart_div6').empty();
					}
				})
			
			})
				
	})
	
	
		
		
	 
</script>
<style>
.w3-opacity{
	padding-top: 10px;
	padding-bottom: 5px;
	margin-top: 5px;
	text-align: center;
}

#letfBottom{
	margin-left: 10%;
}

#rightBottom{
	margin-right: 10%;
}
#showBtn{
	margin-top: 5px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
	
	<hr>
	<div class="w3-panel w3-blue">
    		<h2 class="w3-opacity">성과관리 평균그래프</h2>
 	</div>
 	<hr>	
	 <!-- 그래프 구현 부분 -->
	 <div class="w3-display-container " style="height:300px;">
		<div id="chart_div" class="w3-display-left w3-padding">
	 	</div>
		<div id="chart_div2" class="w3-display-middle w3-padding">
	 	</div>
		<div id="chart_div3" class="w3-display-right w3-padding">
	 	</div>
	 	<div class="w3-display-bottomleft w3-right-align" id="letfBottom">
	 		<strong>단기계약지수평균</strong>
	 	</div>
	 	<div class="w3-display-bottommiddle">
	 		<strong>장기계약지수평균</strong>
	 	</div>
	 	<div class="w3-display-bottomright" id="rightBottom">
	 		<strong>중도해지건수평균</strong>
	 	</div>
	 </div>
	 <!--  
	 <button id="btn" type="button" onclick="drawChart2()">단기계약유지율</button>
	 <button id="btn" type="button" onclick="drawChart3()">월초계약집중율</button>
	 <button id="btn" type="button" onclick="drawChart4()">대리점운영지표</button>
	 -->
	</section>
	
	<section>

		<hr>
		<div class="w3-panel w3-blue">
	    		<h2 class="w3-opacity">개별성과관리그래프</h2>
	 	</div>
	 	<hr>
			<table border="1" class="w3-table">
				<tr>
	               <th width="10%">
	               		사원선택
	               </th>
	               <th width="10%">날짜</th>
	               <th width="15%">단기계약유지지수</th>
	               <th width="15%">장기계약유지지수</th>
	               <th width="15%">중도해지건수</th>
	            </tr>
	            <tr>
	            	<td>
	            		<select name="empno" id="empno" required="required">
							<option value="">사원선택</option>
							<c:forEach items="${ employeeList }" var="list" varStatus="loop">
								<option value="${ list.empno }" >${ list.name }&nbsp;${ list.rank }</option>
							</c:forEach>
						</select>
	            	</td>
	            	<td>
	            		<input type="date" name="date" id="insertDate" required="required">
	            	</td>
	            	<td>
	            		<input type="checkbox" name="performance" value="1">
	            	</td>
	            	<td>
	            		<input type="checkbox" name="performance" value="2">
	            	</td>
	            	<td>
	            		<input type="checkbox" name="performance" value="3">
	            	</td>
	            </tr>
			</table>
			<div class="w3-center" id="showBtn">
				<button type="submit" class="w3-button w3-blue" id="assignBtn">개별그래프보기</button>
				<button type="submit" class="w3-button w3-blue" id="resetBtn">그래프초기화</button>
			</div>
	
		
		<div class="w3-display-container " style="height:300px;">
			<div id="chart_div4" class="w3-display-left w3-padding">
		 	</div>
			<div id="chart_div5" class="w3-display-middle w3-padding">
		 	</div>
			<div id="chart_div6" class="w3-display-right w3-padding">
		 	</div>
	 	</div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>