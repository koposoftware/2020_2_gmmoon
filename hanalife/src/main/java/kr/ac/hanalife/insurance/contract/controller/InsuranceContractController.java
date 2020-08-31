package kr.ac.hanalife.insurance.contract.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.insurance.contract.service.InsuranceContractService;
import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;

@Controller
public class InsuranceContractController {
	
	@Autowired
	private InsuranceContractService insurancecontractService;
	
	@RequestMapping("insuranceContractService")
	public ModelAndView selectInsuranceContract(HttpSession session) {
		
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		int empno = employee.getEmpno();
		
		List<InsuranceContractVO> insuranceContractList = new ArrayList<>();
		insuranceContractList = insurancecontractService.selectInsuranceContract(empno);
		
		ModelAndView mav = new ModelAndView("employee/insuranceContractService");
		mav.addObject("insuranceContractList",insuranceContractList);
		
		return mav;
	}
}
