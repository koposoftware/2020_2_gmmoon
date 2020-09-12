package kr.ac.hanalife.insurance.contract.service;

import java.util.List;

import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;

public interface InsuranceContractService {
	
	List<InsuranceContractVO> selectInsuranceContract(int empno);
	
	List<InsuranceContractVO> selectInsuranceMyContract(int cusno);
	
	void terminationContract(int ic_serialno);
	
	InsuranceContractVO InsuranceMyOneContract(int no);
	
	void insertInsuranceContract(InsuranceContractVO icVO);
	
	List<InsuranceContractVO> selectEntireContract();
}
