package com.multi.product;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	// DI 설정
	@Autowired
	ProductService service;	
	
	// 실행 시 index 페이지 열기
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	// 전체 상품 조회
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		ArrayList<ProductVO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);		
		return "product/productListView";
	}
	
	// 상품 등록폼으로 이동
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}
	
	// 상품 등록
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductVO prd) {
		//System.out.println(prd.getPrdNo());
		service.insertProduct(prd);
		return "redirect:./listAllProduct";
		//return "redirect:/product/listAllProduct"; // 이렇게 해도 됨
		//return "product/productListView"; // 이렇게 하면 데이터 출력 안 됨
	}
	
	// 상품 상제 정보 페이지로 이동
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		// 상품번호 전달하고, 해당 상품 정보 받아오기 
		ProductVO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd", prd);
		
		//System.out.println(prd.getPrdNo()); // 서비로부터 반환된 값 확인
		
		return "product/productDetailView";  // 상품 상세 정보 뷰 페이지
	}
	
	// 상품 정보 수정 화면으로 이동 (수정하기 위해 먼저 상품 상세 정보를 화면(입력 폼)에 출력)
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		// 상품번호 전달하고, 해당 상품 정보 받아오기 
		ProductVO prd = service.detailViewProduct(prdNo); // 상세 상품 조회 메소드 그대로 사용
		model.addAttribute("prd", prd);
		return "product/updateProductForm";
	}
	
	// 상품 정보 수정 : 수정된 상품 정보 DB에 저장
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductVO prd) {
		service.updateProduct(prd);		
		return "redirect:./listAllProduct";  // 전체 상품 조회 페이지로 포워딩
	}
	
	// 상품 정보 삭제
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		//System.out.println(prdNo); // 상품번호 전달되는지 확인
		service.deleteProduct(prdNo);
		return "redirect:../listAllProduct";  // 전체 상품 조회 페이지로 포워딩
		//return "redirect:/product/listAllProduct"; // 이렇게 해도 오류 없음
	}
	
	//상품번호 중복 확인
	@ResponseBody
	@RequestMapping("product/prdNoCheck")
	public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
		// 서비스 호출 -> DAO -> Mapper -> prdNo가 존재하면 prdNo 반환
		String prdNo_result = service.prdNoCheck(prdNo);
		
		String result = "use";
		if(prdNo_result != null) // prdNo_result가 받은 값이 있으면 (널이 아니면)
			result = "no_use";
		
		return result;
	}
	
	// 상품 검색 폼으로 이동
	@RequestMapping("/product/productSearchForm")
	public String productSearchForm() {
		return "product/productSearchForm";
	}
	
	// 상품 검색 
	@ResponseBody
	@RequestMapping("/product/productSearch")
//	public ArrayList<ProductVO> productSearch(@RequestParam("type") String type, 
//																				 @RequestParam("keyword") String keyword) {
	public ArrayList<ProductVO> productSearch(@RequestParam HashMap<String, Object> param, 
																				Model model){
		System.out.println("a");
		ArrayList<ProductVO> prdList = service.productSearch(param);
		model.addAttribute("prdList", prdList);
		
		// prdList로 제대로 반화되었는지 확인하기 위한 코드
//		for(int i =0; i < prdList.size(); i++) {
//			ProductVO prd = (ProductVO) prdList.get(i);
//			System.out.println(prd.getPrdNo());
//		}
		
		return prdList;
	}
	
	// 상품 검색 폼으로 이동
		@RequestMapping("/product/productSearchForm2")
		public String productSearchForm2() {
			return "product/productSearchForm2";
		}
		
		@ResponseBody
		@RequestMapping("/product/productSearch2")
		public String  productSearch2(@RequestParam HashMap<String, Object> param, 
																					Model model){
			System.out.println("a");
			ArrayList<ProductVO> prdList = service.productSearch(param);
			model.addAttribute("prdList", prdList);
			
			return "product/productSearchResultView";
		}
		// 상품 검색 폼으로 이동
		@RequestMapping("/product/productSearchForm3")
		public String productSearchForm3() {
			return "product/productSearchForm3";
		}
		
}




