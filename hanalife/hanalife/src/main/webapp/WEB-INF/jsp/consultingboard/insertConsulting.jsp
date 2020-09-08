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
	padding-right: 300px;	
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
    			<h2 class="w3-opacity">상담신청서</h2>
 		</div>
 		<div id="formDiv">
			<form action="${ pageContext.request.contextPath }/insertConsulting" method="post">
				<input type="hidden" name="empno" value="${ loginVO.empno }">
				<input type="hidden" name="cusno" value="${ loginVO.cusno }">
				<input type="hidden" name="name" value="${ loginVO.name }">
				<table border="1" style="width: 80%" class="w3-table-all">				
					<tr>
						<th width="23%" class="w3-center">작성자</th>
						<td>${ loginVO.name }</td>
					</tr>
					<tr>
						<th width="23%" class="w3-center">상담유형</th>
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
						<th class="w3-center">상담내용</th>
						<td>
							<textarea rows="7" cols="60" name="content" style="width: 99%" ></textarea>
						</td>
					</tr>
				</table>
				<div class="atag">
					<button type="submit" class="w3-button w3-green">등록</button>
					<a href="${pageContext.request.contextPath }/myPage" class="w3-button w3-green">작성취소</a>
				</div>
			</form>
 		</div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>