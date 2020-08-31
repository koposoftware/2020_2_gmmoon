<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
			<br>
			<hr>
			<h2>고객로그인</h2>
			<hr>
			<br>
			
			<form action="${ pageContext.request.contextPath }/login" method="post" onsubmit="return checkForm()" name="lform">
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
				<br>
				<button type="submit">고객로그인</button> &nbsp;
				<a href="${ pageContext.request.contextPath }/signUp" class="button">회원가입</a>
				<a href="${ pageContext.request.contextPath }/employeeLogin" class="button">사원로그인</a>
			</form>
		</div>
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>