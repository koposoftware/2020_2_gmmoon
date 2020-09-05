package kr.ac.hanalife.consulting.dao;

import java.util.List;

import kr.ac.hanalife.consulting.reply.vo.ConsultingReplyVO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;

public interface ConsultingDAO {
	
	/**
	 * ��㳻���� �� �� �ִ� ���
	 * @param cusno ���� ����ȣ
	 * @return ��� ���� ����Ʈ
	 */
	List<ConsultingVO> inqueryConsulting(int cusno);
	
	/**
	 * ����ȣ�� �ش��ϴ� ��㳻�� ��ȸ ���
	 * @param no ����ȣ
	 * @return ��㳻��
	 */
	ConsultingVO inqueryOneConsulting(int no);
	
	/**
	 * ��㳻�� ��� ����
	 * @param csVO Ȩ���������� �Է��� ����
	 */
	void insertConsulting(ConsultingVO csVO);
	
	/**
	 * ��� ���� ��ü�� �� �� �ִ� ����
	 * @return
	 */
	List<ConsultingVO> inqueryNumberConsulting();
	
	/**
	 * ��㳻���� ���� ����� �� �� �ִ� ���
	 * @param csrVO ��㳻���� �� ��۳���
	 */
	void replyConsulting(ConsultingReplyVO csrVO);
}
