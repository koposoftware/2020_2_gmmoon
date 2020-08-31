package kr.ac.hanalife.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.dao.EmployeeDAO;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public EmployeeVO loginEmployee(EmployeeVO employeeVO) {
		return employeeDAO.loginEmployee(employeeVO);
	}

	@Override
	public List<MemberVO> myChargingCustomer(int empno) {
		return employeeDAO.myChargingCustomer(empno);
	}

	@Override
	public List<ConsultingVO> selectConsultingCustomer(int empno) {
		return employeeDAO.selectConsulting(empno);
	}
	
	
	
}
