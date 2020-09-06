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
	
	/**
	 * 사원의 단기계약유지율을 조회하는 기능
	 * @param empno 사원번호
	 * @return 단기계약유지율
	 */
	PerformanceManagementVO selectContractManagement(int empno);
	
	/**
	 * 사원의 월초계약집중율을 조회하는 기능
	 * @param empno 사원번호
	 * @return 월초계약집중율
	 */
	PerformanceManagementVO selectContractRecruiting(int empno);
	
	/**
	 * 대리점 운영 지표를 조회하는 기능
	 * @param empno 사원번호
	 * @return 대리점 운영지표
	 */
	PerformanceManagementVO selectAgencyManagement(int empno);
	
	/**
	 * 성과관리를 입력해주는 기능
	 * @param pmVO 성과관리 
	 */
	void insertPerformanceManagement(PerformanceManagementVO pmVO);
}
