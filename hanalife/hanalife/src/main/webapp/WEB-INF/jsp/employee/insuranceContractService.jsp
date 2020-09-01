<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
		<br>
	         <hr width="100%">
	         <h2>보험계약목록</h2>
	         <hr width="100%">
	         <br>
	         
	         <table border="1" style="width: 100%">
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
	         <a href="${pageContext.request.contextPath }" class="button">홈으로</a>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>