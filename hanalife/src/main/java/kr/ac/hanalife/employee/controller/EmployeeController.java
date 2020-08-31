package kr.ac.hanalife.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.service.EmployeeService;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

@SessionAttributes({"employee"})
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
	
	
}
