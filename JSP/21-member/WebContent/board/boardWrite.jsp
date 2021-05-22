<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	String subject = request.getParameter("subject");
	    String content = request.getParameter("content");
	    String name = (String)session.getAttribute("memName");
	    String id = (String)session.getAttribute("memId");
	    
	    BoardDTO boardDTO = new BoardDTO();
	    boardDTO.setId(id);
	    boardDTO.setName(name);
	    boardDTO.setSubject(subject);
	    boardDTO.setContent(content);
	    
	    BoardDAO boardDAO = new BoardDAO();
	    int su = boardDAO.writeBoard(boardDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function () {
	if(<%=su%> > 0) {
		alert("<%=name %>님의 글(<%=subject %>)이 저장되었습니다");
	} else {
		alert("저장에 실패했습니다.");
	} location.href = "boardList.jsp?pg=1";
}
</script>
</head>
<body>

<%--  
<% if (su>0)  { %>
	<%=name %>님의 글(<%=subject %>)이 저장되었습니다.
<% } else { %>
	저장에 실패했습니다.
<% } %>
--%>

	
</body>
</html>