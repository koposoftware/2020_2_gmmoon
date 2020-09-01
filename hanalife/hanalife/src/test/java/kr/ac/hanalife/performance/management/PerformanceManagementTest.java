package kr.ac.hanalife.performance.management;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.hanalife.performance.management.dao.PerformanceManagementDAO;
import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class PerformanceManagementTest {
	
	@Autowired
	private PerformanceManagementDAO performancemanagementDAO;
	
	@Test
	public void 사원성과관리리스트조회테스트() throws Exception {
		
		List<PerformanceManagementVO> list = new ArrayList<>();
		
		list = performancemanagementDAO.selectPerformanceManagement(71234);
		
		boolean b = list.isEmpty();
		System.out.println(b);
		
		assertFalse(b);
	}
}
