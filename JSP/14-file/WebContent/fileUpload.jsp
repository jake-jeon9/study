<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    /*enctype 이 multipart/form-data 일경우 request.getParameter로 
          데이터를 추출(문자열 읽기 X)할 수 없음.(데이터는 살아 있음)
    
    String subject=request.getParameter("subject");    
	출력시 null로 나옴.
	*/
//	실제 파일 저장 폴더 위치 확인
    String realFolder = request.getServletContext().getRealPath("/storage");
	System.out.println("realfolder : "+ realFolder);
	//realFolder : realfolder : D:\android_seonghwan\jsp\workspace\.metadata\.plugins\
	//org.eclipse.wst.server.core\tmp0\wtpwebapps\14-file\storage
	//이클립스가 데이터를 직접 사용하지 않고 복사해서 사용하기 떄문에 메타데이터 폴더에 있음.
	
	//업로드 : 서버에 파일저장
	MultipartRequest multi = new MultipartRequest
	(request, realFolder, 5*1024*1024,
			"UTF-8",new DefaultFileRenamePolicy());
	
	//순서대로 request 객체 , 저장위치 , 크기(5 * 1024 * 1024 = 5MB) , 엔코딩 타입, 같은 파일 덮어쓰기 방지 설정
	//저장 파일 위치는 realFolder에서 request.getServletContext().getRealPath("폴더 위치"); 
	//new DefaultFileRenamePolicy()은 같은 파일 덮어쓰지 방지 설정 값.
	//							설정을 안하면 덮어쓰고, 설정해주면 이름 + 1 이렇게 카운트.

	
		
    String subject=multi.getParameter("subject");
    String content=multi.getParameter("content");
  	//클라이언트에서 서버로 보낸 파일 이름
    String originalfileName1=multi.getOriginalFileName("upload1");
    String originalfileName2=multi.getOriginalFileName("upload2");
	//서버의 storage 폴더에 저장된 파일 이름    
    String fileName1 = multi.getFilesystemName("upload1");
    String fileName2 = multi.getFilesystemName("upload2");
    //서버에 저장된 파일의 크기
    File file1=multi.getFile("upload1");
    File file2=multi.getFile("upload2");
    System.out.println("file1 :" + file1);
    
    long fileSize1 = 0;
    long fileSize2 = 0;
    if(file1 !=null) fileSize1= file1.length();
    if(file2 !=null) fileSize2= file2.length();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>업로드 완료!!</h2>
	
	<ol>
	<li>제목 : <%=subject %></li>
	<li>내용 : <%=content %></li>
	<li>파일 : <a href="fileDownload.jsp?fileName=<%=originalfileName1%>"> <%=originalfileName1 %></a> 
	&nbsp;&nbsp;&nbsp;&nbsp; <%=fileName1 %>
	</li>
	<li>크기 : <%=fileSize1 %></li>
	</ol>
	<br>
	<br>
	<ol>
	<li>파일 : <%=originalfileName2 %> 	&nbsp;&nbsp;&nbsp;&nbsp; <%=fileName2 %></li>
	<li>크기 : <%=fileSize2 %></li>
	</ol>
	
	<img alt="그림1" src="storage/<%=fileName1 %>" width="50" height="50"> <!-- 상대 경로임. -->
	<img alt="그림2" src="storage/<%=fileName2 %>"  width="50" height="50">
</body>
</html>