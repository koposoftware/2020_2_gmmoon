package kr.ac.hanalife.employee.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public EmployeeVO loginEmployee(EmployeeVO employeeVO) {
		return sqlSession.selectOne("employee.dao.EmployeeDAO.loginEmployee",employeeVO);
	}

	@Override
	public List<MemberVO> myChargingCustomer(int empno) {
		return sqlSession.selectList("employee.dao.EmployeeDAO.myChargingCustomer", empno);
	}

	@Override
	public List<ConsultingVO> selectConsulting(int empno) {
		return sqlSession.selectList("consulting.dao.ConsultingDAO.selectConsulting", empno);
	}

	@Override
	public void employeeSignUp(EmployeeVO employeeVO) {
		sqlSession.insert("employee.dao.EmployeeDAO.employeeSignUp", employeeVO);
	}

	@Override
	public EmployeeVO employeeCheckID(String eid) {
		return sqlSession.selectOne("employee.dao.EmployeeDAO.employeeCheckID", eid);
	}

	@Override
	public List<EmployeeVO> selectEmployeeAll() {
		return sqlSession.selectList("employee.dao.EmployeeDAO.selectEmployeeAll");
	}

	@Override
	public void AssignCustomer(int empno) {
		sqlSession.update("employee.dao.EmployeeDAO.AssignCustomer", empno);
		
	}
		
		
}
