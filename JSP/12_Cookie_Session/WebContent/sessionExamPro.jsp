<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String id =request.getParameter("id");
    String pw =request.getParameter("pw"); 
    //세션에 데이터 저장
    session.setAttribute("id",id);
    session.setAttribute("pw",pw);
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 속성 설정 및 사용</h2>
	<p> id 속성의 값은 <%=session.getAttribute("id") %>이고<br>
	 pw 속성의 값은 <%=session.getAttribute("pw") %>이다.<br><!--  세션은 데이터를 변수에 저장할 때 항변환을 해야함. -->
</body>
</html>