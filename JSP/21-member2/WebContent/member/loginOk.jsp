<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    session.setAttribute("memId", (String)request.getAttribute("id"));
    session.setAttribute("memName", (String)request.getAttribute("name"));
    
    %>
    
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>  로그인 성공.</h2>
	<a href="../main/index.jsp" > 메인으로 이동</a>
	<!-- 그림에 뒤로가기(index화면으로 이동) 기능을 넣고 커서는 손가락으로 변경! -->
	<p><img alt="스폰지밥" src="../image/lion.jpg" width="70" 
	height="70" onclick="location.href='../main/index.jsp'" style="cursor: pointer;"> ${id } (${name })님이 로그인하셨습니다.</p>
</body>
</html>