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
		<hr>
		<h2>상담답변서</h2>
		<hr>
		<form action="${ pageContext.request.contextPath }/replyConsulting/write" method="post">			
			<input type="hidden" name="cs_serialno" value="${ csVO.no }">
			<input type="hidden" name="empno" value="${ csVO.empno }">
			<input type="hidden" name="cusno" value="${ csVO.cusno }">
			<input type="hidden" name="name" value="${ csVO.name }">
			<input type="hidden" name="type" value="${ csVO.type }">
			<table border="1" style="width: 80%">				
				<tr>
					<th width="23%">답변자</th>
					<td>${ employee.name }&nbsp;${ employee.rank }</td>
				</tr>
				<tr>
					<th width="23%">상담유형</th>
					<td>${ csVO.type }</td>
				</tr>
				<tr>
					<th width="23%">질문내용</th>
					<td>${ csVO.content }</td>
				</tr>
				<tr>
					<th>답변내용</th>
					<td>
						<textarea rows="7" cols="60" name="content" style="width: 99%" ></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="등록">
			<a href="${pageContext.request.contextPath }/myConsultingService" class="button">작성취소</a>
		</form>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>