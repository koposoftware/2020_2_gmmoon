package kr.ac.hanalife.insurance.contract.dao;

import java.util.List;

import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;

public interface InsuranceContractDAO {
	
	/**
	 * ����� �ڽ��� �����ฮ��Ʈ�� ��ȸ�� �� �ִ� ���
	 * @param empno ����� �����ȣ
	 * @return �����ฮ��Ʈ
	 */
	List<InsuranceContractVO> selectInsuranceContract(int empno);
}
