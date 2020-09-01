package kr.ac.hanalife.performance.management.service;

import java.util.List;

import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;

public interface PerformanceManagementService {
	
	List<PerformanceManagementVO> selectPerformanceManagement(int empno);
}
