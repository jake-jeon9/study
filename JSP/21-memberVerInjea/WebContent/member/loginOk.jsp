<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 세션에 저장된 공유데이터 얻기 (session.getAttribute로 얻기)
    	String name = (String)request.getAttribute("name");
	    String id = (String)request.getAttribute("memId");
	  
    	session.setAttribute("memId", id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 그림에 뒤로가기(index화면으로 이동) 기능을 넣고 커서는 손가락으로 변경! -->
	<p><img alt="스폰지밥" src="../image/lion.jpg" width="70" 
	height="70" onclick="location.href='./index.jsp'" style="cursor: pointer;"><%=id + "(" +name  + ")" %>님이 로그인하셨습니다.</p>
</body>
</html>