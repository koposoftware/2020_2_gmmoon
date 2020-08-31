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
	
	@Test
	public void 상담내역번호전체조회테스트() throws Exception {
		
		List<ConsultingVO> list = new ArrayList();
		
		list = consultingDAO.inqueryNumberConsulting();
		
		assertNotNull(list);
	}
}
