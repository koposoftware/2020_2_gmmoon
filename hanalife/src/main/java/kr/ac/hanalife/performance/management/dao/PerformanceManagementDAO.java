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
	PerformanceManagementVO selectContractManagement(int empno);
	
	/**
	 * ����� ���ʰ���������� ��ȸ�ϴ� ���
	 * @param empno �����ȣ
	 * @return ���ʰ��������
	 */
	PerformanceManagementVO selectContractRecruiting(int empno);
	
	/**
	 * �븮�� � ��ǥ�� ��ȸ�ϴ� ���
	 * @param empno �����ȣ
	 * @return �븮�� ���ǥ
	 */
	PerformanceManagementVO selectAgencyManagement(int empno);
	
	/**
	 * ���������� �Է����ִ� ���
	 * @param pmVO �������� 
	 */
	void insertPerformanceManagement(PerformanceManagementVO pmVO);
}
