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
}
