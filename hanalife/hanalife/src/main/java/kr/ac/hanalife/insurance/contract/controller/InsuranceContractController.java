package kr.ac.hanalife.insurance.contract.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.insurance.contract.service.InsuranceContractService;
import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;
import kr.ac.hanalife.insurance.product.service.InsuranceProductService;
import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;
import kr.ac.hanalife.member.service.MemberService;
import kr.ac.hanalife.member.vo.MemberVO;

@Controller
public class InsuranceContractController {
	
	@Autowired
	private InsuranceContractService insurancecontractService;
	
	@Autowired
	private InsuranceProductService insuranceproductService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("insuranceContractService")
	public ModelAndView selectInsuranceContract(HttpSession session) {
		
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		int empno = employee.getEmpno();
		
		List<InsuranceContractVO> insuranceContractList = new ArrayList<>();
		insuranceContractList = insurancecontractService.selectInsuranceContract(empno);

		String date = "";
		for(InsuranceContractVO icVO : insuranceContractList) {
			date = icVO.getJoin();
			icVO.setJoin(date.substring(0, 10));
			date = icVO.getMaturity();
			icVO.setMaturity(date.substring(0, 10));
			date = icVO.getTermination();
			icVO.setTermination(date.substring(0, 10));
		}
		
		ModelAndView mav = new ModelAndView("employee/insuranceContractService");
		mav.addObject("insuranceContractList",insuranceContractList);
		
		return mav;
	}
	
	@RequestMapping("insuranceContract/{code}")
	public ModelAndView insuranceContract(HttpSession session, @PathVariable("code") String code) {
		
		
		ModelAndView mav = new ModelAndView("insuranceproduct/insuranceContract");
		mav.addObject("code", code);		
		
		return mav;
	}
	
	@GetMapping("insuranceTermination")
	public ModelAndView insuranceTermination(HttpSession session) {
		
		int ic_serialno = (int)session.getAttribute("check");
		ModelAndView mav = new ModelAndView("insurancecontract/insuranceTermination");
		InsuranceContractVO icVO = insurancecontractService.InsuranceMyOneContract(ic_serialno);
		
		String ipcode = icVO.getCode();
		InsuranceProductVO ipVO = insuranceproductService.searchProduct(ipcode);
		
		mav.addObject("icVO", icVO);
		mav.addObject("ipVO", ipVO);
		
		return mav;
	}
	
	@PostMapping("insuranceContractTermination")
	public String insuranceContractTermination(@Valid MemberVO member, @Valid int ic_serialno, BindingResult result, 
												HttpServletRequest request) {
		
		MemberVO loginVO = memberService.loginMember(member);


		if(loginVO != null) {
			
			insurancecontractService.terminationContract(ic_serialno);
			
			if(result.hasErrors()) {
				System.out.println("오류발생!!!...");
				return "/mypage/myPage";
			}
			System.out.println("보험해지가 성공적으로 됐습니다");
			return "redirect:/myPage";
		
		} else {
			System.out.println("입력오류...");
			return "redirect:/myPage";
		}
						
	}
	
	@GetMapping("insuranceContractForm")
	public String insuranceContractForm() {
		return "insuranceproduct/insuraceContractForm";
	}
	
	@PostMapping("insuranceContractForm")
	public String insuranceContractFormProcess(@Valid InsuranceContractVO icVO, BindingResult result) {
		
		List<InsuranceContractVO> list = insurancecontractService.selectEntireContract();
		int no = list.get(list.size() -1).getNo() + 1;
		icVO.setNo(no);
		
		//입력받은 가입일에 20년을 더해서 만기일 설정
		String today = icVO.getJoin();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		try {
			date = dateFormat.parse(today);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 20);
		String maturity = dateFormat.format(cal.getTime());
		
		//만기일과 해지일(초기값) 설정해주기
		icVO.setMaturity(maturity);
		icVO.setTermination(maturity);
		//test
		System.out.println(maturity);
		insurancecontractService.insertInsuranceContract(icVO);
		
		if(result.hasErrors()) {
			System.out.println("오류발생...");
			return "redirect:/insuranceContract";
		}
		
		return "mypage/myPage";
	}
}
