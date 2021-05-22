<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String realFolder = request.getServletContext().getRealPath("/storage");
	
    MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,	"UTF-8",new DefaultFileRenamePolicy());
	String imageId = multi.getParameter("imageId");
    String imageName=multi.getParameter("imageName");
    int imagePrice = Integer.parseInt((String)multi.getParameter("imagePrice"));
    int imageQty = Integer.parseInt((String)multi.getParameter("imageQty"));
    String imageContent=multi.getParameter("imageContent");
    String image1 = multi.getOriginalFileName("image1");
    
    File file1=multi.getFile("image1");
    
    
    ImageboardDTO imageboardDTO = new ImageboardDTO();
    
    imageboardDTO.setImageId(imageId);
    imageboardDTO.setImageName(imageName);
    imageboardDTO.setImagePrice(imagePrice);
    imageboardDTO.setImageQty(imageQty);
    imageboardDTO.setImageContent(imageContent);
    imageboardDTO.setImage1(image1);
    
    
    ImageboardDAO imageboardDAO = new ImageboardDAO();
    int result=imageboardDAO.writeContent(imageboardDTO);
    
    //화면 이동 방법 (데이터 공유 / 화면이동)
    //1. 화면이동(forward방식)
    request.setAttribute("req",result);
    request.setAttribute("imageName",image1);
    
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardWriteResult");
	dispatcher.forward(request,response);
    
    
    //2. sendRedirect
	//response.sendRedirect("../main/index.jsp?req="+result);    
    //response.sendRedirect("../main/index.jsp?req=check");    
    
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