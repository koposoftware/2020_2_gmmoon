package kr.ac.hanalife.consulting;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.hanalife.consulting.dao.ConsultingDAO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class ConsultingTest {
	
	@Autowired
	private ConsultingDAO consultingDAO;
	
	@Ignore
	@Test
	public void ��㳻���Խ�����ȸ�׽�Ʈ() throws Exception{
		
		List<ConsultingVO> list = new ArrayList<>();
		
		list = consultingDAO.inqueryConsulting(10001);
		
		assertNotNull(list);
		
	}
	
	@Ignore
	@Test
	public void ��㳻������׽�Ʈ() throws Exception {
		
		ConsultingVO csVO = new ConsultingVO();
		
		csVO.setNo(1000000011);
		csVO.setEmpno(71234);
		csVO.setCusno(10001);
		csVO.setName("������");
		csVO.setType("���蹮��");
		csVO.setContent("���ο� ���� ���Ǹ� �ϰ� �ͽ��ϴ�");
		
		consultingDAO.insertConsulting(csVO);
	}
	
	@Test
	public void ��㳻����ȣ��ü��ȸ�׽�Ʈ() throws Exception {
		
		List<ConsultingVO> list = new ArrayList();
		
		list = consultingDAO.inqueryNumberConsulting();
		
		assertNotNull(list);
	}
}
