<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록게시판</title>
<script type="text/javascript" src="../script/imageboardScript.js"></script>
<style type="text/css">
#body1{
	width : 640px;
}
</style>
</head>
<body>
	<div id="body1">
	<h2>이미지 등록</h2>
	<form action="../imageboard/imageboardWrite.jsp" enctype="multipart/form-data" method="post" name = "writeForm">
	 <!--<form action="../main/index.jsp?req=imageboardWrite" enctype="multipart/form-data" method="post" 
	name = "writeForm">-->
	<table border="1">
		<tr>
		<th>상품코드</th>
		<td><input type="text" name="imageId" value="img_" size="20"></td>
		</tr>
		<tr>
		<th>상품명</th>
		<td><input type="text" name="imageName" size="30"></td>
		</tr>
		<tr>
		<th>단가</th>
		<td><input type="text" name="imagePrice" size="15"></td>
		</tr>
		<tr>
		<th>개수</th>
		<td><input type="text" name="imageQty" size="15"></td>
		</tr>
		<tr>
		<th>내용</th>
		<td><textarea name="imageContent" rows="15" cols="76"></textarea></td>
		</tr>
		<tr>
		<td colspan="2" align="left">
		<input type="file" name="image1" ></td>
		</tr>
		<tr>
		<td colspan="2" align="center" >
		<input type="button" value="이미지등록" onclick="checkImageboardWriteForm()">
		<input type="reset" value="다시작성">
		</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>