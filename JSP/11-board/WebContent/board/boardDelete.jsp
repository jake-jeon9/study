<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardDelete(seq); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function() {	// body쪽에 아무 태그가 없기 때문에 window.onload 사용 안해도 됨
	<% if(su > 0) { %>
		alert("삭제 성공");
		location.href="boardList.jsp?pg=<%=pg%>";
	<% } else { %>
		alert("삭제 실패");
		location.href="boardView.jsp?pg=<%=pg%>&seq=<%=seq%>";
	<% } %>
}
</script>
</head>
<body>
</body>
</html>