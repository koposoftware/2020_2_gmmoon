<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script>
	
</script>
<style>
table, th, td {
	border: 1px solid #D4E0EE;
	border-collapse: collapse;
	font-family: verdana, sans-serif;
	color: #555;
}

th, td {
	padding : 5px;
}

td a:link, td a:visited {
	color: #719ABE;
	text-decoration: none;
}

td a:hover {
	text-decoration: underline;
}

table th {
	background-color: #E6EDF5;
	color: #4F76A3;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
	
		<hr>
		<h2>My profile</h2>
		<hr>
		<table>
			<tr>
				<th>ID</th>
				<td>${ loginVO.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${ loginVO.name }</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td>${ loginVO.hp }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${ loginVO.address }</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${ loginVO.age }</td>
			</tr>
			<tr>
				<th>email</th>
				<td>${ loginVO.email }</td>
			</tr>						
		</table>
		<a href="${pageContext.request.contextPath }" class="button">회원정보수정</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }" class="button">회원탈퇴</a>&nbsp;&nbsp;
		<br>
		<hr>
		<h2>나의 담당사원</h2>
		<hr>
		<br>
		<table>
			<tr>
				<th>이름</th>
				<td>${ employeeVO.name }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${ employeeVO.hp }</td>
			</tr>
			<tr>
				<th>email</th>
				<td>${ employeeVO.email }</td>
			</tr>				
		</table>
		<a href="${pageContext.request.contextPath }/insertConsulting" class="button">상담신청</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/inqueryConsulting/${ loginVO.cusno }" class="button" id="viewBoard">상담내역보기</a>&nbsp;&nbsp;
		
		<div id="consultingBoard">
		
		</div>
		

	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>