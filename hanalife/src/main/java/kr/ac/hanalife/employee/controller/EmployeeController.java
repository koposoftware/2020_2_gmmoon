package kr.ac.hanalife.employee.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.consulting.service.ConsultingService;
import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.service.EmployeeService;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;
import kr.ac.hanalife.performance.management.service.PerformanceManagementService;
import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;
import kr.ac.hanalife.util.PagingVO;

@SessionAttributes({"employee","employeeList"})
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ConsultingService consultingService;
	
	@Autowired
	private PerformanceManagementService performancemanagementService;
	
	@GetMapping("/employeeLogin")
	public String employeeLoginForm() {
		return "/login/employeeLogin";
	}
	
	@PostMapping("employeeLogin")
	public ModelAndView employeeLogin(EmployeeVO employeeVO, HttpSession session, SessionStatus status) {
		
		EmployeeVO employee = employeeService.loginEmployee(employeeVO);
		ModelAndView mav = new ModelAndView();
		
		if(employee == null) {
		    employee = new EmployeeVO();
			employee.setId("���¾��̵�");
					
			session.setAttribute("employee", employee);
			status.setComplete();
			mav.setViewName("redirect:/employeelogin");
					
		}
		
		//�α��� ����
		String dest = (String)session.getAttribute("dest");
		if(dest == null ) {
					
			mav.setViewName("redirect:/");
		} else {
			mav.setViewName("redirect:" + dest);
			session.removeAttribute("dest");
		}
				
		mav.addObject("employee", employee);
				
		return mav;
				
	}
	
	@RequestMapping("myEmployeePage")
	public ModelAndView myEmployeePage(HttpSession session) {
		
		List<MemberVO> customerList = new ArrayList<>();
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		ModelAndView mav = new ModelAndView("employee/myEmployeePage");
		
		int empno = employee.getEmpno();
		
		customerList = employeeService.myChargingCustomer(empno);
		
		mav.addObject("customerList", customerList);
		
		return mav;
	}
	
	@RequestMapping("/employeelogout")
	public String logout(SessionStatus status) {
				
		status.setComplete(); 
				
		return "redirect:/";
	}
	
	@RequestMapping("consultingService")
	public ModelAndView selectConsultingCustomer(HttpSession session, PagingVO pgVO, 
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		/* ������ �ִ� ��ȸ���
		List<ConsultingVO> consultingList = new ArrayList<>();
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		ModelAndView mav = new ModelAndView("employee/consultingService");
		
		int empno = employee.getEmpno();
		
		consultingList = employeeService.selectConsultingCustomer(empno);
		
		for(ConsultingVO c : consultingList) {
			
			if(consultingService.existConsultingReply(c.getNo()) != null) {
				c.setAnswer("Y");
				
			} else {
				
				c.setAnswer("N");
			}
		}
		

		mav.addObject("consultingList", consultingList);
		
		return mav;
		*/
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		int empno = employee.getEmpno();
		
		List<ConsultingVO> totalList = consultingService.inqeuryNumberConsultingCustomer();
		
		int total = totalList.size();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		pgVO = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		

		pgVO.setEmpno(empno);

		ModelAndView mav = new ModelAndView("employee/consultingService");
		mav.addObject("paging", pgVO);
		
		List<ConsultingVO> consultingList = new ArrayList<>();
		
		consultingList = consultingService.selectPageConsulting(pgVO);
		
		
		for(ConsultingVO c : consultingList) {
			c.setCsdate(c.getCsdate().substring(0, 16));
			if(consultingService.existConsultingReply(c.getNo()) != null) {
				c.setAnswer("Y");
				
			} else {
				
				c.setAnswer("N");
			}
		}
	
		mav.addObject("consultingList", consultingList);
		return mav;
	}
	
	@GetMapping("/employeeSignUp")
	public String employeeSignUpForm() {
		return "/signup/employeeSignUp";
	}
	
	@PostMapping("employeeSignUp")
	public String employeeSignUp(@Valid EmployeeVO employeeVO, BindingResult result) {
		
		employeeService.employeeSignUp(employeeVO);
		
		if(result.hasErrors()) {
			System.out.println("�����߻�!!!...");
			return "/signup/employeeSignUp";
		}
		
		return "/login/employeeLogin";
	}
	
	@GetMapping("/employeeSignUp/checkid")
	@ResponseBody
	public int checkid(@RequestParam("cid") String cid, HttpSession session) {
		
		EmployeeVO checkemployee = employeeService.employeeCheckID(cid);
		
		if(checkemployee == null) {
			System.out.println("���̵� ���� ��ü�� �����ϴ�");
			return 0;
		} else {
			System.out.println("���̵� ���� ��ü�� �����մϴ�");
			return 1;
		}
		
	}
	
	@RequestMapping("manageEmployee")
	public String manageEmployee(HttpSession session) {
		
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		List<MemberVO> customerList = new ArrayList<>();
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		
		int empno = employee.getEmpno();
		
		customerList = employeeService.myChargingCustomer(empno);
		employeeList = employeeService.selectEmployeeAll();
		
		session.setAttribute("employeeList", employeeList);
		session.setAttribute("customerList", customerList);
		
		return "/employee/manageEmployee";
	}
	
	@RequestMapping("assignCustomer")
	@ResponseBody
	public int assignCustomer(@RequestParam(value = "customerArr[]") List<String> customerArr) {
		
		/* ajax���� ���� �����Ͱ� �ߵ������� Ȯ��
		for(String c : customerArr ) {
			System.out.println(c);
		}
		*/
		try {
			
			// ajax���� ������ �迭�� �� ������ ��ȣ�� �����ȣ
			int empno = Integer.parseInt(customerArr.get(customerArr.size()-1));
			MemberVO member = new MemberVO();
			
			//cusno �ʱ�ȭ
			int cusno;
			for(int i = 0;i<customerArr.size() - 1;i++) {
				
				cusno = Integer.parseInt(customerArr.get(i));
				member.setEmpno(empno);
				member.setCusno(cusno);
				employeeService.AssignCustomer(member);
			}
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ������Ʈ ���н� 0�� ��ȯ���ش�
		return 0;
	}
	
	/*	 ���� ��Ʈ JSON �������� ����
	{
	    "cols": [
	        {"label":"Topping","type":"string"},
	        {"label":"Slices","type":"number"}
	    ],        
	    "rows": [
	        {"c":[{"v":"Mushrooms"},{"v":3}]},
	        {"c":[{"v":"Onions"},{"v":1}]},
	        {"c":[{"v":"Olives"},{"v":1}]},
	        {"c":[{"v":"Zucchini"},{"v":1}]},
	        {"c":[{"v":"Pepperoni"},{"v":2}]}
	    ]
	}
	*/
	
	//�������
	@SuppressWarnings("all")
	@RequestMapping(value="employeeCustomer", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> employee_list(){
		
		ResponseEntity<JSONObject>  entity= null;
		
		//����Ʈ ���¸� json ���·� ���� ����
		JSONObject data =new JSONObject();
		
		//�÷���ü
		JSONObject col1 =new JSONObject();
		JSONObject col2 =new JSONObject();
		JSONArray title =new JSONArray();
		col1.put("label", "�����");
		col1.put("type", "string");
		col2.put("label", "������");
		col2.put("type" , "number");
				
		title.add(col1);
		title.add(col2);
				
		data.put("cols", title);
		
		/*		
		"rows": [
			        {"c":[{"v":"Mushrooms"},{"v":3}]},
			        {"c":[{"v":"Onions"},{"v":1}]},
			       ]
			       
		rows : [ �迭 (��ü :�迭[��ü])]
		
		 */ 	

		//�� ����  ->  rows ��ü �� �迭  <- 
		//  <- [  c ��� ��ü�� �迭 <- ��ü
		//  data ��ü -> rows �迭 <-  c ��ü  ->�迭  <- v ��ü 2��/
		
		List<EmployeeVO> employeeList = employeeService.selectEmployeeAll();
		JSONArray  body =new JSONArray();
		for(EmployeeVO e : employeeList) {
			
			EmployeeVO employee = new EmployeeVO();
			
			employee = employeeService.countEmployeeInCharge(e.getEmpno());
//			System.out.println(employee.getCount());
			int cnt = 0;
			if(employee != null) {
				cnt = employee.getCount();
			} 
			
				
										
			JSONObject name =new JSONObject();
			name.put("v", e.getName()); //��ǰ�̸� -> v ��ü 
			JSONObject price =new JSONObject();
			price.put("v", cnt); //���� ->v ��ü
			
			//  v��ü�� row �迭�� ������ �߰��Ѵ�.
			JSONArray row =new JSONArray();
			row.add(name);
			row.add(price);
			
			//   c ��ü �� ������ row �迭�� ��´�.
			JSONObject c =new JSONObject();
			c.put("c", row);		
			// c ��ü�� �迭 ������ body �� ��´�.
			body.add(c);
		}
		
		// �迭 ������ body �� rows Ű������ ��ü data �� ��´�.
		data.put("rows", body);
		
		try{
			 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(" ����            -- ");
			entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping("employeeInfoCompany")
	private String employeeInfoCompany() {
		return "/pageComponent/about";
	}
	
	//�ܱ��������������
	@SuppressWarnings("all")
	@RequestMapping(value="employeePerformance", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> employee_performance(){
		
		ResponseEntity<JSONObject>  entity= null;
		
		//����Ʈ ���¸� json ���·� ���� ����
		JSONObject data =new JSONObject();
		
		//�÷���ü
		JSONObject col1 =new JSONObject();
		JSONObject col2 =new JSONObject();
		JSONObject col3 =new JSONObject();
		JSONArray title =new JSONArray();
		col1.put("label", "�����");
		col1.put("type", "string");
		col2.put("label", "�ܱ��������������");
		col2.put("type" , "number");

				
		title.add(col1);
		title.add(col2);
				
		data.put("cols", title);
		
		/*		
		"rows": [
			        {"c":[{"v":"Mushrooms"},{"v":3}]},
			        {"c":[{"v":"Onions"},{"v":1}]},
			       ]
			       
		rows : [ �迭 (��ü :�迭[��ü])]
		
		 */ 	

		//�� ����  ->  rows ��ü �� �迭  <- 
		//  <- [  c ��� ��ü�� �迭 <- ��ü
		//  data ��ü -> rows �迭 <-  c ��ü  ->�迭  <- v ��ü 2��/
		
		List<EmployeeVO> employeeList = employeeService.selectEmployeeAll();
		JSONArray  body =new JSONArray();
		for(EmployeeVO e : employeeList) {
			
			PerformanceManagementVO pmVO = new PerformanceManagementVO();
			pmVO = performancemanagementService.shortContractManagementAVG(e.getEmpno());
			
//			System.out.println(employee.getCount());
			double cnt = 0;
			if(pmVO != null) {
				cnt = (pmVO.getAvg());
			} 
			
				
										
			JSONObject name =new JSONObject();
			name.put("v", e.getName()); //��ǰ�̸� -> v ��ü 
			JSONObject price =new JSONObject();
			price.put("v", cnt); //���� ->v ��ü
			
			//  v��ü�� row �迭�� ������ �߰��Ѵ�.
			JSONArray row =new JSONArray();
			row.add(name);
			row.add(price);
			
			//   c ��ü �� ������ row �迭�� ��´�.
			JSONObject c =new JSONObject();
			c.put("c", row);		
			// c ��ü�� �迭 ������ body �� ��´�.
			body.add(c);
		}
		
		// �迭 ������ body �� rows Ű������ ��ü data �� ��´�.
		data.put("rows", body);
		
		try{
			 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(" ����            -- ");
			entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//����������������
	@SuppressWarnings("all")
	@RequestMapping(value="employeePerformance2", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> employee_performance2(){
		
		ResponseEntity<JSONObject>  entity= null;
		
		//����Ʈ ���¸� json ���·� ���� ����
		JSONObject data =new JSONObject();
		
		//�÷���ü
		JSONObject col1 =new JSONObject();
		JSONObject col2 =new JSONObject();
		JSONObject col3 =new JSONObject();
		JSONArray title =new JSONArray();
		col1.put("label", "�����");
		col1.put("type", "string");
		col2.put("label", "����������������");
		col2.put("type" , "number");

				
		title.add(col1);
		title.add(col2);
				
		data.put("cols", title);
		
		/*		
		"rows": [
			        {"c":[{"v":"Mushrooms"},{"v":3}]},
			        {"c":[{"v":"Onions"},{"v":1}]},
			       ]
			       
		rows : [ �迭 (��ü :�迭[��ü])]
		
		 */ 	

		//�� ����  ->  rows ��ü �� �迭  <- 
		//  <- [  c ��� ��ü�� �迭 <- ��ü
		//  data ��ü -> rows �迭 <-  c ��ü  ->�迭  <- v ��ü 2��/
		
		List<EmployeeVO> employeeList = employeeService.selectEmployeeAll();
		JSONArray  body =new JSONArray();
		for(EmployeeVO e : employeeList) {
			
			PerformanceManagementVO pmVO = new PerformanceManagementVO();
			pmVO = performancemanagementService.longContractManagementAVG(e.getEmpno());
			
			double cnt = 0;
			if(pmVO != null) {
				cnt = (pmVO.getAvg());
			} 
			
				
										
			JSONObject name =new JSONObject();
			name.put("v", e.getName()); //��ǰ�̸� -> v ��ü 
			JSONObject price =new JSONObject();
			price.put("v", cnt); //���� ->v ��ü
			
			//  v��ü�� row �迭�� ������ �߰��Ѵ�.
			JSONArray row =new JSONArray();
			row.add(name);
			row.add(price);
			
			//   c ��ü �� ������ row �迭�� ��´�.
			JSONObject c =new JSONObject();
			c.put("c", row);		
			// c ��ü�� �迭 ������ body �� ��´�.
			body.add(c);
		}
		
		// �迭 ������ body �� rows Ű������ ��ü data �� ��´�.
		data.put("rows", body);
		
		try{
			 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(" ����            -- ");
			entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//�ߵ������Ǽ����
		@SuppressWarnings("all")
		@RequestMapping(value="employeePerformance3", method = RequestMethod.GET)
		public ResponseEntity<JSONObject> employee_performance3(){
			
			ResponseEntity<JSONObject>  entity= null;
			
			//����Ʈ ���¸� json ���·� ���� ����
			JSONObject data =new JSONObject();
			
			//�÷���ü
			JSONObject col1 =new JSONObject();
			JSONObject col2 =new JSONObject();
			JSONObject col3 =new JSONObject();
			JSONArray title =new JSONArray();
			col1.put("label", "�����");
			col1.put("type", "string");
			col2.put("label", "�ߵ������Ǽ����");
			col2.put("type" , "number");

					
			title.add(col1);
			title.add(col2);
					
			data.put("cols", title);
			
			/*		
			"rows": [
				        {"c":[{"v":"Mushrooms"},{"v":3}]},
				        {"c":[{"v":"Onions"},{"v":1}]},
				       ]
				       
			rows : [ �迭 (��ü :�迭[��ü])]
			
			 */ 	

			//�� ����  ->  rows ��ü �� �迭  <- 
			//  <- [  c ��� ��ü�� �迭 <- ��ü
			//  data ��ü -> rows �迭 <-  c ��ü  ->�迭  <- v ��ü 2��/
			
			List<EmployeeVO> employeeList = employeeService.selectEmployeeAll();
			JSONArray  body =new JSONArray();
			for(EmployeeVO e : employeeList) {
				
				PerformanceManagementVO pmVO = new PerformanceManagementVO();
				pmVO = performancemanagementService.selectTerminationAVG(e.getEmpno());
				
//				System.out.println(employee.getCount());
				double cnt = 0;
				if(pmVO != null) {
					cnt = (pmVO.getAvg());
				} 
				
					
											
				JSONObject name =new JSONObject();
				name.put("v", e.getName()); //��ǰ�̸� -> v ��ü 
				JSONObject price =new JSONObject();
				price.put("v", cnt); //���� ->v ��ü
				
				//  v��ü�� row �迭�� ������ �߰��Ѵ�.
				JSONArray row =new JSONArray();
				row.add(name);
				row.add(price);
				
				//   c ��ü �� ������ row �迭�� ��´�.
				JSONObject c =new JSONObject();
				c.put("c", row);		
				// c ��ü�� �迭 ������ body �� ��´�.
				body.add(c);
			}
			
			// �迭 ������ body �� rows Ű������ ��ü data �� ��´�.
			data.put("rows", body);
			
			try{
				 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
			}catch (Exception e) {
				System.out.println(" ����            -- ");
				entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
			}
			
			return entity;
		}
	
	
	
	
	@RequestMapping("manageEmployeeOfPerformance")
	public ModelAndView manageEmployeeOfPerformance() {
		
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		employeeList = employeeService.selectEmployeeAll();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String strdate = sdf.format(date);
		ModelAndView mav = new ModelAndView("employee/manageEmployeeOfPerformance");
		mav.addObject("employeeList",  employeeList);
		mav.addObject("MM", strdate);
		return mav;
	}
	
	@PostMapping("insertPerformanceManagement")
	public String insertPerformanceManagement(@Valid PerformanceManagementVO pmVO, BindingResult result) {
		
		System.out.println(pmVO.getDate());
		performancemanagementService.insertPerformanceManagement(pmVO);
		
		if(result.hasErrors()) {
			System.out.println("�����߻�!!!...");
			return "/employee/manageEmployeeOfPerformance";
		}
		
		return "/employee/manageEmployeeOfPerformance";
	}
	
	@RequestMapping("chatting")
	public String chatting() {
		return "/chatting/chatting";
	}
}
