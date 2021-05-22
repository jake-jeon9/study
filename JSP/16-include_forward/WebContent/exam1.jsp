<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String name = "홍길동";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>** include 지시자 **</h3>
	<%@ include file="today.jsp" %>
	
	<h3>** include jsp 태그 **</h3>
	<jsp:include page ="image.jsp"/>
	exam1.jsp name = <%=name %><br>
</body>
</html>