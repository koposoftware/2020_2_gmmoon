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
	public void 사원로그인테스트() throws Exception {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO.setEmpno(71236);
		employeeVO.setId("hana1236");
		employeeVO.setPassword("1111");
				
		assertNotNull(employeeDAO.loginEmployee(employeeVO));
	}
	
	@Ignore
	@Test
	public void 담당하는고객리스트조회테스트() throws Exception {
		List<MemberVO> list = new ArrayList<>();
		
		list = employeeDAO.myChargingCustomer(71234);
		
		if(list == null) {
			System.out.println("객체가 존재하지 않습니다");
		}
		
		for(MemberVO mv : list) {
			System.out.println(mv.getName());
		}
		
		assertNotNull(list);
	}
	
	@Ignore
	@Test
	public void 담당하는고객상담내역리스트조회테스트() throws Exception {
		
		List<ConsultingVO> list = new ArrayList<>();
		
		list = employeeDAO.selectConsulting(71234);
		
		assertNotNull(list);
	}
	
}
