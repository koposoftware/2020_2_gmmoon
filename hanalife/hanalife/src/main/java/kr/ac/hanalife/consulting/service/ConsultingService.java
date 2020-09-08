package kr.ac.hanalife.consulting.service;

import java.util.List;

import kr.ac.hanalife.consulting.reply.vo.ConsultingReplyVO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.util.PagingVO;

public interface ConsultingService {
	
	List<ConsultingVO> inqueryConsultingCustomer(int cusno);
	
	void insertConsultingCustomer(ConsultingVO csVO);
	
	List<ConsultingVO> inqeuryNumberConsultingCustomer();
	
	void replyConsulting(ConsultingReplyVO csrVO);
	
	ConsultingVO inqueryOneConsulting(int no);
	
	ConsultingVO existConsultingReply(int cs_serialno);
	
	ConsultingReplyVO inqueryReplyConsulting(int cs_serialno);
	
	public int countBoard(int empno);
	
	public List<ConsultingVO> selectPageConsulting(PagingVO pgVO);
}
