<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 세션에 저장된 공유 데이터 얻기
	String name = (String)session.getAttribute("memName");
	String id = (String)session.getAttribute("memId");
	
	/* get 방식으로 전달된 데이터 얻기
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><img alt="투미가방" src="../image/tumi.png" width="30" height="30"
			onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
			<%= id + "(" + name + ")"%>님이 로그인</p>
			<br>
			<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
</body>
</html>