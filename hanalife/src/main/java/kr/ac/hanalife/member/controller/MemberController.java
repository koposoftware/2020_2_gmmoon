package kr.ac.hanalife.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.service.MemberService;
import kr.ac.hanalife.member.vo.MemberVO;
@SessionAttributes({"loginVO","memberVO","employeeVO"}) 
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String loginForm() {
		return "/login/login";
	}
	
	
//	@RequestMapping(value="/login", method = RequestMethod.POST)
	@PostMapping("login")
	public ModelAndView login(MemberVO member, HttpSession session, SessionStatus status) {
		

		
		MemberVO loginVO = memberService.loginMember(member);
		ModelAndView mav = new ModelAndView();
		
		//�α��� ����
		if(loginVO == null) {
			// @SessionAttributes({"loginVO"})�� ����߱� ������ �ѹ� ä���, �������Ѵ�
			loginVO = new MemberVO();
			loginVO.setId("���¾��̵�");
			
			session.setAttribute("loginVO", loginVO);
			status.setComplete();
			mav.setViewName("redirect:/login");
			
		}
		
		//�α��� ����
		String dest = (String)session.getAttribute("dest");
		if(dest == null ) {
			
			mav.setViewName("redirect:/");
		} else {
			mav.setViewName("redirect:" + dest);
			session.removeAttribute("dest");
		}
		
		mav.addObject("loginVO", loginVO);
		
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
				
		status.setComplete(); 
				
		return "redirect:/";
	}
	
	@GetMapping("/signUp")
	public String signUpForm() {
		return "/signup/signUp";
	}
	
	@PostMapping("signUp")
	public String signUp(@Valid MemberVO member, BindingResult result) {
		
		memberService.signUpMember(member);
		
		if(result.hasErrors()) {
			System.out.println("�����߻�!!!...");
			return "/signup/signUp";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/signUp/checkid")
	@ResponseBody
	public int checkid(@RequestParam("cid") String cid, HttpSession session) {
		
		MemberVO checkmember = memberService.checkid(cid);
		
		if(checkmember == null) {
			System.out.println("���̵� ���� ��ü�� �����ϴ�");
			return 0;
		} else {
			System.out.println("���̵� ���� ��ü�� �����մϴ�");
			return 1;
		}
		
		
	}
	
	
	@RequestMapping("/myPage")
	public ModelAndView myPage(MemberVO loginVO, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		loginVO = (MemberVO)session.getAttribute("loginVO");
		EmployeeVO employeeVO = new EmployeeVO();
							
		String id = loginVO.getId();
		int	empno = loginVO.getEmpno();
		
		MemberVO memberVO = new MemberVO();
		
		memberVO = memberService.myPageProfileMember(id);
		employeeVO = memberService.myChargedStaff(empno);
		
		//session�� memberVO, employeeVO����
		session.setAttribute("memberVO", memberVO);
		session.setAttribute("employeeVO", employeeVO);
		
		ModelAndView mav = new ModelAndView("mypage/myPage");
		mav.addObject("memberVO", memberVO);
		mav.addObject("employeeVO", employeeVO);
		return mav;
	}
	
	@GetMapping("modifyInfo")
	public String modifyInfoForm() {
		return "/modifyinfo/modifyInfo";
	}
	
	@PostMapping("modifyInfo")
	public String modifyInfo(@Valid MemberVO member, BindingResult result) {
		
		memberService.modifyMyInfo(member);
		
		if(result.hasErrors()) {
			System.out.println("�����߻�!!!...");
			return "/modifyinfo/modifyInfo";
		}
		
		return "redirect:/myPage";
		
	}
	
	@GetMapping("withdrawalCustomer")
	public String withdrawalCustomerForm() {
		return "/withdrawal/withdrawalCustomer";
	}
	
	@PostMapping("withdrawalCustomer")
	public String withdrawalCustomer(@Valid MemberVO member, BindingResult result) {
		
		memberService.deleteMyInfo(member);
		
		if(result.hasErrors()) {
			System.out.println("�����߻�!!!...");
			return "/withdrawal/withdrawalCustomer";
		}
		
		return "redirect:/logout";
		
	}
	
	@RequestMapping("customerInfoCompany")
	public String customerInfoCompany() {
		return "/pageComponent/about";
	}
	
	@RequestMapping("about")
	public String about() {
		return "/pageComponent/about";
	}
	
	@RequestMapping("resource")
	public String resource() {
		return "/pageComponent/resource";
	}
}
