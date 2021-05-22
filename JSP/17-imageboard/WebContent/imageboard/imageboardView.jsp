<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    int seq = Integer.parseInt((String)request.getParameter("seq"));
    int pg = Integer.parseInt((String)request.getParameter("pg"));
    ImageboardDTO imageboardDTO = new ImageboardDTO();
    ImageboardDAO imageboardDAO = new ImageboardDAO();
    imageboardDTO=imageboardDAO.getView(seq);
    
    
    request.setAttribute("imageboardDTO",imageboardDTO);
    request.setAttribute("pg",pg);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardViewResult");
	dispatcher.forward(request,response);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>

</head>
<body>

<%--  <img alt="<%=imageboardDTO.getImage1()%>" src="../storage/<%=imageboardDTO.getImage1()%>" width="200" height="200"> --%>
</body>
</html>