<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    //세션 으로 전달된 데이터 처리
    String name= (String)session.getAttribute("memName");
    String id= (String)session.getAttribute("memId");
    
    //get방식으로 전달된 데이터 처리
    //String name = request.getParameter("name"); 
    //String id = request.getParameter("id"); 
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><img alt="투미가방" src="../image/tumi.png" width="30" height="30" 
	onclick="location.href='../main/index.jsp'" style="cursor : pointer;"> 
	 로그인 성공!, <%=id +"("+ name+")" %>님 환영할껄. </p>
	
</body>
</html>