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
	
	/**
	 * ���� �������� �����ϴ� ����
	 * @param ic_serialno �������Ϸù�ȣ
	 */
	void terminationContract(int ic_serialno);
	
	/**
	 * �����Ϸù�ȣ�� ���� ��������ȸ
	 * @param no �����Ϸù�ȣ
	 * @return ������
	 */
	InsuranceContractVO InsuranceMyOneContract(int no);
	
	/**
	 * ���� �����ǰ�� �����ϴ� ����
	 * @param icVO �ش� ���� ��ǰ
	 */
	void insertInsuranceContract(InsuranceContractVO icVO);
	
	/**
	 * ��ü ���Ǽ��� �Ϸù�ȣ�� �������� ���
	 * @return ��ü ��� �Ǽ� �Ϸù�ȣ
	 */
	List<InsuranceContractVO> selectEntireContract();
}
