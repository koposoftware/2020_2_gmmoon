<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#div1 {
	margin-top:15px;
	margin-left: 25%;
	margin-bottom: 15px;
}
table {
	margin-top: 60px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		
	</section>
	
	<section>
		<div align="center" style="border:1px solid black; height: 300px; width: 750px;" id="div1">
 		<form action="${ pageContext.request.contextPath }/insuranceContractForm" method="post"  name="lform">
			<table style="width: 40%">
				<tr>
					<th>보험가입일</th>
					<td><input type="date" name="join" class="w3-input"></td>
				</tr>
				<tr>
					<th>보험수익자</th>
					<td><input type="text" name="beneficiary" class="w3-input"></td>
				</tr>
			</table>
			<input type="hidden" name="code" value="${ code }">
			<input type="hidden" name="empno" value="${ loginVO.empno }">
			<input type="hidden" name="cusno" value="${ loginVO.cusno }">
			<input type="hidden" name="name" value="${ loginVO.name }">
			<br>
			<div class="atag">
				<button type="submit" class="w3-button w3-green">보험계약</button> &nbsp;
				<a href="${ pageContext.request.contextPath }/myPage" class="w3-button w3-green">뒤로돌아가기</a>
			</div>
		</form>
 	</div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>