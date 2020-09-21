<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<style>
.w3-opacity{
	padding-top: 10px;
	padding-bottom: 5px;
	margin-top: 5px;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
	<hr>
	<div class="w3-panel w3-green">
    		<h2 class="w3-opacity">보험계약해지</h2>
 	</div>
 	<hr>
 	
 	<div>
 		<table class="w3-table-all">
 			<tr>
				<th>보험상품명</th>
				<td>${ ipVO.name }</td>
			</tr>
			<tr>
				<th>보장내역</th>
				<td>${ ipVO.guarantee }</td>
			</tr>
			<tr>
				<th>월납부보험료</th>
				<td>${ ipVO.price}</td>
			</tr>
			<tr>
				<th>보험가입일</th>
				<td>${ icVO.join }</td>
			</tr>
			<tr>
				<th>보험만기일</th>
				<td>${ icVO.maturity }</td>
			</tr>
			<tr>
				<th>보험수익자</th>
				<td>${ icVO.beneficiary }</td>
			</tr>
								
		</table>
 	</div>
 	
 	<div>
 		<form action="${ pageContext.request.contextPath }/insuranceContractTermination" method="post"  name="lform">
				<table style="width: 40%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"><div id="checkid"></div></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="hidden" name="ic_serialno" value="${ icVO.no }">
		
 		
 				            
				
				<br>
				<div class="atag">
					<button type="submit" class="w3-button w3-green">보험해지</button> &nbsp;
					<a href="${ pageContext.request.contextPath }/myPage" class="w3-button w3-green">뒤로돌아가기</a>
				</div>
			</form>
 	</div>
 	
 	<!-- 이메일 인증하기 -->
 	<!--  
 	<span>이메일 인증 (이메일을 인증 받아야 다음 단계로 넘어갈 수 있습니다.)</span> <br> <br> 
 	<form action="${ pageContext.request.contextPath }/auth" method="post">
 		<table>
 			<tr>
				<th>이메일</th>
				<td><input type="email" name="e_mail"
                                placeholder="  이메일주소를 입력하세요. ">
			</tr>
 		</table>
 		<button type="submit" name="submit">이메일 인증받기 (이메일 보내기)</button>
 	</form>
     -->   
           

	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>