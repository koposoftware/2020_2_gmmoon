package kr.ac.hanalife.insurance.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void 보험계약리스트조회테스트() throws Exception {
		
		List<InsuranceContractVO> list = new ArrayList<InsuranceContractVO>();
		
		list = insurancecontractDAO.selectInsuranceContract(71234);
		
		boolean b = list.isEmpty();
//		System.out.println(b);
		
		/*
		 * List는 assertNotNull로 체크했을 떄, <[]> 형태로 나옴
		 * 따라서, list 자체에 함수인 isEmpty() 메소드 사용
		 * list안에 아무것도 없으면 True, 아니면 false를 반환
		 */
		
		
		
		for(InsuranceContractVO icVO : list  ) {
		
			String test = icVO.getJoin();
			String t = test.substring(0, 10);
	
			System.out.println(t);
			System.out.println(test.length());
		}
		
		assertTrue(b);
	}
	
	@Ignore
	@Test
	public void 고객이자신의보험계약리스트조회테스트() {
		
		List<InsuranceContractVO> list = new ArrayList<InsuranceContractVO>();
		
		list = insurancecontractDAO.selectInsuranceMyContract(10001);
		
		for(InsuranceContractVO c : list) {
			System.out.println(c.getName() + " : " + c.getBeneficiary());
		}
	}
}
