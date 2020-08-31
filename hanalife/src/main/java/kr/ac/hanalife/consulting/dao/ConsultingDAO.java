package kr.ac.hanalife.consulting.dao;

import java.util.List;

import kr.ac.hanalife.consulting.vo.ConsultingVO;

public interface ConsultingDAO {
	
	/**
	 * 상담내역을 볼 수 있는 기능
	 * @param cusno 고객의 고객번호
	 * @return 상담 내역 리스트
	 */
	List<ConsultingVO> inqueryConsulting(int cusno);
	
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
}
