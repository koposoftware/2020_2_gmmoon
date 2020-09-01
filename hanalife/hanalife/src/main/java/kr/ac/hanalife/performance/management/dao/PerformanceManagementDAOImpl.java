package kr.ac.hanalife.performance.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hanalife.performance.management.vo.PerformanceManagementVO;

@Repository
public class PerformanceManagementDAOImpl implements PerformanceManagementDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<PerformanceManagementVO> selectPerformanceManagement(int empno) {
		
		List<PerformanceManagementVO> list = new ArrayList<PerformanceManagementVO>();
		
		list = sqlSession.selectList("performance.management.dao.PerformanceManagementDAO.selectPerformanceManagement", empno);
		
		String date ="";
		for(PerformanceManagementVO pmVO : list) {
			date = pmVO.getDate();
			pmVO.setDate(date.substring(0, 10));
		}
		
		return list;
	}
	
	
}
