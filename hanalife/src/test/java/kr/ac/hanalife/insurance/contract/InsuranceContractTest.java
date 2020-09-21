package kr.ac.hanalife.insurance.contract;

import static org.junit.Assert.assertNotNull;
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
	public void �����ฮ��Ʈ��ȸ�׽�Ʈ() throws Exception {
		
		List<InsuranceContractVO> list = new ArrayList<InsuranceContractVO>();
		
		list = insurancecontractDAO.selectInsuranceContract(71234);
		
		boolean b = list.isEmpty();
//		System.out.println(b);
		
		/*
		 * List�� assertNotNull�� üũ���� ��, <[]> ���·� ����
		 * ����, list ��ü�� �Լ��� isEmpty() �޼ҵ� ���
		 * list�ȿ� �ƹ��͵� ������ True, �ƴϸ� false�� ��ȯ
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
	public void �����ڽ��Ǻ����ฮ��Ʈ��ȸ�׽�Ʈ() {
		
		List<InsuranceContractVO> list = new ArrayList<InsuranceContractVO>();
		
		list = insurancecontractDAO.selectInsuranceMyContract(10001);
		
		for(InsuranceContractVO c : list) {
			System.out.println(c.getName() + " : " + c.getBeneficiary());
		}
	}
	
	@Ignore
	@Test
	public void �����������׽�Ʈ() throws Exception {
		insurancecontractDAO.terminationContract(1000000009);
	}
	
	@Ignore
	@Test
	public void �������ǰ��ȸ�׽�Ʈ() throws Exception {
		
		InsuranceContractVO icVO = insurancecontractDAO.InsuranceMyOneContract(1000000003);
		
		assertNotNull(icVO);
	}
	
	@Ignore
	@Test
	public void �����ǰ�����׽�Ʈ() throws Exception {
		
		InsuranceContractVO icVO = new InsuranceContractVO();
		
		List<InsuranceContractVO> list = insurancecontractDAO.selectEntireContract();
		int no = list.get(list.size() - 1).getNo() + 1;
		
		icVO.setNo(no);
		icVO.setEmpno(11111);
		icVO.setCusno(10012);
		icVO.setName("���ϳ�");
		icVO.setCode("B001");
		icVO.setJoin("2020-09-12");
		icVO.setMaturity("2040-09-12");
		icVO.setTermination("2040-09-12");
		icVO.setBeneficiary("���ٴ�");
		
		insurancecontractDAO.insertInsuranceContract(icVO);
	}
	
	@Ignore
	@Test
	public void �������Ϸù�ȣ��ü��ȸ�׽�Ʈ() throws Exception {
		 
		List<InsuranceContractVO> list = insurancecontractDAO.selectEntireContract();
		
		for(InsuranceContractVO c : list) {
			System.out.println(c.getNo());
		}
		System.out.println(list.get(list.size() - 1).getNo() + 1);
	}
}
