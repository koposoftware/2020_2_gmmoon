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
			employee.setId("없는아이디");
					
			session.setAttribute("employee", employee);
			status.setComplete();
			mav.setViewName("redirect:/employeelogin");
					
		}
		
		//로그인 성공
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
			System.out.println("오류발생!!!...");
			return "/signup/employeeSignUp";
		}
		
		return "/login/employeeLogin";
	}
	
	@GetMapping("/employeeSignUp/checkid")
	@ResponseBody
	public int checkid(@RequestParam("cid") String cid, HttpSession session) {
		
		EmployeeVO checkemployee = employeeService.employeeCheckID(cid);
		
		if(checkemployee == null) {
			System.out.println("아이디를 가진 객체가 없습니다");
			return 0;
		} else {
			System.out.println("아이디를 가진 객체가 존재합니다");
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
	
	@GetMapping("assignCustomer")
	public int assignCustomer() {
		return 0;
	}
	
}
