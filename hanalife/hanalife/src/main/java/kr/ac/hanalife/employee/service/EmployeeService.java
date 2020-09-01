package kr.ac.hanalife.employee.service;

import java.util.List;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

public interface EmployeeService {
		
	EmployeeVO loginEmployee(EmployeeVO employeeVO);
	
	List<MemberVO> myChargingCustomer(int empno);
	
	List<ConsultingVO> selectConsultingCustomer(int empno);
	
	void employeeSignUp(EmployeeVO employeeVO);
	
	EmployeeVO employeeCheckID(String eid);
	
	List<EmployeeVO> selectEmployeeAll();
	
	void AssignCustomer(int empno);
}
