package kr.ac.hanalife.consulting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanalife.consulting.dao.ConsultingDAO;
import kr.ac.hanalife.consulting.reply.vo.ConsultingReplyVO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.util.PagingVO;

@Service
public class ConsultingServiceImpl implements ConsultingService {
	
	@Autowired
	private ConsultingDAO consultingDAO;

	@Override
	public List<ConsultingVO> inqueryConsultingCustomer(int cusno) {
		return consultingDAO.inqueryConsulting(cusno);
	}

	@Override
	public void insertConsultingCustomer(ConsultingVO csVO) {
		
		List<ConsultingVO> list = new ArrayList<ConsultingVO>();
		list = consultingDAO.inqueryNumberConsulting();
		
		ConsultingVO check_csVO = list.get(list.size()-1);
		csVO.setNo(check_csVO.getNo() + 1);
		
		consultingDAO.insertConsulting(csVO);
	}

	@Override
	public List<ConsultingVO> inqeuryNumberConsultingCustomer() {
		return consultingDAO.inqueryNumberConsulting();
	}

	@Override
	public void replyConsulting(ConsultingReplyVO csrVO) {
		consultingDAO.replyConsulting(csrVO);
	}

	@Override
	public ConsultingVO inqueryOneConsulting(int no) {
		return consultingDAO.inqueryOneConsulting(no);
	}

	@Override
	public ConsultingVO existConsultingReply(int cs_serialno) {
		return consultingDAO.existConsultingReply(cs_serialno);
	}

	@Override
	public ConsultingReplyVO inqueryReplyConsulting(int cs_serialno) {
		return consultingDAO.inqueryReplyConsulting(cs_serialno);
	}

	@Override
	public int countBoard(int empno) {
		return consultingDAO.countBoard(empno);
	}

	@Override
	public List<ConsultingVO> selectPageConsulting(PagingVO pgVO) {
		return consultingDAO.selectPageConsulting(pgVO);
	}
	
	
	
}
