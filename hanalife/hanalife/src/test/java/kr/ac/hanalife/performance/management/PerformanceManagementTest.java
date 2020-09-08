package kr.ac.hanalife.performance.management;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void ���������������Ʈ��ȸ�׽�Ʈ() throws Exception {
		
		List<PerformanceManagementVO> list = new ArrayList<>();
		
		list = performancemanagementDAO.selectPerformanceManagement(71234);
		
		boolean b = list.isEmpty();
		System.out.println(b);
		
		assertFalse(b);
	}
	
	@Ignore
	@Test
	public void ����ܱ�����������ȸ�׽�Ʈ() throws Exception {
		
		PerformanceManagementVO pmVO = new PerformanceManagementVO();
		
		pmVO = performancemanagementDAO.shortContractManagementAVG(71234);
		
		System.out.println(pmVO.getAvg());
		assertNotNull(pmVO);
	
	}
	
	@Ignore
	@Test
	public void ������ʰ����������ȸ�׽�Ʈ() throws Exception {
		
		PerformanceManagementVO pmVO = new PerformanceManagementVO();
		pmVO = performancemanagementDAO.longContractManagementAVG(71235);
		
		System.out.println(pmVO.getAvg());
		assertNotNull(pmVO);
	}
	
	@Ignore
	@Test
	public void �븮�����ǥ��ȸ�׽�Ʈ() throws Exception {
		PerformanceManagementVO pmVO = new PerformanceManagementVO();
		pmVO = performancemanagementDAO.selectTerminationAVG(71235);
		
		System.out.println(pmVO.getAvg());
		assertNotNull(pmVO);
	}
	
	@Ignore
	@Test
	public void ���������Է��׽�Ʈ() throws Exception {
		PerformanceManagementVO pmVO = new PerformanceManagementVO();
		pmVO.setEmpno(71234);
		String strDate = "2020-09-07";
		java.sql.Date date = java.sql.Date.valueOf(strDate);
		System.out.println(date);
		pmVO.setDate(strDate);
//		pmVO.setContractManagement("90");
//		pmVO.setContractRecruiting("80");
//		pmVO.setAgencyManagement("20");
		
		performancemanagementDAO.insertPerformanceManagement(pmVO);
	}
}
