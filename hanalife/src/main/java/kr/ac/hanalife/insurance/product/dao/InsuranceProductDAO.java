package kr.ac.hanalife.insurance.product.dao;

import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;

public interface InsuranceProductDAO {
	
	/**
	 * �����ڵ忡 ���� �����ǰ�� ã���ϴ� ���
	 * @return �����ǰ����
	 */
	public InsuranceProductVO searchProduct(String code);

}
