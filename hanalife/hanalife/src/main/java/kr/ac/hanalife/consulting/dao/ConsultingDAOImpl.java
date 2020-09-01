package kr.ac.hanalife.consulting.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hanalife.consulting.vo.ConsultingVO;

@Repository
public class ConsultingDAOImpl implements ConsultingDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ConsultingVO> inqueryConsulting(int cusno) {
		
		List<ConsultingVO> list = new ArrayList<ConsultingVO>();
		
		list = sqlSession.selectList("consulting.dao.ConsultingDAO.inqueryConsulting", cusno);
		
		return list;
	}

	@Override
	public void insertConsulting(ConsultingVO csVO) {
		
		sqlSession.insert("consulting.dao.ConsultingDAO.insertConsulting", csVO);
	}

	@Override
	public List<ConsultingVO> inqueryNumberConsulting() {
		
		List<ConsultingVO> list = new ArrayList<ConsultingVO>();
		
		list = sqlSession.selectList("consulting.dao.ConsultingDAO.inqueryNumberConsulting");
		
		return list;
	}
	
	
}
