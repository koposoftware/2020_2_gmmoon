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
	var userid = '${ employee.name }';
	
	function connect() {
		ws = new WebSocket('ws://localhost:9999/hanalife/chat');
		
		ws.onopen = function() {
			console.log('연결생성');
			register();
		};
		
		ws.onmessage = function(e) {
			console.log('메세지받음');
			var data = e.data;
			//alert(data);
			addMsg(data);
		};
		
		ws.onclose = function() {
			console.log('연결끊김');
		};
	}
	
	function addMsg(msg) {
		var chat = $('#msgArea').val();
		chat = chat + "\n "+ $('#targetUser').val() + " : " + msg;
		$('#msgArea').val(chat);
	}
	
	function register() {
		var msg = {
				type : "register",
				userid : '${ employee.name }'
		};
		ws.send(JSON.stringify(msg));
	}
	
	function sendMsg() {
		var msg = {
				type : "chat",
				target : $('#targetUser').val(),
				message : $('#chatMsg').val()
		};
		ws.send(JSON.stringify(msg));
	}
	
	$(function() {
		connect();
		$('#btnSend').on("click", function() {
			var chat = $('#msgArea').val();
			chat =  chat + "\n나 : " + $('#chatMsg').val();
			$('#msgArea').val(chat);
			sendMsg();
			$('#chatMsg').val("");
		})
	});
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<textarea rows="5" cols="30" id="msgArea">
		</textarea>
		<br>메세지 : <input type="text" id="chatMsg">
		<br>보낼사람이름 : <input type="text" id="targetUser">
		<br>
		<input type="button" value="전송" id="btnSend">
	</section>
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>		
	</footer>
</body>
</html>