package kr.ac.hanalife.employee;

import static org.junit.Assert.assertFalse;
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
	
	@Ignore
	@Test
	public void 사원회원가입테스트() throws Exception {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO.setEmpno(79999);
		employeeVO.setId("hana79999");
		employeeVO.setPassword("1111");
		employeeVO.setName("송하나");
		employeeVO.setRank("대리");
		employeeVO.setAge(21);
		employeeVO.setHp("010-2349-0861");
		employeeVO.setEmail("hana@naver.com");
		
		employeeDAO.employeeSignUp(employeeVO);
	}
	
	@Ignore
	@Test
	public void 사원아이디중복체크테스트() throws Exception {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO = employeeDAO.employeeCheckID("hana1234");
		
		assertNotNull(employeeVO);
	}
	
	@Ignore
	@Test
	public void 사원리스트조회기능테스트() throws Exception {
		
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		
		list = employeeDAO.selectEmployeeAll();
		
		boolean b = list.isEmpty();
		
		assertFalse(b);
	}
	
	@Ignore
	@Test
	public void 사원배정테스트() throws Exception {
		
		MemberVO member = new MemberVO();
		
		member.setEmpno(71235);
		member.setCusno(10014);
		
		employeeDAO.AssignCustomer(member);
	}
	
	@Test
	public void 사원이담당하는고객수조회테스트() throws Exception {
		
		EmployeeVO employee = new EmployeeVO();
		
		employee = employeeDAO.countEmployeeInCharge(71250);
//		System.out.println(employee.getEmpno());
//		System.out.println(employee.getCount());
		
		assertNull(employee);
	}
	
}
