package kr.ac.hanalife.member.dao;

import java.util.ArrayList;
import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
//	private static int cusno = 10012;
	
	@Override
	public MemberVO login(MemberVO member) {
		
		MemberVO loginVO = sqlSession.selectOne("member.dao.MemberDAO.login", member);
		
		return loginVO;
	}

	@Override
	public void signUp(MemberVO member) {
		
		member.setEmpno(11111);
	
		sqlSession.insert("member.dao.MemberDAO.signUp", member);
		
	}

	@Override
	public List<MemberVO> membercusno() {
		
		List<MemberVO> list = new ArrayList<>();
		
		list = sqlSession.selectList("member.dao.MemberDAO.membercusno");
		
		return list;
	}

	@Override
	public MemberVO checkid(String id) {
		
		MemberVO member = sqlSession.selectOne("member.dao.MemberDAO.checkid", id);
		
		return member;
	}

	@Override
	public MemberVO myPageProfile(String id) {
		
		MemberVO member = sqlSession.selectOne("member.dao.MemberDAO.myPageProfile", id);
		
		return member;
	}

	@Override
	public EmployeeVO myChargedStaff(int empno) {
		
		EmployeeVO employee = sqlSession.selectOne("member.dao.MemberDAO.myChargedStaff",empno);
		
		return employee;
	}

	@Override
	public MemberVO selectByCusno(int cusno) {
		return sqlSession.selectOne("member.dao.MemberDAO.selectByCusno",cusno);
	}

	@Override
	public void modifyMyInfo(MemberVO member) {
		sqlSession.update("member.dao.MemberDAO.modifyMyInfo", member);
	}

	@Override
	public void deleteMyInfo(MemberVO member) {
		sqlSession.delete("member.dao.MemberDAO.deleteMyInfo", member);
	}

	@Override
	public MemberVO authentication(MemberVO member) {
		return sqlSession.selectOne("member.dao.MemberDAO.authentication", member);
	}

	
	
	
		
}
