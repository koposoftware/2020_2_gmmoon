<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script>
//검색
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<br>
	         <hr width="100%">
	         <h2>상담 내역 목록</h2>
	         <hr width="100%">
	         <br>
	         
	         <input class="form-control" id="myInput" type="text" placeholder="Search..">
	         <table border="1" style="width: 100%">
	            <tr>
	               <th width="7%">번호</th>
	               <th width="7%">고객이름</th>	               
	               <th>상담유형</th>
	               <th width="50%">상담내용</th>
	               <th width="10%">상담일자</th>
	               <th width="10%">답변여부</th>
	            </tr>
	            <tbody id="myTable">
		            <c:forEach items="${ consultingList }" var="list" varStatus="loop">
		               <tr>
		                  <td align="center">
		                  	<a href="${pageContext.request.contextPath }/replyConsulting/${list.no}">${ loop.count }</a>
		                  </td>
		                  <td align="center">${ list.name }</td>
		                  <td align="center">${ list.type }</td>
		                  <td align="center">${ list.content }</td>
		                  <td align="center">${ list.csdate }</td>
		                  <c:choose>
		                  	<c:when test="${ consultingReplyNo eq list.no }">
		                  		<td align="center">답변완료</td>
		                  	</c:when>
		                  	<c:otherwise>
		                  		<td align="center">답변미완료</td>
		                  	</c:otherwise>
		                  </c:choose>	                  
		               </tr>
		            </c:forEach>
	            </tbody>
	         </table>
	         <a href="${pageContext.request.contextPath }" class="button">홈으로</a>
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>