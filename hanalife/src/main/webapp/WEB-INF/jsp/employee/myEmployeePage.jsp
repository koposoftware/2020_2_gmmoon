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
	
	</section>
		<hr>
		<h2>My profile</h2>
		<hr>
		<table>
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
		<a href="${pageContext.request.contextPath }" class="button">회원정보수정</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }" class="button">회원탈퇴</a>&nbsp;&nbsp;
		
		<br>
		<hr>
		<h2>나의 담당고객</h2>
		<hr>
		<br>
		
			<table border="1" style="width: 100%">
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
		
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>