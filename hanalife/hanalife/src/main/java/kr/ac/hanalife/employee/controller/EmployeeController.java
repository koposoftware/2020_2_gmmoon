package kr.ac.hanalife.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.service.EmployeeService;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

@SessionAttributes({"employee","employeeList"})
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
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
	public ModelAndView selectConsultingCustomer(HttpSession session) {
		
		List<ConsultingVO> consultingList = new ArrayList<>();
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		ModelAndView mav = new ModelAndView("employee/consultingService");
		
		int empno = employee.getEmpno();
		
		consultingList = employeeService.selectConsultingCustomer(empno);
		
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
	
}
