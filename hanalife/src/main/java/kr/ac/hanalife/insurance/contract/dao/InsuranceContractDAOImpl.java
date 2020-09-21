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

	@Override
	public void terminationContract(int ic_serialno) {
		sqlSession.delete("insurance.contract.dao.InsuranceContractDAO.terminationContract", ic_serialno);
	}

	@Override
	public InsuranceContractVO InsuranceMyOneContract(int no) {
		return sqlSession.selectOne("insurance.contract.dao.InsuranceContractDAO.InsuranceMyOneContract", no);
	}

	@Override
	public void insertInsuranceContract(InsuranceContractVO icVO) {
		sqlSession.insert("insurance.contract.dao.InsuranceContractDAO.insertInsuranceContract", icVO);
	}

	@Override
	public List<InsuranceContractVO> selectEntireContract() {
		return sqlSession.selectList("insurance.contract.dao.InsuranceContractDAO.selectEntireContract");
	}
	
	
}
