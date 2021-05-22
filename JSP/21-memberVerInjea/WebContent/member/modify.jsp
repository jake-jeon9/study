<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	int su = Integer.parseInt(request.getParameter("su"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(su>0) { %>
		정상적으로 업데이트 되었습니다.
	<% } else { %>
		정상적으로 업데이트가 안됐습니다.
	<% } %>
	
	<input type="button" value="메인화면으로" onclick="location.href='./index.jsp'">
</body>
</html>