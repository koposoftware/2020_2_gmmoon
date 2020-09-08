<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/hanalife/resources/css/table.css">
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
    			<h2 class="w3-opacity">성과관리</h2>
 			</div>
	         
	         <table class="w3-table-all">
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
	         <div class="atag">
		         <a href="${pageContext.request.contextPath }" class="w3-button w3-green">홈으로</a>
	         </div>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>