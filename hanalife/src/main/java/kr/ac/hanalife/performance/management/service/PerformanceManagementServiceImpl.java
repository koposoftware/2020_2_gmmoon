package kr.ac.hanalife.performance.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanalife.performance.management.dao.PerformanceManagementDAO;
import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;

@Service
public class PerformanceManagementServiceImpl implements PerformanceManagementService {
	
	@Autowired
	private PerformanceManagementDAO performancemanagementDAO;

	@Override
	public List<PerformanceManagementVO> selectPerformanceManagement(int empno) {
		return performancemanagementDAO.selectPerformanceManagement(empno);
	}

	@Override
	public PerformanceManagementVO shortContractManagementAVG(int empno) {
		return  performancemanagementDAO.shortContractManagementAVG(empno);
	}

	@Override
	public PerformanceManagementVO longContractManagementAVG(int empno) {
		return performancemanagementDAO.longContractManagementAVG(empno);
	}

	@Override
	public PerformanceManagementVO selectTerminationAVG(int empno) {
		return performancemanagementDAO.selectTerminationAVG(empno);
	}

	@Override
	public void insertPerformanceManagement(PerformanceManagementVO pmVO) {
		performancemanagementDAO.insertPerformanceManagement(pmVO);
	}

	@Override
	public List<PerformanceManagementVO> lookUpShortContract(PerformanceManagementVO pmVO) {
		return performancemanagementDAO.lookUpShortContract(pmVO);
	}

	@Override
	public List<PerformanceManagementVO> lookUpLongContract(PerformanceManagementVO pmVO) {
		return performancemanagementDAO.lookUpLongContract(pmVO);
	}

	@Override
	public List<PerformanceManagementVO> lookUpTermination(PerformanceManagementVO pmVO) {
		return performancemanagementDAO.lookUpTermination(pmVO);
	}
	
	
}
