package kr.ac.hanalife.insurance.contract.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;

@Repository
public class InsuranceContractDAOImpl implements InsuranceContractDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<InsuranceContractVO> selectInsuranceContract(int empno) {
		return sqlSession.selectList("insurance.contract.dao.InsuranceContractDAO.selectInsuranceContract", empno);
	}

	@Override
	public List<InsuranceContractVO> selectInsuranceMyContract(int cusno) {
		return sqlSession.selectList("insurance.contract.dao.InsuranceContractDAO.selectInsuranceMyContract", cusno);
	}
	
	
}
