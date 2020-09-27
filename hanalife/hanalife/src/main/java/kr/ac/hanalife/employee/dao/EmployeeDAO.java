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
	
	/**
	 * 사원의 회원가입 기능
	 * @param employeeVO 홈페이지에서 입력하는 사원의 정보
	 */
	void employeeSignUp(EmployeeVO employeeVO);
	
	/**
	 * 사원의 아이디 중복체크 기능
	 * @param eid 중복체크할 사원의 아이디
	 * @return 아이디에 따른 객체, 없으면 null
	 */
	EmployeeVO employeeCheckID(String eid);
	
	/**
	 * 사원리스트(대리,사원) 조회 기능, 추후에 부서별로 조회할 수 있도록
	 * '@param'으로 부서별 번호를 추가해준다
	 * @return 사원리스트
	 */
	List<EmployeeVO> selectEmployeeAll();
	
	
	/**
	 * 과장이상직원이 사원배정미정고객에게 사원을 배정해주는 기능
	 * @param member 배정될 사원 번호를 가진 고객정보
	 */
	void AssignCustomer(MemberVO member);
	
	/**
	 * 사원별 담당 고객 수를 조회하는 기능
	 * @param empno 사원번호
	 * @return 담당 고객 수
	 */
	EmployeeVO countEmployeeInCharge(int empno);
	
	/**
	 * 사원이 퇴사하는 기능
	 * @param employeeVO 퇴사할 사원 정보
	 */
	void withdrawalEmployee(EmployeeVO employeeVO);
	
}
