<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function check(){
	if(${result}>0){
		alert("압데이트 완료, 갱신된 페이지를 보여줍니다.");	
	}else if(${result}==0){
		alert("압데이트 실패..");
	}
	}

</script>
</head>
<body onload="check()">

	<c:if test="${result>0}">
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
	</c:if>
	
	<c:if test="${result==0}">
	<p>오류 발생.. </p>
	</c:if>
	<input type="button" value="처음화면가기" onclick="location.href='../main/index.jsp'">
	<input type="button" value="리스트화면으로 가기" onclick="location.href='../imageboard/imageboardList.jsp?pg=${pg}'">
	<input type="button" value="수정된 화면 보기" onclick="location.href='../imageboard/imageboardView.jsp?seq=${seq }&pg=${pg}'">

</body>
</html>