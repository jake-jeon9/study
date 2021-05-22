<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="java.util.List"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    int pg=Integer.parseInt((String)request.getParameter("pg"));
   
    
    
    int endNum = pg*5;
    int startNum = endNum-4;
    

    ImageboardDAO imageboardDAO = new ImageboardDAO(); 
    List<ImageboardDTO> list = imageboardDAO.imageboardList(startNum,endNum);
    
    
    int totalA = imageboardDAO.getTotalA();
    int totalP = (totalA+4)/5; 
    
    int startPage = (pg-1)/3*3+1;
 	int endPage = startPage+2;
    
    if(endPage>totalP) endPage = totalP;
    
	request.setAttribute("startPage",startPage);
	request.setAttribute("endPage",endPage);
	request.setAttribute("list",list);
	request.setAttribute("pg",pg);
	request.setAttribute("totalP",totalP);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardListResult");
	dispatcher.forward(request,response);

	
	/*    
    String fileName=list.get(1).getImage1();
    String realPath = request.getServletContext().getRealPath("/storage");

	File file = new File(realPath,fileName);
	String set_fileName = new String(URLEncoder.encode(fileName,"utf-8")).replace("\\+"," ");
	response.setHeader("Content-Disposition","attachment; fileName="+set_fileName);
	response.setHeader("Content-Lengh",String.valueOf(file.length()));

	out.clear();
    out = pageContext.pushBody();
    
    FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis);
    
    byte[] b= new byte[(int)file.length()];
    bis.read(b,0,b.length);
    bis.close();
    fis.close();
    
    ServletOutputStream sos = response.getOutputStream();
    BufferedOutputStream bos = new BufferedOutputStream(sos);
    bos.write(b);//실제로 이걸로 파일을 클라이언트에 전송함.
    bos.close();
    */
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