package kr.ac.hanalife.member.service;

import java.util.List;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

public interface MemberService {
	
	MemberVO loginMember(MemberVO member);
	
	void signUpMember(MemberVO member);
	
	List<MemberVO> membercusno();
	
	MemberVO checkid(String id);
	
	MemberVO myPageProfileMember(String id);
	
	EmployeeVO myChargedStaff(int empno);
	
	MemberVO selectByCusno(int cusno);
}
