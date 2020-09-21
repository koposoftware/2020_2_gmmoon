<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script>
	
	window.onload = function() {
		
		var ws;
		var userid = 'bbb';
		
		function connect() {
			ws = new WebSocket('ws://localhost:5054/hanalife/chat');
			
			ws.onopen = function() {
				console.log('연결생성');
				register();
			};
			
			ws.onmessage = function(event) {
				console.log('메세지받음');
				var data = event.data;
				alert(data);
				addMsg(data);
			};
			
			ws.onclose = function() {
				console.log('연결끊김');
			};
		}
		
		function addMsg(msg) {
			var chat = $('#msgArea').val();
			chat = chat + "\n상대방 : " + msg;
			console.log(chat);
			$('#msgArea').val(chat);
		}
		
		function register() {
			var msg = {
					type : "register",
					userid : 'bbb'
			};
			ws.send(JSON.stringify(msg));
		}
		
		function sendMsg() {
			var msg = {
					type : "chat",
					target : $('#targetUser').val(),
					message : $('#chatMsg').val()
			};
			console.log(msg);
			ws.send(JSON.stringify(msg));
		}
		
		$(function() {
			connect();
			$('#btnSend').on('click', function() {
				var chat = $('#msgArea').val();
				chat =  chat + "\n나 : " + $('#chatMsg').val();
				$('#msgArea').val(chat);
				sendMsg();
				$('#chatMsg').val("");
				console.log(chat);
			})
		});
	}
	
</script>
</head>
<body>
	<textarea rows="5" cols="30" id="msgArea">
	
	</textarea>
	<br>메세지 : <input type="text" id="chatMsg">
	<br>상대아이디 : <input type="text" id="targetUser">
	<br>
	<input type="button" value="전송" id="btnSend">
</body>
</html>