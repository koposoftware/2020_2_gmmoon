package kr.ac.hanalife.employee.dao;

import java.util.List;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

public interface EmployeeDAO {
	
	/**
	 * 사원 로그인을 하게 하는 기능
	 * @param employeeVO 화면에서 입력하는 employee 정보
	 * @return DB에 저장되어있는 employee정보
	 */
	EmployeeVO loginEmployee(EmployeeVO employeeVO);
	
	/**
	 * 사원이 담당하는 고객리스트를 조회하는기능
	 * @param empno 사원의 사원번호
	 * @return 사원이 담당하는 고객리스트
	 */
	List<MemberVO> myChargingCustomer(int empno);
	
	/**
	 * 사원이 담당하는 고객의 상담내역을 조회하는 기능
	 * @param empno 사원의 사원번호
	 * @return 사원이 담당하는 고객의 상담내역리스트
	 */
	List<ConsultingVO> selectConsulting(int empno);
	
}
