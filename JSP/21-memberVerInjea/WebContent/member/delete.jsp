<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("memId", null);
	int result = Integer.parseInt(request.getParameter("result"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(result > 0) { %>
		회원탈퇴작업이 성공적으로 이루어졌습니다.
	<% } else { %>
		회원탈퇴에 실패했습니다.
	<% } %>
	<br>
	<a href="./index.jsp">메인 화면으로 이동</a>
</body>
</html>