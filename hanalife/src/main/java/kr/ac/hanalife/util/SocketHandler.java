package kr.ac.hanalife.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketHandler extends TextWebSocketHandler {
	
	List<HashMap<String, Object>> rls = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		boolean flag = false;
		
		String url = session.getUri().toString();
		//url Ȯ��
		System.out.println(url);
		
		String roomNumber = url.split("/chat/")[1];
		int idx = rls.size();
		
		if(rls.size() > 0) {
			for(int i = 0;i<rls.size();i++) {
				String rN = (String)rls.get(i).get("roomNumber");
				
				if(rN.equals(roomNumber)) {
					flag = true;
					idx = i;
					break;
				}
			}
		}
		
		//�����ϴ� ���� ���ǿ� �߰�
		if(flag) {
			HashMap<String, Object> map = rls.get(idx);
			map.put(session.getId(), session);
		} else { //���� �����ϴ� ���� ���ȣ�� ���� �߰�
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("roomNumber", roomNumber);
			map.put(session.getId(), session);
			rls.add(map);
		}
		
		//���ǵ���� ������ �߱޹��� ���� ID���� �޽��� �߼�
		JSONObject obj = new JSONObject();
		obj.put("type", "getId");
		obj.put("sessionId", session.getId());
		session.sendMessage(new TextMessage(obj.toJSONString()));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//�޼��� �߼�
		String msg = message.getPayload();
		JSONObject obj = jsonToObjectParser(msg);
		
		String rN = (String)obj.get("roomNumber");
		HashMap<String, Object> temp = new HashMap<String, Object>();
		
		if(rls.size() > 0) {
			
			for(int i = 0;i<rls.size();i++) {
				String roomNumber = (String)rls.get(i).get("roomNumber");
				if(roomNumber.equals(rN)) {
					temp = rls.get(i);
					break;
				}
			}
			
			//�ش� ���� ���ǵ鸸 ã�Ƽ� �޽����� �߼����ش�.
			for(String k : temp.keySet()) {
				if(k.equals("roomNumber")) {
					continue;
				}
				
				WebSocketSession wss = (WebSocketSession) temp.get(k);
				if(wss != null) {
					try {
						wss.sendMessage(new TextMessage(obj.toJSONString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//���� ����
		if(rls.size() > 0) {
			for(int i = 0;i<rls.size();i++) {
				rls.get(i).remove(session.getId());
			}
		}
		
	}
	
	private static JSONObject jsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		
		try {
			obj = (JSONObject) parser.parse(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
