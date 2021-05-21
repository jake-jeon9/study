<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    MemberDAO dao = new MemberDAO();
    
    String result = dao.checkId(id, pw);
    request.setAttribute("result",result);
	
    String forward = "../board/boardList.jsp?pg=1";
    
    if(result!=null){
    	RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
    	dispatcher.forward(request,response);	
    	session.setAttribute("memName", result);
    	session.setAttribute("memId", id);
    }else{//로그인 실패
    	response.sendRedirect("loginForm.jsp");
    }
    
   	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>