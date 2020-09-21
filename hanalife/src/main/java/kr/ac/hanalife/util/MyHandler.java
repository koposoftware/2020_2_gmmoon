package kr.ac.hanalife.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyHandler extends TextWebSocketHandler {
	
	private List<WebSocketSession> users;
	private Map<String, Object> userMap;
	
	public MyHandler() {
		users = new ArrayList<WebSocketSession>();
		userMap = new HashMap<String, Object>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결생성");
		users.add(session);
		System.out.println(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("메시지 수신");
		System.out.println("메시지 : " + message.getPayload());
		JSONObject object = new JSONObject(message.getPayload());
		
		String type = object.getString("type");
		
		if(type != null && type.equals("register")) {
			//등록 요청 메시지
			String user = object.getString("userid");
			//아이디랑 Session이랑 맵핑
			userMap.put(user, session);
			System.out.println(userMap.get(user));
		} else {
			//채팅메시지 : 상대방 아이디를 포함해서 메시지를 보내기 때문에
			//Map에서 상대방 아이디에 해당하는 WebSocket을 꺼내와서 메시지 전송
			String target = object.getString("target");
			WebSocketSession ws = (WebSocketSession)userMap.get(target);
			String msg = object.getString("message");
			
			if(ws != null) {
				ws.sendMessage(new TextMessage(msg));
			}
		}
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 종료!");
		users.remove(session);
	}
	
	
}
