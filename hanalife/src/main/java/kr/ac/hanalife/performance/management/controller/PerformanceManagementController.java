package kr.ac.hanalife.performance.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
