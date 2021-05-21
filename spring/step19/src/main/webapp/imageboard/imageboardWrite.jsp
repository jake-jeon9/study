<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>파일 이름 : ${dto.image1}</p>
<p>상품명 : ${dto.imageName}</p>
<img alt="" src="../storage/${dto.image1}">
<!-- 새로 고침을 해야 이미지를 볼수 있지만, 정식 서버에서는 제대로 동작함. -->
</body>
</html>