package kr.ac.hanalife.insurance.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanalife.insurance.product.dao.InsuranceProductDAO;
import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;

@Service
public class InsuranceProductServiceImpl implements InsuranceProductService {
	
	@Autowired
	private InsuranceProductDAO insuranceproductDAO;
	
	@Override
	public InsuranceProductVO searchProduct(String code) {
		return insuranceproductDAO.searchProduct(code);
	}
	
	
}
