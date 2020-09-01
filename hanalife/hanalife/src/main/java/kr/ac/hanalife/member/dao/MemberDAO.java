package kr.ac.hanalife.member.dao;

import java.util.List;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

public interface MemberDAO {
	
	/**
	 * 고객 로그인을 하게 하는 기능
	 * @param member 화면에서 입력하는 member정보
	 * @return DB에 저장되어있는 member정보
	 */
	MemberVO login(MemberVO member);
	
	/**
	 * 회원가입을 하게 하는 기능
	 * @param 가입 입력 정보
	 */
	void signUp(MemberVO member);
	
	/**
	 * 고객번호를 생성하기 위한 기능
	 * @return DB에 있는 기존 고객 번호들
	 */
	List<MemberVO> membercusno();
	
	/**
	 * 아이디 중복체크를 위한 기능
	 * @param id 입력하는 아이디
	 * @return 아이디가 있는 member, 없으면 null
	 */
	MemberVO checkid(String id);
	
	/**
	 * My Page에서 자신의 프로필 정보를 볼 수 있는 기능
	 * @param 접속해 있는 loginVO의 id
	 * @return loginVO의 전체 정보
	 */
	MemberVO myPageProfile(String id);
	
	/**
	 * My Page에서 자신의 담당사원을 확인할 수 있는 기능
	 * @param 해당고객을 담당하고 있는 사원의 사원번호
	 * @return 고객에게 배정된 담당 사원
	 */
	EmployeeVO myChargedStaff(int empno);

}
