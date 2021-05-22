<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
 	int seq=Integer.parseInt((String)request.getParameter("seq"));
 	int pg=Integer.parseInt((String)request.getParameter("pg"));
    
    request.setAttribute("seq", seq);
	request.setAttribute("pg", pg); 

    
	ImageboardDTO imageboardDTO = new ImageboardDTO();
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	
	imageboardDTO = imageboardDAO.getView(seq);
	   
	request.setAttribute("imageboardDTO", imageboardDTO);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardModifyForm");
	dispatcher.forward(request,response);
	
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