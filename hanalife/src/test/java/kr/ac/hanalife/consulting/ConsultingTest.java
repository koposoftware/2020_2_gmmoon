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
import kr.ac.hanalife.consulting.reply.vo.ConsultingReplyVO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class ConsultingTest {
	
	@Autowired
	private ConsultingDAO consultingDAO;
	
	@Ignore
	@Test
	public void 상담내역게시판조회테스트() throws Exception{
		
		List<ConsultingVO> list = new ArrayList<>();
		
		list = consultingDAO.inqueryConsulting(10001);
		
		assertNotNull(list);
		
	}
	
	@Ignore
	@Test
	public void 상담내역등록테스트() throws Exception {
		
		ConsultingVO csVO = new ConsultingVO();
		
		csVO.setNo(1000000011);
		csVO.setEmpno(71234);
		csVO.setCusno(10001);
		csVO.setName("구재희");
		csVO.setType("보험문의");
		csVO.setContent("새로운 보험 문의를 하고 싶습니다");
		
		consultingDAO.insertConsulting(csVO);
	}
	
	@Ignore
	@Test
	public void 상담내역번호전체조회테스트() throws Exception {
		
		List<ConsultingVO> list = new ArrayList();
		
		list = consultingDAO.inqueryNumberConsulting();
		
		assertNotNull(list);
	}
	
	@Ignore
	@Test
	public void 상담내역댓글입력테스트() throws Exception {
		
		ConsultingReplyVO csrVO = new ConsultingReplyVO();
		
		csrVO.setCs_serialno(1000000011);
		csrVO.setEmpno(71234);
		csrVO.setCusno(10001);
		csrVO.setName("구재희");
		csrVO.setType("방문상담예약");
		csrVO.setContent("가능한 날짜목록을 보냈습니다. 이를 확인하시려면 이메일을 확인해주세요");
		
		consultingDAO.replyConsulting(csrVO);
		
	}
	
	@Ignore
	@Test
	public void 상담내역번호별조회테스트() throws Exception {
		
		ConsultingVO csVO = consultingDAO.inqueryOneConsulting(1000000002);
		System.out.println(csVO.getName());
		System.out.println(csVO.getContent());
		
		assertNotNull(consultingDAO.inqueryOneConsulting(1000000002));
	}
	
	@Ignore
	@Test
	public void 상담내역번호별답글존재유무테스트() throws Exception {
		
		ConsultingVO csVO = consultingDAO.existConsultingReply(1000000005);
		
		System.out.println(csVO.getNo());
		
		assertNotNull(csVO);
		
		
	}
	
	@Ignore
	@Test
	public void 상담내역답글조회테스트() throws Exception {
		
		ConsultingReplyVO csrVO = consultingDAO.inqueryReplyConsulting(1000000005);
		
		assertNotNull(csrVO);
	}
}
