package kr.ac.hanalife.performance.management.dao;

import java.util.List;

import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;

public interface PerformanceManagementDAO {
	
	/**
	 * 사원이 자신의 성과관리를 볼 수 있는 기능
	 * @param empno 사원의 사원번호
	 * @return 사원의 성과관리 리스트
	 */
	List<PerformanceManagementVO> selectPerformanceManagement(int empno);
}
