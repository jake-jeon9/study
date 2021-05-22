<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//데이터
    	//String subject = request.getParameter("subject");
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	//String name = (String)session.getAttribute("memName");
    	//int hit = Integer.parseInt(request.getParameter("hit"));
    	//String content = request.getParameter("content");
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	
    	
    	// DB (DAO를 생성하고 DTO 값을 DAO에 저장) 
    	BoardDAO boardDAO = new BoardDAO();
    	// 조회수 증가시키기
    	boardDAO.updateHit(seq);
    	BoardDTO boardDTO = boardDAO.boardView(seq);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
		<td colspan="3">
			<font size="5"><%=boardDTO.getSubject()%></font>
		</td>
		</tr>
		<tr align="center">
		<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
		<td width="150">작성자 : <%=boardDTO.getName() %></td>
		<td width="150">조회수 : <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
		<td colspan="3" height="200" valign="top">
		<pre><%=boardDTO.getContent()%></pre></td>
		</tr>
	</table>
	<input type="button" value="목록으로" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
	<input type="button" value="글 수정하기" onclick="location.href='boardModifyForm.jsp?seq=<%=seq %>'">
	<input type="button" value="글 삭제하기" 
			onclick="location.href='boardDelete.jsp?seq=<%=seq%>&pg=<%=pg%>'">
	
</body>
</html>


