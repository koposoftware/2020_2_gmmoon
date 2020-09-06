<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js" ></script>
<script>
	
	//아이디중복체크 기능 AJAX
	$(document).ready(function() {
		$('#checkid').click(function() {
			
			
			let id = document.mform.id.value;
			
			$.ajax({
				url : '${ pageContext.request.contextPath }/signUp/checkid?cid=' + id,
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

	//비밀번호 일치 여부
	$(document).ready(function() {
		$('#check_pw').keyup(function() {
			let firstpw = document.mform.password.value;
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
	
	
	function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('post').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('addr').value = fullRoadAddr;
            }
        }).open();
    }
	
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
		<hr>
		<h2>회원수정</h2>
		<hr>
		<form action="${ pageContext.request.contextPath }/modifyInfo" method="post" name="mform" class="search-form">
			<div>
				<input type="text" name="id" placeholder="${ loginVO.id }" required="required"  /> &nbsp;
				<input type="button" value="아이디중복체크"  id="checkid" /> &nbsp; <p  id="msgView"></p>
			</div>
			<div>
				비밀번호 수정 : <input type="text" name="password" placeholder="${ loginVO.password }" id="input_pw" required="required" >
			</div>
			<div>
				비밀번호 재확인 : <input type="text" name="password_re" placeholder="PASSWORD 재입력" id="check_pw"> &nbsp;
				<p id="msgView2"></p>
			</div>
			<div>
				이름 : <input type="text" name="name" placeholder="${ memberVO.name }" required="required" >
			</div>
			<div>
				전화번호 : <input type="text" name="hp" placeholder="${ memberVO.hp }" required="required" >
			</div>
			<div>
				<button onclick="execDaumPostcode();" class="btn btn-outline-info py-2 px-1 px-md-3">주소검색</button>
				<input type="text" name="post" id="post" placeholder="${ memberVO.post }" required="required" >
			</div>
			<div>
				<input type="text" name="addr" id="addr" placeholder="${ memberVO.addr }" required="required" >
			</div>
			<div>
				<input type="email" name="email" placeholder="${ memberVO.email }" required="required" >
			</div>
			<div>
				<button type="submit">회원정보수정</button>
				<input type="reset" value="초기화" />
			</div>
			
		</form>
	</section>
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>