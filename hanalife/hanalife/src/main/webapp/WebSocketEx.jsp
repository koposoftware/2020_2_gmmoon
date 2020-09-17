<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
</head>
<body>
	<textarea rows="5" cols="30" id="msgArea">
	
	</textarea>
	<br>메세지 : <input type="text" id="chatMsg">
	<br>상대아이디 : <input type="text" id="targetUser">
	<br>
	<input type="button" value="전송" id="btnSend">
</body>
<script>
		let ws;
		let userid = '${ param.id }';
		
		//connect();
		
		function connect() {
			ws = new WebSocket('ws://localhost:5054/hanalife/chat');
			//ws = new SockJS('//localhost:5054/hanalife/chat');
			
			ws._original_send_func = ws.send;
			ws.send = function(data) {
				   if(this.readyState == 1)
				     this._original_send_func(data);
			}.bind(ws);
			
			//ws = new SockJS("<c:url value='/chat'/>");
			ws.onopen = function() {
				console.log('연결생성');
				if(ws.readyState == 1)
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
			let chat = $('#msgArea').val();
			chat = chat + "\n상대방 : " + msg;
			console.log(chat);
			$('#msgArea').val(chat);
		}
		
		function register() {
			let msg = {
					type : "register",
					userid : '${ param.id }'
			};
			console.log('register start');
			ws.send(JSON.stringify(msg));
			console.log(ws.readyState)
			
		}
		
		function sendMsg() {
			let msg = {
					type : "chat",
					target : $('#targetUser').val(),
					message : $('#chatMsg').val()
			};
			console.log('send start')
			ws.send(JSON.stringify(msg));
			console.log(ws.readyState)
			console.log('send end')
		}
				
			
		$(function() {
			connect();
			$('#btnSend').on('click', function() {
				let chat = $('#msgArea').val();
				chat =  chat + "\n나 : " + $('#chatMsg').val();
				$('#msgArea').val(chat);
				sendMsg();
				$('#chatMsg').val("");
				console.log(chat);
			}) 
		});
	
</script>
</html>