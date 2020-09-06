<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/hanalife/resources/css/table.css">
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<hr>
		<h2>상담 답글 내역</h2>
		<hr>
		<table>
			<tr>
				<th>상담번호</th>
				<td>${ csrVO.cs_serialno }</td>
			</tr>
			<tr>
				<th>고객이름</th>
				<td>${ csrVO.name }</td>
			</tr>
			<tr>
				<th>상담유형</th>
				<td>${ csrVO.type }</td>
			</tr>
			<tr>
				<th>답변내용</th>
				<td>${ csrVO.content }</td>
			</tr>
			<tr>
				<th>답변날짜</th>
				<td>${ csrVO.date }</td>
			</tr>						
		</table>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>