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
}
