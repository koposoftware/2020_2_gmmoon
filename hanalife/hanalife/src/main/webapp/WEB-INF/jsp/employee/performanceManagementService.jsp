<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	         <h2>성과관리</h2>
	         <hr width="100%">
	         <br>
	         
	         <table border="1" style="width: 100%">
	            <tr>
	               <th width="7%">번호</th>
	               <th width="7%">사원이름</th>	               
	               <th width="7%">날짜</th>	               
	               <th width="15%">계약관리</th>
	               <th width="15%">계약모집</th>
	               <th width="15%">대리점운영</th>
	            </tr>
	            <c:forEach items="${ performanceManagementList }" var="list" varStatus="loop">
	               <tr>
	                  <td align="center">${ loop.count }</td>
	                  <td align="center">${ employee.name }</td>
	                  <td align="center">${ list.date }</td>
	                  <td align="center">단기 계약 유지율 : ${ list.contractManagement }</td>
	                  <td align="center">월초 계약 집중율 : ${ list.contractRecruiting}</td>
	                  <td align="center">보험설계사수 변동성 : ${ list.agencyManagement}</td>
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