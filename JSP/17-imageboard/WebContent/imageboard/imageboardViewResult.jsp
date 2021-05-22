<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
     <%
     	int pg = Integer.parseInt((String)request.getParameter("pg"));
     	int seq=Integer.parseInt((String)request.getParameter("seq"));
     	
     	request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);     	
     	

     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th rowspan="4"><img alt="${imageboardDTO.image1}" src="../storage/${imageboardDTO.image1}" width="220" height="220"></th>
			<th width="200">상품명 : ${imageboardDTO.imageName } </th>
		</tr>
		<tr>
			<th width="200">단가 : ${imageboardDTO.imagePrice }</th>
		</tr>
		<tr>
			<th width="200">개수 : ${imageboardDTO.imageQty }</th>
		</tr>
		<tr>
			<th width="200">합계 : ${imageboardDTO.imageQty * imageboardDTO.imagePrice }</th>
		</tr>
		<tr>
		<td colspan="2">
		<textarea rows="15" cols="83">${imageboardDTO.imageContent}</textarea></td>
		</tr>
	</table>
	<input type="button" value="이전화면" onclick="history.go(-1)">
	<input type="button" value="삭제" onclick="location.href='../imageboard/imageboardDelete.jsp?seq=${seq}&pg=${pg}'">
	<input type="button" value="수정" onclick="location.href='../imageboard/imageboardModifyFormReady.jsp?seq=${seq}&pg=${pg}'">
	<input type="button" value="목록" onclick="location.href='../imageboard/imageboardList.jsp?pg=${pg}'">

</body>
</html>