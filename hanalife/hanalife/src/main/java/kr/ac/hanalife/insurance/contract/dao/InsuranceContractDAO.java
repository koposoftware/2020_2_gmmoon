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
	
	/**
	 * ���� �ڽ��� �����ฮ��Ʈ�� ��ȸ�� �� �ִ� ���
	 * @param cusno ���� ����ȣ
	 * @return �����ฮ��Ʈ
	 */
	List<InsuranceContractVO> selectInsuranceMyContract(int cusno);
}
