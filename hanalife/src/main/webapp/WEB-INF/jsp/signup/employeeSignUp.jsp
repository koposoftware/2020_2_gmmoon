<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script>
	//아이디중복체크 기능 AJAX
	$(document).ready(function() {
		$('#checkid').click(function() {
			
			
			let id = document.sform.id.value;
			
			$.ajax({
				url : '${ pageContext.request.contextPath }/employeeSignUp/checkid?cid=' + id,
				type : 'get',
				success : function(data) {
					
					
					console.log(data);
					
					if(data == 1){
						// alert('아이디 중복체크를 시작합니다');
						
						$('#msgView').text('이미 사용중인 아이디입니다');
						
					} 
						
					if( data == 0) {
						$('#msgView').text('사용할 수 있는 아이디 입니다');
					}
				},
				error : function(data) {
					alert('실패');
				}
			});	
			
		})
	})
	
	// 비밀번호 일치 여부
	$(document).ready(function() {
		$('#check_pw').keyup(function() {
			let firstpw = document.sform.password.value;
			let msg = '';
			
			$('#msgView2').hide();	
			
				// console.log(firstpw);
				if(firstpw != ''){
					if(firstpw == $('#check_pw').val()) {
					
						msg = '비밀번호 값이 일치합니다';
						$('#msgView2').text(msg).show();
					} else {
					
						msg = '비밀번호 값이 일치하지않습니다';
						$('#msgView2').text(msg).show();
					}
					
				} else {
					msg = '비밀번호 값을 먼저 입력해주세요';
					$('#msgView2').text(msg).show();
				
				}
		
			 
		})
	})

</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<h2>회원가입</h2>
		<form action="${ pageContext.request.contextPath }/employeeSignUp" method="post" name="sform" class="search-form">
			<div>
				<input type="text" name="id" placeholder="ID" required="required"  /> &nbsp;
				<input type="button" value="아이디중복체크"  id="checkid" /> &nbsp; <p  id="msgView"></p>
			</div>
			<div>
				<input type="text" name="password" placeholder="PASSWORD" id="input_pw" required="required" >
			</div>
			<div>
				<input type="text" name="password_re" placeholder="PASSWORD 재입력" id="check_pw"> &nbsp;
				<p id="msgView2"></p>
			</div>
			<div>
				<input type="text" name="name" placeholder="사원명" required="required" >
			</div>
			<div>
				<input type="text" name="empno" placeholder="사원번호" required="required" >
			</div>
			<div>
				직급을 선택하세요 : 
				<select name="rank">
							<option value="">직급선택</option>
							<option value="사원">사원</option>
							<option value="대리">대리</option>
							<option value="과장">과장</option>
							<option value="차장">차장</option>
							<option value="부장">부장</option>
							<option value="임원">임원</option>
				</select>
			</div>
			<div>
				<input type="text" name="age" placeholder="나이" required="required" >
			</div>
			<div>
				<input type="text" name="hp" placeholder="사원전화번호" required="required" >
			</div>
			<div>
			</div>
			<div>
				<input type="email" name="email" placeholder="email" required="required" >
			</div>
			<div>
				<button type="submit">회원가입</button>
			</div>
			
		</form>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>