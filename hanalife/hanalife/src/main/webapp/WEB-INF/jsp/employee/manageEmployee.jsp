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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	$(document).ready(function() {
		$('#assignBtn').click(function() {
			
			if(!confirm('사원을 배정하시겠습니까?')) return;
			
			//배열 초기화
			let checkArr = [];
			
			//선택된 사원의 사원번호값 가져오기
			let checkempno = $('#type option:selected').attr('value');
			
			//체크된 값들을 배열에 저장
			$('input[name="customer"]:checked').each(function(i) {
				checkArr.push($(this).val());
			})
			
			console.log(checkArr); 
			console.log(checkempno);
			
			//checkArr배열 맨 뒤에 사원번호값 넣기
			checkArr.push(checkempno);
			console.log(checkArr);
			
			$.ajax({
				url : '${ pageContext.request.contextPath }/assignCustomer',
				type : 'post',
				data : {
					customerArr : checkArr,
				},
				success : function(data) {
					if(data == 1)
					alert('성공입니다')
					
					let checkRows = $("[name='customer']:checked");
					
					for(let i = checkRows.length-1;i>-1;i--){
						checkRows.eq(i).closest('tr').remove();
					}
					
					
					if(data == 0)
					alert('프로세스 중 이상 발견')
				},
				error : function(data) {
					alert('실패')
				}
			})
			
		})
	
	})
	
	
	$(document).ready(function() {
		$("#modal, .close").on('click',function(){
			  $("#modal").fadeOut(300);
			  $(".modal-con").fadeOut(300);
		});
		
		
	})
	
	function openModal(modalname){
			  document.get
			  $("#modal").fadeIn(300);
			  $("."+modalname).fadeIn(300);
			
	}

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
				
				url : "${ pageContext.request.contextPath }/employeeCustomer",
				
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
	
    
 

	
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<br>
		<hr>
		<h2>사원목록</h2>
		<hr>
		<br>
		
			<table border="1" style="width: 100%">
	            <tr>
	               <th width="7%">선택</th>
	               <th width="7%">번호</th>
	               <th width="7%">사원번호</th>
	               <th width="15%">사원이름</th>
	               <th width="15%">사원직책</th>
	               <th width="10%">사원나이</th>
	               <th >사원전화번호</th>
	               <th >사원email</th>
	            </tr>
	            <c:forEach items="${ employeeList }" var="list" varStatus="loop">
	               <tr>
	                  <td align="center"><input type="checkbox" value="${ list.empno }"></td>
	                  <td align="center">${ loop.count }</td>
	                  <td align="center">${ list.empno }</td>
	                  <td align="center">${ list.name }</td>
	                  <td align="center">${ list.rank }</td>
	                  <td align="center">${ list.age }</td>
	                  <td align="center">${ list.hp }</td>
	                  <td align="center">${ list.email }</td>
	               </tr>
	            </c:forEach>
	         </table>
	         
  
  <!-- 그래프 구현 부분 -->
	<div id="chart_div">
 
 	</div>
	

		         
	</section>
	<section>
				<br>
				<hr>
				<h2>배정미정고객</h2>
				<hr>
				<br>
		
			<table border="1" style="width: 100%">
	            <tr>
	               <th width="7%">선택</th>
	               <th width="7%">번호</th>
	               <th width="15%">고객이름</th>
	               <th width="25%">고객전화번호</th>
	               <th width="10%">고객나이</th>
	               <th>고객email</th>
	            </tr>
	            <c:forEach items="${ customerList }" var="list" varStatus="loop">
	               <tr>
	               	  <td align="center"><input type="checkbox" value="${ list.cusno }" name="customer"></td>
	                  <td align="center">${ loop.count }</td>
	                  <td align="center">${ list.name }</td>
	                  <td align="center">${ list.hp }</td>
	                  <td align="center">${ list.age }</td>
	                  <td align="center">${ list.email }</td>
	               </tr>
	            </c:forEach>
	         </table>
	         
	         <select id="type">
				<option value="">사원선택</option>
				<c:forEach items="${ employeeList }" var="list" varStatus="loop">
					<option value="${ list.empno }" >${ list.name }&nbsp;${ list.rank }</option>
				</c:forEach>
			</select>
						
	         <button id="assignBtn">사원배정</button>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>