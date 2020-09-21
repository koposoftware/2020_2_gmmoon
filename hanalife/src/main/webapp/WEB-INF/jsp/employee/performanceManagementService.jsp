<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/hanalife/resources/css/table.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	$(document).ready(function() {
		

		//each를 통한 단기계약지수반복문
		$('.shortcontract').each(function(index, item) {
			
			let shortcontract = '';
			let num1 = '';
			shortcontract = $(item).text();
			num1 = parseInt(shortcontract, 10);
			
			if(num1 >= 84){
				$(item).css('color','blue');
			}
			
			if(num1 <= 79){
				$(item).css('color','red');
			}
		})
		
		//each를 통한 장기계약지수반복문
		$('.longcontract').each(function(index, item) {
			
			let longcontract = '';
			let num2 = '';
			longcontract = $(item).text();
			num2 = parseInt(longcontract, 10);
			
			if(num2 >= 88){
				$(item).css('color','blue');
			}
			
			if(num2 <= 84){
				$(item).css('color','red');
			}
		})
		
		//each를 통한 중도해지건수반복문
		$('.termination').each(function(index, item) {
			
			let termination = '';
			let num3 = '';
			termination = $(item).text();
			num3 = parseInt(termination, 10);
			
			//console.log(num3);
			//console.log(typeof num3);
			if(num3 > 10){
				$(item).css('color','red');
			}
		})
		
		//그래프
		google.load('visualization', '1', {
			
			'packages' : [ 'corechart' ]
		
				});
		
		$('#assignBtn').on('click', function() {
			//alert('클릭');
			
			//배열 초기화
			let checkArr = [];
			
			//선택된 사원의 사원번호값 가져오기
			let checkempno = $('#empno').attr('value');
			
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
					
					google.setOnLoadCallback(drawChart1);
					function drawChart1() {
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
						
							.getElementById('chart_div1'));
							
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
					
					google.setOnLoadCallback(drawChart2);
					function drawChart2() {
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
						
							.getElementById('chart_div2'));
							
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
					
					google.setOnLoadCallback(drawChart3);
					function drawChart3() {
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
						
							.getElementById('chart_div3'));
							
							//draw(데이터, 옵션)
							chart.draw(data, {
								width : 400,
								height : 240
						});
				
				 }
					
				}
				
			})

				
			
		})
		
		//그래프 리셋버튼
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
						$('#chart_div1').empty();
					}
					if(item == "2"){
						$('#chart_div2').empty();
					}
					if(item == "3"){
						$('#chart_div3').empty();
					}
				})
			
			})
		
		
	})
</script>
<style>
.atag {
	text-align: center;
	margin-top: 1%;
	margin-bottom: 1%;
		
}


.w3-opacity{
	padding-top: 10px;
	padding-bottom: 5px;
	margin-top: 5px;
	text-align: center;
}

#formDiv {
	margin: 0 auto;
	width: 100%;
	margin-left: 10%;
}
#div1 {
	margin-top:15px;
	margin-left: 5%;
	margin-bottom: 15px;
}
#div2 {
	margin-top:15px;
	margin-left: 5%;
	margin-bottom: 15px;
}
#div3 {
	margin-top:15px;
	margin-left: 5%;
	margin-bottom: 15px;
}


</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<div align="center" style="border:1px solid black; width: 90%;" id="div1">
			<hr>
	        <div class="w3-panel w3-green">
    			<h2 class="w3-opacity">성과관리</h2>
 			</div>
	        <hr>
	         <table class="w3-table-all">
	            <tr>
	               <th width="7%" >번호</th>
	               <th width="7%" >날짜</th>	               	               
	               <th width="15%" >단기계약지수</th>
	               <th width="15%" >장기계약지수</th>
	               <th width="15%" >중도해지건수</th>
	            </tr>
	            <c:forEach items="${ performanceManagementList }" var="list" varStatus="loop">
	               <tr>
	                  <td class="count">${ loop.count }</td>
	                  <td >${ list.date }</td>
	                  <td class="shortcontract">${ list.shortContract }</td>
	                  <td class="longcontract">${ list.longContract}</td>
	                  <td class="termination">${ list.numberOfTermination}</td>
	               </tr>
	            </c:forEach>
	         </table>
	         <div class="atag">
		         <a href="${pageContext.request.contextPath }" class="w3-button w3-green">홈으로</a>
	         </div>
	      </div>
	</section>

	<section>
		<div align="center" style="border:1px solid black; width: 90%;" id="div2">
			<table border="1" class="w3-table">
				<tr>
	               <th width="10%">날짜</th>
	               <th width="15%">단기계약유지지수</th>
	               <th width="15%">장기계약유지지수</th>
	               <th width="15%">중도해지건수</th>
	            </tr>
				<tr>
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
				<input type="hidden" id="empno" value="${ employee.empno }">
				<button type="submit" class="w3-button w3-blue" id="assignBtn">개별그래프보기</button>
				<button type="submit" class="w3-button w3-blue" id="resetBtn">그래프초기화</button>
		</div>
		
		 <div class="w3-display-container " style="height:300px; width:90%; border:1px solid black;" id="div3">
		 	<div id="chart_div1" class="w3-display-left w3-padding">
	 		</div>
	 		<div id="chart_div2" class="w3-display-middle w3-padding">
		 	</div>
			<div id="chart_div3" class="w3-display-right w3-padding">
		 	</div>
		 </div>
	</section>

	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>