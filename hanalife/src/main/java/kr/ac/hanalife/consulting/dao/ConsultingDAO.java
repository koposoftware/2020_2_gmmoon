package kr.ac.hanalife.consulting.dao;

import java.util.List;

import kr.ac.hanalife.consulting.vo.ConsultingVO;

public interface ConsultingDAO {
	
	/**
	 * ��㳻���� �� �� �ִ� ���
	 * @param cusno ���� ����ȣ
	 * @return ��� ���� ����Ʈ
	 */
	List<ConsultingVO> inqueryConsulting(int cusno);
	
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
}
