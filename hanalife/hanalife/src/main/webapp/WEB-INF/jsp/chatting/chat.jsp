<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script>
	var ws;
	
	function wsOpen() {
		console.log($("#roomNumber").val());
		ws = new WebSocket("ws://" + location.hostname + ":9999/hanalife" + "/chat/"+$("#roomNumber").val());
		wsEvt();
	}
	
	function wsEvt() {
		ws.onopen = function(data) {
			//소켓이 열리면 동작
			console.log('open')
		}
		
		ws.onmessage = function(data) {
			//메세지 받으면 동작
			var msg = data.data;
			//console.log(msg);
			if(msg != null && msg.trim() != ''){
				var d = JSON.parse(msg);
				//console.log(d);
				if(d.type == "getId"){
					var si = d.sessionId != null ? d.sessionId : "";
					if(si != ''){
						$('#sessionId').val(si);
					}
					
				}else if(d.type == "message"){
					if(d.sessionId == $('#sessionId').val()){
						$('#chating').append("<p class='me'>나 :" + d.msg + "</p>");
					}else {
						console.log(d.userName);
						$('#chating').append("<p class='others'>" + d.userName + " : " + d.msg + "</p>" );
					}
					
				} else {
					console.warn("unknown type!");
				}
			}
		}
		
		document.addEventListener('keypress', function(e) {
			if(e.keyCode == 13){
				send();
			}
		});
	}
	
	function chatName() {
		var userName = $('#userName').val();
		console.log(userName);
		if(userName == null || userName.trim() == ""){
			alert('사용자 이름을 입력해주세요');
			$('#userName').focus();
		} else {
			wsOpen();
			$('#yourName').hide();
			$('#yourMsg').show();
		}
	}
	
	function send() {
		var option = {
				type : "message",
				roomNumber: $('#roomNumber').val(),
				sessionId : $('#sessionId').val(),
				userName : $('#userName').val(),
				msg : $('#chatting').val()
		}
		ws.send(JSON.stringify(option))
		$('#chatting').val("");
	}
	
</script>
<style type="text/css">
*{
	margin:0;
	padding:0;
}
.container{
	width: 500px;
	margin: 0 auto;
	padding: 25px
}
.container h1{
	text-align: left;
	padding: 5px 5px 5px 15px;
	color: #04B404;
	border-left: 3px solid #04B404;
	margin-bottom: 20px;
}
.chating{
	background-color: #000;
	width: 500px;
	height: 500px;
	overflow: auto;
}
.chating .me{
	color: #F6F6F6;
	text-align: right;
}
.chating .others{
	color: #04B404;
	text-align: left;
}
input{
	width: 330px;
	height: 25px;
}
#yourMsg{
	display: none;
}
</style>
</head>
<body>
	<div id="container" class="container">
		<h1>${roomName} 채팅방</h1>
		<input type="hidden" id="sessionId" value="">
		<input type="hidden" id="roomNumber" value="${roomNumber}">
		
		<div id="chating" class="chating">
		</div>
		
		<div id="yourName">
			<table class="inputTable">
				<tr>
					<th>사용자명</th>
					<th><input type="text" name="userName" id="userName"></th>
					<th><button onclick="chatName()" id="startBtn">이름 등록</button></th>
				</tr>
			</table>
		</div>
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>