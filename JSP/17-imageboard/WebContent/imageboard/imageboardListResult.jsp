<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <%
 	int pg = (int)request.getAttribute("pg");
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
		<tr bgcolor="ffff00">
			<th width="50">번호</th>
			<th width="150">이미지</th>
			<th width="150">상품명</th>
			<th width="100">단가</th>
			<th width="100">개수</th>
			<th width="100">합계</th>
		</tr>
		<c:set var="list1" value="${list }"/>
		<c:forEach var="imageboardDTO" items="${list1}">
		<tr align="center">
		<td>${imageboardDTO.getSeq() }</td> 
		<td><img onclick="location.href='../imageboard/imageboardView.jsp?seq=${imageboardDTO.getSeq()}&pg=${pg }'" 
		alt="${imageboardDTO.getImageName()}" src="../storage/${imageboardDTO.getImage1()}" width="50" height="50"></td>
		<td>${imageboardDTO.getImageName() }</td> 
		<td>${imageboardDTO.getImagePrice() }</td> 
		<td>${imageboardDTO.getImageQty() }</td> 
		<td>${imageboardDTO.getImageQty() * imageboardDTO.getImagePrice() }</td>
		</tr>
	</c:forEach>
	<tr>
	<td colspan="6" align="center">
		<c:if test="${ startPage>3}">
		[<a id="paging" href="../imageboard/imageboardList.jsp?pg=${startPage-1}">이전]</a>
		</c:if>
		<c:forEach var="i" begin="${ startPage}" end="${endPage }" step="1">
			<c:if test="${i==pg }">
			[<a id="currentpaging" href="../imageboard/imageboardList.jsp?pg=${i}">${i}]</a>
			</c:if>
			<c:if test="${i!=pg }">
			[<a id="paging"  href="../imageboard/imageboardList.jsp?pg=${i}">${i}]</a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage<totalP }">
		[<a id="paging"  href="../imageboard/imageboardList.jsp?pg=${endPage+1}">다음]</a>
		</c:if>
		</td>
	</tr>
	</table>
	
</body>
</html>