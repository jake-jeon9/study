<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    int seq = Integer.parseInt((String)request.getParameter("seq"));
    int pg = Integer.parseInt((String)request.getParameter("pg"));
    
    ImageboardDAO imageboardDAO =new ImageboardDAO();
    
    int result = imageboardDAO.deleteContent(seq);
    
    
    request.setAttribute("result",result);
    request.setAttribute("pg",pg);
    request.setAttribute("seq",seq);
    RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardDelete");
	dispatcher.forward(request,response);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 페이지</title>
</head>
<body>

</body>
</html>