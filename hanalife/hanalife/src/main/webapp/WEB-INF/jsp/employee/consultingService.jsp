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
	
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="${pageContext.request.contextPath }/consultingService?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}

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
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<!--  기존에 있던 상담내역목록
	         <div class="w3-panel w3-green">
    			<h2 class="w3-opacity">상담내역목록</h2>
 			 </div>
	         <br>
	         <div class="searchTag">
		         <input class="form-control" id="myInput" type="text" placeholder="Search..">
	         </div>
	         <table border="1" style="width: 100%" class="w3-table-all">
	            <tr class="w3-green">
	               <th width="7%" class="w3-center">번호</th>
	               <th width="7%" class="w3-center">고객이름</th>	               
	               <th class="w3-center">상담유형</th>
	               <th width="50%" class="w3-center">상담내용</th>
	               <th width="10%" class="w3-center">상담일자</th>
	               <th width="10%" class="w3-center">답변여부</th>
	            </tr>
	            <tbody id="myTable">
		            <c:forEach items="${ consultingList }" var="list" varStatus="loop">
		               <tr>
		                  <c:choose>
		                  	<c:when test="${ list.answer eq 'Y' }">
		                  		<td class="w3-center">${ loop.count }</td>
		                  	</c:when>
		                  	<c:otherwise>
		                  		<td class="w3-center">
		                  			<a href="${pageContext.request.contextPath }/replyConsulting/${list.no}">${ loop.count }</a>
		                  		</td>
		                  	</c:otherwise>
		                  </c:choose>
		                  <td class="w3-center">${ list.name }</td>
		                  <td class="w3-center">${ list.type }</td>
		                  <td align="center">${ list.content }</td>
		                  <td class="w3-center">${ list.csdate }</td>
		                  <c:choose>
		                  	<c:when test="${ list.answer eq 'Y' }">
		                  		<td class="w3-center">
		                  			<a href="${pageContext.request.contextPath }/inqueryReplyConsulting/${list.no}">답변완료</a>
		                  		</td>
		                  	</c:when>
		                  	<c:otherwise>
		                  		<td class="w3-center" style="color: red">답변미완료</td>
		                  	</c:otherwise>
		                  </c:choose>	                  
		               </tr>
		            </c:forEach>
	            </tbody>
	         </table>
	         <div class="atag">
		         <a href="${pageContext.request.contextPath }" class="w3-button w3-green">홈으로</a>
	         </div>
	         -->
	       
	    <div id="outter">
		<div style="float: left;">
			<select id="cntPerPage" name="sel" onchange="selChange()">
				<option value="5"
					<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
				<option value="10"
					<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
				<option value="15"
					<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
				<option value="20"
					<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
			</select>
		</div> <!-- 옵션선택 끝 -->
		
		<!-- 검색기능 -->
		<div class="searchTag">
		      <input class="form-control" id="myInput" type="text" placeholder="Search..">
	    </div>
	    
		<table border="1">
			<tr class="w3-green">
	               <th width="7%" class="w3-center">번호</th>
	               <th width="7%" class="w3-center">고객이름</th>	               
	               <th class="w3-center">상담유형</th>
	               <th width="50%" class="w3-center">상담내용</th>
	               <th width="10%" class="w3-center">상담일자</th>
	               <th width="10%" class="w3-center">답변여부</th>
	        </tr>
			<tbody id="myTable">
		            <c:forEach items="${ consultingList }" var="list" varStatus="loop">
		               <tr>
		                  <c:choose>
		                  	<c:when test="${ list.answer eq 'Y' }">
		                  		<td class="w3-center">${ loop.count }</td>
		                  	</c:when>
		                  	<c:otherwise>
		                  		<td class="w3-center">
		                  			<a href="${pageContext.request.contextPath }/replyConsulting/${list.no}">${ loop.count }</a>
		                  		</td>
		                  	</c:otherwise>
		                  </c:choose>
		                  <td class="w3-center">${ list.name }</td>
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
		                  		<td class="w3-center" style="color: red">답변미완료</td>
		                  	</c:otherwise>
		                  </c:choose>	                  
		               </tr>
		            </c:forEach>
	            </tbody>
		</table>
		
		<div style="display: block; text-align: center;">		
			<c:if test="${paging.startPage != 1 }">
				<a href="${pageContext.request.contextPath }/consultingService?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
			</c:if>
			<c:forEach  begin="${paging.startPage }" end="${paging.endPage }" var="p">
				<c:choose>
					<c:when test="${p == paging.nowPage }">
						<b>${ p }</b>
					</c:when>
					<c:when test="${p != paging.nowPage }">
						<a href="${pageContext.request.contextPath }/consultingService?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.endPage != paging.lastPage}">
				<a href="${pageContext.request.contextPath }/consultingService?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
			</c:if>
		</div>
	</div>  
	         
	         
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>