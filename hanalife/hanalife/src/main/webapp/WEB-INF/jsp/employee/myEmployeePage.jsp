<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

#div1 {
	margin-top:15px;
	margin-left: 5%;
	margin-bottom: 15px;
}
#div2 {
	margin-top:15px;
	margin-left: 5%;
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
	
	</section>
	<div align="center" style="border:1px solid black; height: 350px; width: 90%;" id="div1">
		<div class="w3-panel w3-green">
    		<h2 class="w3-opacity">My Profile</h2>
 		</div>
	
			<table class="w3-table-all w3-centered" >
				<tr>
					<th>ID</th>
					<td>${ employee.id }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${ employee.name }</td>
				</tr>
				<tr>
					<th>직급</th>
					<td>${ employee.rank }</td>
				</tr>
				<tr>
					<th>휴대폰번호</th>
					<td>${ employee.hp }</td>
				</tr>
				<tr>
					<th>email</th>
					<td>${ employee.email }</td>
				</tr>						
			</table>
		
		<div class="atag">
			<a href="${pageContext.request.contextPath }" class="w3-button w3-green">회원정보수정</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/withdrawalEmployee" class="w3-button w3-green">회원탈퇴</a>&nbsp;&nbsp;
		</div>
		</div>
		
		<div align="center" style="border:1px solid black; height: 30%; width: 90%;" id="div2">
		<c:choose>
			<c:when test="${ employee.rank eq '사원'}">
			<div class="w3-panel w3-green">
	    		<h2 class="w3-opacity">나의 담당고객</h2>
	 		</div>
		
			<table class="w3-table-all w3-centered">
	            <tr>
	               <th width="7%">번호</th>
	               <th width="15%">고객이름</th>
	               <th width="25%">고객전화번호</th>
	               <th width="10%">고객나이</th>
	               <th>고객email</th>
	            </tr>
	            <c:forEach items="${ customerList }" var="list" varStatus="loop">
	               <tr>
	                  <td align="center">${ loop.count }</td>
	                  <td align="center">${ list.name }</td>
	                  <td align="center">${ list.hp }</td>
	                  <td align="center">${ list.age }</td>
	                  <td align="center">${ list.email }</td>
	               </tr>
	            </c:forEach>
	         </table>
			</c:when>
			<c:when test="${ employee.rank eq '대리'}">
				<div class="w3-panel w3-green">
	    			<h2 class="w3-opacity">나의 담당고객</h2>
	 			</div>
		
			<table class="w3-table-all w3-centered">
	            <tr>
	               <th width="7%">번호</th>
	               <th width="15%">고객이름</th>
	               <th width="25%">고객전화번호</th>
	               <th width="10%">고객나이</th>
	               <th>고객email</th>
	            </tr>
	            <c:forEach items="${ customerList }" var="list" varStatus="loop">
	               <tr>
	                  <td align="center">${ loop.count }</td>
	                  <td align="center">${ list.name }</td>
	                  <td align="center">${ list.hp }</td>
	                  <td align="center">${ list.age }</td>
	                  <td align="center">${ list.email }</td>
	               </tr>
	            </c:forEach>
	         </table>			
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		</div>				
		
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>