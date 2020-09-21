<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#div1 {
	margin-top:15px;
	margin-left: 25%;
	margin-bottom: 15px;
}
.atag {
	text-align: center;
	margin-top: 1%;
	margin-bottom: 1%;
		
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<div align="center" style="border:1px solid black; width: 750px;" id="div1">
			<hr>
			<div class="w3-panel w3-blue">
    			<h2 class="w3-opacity">사원로그인</h2>
 			</div>
			<hr>
			<form action="${ pageContext.request.contextPath }/employeeLogin" method="post" name="lform">
				<table style="width: 40%">
					<tr>
						<td>
							<p>
					  		<label>ID</label>
					  		<input type="text" name="id" class="w3-input">
							</p>
						</td>					
					</tr>
					<tr>
						<td>
						<p>
					  		<label>PASSWORD</label>
					  		<input type="password" name="password" class="w3-input">
							</p>
						</td>
					</tr>
					<tr>						
						<td>
						<p>
					  		<label>사원번호</label>
					  		<input type="text" name="empno" class="w3-input">
						</p>
						</td>
					</tr>
				</table>
				<br>
				<div class="atag">
					<button type="submit">사원로그인</button> &nbsp;
					<a href="${ pageContext.request.contextPath }/employeeSignUp" class="button">사원회원가입</a>
				</div>
			</form>
		</div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>