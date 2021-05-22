<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = (String)session.getAttribute("memName");
	String id = (String)session.getAttribute("memId");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setName(name);
	boardDTO.setId(id);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardWrite(boardDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function() {
	if(<%=su%> > 0) {
		alert("작성하신 글을 저장하였습니다.");
	} else {
		alert("작성하신 글을 저장하지 못하였습니다.");
	}
		location.href="../board/boardList.jsp?pg=1";
	}
</script>
</head>
<body>
<%-- 
글쓴이 : <%= name %><br>
제목 : <%= subject %><br>
내용 : <%= content %>
--%>
</body>
</html>