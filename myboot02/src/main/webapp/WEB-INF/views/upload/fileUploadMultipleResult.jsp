<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> 여러개 파일 업로드 결과</title>
	</head>
	<body>
		다음의 여러 파일을 전송하였습니다. <br>
		<c:forEach items="${originalFileNameList }" var="file">
			${file }<br>
		</c:forEach>
	</body>
</html>