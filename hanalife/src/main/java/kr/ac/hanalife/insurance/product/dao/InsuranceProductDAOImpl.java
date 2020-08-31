package kr.ac.hanalife.insurance.product.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;

@Repository
public class InsuranceProductDAOImpl implements InsuranceProductDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public InsuranceProductVO searchProduct(String code) {

		 InsuranceProductVO ipVO = new InsuranceProductVO();
		 
		 ipVO = sqlSession.selectOne("insurance.product.dao.InsuranceProductDAO.searchProduct", code);
		
		 return ipVO;
	}
	
	
}
