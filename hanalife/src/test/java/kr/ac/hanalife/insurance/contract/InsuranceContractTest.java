package kr.ac.hanalife.insurance.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.hanalife.insurance.contract.dao.InsuranceContractDAO;
import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class InsuranceContractTest {
	
	@Autowired
	private InsuranceContractDAO insurancecontractDAO;
	
	@Test
	public void 보험계약리스트조회테스트() throws Exception {
		
		List<InsuranceContractVO> list = new ArrayList<InsuranceContractVO>();
		
		list = insurancecontractDAO.selectInsuranceContract(71234);
		
		boolean b = list.isEmpty();
		System.out.println(b);
		
		assertTrue(b);
	}
}
