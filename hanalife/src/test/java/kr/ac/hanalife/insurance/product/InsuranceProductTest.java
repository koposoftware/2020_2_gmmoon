package kr.ac.hanalife.insurance.product;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.hanalife.insurance.product.dao.InsuranceProductDAOImpl;
import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/spring/*.xml"})
public class InsuranceProductTest {
	
	@Autowired
	private InsuranceProductDAOImpl insuranceproductDAO;
	
	@Test
	public void 보험상품정보검색테스트() throws Exception {
		
		InsuranceProductVO ipVO = new InsuranceProductVO();
		
		ipVO = insuranceproductDAO.searchProduct("A001");
		
		assertNotNull(ipVO);
		
	}
}
