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
		//url 확인
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
		
		//존재하는 방은 세션에 추가
		if(flag) {
			HashMap<String, Object> map = rls.get(idx);
			map.put(session.getId(), session);
		} else { //최초 생성하는 방은 방번호와 세션 추가
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("roomNumber", roomNumber);
			map.put(session.getId(), session);
			rls.add(map);
		}
		
		//세션등록이 끝나면 발급받은 세션 ID값의 메시지 발송
		JSONObject obj = new JSONObject();
		obj.put("type", "getId");
		obj.put("sessionId", session.getId());
		session.sendMessage(new TextMessage(obj.toJSONString()));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//메세지 발송
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
			
			//해당 방의 세션들만 찾아서 메시지를 발송해준다.
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
		//소켓 종료
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
