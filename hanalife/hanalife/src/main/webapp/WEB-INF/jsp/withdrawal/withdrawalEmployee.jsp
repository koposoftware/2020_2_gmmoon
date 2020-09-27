<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		
		<form action="${ pageContext.request.contextPath }/withdrawalEmployee" method="post"  name="lform"  class="w3-container">
				<p>
				  <label>ID</label>
				  <input type="text" name="id"  required="required" class="w3-input">
				</p>
		 		 <!-- <p  id="msgView"></p> -->
		 		
		 		<p>
				  <label>PASSWORD</label>
				  <input type="text" name="password"  id="input_pw" required="required" class="w3-input">
				</p>
				
				<p>
				  <label>사원번호</label>
				  <input type="text" name="empno"  required="required" class="w3-input">
				</p>
				<button type="submit">회원탈퇴</button> &nbsp;
		</form>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>		
	</footer>
</body>
</html>