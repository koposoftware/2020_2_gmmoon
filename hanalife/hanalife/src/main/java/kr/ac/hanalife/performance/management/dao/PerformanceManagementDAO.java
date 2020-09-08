package kr.ac.hanalife.performance.management.dao;

import java.util.List;

import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;

public interface PerformanceManagementDAO {
	
	/**
	 * ����� �ڽ��� ���������� �� �� �ִ� ���
	 * @param empno ����� �����ȣ
	 * @return ����� �������� ����Ʈ
	 */
	List<PerformanceManagementVO> selectPerformanceManagement(int empno);
	
	/**
	 * ����� �ܱ����������� ��ȸ�ϴ� ���
	 * @param empno �����ȣ
	 * @return �ܱ���������
	 */
	PerformanceManagementVO shortContractManagementAVG(int empno);
	
	/**
	 * ����� ������������� ��ȸ�ϴ� ���
	 * @param empno �����ȣ
	 * @return ���ʰ��������
	 */
	PerformanceManagementVO longContractManagementAVG(int empno);
	
	/**
	 * �ߵ������Ǽ��� ��ȸ�ϴ� ���
	 * @param empno �����ȣ
	 * @return �븮�� ���ǥ
	 */
	PerformanceManagementVO selectTerminationAVG(int empno);
	
	/**
	 * ���������� �Է����ִ� ���
	 * @param pmVO �������� 
	 */
	void insertPerformanceManagement(PerformanceManagementVO pmVO);
	
	
}
