<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h2>보험 소개 내역입니다</h2>
		<hr>
		<table>
			<tr>
				<th>보험이름</th>
				<td>${ ipVO.name }</td>
			</tr>
			<tr>
				<th>보장내역</th>
				<td>${ ipVO.guarantee }</td>
			</tr>
			<tr>
				<th>납부보험료</th>
				<td>${ ipVO.price }</td>
			</tr>
								
		</table>
		<P>납부보험료는 월 납부 보험료 기준입니다</P>
		<c:if test="${ not empty loginVO }">
			<a href="${pageContext.request.contextPath }" class="button">보험계약</a>
		</c:if>
		
</section>
<footer>
	<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>	
</footer>
</body>
</html>