<%@page import="board.bean.BoardBean"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	request.setCharacterEncoding("utf-8");
            	String subject = request.getParameter("subject");
            	String content = request.getParameter("content");
            	String writer = (String)session.getAttribute("memName");
            	String id=(String)session.getAttribute("memId");
            	//DB작업
            	BoardBean boardDTO = new BoardBean();
            	boardDTO.setId(id);
            	boardDTO.setName(writer);
            	boardDTO.setSubject(subject);
            	boardDTO.setContent(content);
            	
            	//서버에 등록
            	BoardDAO boardDAO = new BoardDAO();
            	int result = boardDAO.writeContent(boardDTO);
        		//result는 결과값 확인용
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<%if(result>0){ %>
	<p>글쓴이 : <%=writer %></p>
	<p>제목 : <%=subject %></p>
	<p>내용 : <%=content %></p>
	<%=result %> 개가 등록 됨.
	<%}else{ %>
	<p>등록에 실패하였습니다</p>
	<p>글쓴이 :<%=writer %></p>
	<p>제목 : <%=subject %></p>
	<p>내용 : <%=content %></p>
	<%} %>
	<br>
	<a href="../main/index.jsp">메인으로가기</a>       
	<a href="boardList.jsp?pg=1">리스트 보기</a>
	
</body>
</html>