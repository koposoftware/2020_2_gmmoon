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


</script>
<style>
.atag {
	text-align: center;
	margin-top: 1%;
	margin-bottom: 1%;
}

.searchTag{
	text-align: right;
	margin-right: 5px;
	margin-bottom: 5px;
}

.w3-opacity{
	padding-top: 10px;
	padding-bottom: 5px;
	margin-top: 5px;
	text-align: center;
}

#div1 {
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
		<div align="center" style="border:1px solid black;  width: 90%;" id="div1">
			 <hr>
	         <div class="w3-panel w3-green">
    			<h2 class="w3-opacity">상담내역목록</h2>
 			 </div>
	         <hr>
	         
	         <table border="1" style="width: 100%" class="w3-table-all">
	            <tr>
	               <th width="7%" class="w3-center">번호</th>
	               <th class="w3-center">상담유형</th>
	               <th width="50%" class="w3-center">상담내용</th>
	               <th width="10%" class="w3-center">상담일자</th>
	               <th width="10%" class="w3-center">답변여부</th>
	            </tr>
	         <tbody id="myTable">
		            <c:forEach items="${ consultinglist }" var="list" varStatus="loop">
		               <tr>
		                  <td class="w3-center">${ loop.count }</td>
		                  <td class="w3-center">${ list.type }</td>
		                  <td >${ list.content }</td>
		                  <td class="w3-center">${ list.csdate }</td>
		                   <c:choose>
			                  	<c:when test="${ list.answer eq 'Y' }">
			                  		<td class="w3-center">
			                  			<a href="${pageContext.request.contextPath }/inqueryReplyConsulting/${list.no}">답변완료</a>
			                  		</td>
			                  	</c:when>
			                  	<c:otherwise>
			                  		<td class="w3-center">답변미완료</td>
			                  	</c:otherwise>
			                  </c:choose>
		               </tr>
		            </c:forEach>
	            </tbody>
	         </table>
	          <div class="atag">
		         <a href="${pageContext.request.contextPath }/myPage" class="w3-button w3-green">My Page</a>
	          </div>
	     </div>
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>