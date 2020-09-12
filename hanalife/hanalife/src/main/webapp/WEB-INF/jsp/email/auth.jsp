<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#div1 {
	margin-top:15px;
	margin-left: 30%;
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>

	<section>
	<!-- 이메일 인증하기 -->
	<!--  
 	<span>이메일 인증 (이메일을 인증 받아야 다음 단계로 넘어갈 수 있습니다.)</span> <br> <br> 
 	<form action="${ pageContext.request.contextPath }/auth/${ check }" method="post">
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
 	<div align="center" style="border:1px solid black; height: 400px; width: 600px;" id="div1">
			<hr>
			<div class="w3-container w3-green">
			<h3>이메일 인증 (이메일을 인증 받아야 다음 단계로 진행 가능 합니다)</h3>
			</div>
			<hr> 
		 	<form action="${ pageContext.request.contextPath }/auth/${ check }" method="post" class="w3-container">
		 		<p>
				  <label>Email</label>
				  <input class="w3-input" type="email" name="e_mail" placeholder="  이메일주소를 입력하세요. "></p>
		 		<br>
		 		<button type="submit" name="submit" class="w3-button w3-green">이메일 인증받기 (이메일 보내기)</button>
		 	</form>
		</div>
 	
 	
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>