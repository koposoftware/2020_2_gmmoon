package kr.ac.hanalife.consulting.service;

import java.util.List;

import kr.ac.hanalife.consulting.vo.ConsultingVO;

public interface ConsultingService {
	
	List<ConsultingVO> inqueryConsultingCustomer(int cusno);
	
	void insertConsultingCustomer(ConsultingVO csVO);
	
	List<ConsultingVO> inqeuryNumberConsultingCustomer();
}
