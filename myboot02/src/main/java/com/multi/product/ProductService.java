package com.multi.product;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
	// MyBatis  사용하는 경우의 DI 설정
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;

	@Override
	public ArrayList<ProductVO> listAllProduct() {		
		return dao.listAllProduct();
	}

	@Override
	public void insertProduct(ProductVO prdVo) {
		dao.insertProduct(prdVo);
	}

	@Override
	public void updateProduct(ProductVO prdVo) {
		dao.updateProduct(prdVo);
	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);
	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {		
		return dao.detailViewProduct(prdNo);
	}
	@Override
	public String prdNoCheck(String prdNo) {
		return dao.prdNoCheck(prdNo);
	}
	@Override
	public ArrayList<ProductVO> productSearch(HashMap<String, Object>map){
		return dao.productSearch(map);
	}
	
}


