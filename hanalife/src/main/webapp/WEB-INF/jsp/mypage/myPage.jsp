<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script>
	$(document).ready(function() {
		
		$('input[name="checkInsurance"]').on('click', function() {
			//checkbox에서 check된 갯수가 1개면 나머지 버튼은 못쓰게 설정
			if($('input[name="checkInsurance"]:checked').length == 1){
				$(":checkbox:not(:checked)").attr("disabled", "disabled");
				
				//보험계약해지진행
				$('#terminationBtn').on('click',function() {
					
					if(!confirm('보험계약해지를 진행하시겠습니까?')) return;
					
					let check = $('input[name="checkInsurance"]:checked').attr('value');
					//alert(check);
					
					// url초기화
					let url = '';
					// checkbox 선택안한채 check를 넘기면 데이터타입이 undefined
					if(typeof check == "undefined"){
						alert("해지할 보험계약을 선택해주세요");
						url = "${pageContext.request.contextPath }/myPage"
					} else {
						
						url = "${pageContext.request.contextPath }/auth/" + check
					}
					
					$(location).attr('href', url);
				})
			//length가 다시 0으로 돌아왔을 때, disabled를 없앤다	
			} else {
				$('input[name="checkInsurance"]:checkbox').removeAttr("disabled");
			}
			
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

</style>

</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
	<div align="center" style="border:1px solid black; height: 850px; width: 90%;" id="div1">
		<hr>
		<div class="w3-panel w3-green">
    		<h2 class="w3-opacity">My Profile</h2>
 		</div>
 		<hr>
		<table class="w3-table-all w3-centered">
			<tr>
				<th>ID</th>
				<td>${ loginVO.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${ loginVO.name }</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td>${ loginVO.hp }</td>
			</tr>
			<tr>
				<th>도로명번호</th>
				<td>${ loginVO.post }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${ loginVO.addr }</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${ loginVO.age }</td>
			</tr>
			<tr>
				<th>email</th>
				<td>${ loginVO.email }</td>
			</tr>						
		</table>
		<div class="atag">
			<a href="${pageContext.request.contextPath }/modifyInfo" class="w3-button w3-green">회원정보수정</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/withdrawalCustomer" class="w3-button w3-green">회원탈퇴</a>&nbsp;&nbsp;
		</div>
		<hr>
		<div class="w3-panel w3-green">
    		<h2 class="w3-opacity">나의 담당사원</h2>
 		</div>
		<hr>
		<table class="w3-table-all w3-centered">
			<tr>
				<th>이름</th>
				<td>${ employeeVO.name }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${ employeeVO.hp }</td>
			</tr>
			<tr>
				<th>email</th>
				<td>${ employeeVO.email }</td>
			</tr>				
		</table>
		<div class="atag">
			<a href="${pageContext.request.contextPath }/inqueryConsulting/${ loginVO.cusno }" class="w3-button w3-green" id="viewBoard">상담내역보기</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/insertConsulting" class="w3-button w3-green">상담신청</a>&nbsp;&nbsp;
		</div>
		<div id="consultingBoard">
		
		</div>
		
	</div>
	</section>
	<section>
		<div  align="center" style="border:1px solid black; width: 90%;" id="div2">
			<hr>
			<div class="w3-panel w3-green">
    			<h2 class="w3-opacity">보험 계약목록</h2>
 			</div>
 			<hr>
	         
	         <table class="w3-table-all">
	            <tr>	            
	               <th width="7%">선택</th>
	               <th width="7%">번호</th>
	               <th width="7%">고객이름</th>	               
	               <th width="7%">담당자이름</th>	               
	               <th width="7%">보험상품코드</th>
	               <th width="10%">가입일</th>
	               <th width="10%">만기일</th>
	               <th width="10%">해지일</th>
	               <th width="10%">보험수익자</th>
	            </tr>
	            <c:forEach items="${ insuranceContractList }" var="list" varStatus="loop">
	               <tr>
	               	  <td align="center">
	               	  	<input type="checkbox" name="checkInsurance" value="${ list.no }">
	               	  </td>
	                  <td align="center">${ loop.count }</td>
	                  <td align="center">${ list.name }</td>
	                  <td align="center">${ list.ename }</td>
	                  <td align="center">${ list.code }</td>
	                  <td align="center">
	                  ${ list.join }
	                  </td>
	                  <td align="center">${ list.maturity }</td>
	                  <td align="center">${ list.termination }</td>
	                  <td align="center">${ list.beneficiary }</td>
	               </tr>
	            </c:forEach>
	         </table>
	         <div class="atag">
	         	 <button type="submit" class="w3-button w3-green" id="terminationBtn">보험해지진행</button>
		         <a href="${pageContext.request.contextPath }" class="w3-button w3-green">홈으로</a>
	         </div>
	      </div> 
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>