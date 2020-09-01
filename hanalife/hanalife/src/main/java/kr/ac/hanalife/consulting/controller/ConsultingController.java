package kr.ac.hanalife.consulting.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.consulting.service.ConsultingService;
import kr.ac.hanalife.consulting.vo.ConsultingVO;

@Controller
public class ConsultingController {
	
	@Autowired
	private ConsultingService consultingService;
	
	@GetMapping("inqueryConsulting/{cusno}")
	public ModelAndView inqueryConsulting(@PathVariable("cusno") int cusno){
		
		List<ConsultingVO> consultinglist = new ArrayList<ConsultingVO>();
		
		consultinglist = consultingService.inqueryConsultingCustomer(cusno);
		ModelAndView mav = new ModelAndView("consultingboard/inqueryConsulting");
		mav.addObject("consultinglist", consultinglist);
		
		return mav;
	}
	
	@GetMapping("/insertConsulting")
	public String insertConsultingForm() {
		return "/consultingboard/insertConsulting";
	}
	
	@PostMapping("insertConsulting")
	public String insertConsulting(@Valid ConsultingVO csVO, BindingResult result) {
		
		consultingService.insertConsultingCustomer(csVO);
		
		if(result.hasErrors()) {
			System.out.println("오류발생!!!...");
			return "/consultingboard/insetConsulting";
		}
		
		return "/mypage/myPage";
	}
}
