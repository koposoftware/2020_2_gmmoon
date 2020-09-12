package kr.ac.hanalife.insurance.contract.dao;

import java.util.List;

import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;

public interface InsuranceContractDAO {
	
	/**
	 * 사원이 자신의 보험계약리스트를 조회할 수 있는 기능
	 * @param empno 사원의 사원번호
	 * @return 보험계약리스트
	 */
	List<InsuranceContractVO> selectInsuranceContract(int empno);
	
	/**
	 * 고객이 자신의 보험계약리스트를 조회할 수 있는 기능
	 * @param cusno 고객의 고객번호
	 * @return 보험계약리스트
	 */
	List<InsuranceContractVO> selectInsuranceMyContract(int cusno);
	
	/**
	 * 고객이 보험계약을 해지하는 서비스
	 * @param ic_serialno 보험계약일련번호
	 */
	void terminationContract(int ic_serialno);
	
	/**
	 * 보험일련번호로 고객의 보험계약조회
	 * @param no 보험일련번호
	 * @return 보험계약
	 */
	InsuranceContractVO InsuranceMyOneContract(int no);
	
	/**
	 * 고객이 보험상품에 가입하는 서비스
	 * @param icVO 해당 보험 상품
	 */
	void insertInsuranceContract(InsuranceContractVO icVO);
	
	/**
	 * 전체 계약건수의 일련번호를 가져오는 기능
	 * @return 전체 계약 건수 일련번호
	 */
	List<InsuranceContractVO> selectEntireContract();
}
