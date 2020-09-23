package kr.ac.hanalife.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
	
	List<RoomVO> roomList = new ArrayList<RoomVO>();
	static int roomNumber = 0;
	
	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mav = new ModelAndView("chatting/chat");
		return mav;
	}
	
	/**
	 * 방페이지
	 * @return
	 */
	@RequestMapping("/room")
	public ModelAndView room() {
		ModelAndView mav = new ModelAndView("chatting/room");
		return mav;
	}
	
	/**
	 * 방생성하기
	 * @param params
	 * @return
	 */
	@RequestMapping("createRoom")
	public @ResponseBody List<RoomVO> createRoom(@RequestParam HashMap<Object, Object> params){
		
		String roomName = (String)params.get("roomName");
		
		if(roomName != null && !roomName.trim().equals("")) {
			RoomVO room = new RoomVO();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
		}
		
		return roomList;
	}
	
	/**
	 * 방정보 불러오기
	 * @param params
	 * @return
	 */
	@RequestMapping("/getRoom")
	public @ResponseBody List<RoomVO> getRoom(@RequestParam HashMap<Object, Object> params){
		return roomList;
	}
	
	@RequestMapping("moveChating")
	public ModelAndView chatting(@RequestParam HashMap<Object, Object> params) {
		
		ModelAndView mav = new ModelAndView();
		int roomNumber =  Integer.parseInt((String)params.get("roomNumber"));
		
		//filter(predicate)에 대해 알아보자
		List<RoomVO> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		
		if(new_list != null && new_list.size() > 0) {
			mav.addObject("roomName", params.get("roomName"));
			mav.addObject("roomNumber", params.get("roomNumber"));
			mav.setViewName("chatting/chat");
		} else {
			mav.setViewName("chatting/room");
		}
		
		return mav;
	}
}
