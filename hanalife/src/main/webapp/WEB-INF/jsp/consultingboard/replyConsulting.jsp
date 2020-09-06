<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<div class="w3-panel w3-green">
    		<h2 class="w3-opacity">상담답변서</h2>
 		</div>
		<form action="${ pageContext.request.contextPath }/replyConsulting/write" method="post">			
			<input type="hidden" name="cs_serialno" value="${ csVO.no }">
			<input type="hidden" name="empno" value="${ csVO.empno }">
			<input type="hidden" name="cusno" value="${ csVO.cusno }">
			<input type="hidden" name="name" value="${ csVO.name }">
			<input type="hidden" name="type" value="${ csVO.type }">
			<table class="w3-table-all w3-centered">				
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
			<div class="atag">
				<button type="submit" class="w3-button w3-green">등록</button>
				<a href="${pageContext.request.contextPath }/myConsultingService" class="w3-button w3-green">작성취소</a>
			</div>
		</form>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>