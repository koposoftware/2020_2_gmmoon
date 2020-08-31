package kr.ac.hanalife.employee;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.dao.EmployeeDAO;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class EmployeeTest {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Ignore
	@Test
	public void ����α����׽�Ʈ() throws Exception {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO.setEmpno(71236);
		employeeVO.setId("hana1236");
		employeeVO.setPassword("1111");
				
		assertNotNull(employeeDAO.loginEmployee(employeeVO));
	}
	
	@Ignore
	@Test
	public void ����ϴ°�����Ʈ��ȸ�׽�Ʈ() throws Exception {
		List<MemberVO> list = new ArrayList<>();
		
		list = employeeDAO.myChargingCustomer(71234);
		
		if(list == null) {
			System.out.println("��ü�� �������� �ʽ��ϴ�");
		}
		
		for(MemberVO mv : list) {
			System.out.println(mv.getName());
		}
		
		assertNotNull(list);
	}
	
	@Ignore
	@Test
	public void ����ϴ°���㳻������Ʈ��ȸ�׽�Ʈ() throws Exception {
		
		List<ConsultingVO> list = new ArrayList<>();
		
		list = employeeDAO.selectConsulting(71234);
		
		assertNotNull(list);
	}
	
}
