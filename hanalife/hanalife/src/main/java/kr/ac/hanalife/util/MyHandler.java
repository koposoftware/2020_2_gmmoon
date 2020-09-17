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
		System.out.println("�������");
		users.add(session);
		System.out.println(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("�޽��� ����");
		System.out.println("�޽��� : " + message.getPayload());
		JSONObject object = new JSONObject(message.getPayload());
		
		String type = object.getString("type");
		
		if(type != null && type.equals("register")) {
			//��� ��û �޽���
			String user = object.getString("userid");
			//���̵�� Session�̶� ����
			userMap.put(user, session);
			System.out.println(userMap.get(user));
		} else {
			//ä�ø޽��� : ���� ���̵� �����ؼ� �޽����� ������ ������
			//Map���� ���� ���̵� �ش��ϴ� WebSocket�� �����ͼ� �޽��� ����
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
		System.out.println("���� ����!");
		users.remove(session);
	}
	
	
}
