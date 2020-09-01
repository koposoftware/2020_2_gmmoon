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
		<h2>상담신청서</h2>
		<hr>
		<form action="${ pageContext.request.contextPath }/insertConsulting" method="post">
			<input type="hidden" name="empno" value="${ loginVO.empno }">
			<input type="hidden" name="cusno" value="${ loginVO.cusno }">
			<input type="hidden" name="name" value="${ loginVO.name }">
			<table border="1" style="width: 80%">				
				<tr>
					<th width="23%">작성자</th>
					<td>${ loginVO.name }</td>
				</tr>
				<tr>
					<th width="23%">상담유형</th>
					<td>
						<select name="type">
							<option value="">상담유형선택</option>
							<option value="보험문의">보험문의</option>
							<option value="보험해지">보험해지</option>
							<option value="보험옵션추가">보험옵션추가</option>
							<option value="방문상담예약">방문상담예약</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>상담내용</th>
					<td>
						<textarea rows="7" cols="60" name="content" style="width: 99%" ></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="등록">
			<a href="${pageContext.request.contextPath }/myPage" class="button">작성취소</a>
		</form>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>