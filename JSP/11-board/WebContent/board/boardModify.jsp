<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("utf-8");
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardUpdate(subject, content, seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=su%> > 0) {
		alert("수정되었습니다");
		location.href="boardView.jsp?pg=<%=pg%>&seq=<%=seq%>";
	} else {
		alert("수정에 실패하였습니다");
	}
</script>
</head>
<body>

</body>
</html>