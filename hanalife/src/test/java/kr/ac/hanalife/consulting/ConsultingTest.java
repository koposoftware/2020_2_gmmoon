package kr.ac.hanalife.consulting;

import static org.junit.Assert.assertFalse;
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
import kr.ac.hanalife.consulting.reply.vo.ConsultingReplyVO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.util.PagingVO;

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
	
	@Ignore
	@Test
	public void ��㳻����ȣ��ü��ȸ�׽�Ʈ() throws Exception {
		
		List<ConsultingVO> list = new ArrayList<>();
		
		list = consultingDAO.inqueryNumberConsulting();
		
		assertNotNull(list);
	}
	
	@Ignore
	@Test
	public void ��㳻������Է��׽�Ʈ() throws Exception {
		
		ConsultingReplyVO csrVO = new ConsultingReplyVO();
		
		csrVO.setCs_serialno(1000000011);
		csrVO.setEmpno(71234);
		csrVO.setCusno(10001);
		csrVO.setName("������");
		csrVO.setType("�湮��㿹��");
		csrVO.setContent("������ ��¥����� ���½��ϴ�. �̸� Ȯ���Ͻ÷��� �̸����� Ȯ�����ּ���");
		
		consultingDAO.replyConsulting(csrVO);
		
	}
	
	@Ignore
	@Test
	public void ��㳻����ȣ����ȸ�׽�Ʈ() throws Exception {
		
		ConsultingVO csVO = consultingDAO.inqueryOneConsulting(1000000002);
		System.out.println(csVO.getName());
		System.out.println(csVO.getContent());
		
		assertNotNull(consultingDAO.inqueryOneConsulting(1000000002));
	}
	
	@Ignore
	@Test
	public void ��㳻����ȣ��������������׽�Ʈ() throws Exception {
		
		ConsultingVO csVO = consultingDAO.existConsultingReply(1000000005);
		
		System.out.println(csVO.getNo());
		
		assertNotNull(csVO);
		
		
	}
	
	@Ignore
	@Test
	public void ��㳻�������ȸ�׽�Ʈ() throws Exception {
		
		ConsultingReplyVO csrVO = consultingDAO.inqueryReplyConsulting(1000000005);
		
		assertNotNull(csrVO);
	}
	
	@Ignore
	@Test
	public void ��������Խñ۰���() throws Exception {
		
		int cnt = consultingDAO.countBoard(71236);
		System.out.println(cnt);
		assertNotNull(cnt);
	}
	
	@Ignore
	@Test
	public void ��������Խñ�����¡ó���׽�Ʈ() throws Exception {
		
		List<ConsultingVO> list = new ArrayList<>();
		
		PagingVO pgVO = new PagingVO();
		
		pgVO.setEmpno(71234);
		pgVO.setStart(0);
		pgVO.setEnd(5);
		
		list = consultingDAO.selectPageConsulting(pgVO);
		
		for(ConsultingVO c : list) {
			System.out.println(c.getRn());
			System.out.println(c.getName());
			System.out.println(c.getCsdate());
		}
		
		boolean b = list.isEmpty();
		assertFalse(b);
	}
}
