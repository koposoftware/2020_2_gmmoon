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
		<div align="center">
			<br>
			<hr>
			<h2>회원탈퇴</h2>
			<hr>
			<br>
			
			<form action="${ pageContext.request.contextPath }/withdrawalCustomer" method="post"  name="lform">
				<table style="width: 40%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<br>
				<button type="submit" class="w3-button w3-blue">회원탈퇴</button> &nbsp;
				<a href="${ pageContext.request.contextPath }" class="button">홈으로</a>
			</form>
		</div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>		
	</footer>
</body>
</html>