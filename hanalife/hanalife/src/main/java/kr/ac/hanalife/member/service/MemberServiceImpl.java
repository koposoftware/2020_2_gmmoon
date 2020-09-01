package kr.ac.hanalife.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.dao.MemberDAO;
import kr.ac.hanalife.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO loginMember(MemberVO member) {
		return memberDAO.login(member);
	}
	
	@Transactional
	@Override
	public void signUpMember(MemberVO member) {
		
		List<MemberVO> list = new ArrayList<>();
		list = memberDAO.membercusno();
		
		MemberVO checkmember = list.get(list.size() - 1);
		member.setCusno(checkmember.getCusno() + 1);
		
		memberDAO.signUp(member);
	}

	@Override
	public List<MemberVO> membercusno() {
		return memberDAO.membercusno();
	}

	@Override
	public MemberVO checkid(String id) {
		return memberDAO.checkid(id);
	}

	@Override
	public MemberVO myPageProfileMember(String id) {
		return memberDAO.myPageProfile(id);
	}

	@Override
	public EmployeeVO myChargedStaff(int empno) {
		return memberDAO.myChargedStaff(empno);
	}
		
	
}
