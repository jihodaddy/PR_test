<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 상제 정보 조회</title>
	</head>
	<body>
			<h3>상품 상세 정보 조회</h3>
			<table border="1" width="300">
				<tr><td>상품번호</td><td>${prd.prdNo }</td></tr>
				<tr><td>상품명</td><td>${prd.prdName }</td></tr>
				<tr><td>가격</td><td>${prd.prdPrice }</td></tr>
				<tr><td>제조회사</td><td>${prd.prdCompany }</td></tr>
				<tr><td>재고</td><td>${prd.prdStock }</td></tr>
			</table><br>
			
			<!-- 상품 정보 수정 화면으로 이동  -->
			
			<br>
			<a href="<c:url value='/product/updateProductForm/${prd.prdNo}'/>">상품 정보 수정</a><br><br>
			
			<!-- 상품 정보 삭제 : 삭제 여부 확인 처리 (자바스크립트로) -->
			<a href="javascript:deleteCheck();">상품 정보 삭제</a><br><br>
			<script type="text/javascript">
				function deleteCheck(){
					var answer = confirm("선택한 상품을 삭제하시겠습니까?");
					if(answer == true){
						location.href="<c:url value='/product/deleteProduct/${prd.prdNo}' />";
					}
				}
			</script>
			
			<a href="<c:url value='/'/>">메인 화면으로 이동</a>
	</body>
</html>





