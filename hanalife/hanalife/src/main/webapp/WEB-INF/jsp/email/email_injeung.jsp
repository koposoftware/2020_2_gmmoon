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
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
	<!-- 
		<span style="color: green; font-weight: bold;">입력한 이메일로 받은 인증번호를 입력하세요. (인증번호가 맞아야 다음 단계로 넘어가실 수 있습니다.)</span> <br> <br> 
		<form action="${ pageContext.request.contextPath }/join_injeung/${ dice }" method="post">
 		<table>
 			<tr>
				<th>인증번호입력</th>
				<td><input type="number" name="email_injeung"
                                placeholder="  인증번호를 입력하세요. ">
			</tr>
		
 		</table>
 		<button type="submit" name="submit">인증번호 전송</button>
 	</form>
 	 -->
 	<div align="center" style="border:1px solid black; height: 400px; width: 750px;" id="div1">
 			<hr>
			<div class="w3-container w3-green">
			<h3>입력한 이메일로 받은 인증번호를 입력하세요</h3>
			</div>
			<hr>
			
 			<form action="${ pageContext.request.contextPath }/join_injeung/${ dice }" method="post" class="w3-container">
		 		<p>
				  <label>인증번호입력</label>
				  <input class="w3-input" type="number" name="email_injeung"
                                placeholder="  인증번호를 입력하세요. "></p>
		 		<br>
		 		<button type="submit" name="submit" class="w3-button w3-green">인증번호 전송</button>
		 	</form>
 	</div>
 	
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>