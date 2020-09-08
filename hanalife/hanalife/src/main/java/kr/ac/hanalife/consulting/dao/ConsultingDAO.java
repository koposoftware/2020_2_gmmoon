package kr.ac.hanalife.consulting.dao;

import java.util.List;

import kr.ac.hanalife.consulting.reply.vo.ConsultingReplyVO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.util.PagingVO;

public interface ConsultingDAO {
	
	/**
	 * 상담내역을 볼 수 있는 기능
	 * @param cusno 고객의 고객번호
	 * @return 상담 내역 리스트
	 */
	List<ConsultingVO> inqueryConsulting(int cusno);
	
	/**
	 * 상담번호에 해당하는 상담내역 조회 기능
	 * @param no 상담번호
	 * @return 상담내역
	 */
	ConsultingVO inqueryOneConsulting(int no);
	
	/**
	 * 상담내용 등록 서비스
	 * @param csVO 홈페이지에서 입력한 내용
	 */
	void insertConsulting(ConsultingVO csVO);
	
	/**
	 * 상담 내역 전체를 볼 수 있는 서비스
	 * @return
	 */
	List<ConsultingVO> inqueryNumberConsulting();
	
	/**
	 * 상담내역에 대해 답글을 달 수 있는 기능
	 * @param csrVO 상담내역에 달 답글내역
	 */
	void replyConsulting(ConsultingReplyVO csrVO);
	
	/**
	 * 상담내역에 대한 답글이 있는지 조회한 후 answer에 답변 여후 세팅
	 * @param cs_serialno 조회하려는 상담내역번호
	 * @return 상담내역이 있는 답글 없으면 null
	 */
	ConsultingVO existConsultingReply(int cs_serialno);
	
	/**
	 * 상담내역에 대한 답글 조회 기능
	 * @param cs_serialno 조회하려난 상담내역답글
	 * @return 상담내역답글
	 */
	ConsultingReplyVO inqueryReplyConsulting(int cs_serialno);
	
	/**
	 * 사원이 담당하는 상담내역 갯수
	 * @param empno 해당 사원번호
	 * @return
	 */
	public int countBoard(int empno);
	
	/**
	 * 페이지 처리된 사원이 담당하는 상담내역 조회
	 * @param pgVO 페이징
	 * @return 사원이 담당하는 상담내역
	 */
	public List<ConsultingVO> selectPageConsulting(PagingVO pgVO);
}
