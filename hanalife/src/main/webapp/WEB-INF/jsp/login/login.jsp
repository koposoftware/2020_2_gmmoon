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
		<div align="center" style="border:1px solid black; width: 750px;" id="div1">
			<hr>
			<div class="w3-panel w3-green">
    			<h2 class="w3-opacity">고객로그인</h2>
 			</div>
			<hr>
			<form action="${ pageContext.request.contextPath }/login" method="post" name="lform" class="w3-container">
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
					
				</table>
					
				
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