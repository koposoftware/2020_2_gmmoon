<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/hanalife/resources/css/table.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
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


</style>
</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
			<div class="w3-panel w3-green">
    			<h2 class="w3-opacity">고객로그인</h2>
 			</div>
			
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
				<div class="atag">
					<button type="submit" class="w3-button w3-green">고객로그인</button> &nbsp;
					<a href="${ pageContext.request.contextPath }/signUp" class="w3-button w3-green">회원가입</a>
					<a href="${ pageContext.request.contextPath }/employeeLogin" class="w3-button w3-green">사원로그인</a>
				</div>
			</form>
		</div>
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>