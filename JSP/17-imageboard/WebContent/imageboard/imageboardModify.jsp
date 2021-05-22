<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
    //데이터 추출 준비
	String realFolder = request.getServletContext().getRealPath("/storage");
	MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,	"UTF-8",new DefaultFileRenamePolicy());
   	
	//데이터 뽑기
	String imageId = multi.getParameter("imageId");
    String imageName=multi.getParameter("imageName");
    int imagePrice = Integer.parseInt((String)multi.getParameter("imagePrice"));
    int imageQty = Integer.parseInt((String)multi.getParameter("imageQty"));
    int seq = Integer.parseInt((String)multi.getParameter("seq"));
    int pg = Integer.parseInt((String)multi.getParameter("pg"));
    String imageContent=multi.getParameter("imageContent");
    String image1 = multi.getOriginalFileName("image1");

    //DB작업
    ImageboardDTO imageboardDTO = new ImageboardDTO();
    imageboardDTO.setSeq(seq);
    imageboardDTO.setImageId(imageId);
    imageboardDTO.setImageName(imageName);
    imageboardDTO.setImagePrice(imagePrice);
    imageboardDTO.setImageQty(imageQty);
    imageboardDTO.setImageContent(imageContent);
    imageboardDTO.setImage1(image1);
       
       
    ImageboardDAO imageboardDAO = new ImageboardDAO();
    int result=imageboardDAO.editContent(imageboardDTO);
       
	request.setAttribute("pg", pg);
	request.setAttribute("seq", seq);
	request.setAttribute("result", result);
	request.setAttribute("imageboardDTO", imageboardDTO);
    
   	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardModify");
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