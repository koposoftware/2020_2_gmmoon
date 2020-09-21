<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
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
.city {display:none}

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
	<div align="center" style="border:1px solid black; height: 400px; width: 750px;" id="div1">
		<hr>
		<div class="w3-panel w3-green">
    		<h2 class="w3-opacity">보험 소개 내역</h2>
 		</div>
		<hr>
		<table class="w3-table-all">
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
			<div class="atag">
				<a href="${pageContext.request.contextPath }/insuranceContract/${ ipVO.code}" class="w3-button w3-green">보험계약</a>
			</div>
		</c:if>
	</div>
		
		
</section>
<footer>
	<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>	
</footer>
</body>
</html>