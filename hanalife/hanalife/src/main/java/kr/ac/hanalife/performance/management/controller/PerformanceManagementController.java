package kr.ac.hanalife.performance.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.performance.management.service.PerformanceManagementService;
import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;

@Controller
public class PerformanceManagementController {
	
	@Autowired
	private PerformanceManagementService performancemanagementService;
	
	@RequestMapping("performanceManagementService")
	public ModelAndView selectPerformanceManagement(HttpSession session) {
		
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		int empno = employee.getEmpno();
		
		List<PerformanceManagementVO> performanceManagementList = new ArrayList<>();
		performanceManagementList = performancemanagementService.selectPerformanceManagement(empno);
		
		ModelAndView mav = new ModelAndView("employee/performanceManagementService");
		mav.addObject("performanceManagementList", performanceManagementList);
		
		return mav;
	}
	
	@SuppressWarnings("all")
	@RequestMapping(value = "lookUpEmployeeManagement",  method = RequestMethod.POST)
	public ResponseEntity<JSONObject> selectGraph(@RequestParam(value = "inputArr[]") List<String> inputArr){
		
		//test
		/*
		for(String i : inputArr) {
			System.out.println(i);
		}
		*/
		ResponseEntity<JSONObject>  entity= null;
		
		//단기계약지수
		if(inputArr.get(0).equals("1")) {
//			System.out.println("단기계약 유지율 그래프를 그립니다...");
			
			JSONObject data =new JSONObject();
			
			JSONObject col1 =new JSONObject();
			JSONObject col2 =new JSONObject();
			JSONObject col3 =new JSONObject();
			JSONArray title =new JSONArray();
			
			col1.put("label", "월별");
			col1.put("type", "string");
			col2.put("label", "단기계약유지지수");
			col2.put("type" , "number");
			
			title.add(col1);
			title.add(col2);
					
			data.put("cols", title);
			
			
			PerformanceManagementVO pmVO = new PerformanceManagementVO();
			pmVO.setEmpno(Integer.parseInt(inputArr.get(1)));
			pmVO.setDate(inputArr.get(2));
			List<PerformanceManagementVO> shortContractList = performancemanagementService.lookUpShortContract(pmVO);
			
			JSONArray body =new JSONArray();
			for(PerformanceManagementVO p : shortContractList) {
				
				JSONObject name =new JSONObject();
				name.put("v", p.getDate().substring(5, 7)); //월-> v 객체 
				JSONObject price =new JSONObject();
				price.put("v", p.getShortContract()); //단기계약지수 ->v 객체
				
				JSONArray row =new JSONArray();
				row.add(name);
				row.add(price);
				
				JSONObject c =new JSONObject();
				c.put("c", row);
				
				body.add(c);
			}
			data.put("rows", body);
			
			try{
				 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
			}catch (Exception e) {
				System.out.println(" 에러            -- ");
				entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
			}
			
			return entity;
		}
		
		//장기계약지수
		if(inputArr.get(0).equals("2")) {
//			System.out.println("장기계약 유지율 그래프를 그립니다...");
			
			JSONObject data =new JSONObject();
			
			JSONObject col1 =new JSONObject();
			JSONObject col2 =new JSONObject();
			JSONObject col3 =new JSONObject();
			JSONArray title =new JSONArray();
			
			col1.put("label", "월별");
			col1.put("type", "string");
			col2.put("label", "장기계약유지지수");
			col2.put("type" , "number");
			
			title.add(col1);
			title.add(col2);
					
			data.put("cols", title);
			
			
			PerformanceManagementVO pmVO = new PerformanceManagementVO();
			pmVO.setEmpno(Integer.parseInt(inputArr.get(1)));
			pmVO.setDate(inputArr.get(2));
			List<PerformanceManagementVO> longContractList = performancemanagementService.lookUpLongContract(pmVO);
			
			JSONArray body =new JSONArray();
			for(PerformanceManagementVO p : longContractList) {
				
				JSONObject name =new JSONObject();
				name.put("v", p.getDate().substring(5, 7)); //월-> v 객체 
				JSONObject price =new JSONObject();
				price.put("v", p.getLongContract()); //장기계약지수 ->v 객체
				
				JSONArray row =new JSONArray();
				row.add(name);
				row.add(price);
				
				JSONObject c =new JSONObject();
				c.put("c", row);
				
				body.add(c);
			}
			data.put("rows", body);
			
			try{
				 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
			}catch (Exception e) {
				System.out.println(" 에러            -- ");
				entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
			}
			
			return entity;
		}
		
		
		//중도해지건수
		if(inputArr.get(0).equals("3")) {
//			System.out.println("중도해지건수 그래프를 그립니다...");
			
			JSONObject data =new JSONObject();
			
			JSONObject col1 =new JSONObject();
			JSONObject col2 =new JSONObject();
			JSONObject col3 =new JSONObject();
			JSONArray title =new JSONArray();
			
			col1.put("label", "월별");
			col1.put("type", "string");
			col2.put("label", "중도해지건수");
			col2.put("type" , "number");
			
			title.add(col1);
			title.add(col2);
					
			data.put("cols", title);
			
			
			PerformanceManagementVO pmVO = new PerformanceManagementVO();
			pmVO.setEmpno(Integer.parseInt(inputArr.get(1)));
			pmVO.setDate(inputArr.get(2));
			List<PerformanceManagementVO> longContractList = performancemanagementService.lookUpTermination(pmVO);
			
			JSONArray body =new JSONArray();
			for(PerformanceManagementVO p : longContractList) {
				
				JSONObject name =new JSONObject();
				name.put("v", p.getDate().substring(5, 7)); //월-> v 객체 
				JSONObject price =new JSONObject();
				price.put("v", p.getNumberOfTermination()); //중도해지건수 ->v 객체
				
				JSONArray row =new JSONArray();
				row.add(name);
				row.add(price);
				
				JSONObject c =new JSONObject();
				c.put("c", row);
				
				body.add(c);
			}
			data.put("rows", body);
			
			try{
				 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
			}catch (Exception e) {
				System.out.println(" 에러            -- ");
				entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
			}
			
			return entity;
		}		
		
		
		return null;
	}
}
