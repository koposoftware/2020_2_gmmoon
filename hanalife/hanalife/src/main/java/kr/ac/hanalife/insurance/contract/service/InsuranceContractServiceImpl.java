package kr.ac.hanalife.insurance.contract.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanalife.insurance.contract.dao.InsuranceContractDAO;
import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;

@Service
public class InsuranceContractServiceImpl implements InsuranceContractService {
	
	@Autowired
	private InsuranceContractDAO insurancecontractDAO;
	
	@Override
	public List<InsuranceContractVO> selectInsuranceContract(int empno) {
		return insurancecontractDAO.selectInsuranceContract(empno);
	}

	@Override
	public List<InsuranceContractVO> selectInsuranceMyContract(int cusno) {
		return insurancecontractDAO.selectInsuranceMyContract(cusno);
	}
	
	
}
