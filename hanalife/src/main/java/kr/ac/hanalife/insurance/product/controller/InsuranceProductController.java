package kr.ac.hanalife.insurance.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.insurance.product.service.InsuranceProductService;
import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;

@Controller
public class InsuranceProductController {
	
	@Autowired
	private InsuranceProductService insuranceProductService;
	
	@RequestMapping("/productDetail/{code}")
	public ModelAndView productDetail(@PathVariable("code") String code) {
		
		InsuranceProductVO ipVO = insuranceProductService.searchProduct(code);
		
		ModelAndView mav = new ModelAndView("insuranceproduct/productDetail");
		mav.addObject("ipVO",ipVO);
		
		return mav;
	}
}
