package kr.ac.hanalife.insurance.product.dao;

import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;

public interface InsuranceProductDAO {
	
	/**
	 * 보험코드에 따른 보험상품을 찾게하는 기능
	 * @return 보험상품정보
	 */
	public InsuranceProductVO searchProduct(String code);

}
