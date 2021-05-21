<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	
    	BoardDTO dto = new BoardDTO();
    	BoardDAO dao = new BoardDAO();
    	dao.updateHit(seq);
    	dto = dao.boardView(seq);
    	
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
 		<th width="400" colspan="3">
 			<%=dto.getSubject() %>
 		</th>
		</tr> 
		<tr align="center">
		<td width="100" > 글번호 : <%=dto.getSeq() %></td>
		<td width="200" > 작성자 : <%=dto.getName() %></td>
		<td width="100" > 조회수 : <%=dto.getHit() %></td>
		</tr>
		<tr>
		<td width="400" colspan="3" height="300">
		<%=dto.getContent() %>
		</td>
		</tr>
 	</table>
 	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
 	<%if(session.getAttribute("memId").equals(dto.getId())){ %>
 	<input type="button" value="글수정">
 	<input type="button" value="글삭제" onclick="location.href='boardDelete.jsp?pg=<%=pg%>&seq=<%=seq%>'">
 	<%} %>
 	<br>
 	내아이디? : <%=session.getAttribute("memId") %>
 	적성자 아이디? : <%=dto.getId() %>
</body>
</html>