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
.w3-opacity{
	padding-top: 10px;
	padding-bottom: 5px;
	margin-top: 5px;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
	<div align="center" style="border:1px solid black; height: 300px; width: 750px;" id="div1">
			<hr>
				<div class="w3-panel w3-green">
	    		<h2 class="w3-opacity">상담 답글 내역</h2>
	 			</div>
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
		</div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>