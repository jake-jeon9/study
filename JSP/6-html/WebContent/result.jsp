<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  // jsp : 클라이언트로부터 넘어온 데이터 처리를 한 후, 결과를 HTML 문서로 클라이언트에 돌려줌
	// 자바 영역 
	String user_name = request.getParameter("user_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 처리</title>
</head>
<body>
전달된 이름은 <%=user_name %> 입니다.
</body>
</html>








