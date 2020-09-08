<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
		<br>
	         <div class="w3-panel w3-green">
    			<h2 class="w3-opacity">보험 계약목록</h2>
 			</div>
	         
	         <table class="w3-table-all">
	            <tr>
	               <th width="7%">번호</th>
	               <th width="7%">고객이름</th>	               
	               <th width="7%">담당자이름</th>	               
	               <th width="7%">보험상품코드</th>
	               <th width="10%">가입일</th>
	               <th width="10%">만기일</th>
	               <th width="10%">해지일</th>
	               <th width="10%">보험수익자</th>
	            </tr>
	            <c:forEach items="${ insuranceContractList }" var="list" varStatus="loop">
	               <tr>
	                  <td align="center">${ loop.count }</td>
	                  <td align="center">${ list.name }</td>
	                  <td align="center">${ employee.name }</td>
	                  <td align="center">${ list.code }</td>
	                  <td align="center">
	                  ${ list.join }
	                  </td>
	                  <td align="center">${ list.maturity }</td>
	                  <td align="center">${ list.termination }</td>
	                  <td align="center">${ list.beneficiary }</td>
	               </tr>
	            </c:forEach>
	         </table>
	         <div class="atag">
		         <a href="${pageContext.request.contextPath }" class="w3-button w3-green">홈으로</a>
	         </div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>