package kr.ac.hanalife.consulting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanalife.consulting.dao.ConsultingDAO;
import kr.ac.hanalife.consulting.vo.ConsultingVO;

@Service
public class ConsultingServiceImpl implements ConsultingService {
	
	@Autowired
	private ConsultingDAO consultingDAO;

	@Override
	public List<ConsultingVO> inqueryConsultingCustomer(int cusno) {
		return consultingDAO.inqueryConsulting(cusno);
	}

	@Override
	public void insertConsultingCustomer(ConsultingVO csVO) {
		
		List<ConsultingVO> list = new ArrayList<ConsultingVO>();
		list = consultingDAO.inqueryNumberConsulting();
		
		ConsultingVO check_csVO = list.get(list.size()-1);
		csVO.setNo(check_csVO.getNo() + 1);
		
		consultingDAO.insertConsulting(csVO);
	}

	@Override
	public List<ConsultingVO> inqeuryNumberConsultingCustomer() {
		return consultingDAO.inqueryNumberConsulting();
	}
	
	
	
}
