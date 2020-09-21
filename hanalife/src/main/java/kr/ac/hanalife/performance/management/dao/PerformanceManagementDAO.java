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
	
	/**
	 * ����� �ܱ��������� ������ ���� �� �� �ִ� ���
	 * @param pmVO �����ȣ, �� ����(������� �Ⱓ�� �� ��)
	 * @return ����� ���� �ܱ������� ����Ʈ
	 */
	List<PerformanceManagementVO> lookUpShortContract(PerformanceManagementVO pmVO);
	
	/**
	 * ����� ����������� ������ ���� �� �� �ִ� ���
	 * @param pmVO �����ȣ, �� ����(������� �Ⱓ�� �� ��)
	 * @return ����� ���� ��������� ����Ʈ
	 */
	List<PerformanceManagementVO> lookUpLongContract(PerformanceManagementVO pmVO);
	
	/**
	 * ����� �ߵ������Ǽ��� ������ ���� �� �� �ִ� ���
	 * @param pmVO �����ȣ, �� ����(������� �Ⱓ�� �� ��)
	 * @return ����� ���� �ߵ������Ǽ� ����Ʈ
	 */
	List<PerformanceManagementVO> lookUpTermination(PerformanceManagementVO pmVO);
}
