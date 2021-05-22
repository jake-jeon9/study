<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터
	int seq = Integer.parseInt(request.getParameter("seq"));

	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	// DB (DAO를 생성하고 DTO 값을 DAO에 저장)
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.boardModify(subject, content, seq);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	목록으로 가서 수정됐는지 확인해보세염<br>
	<input type="button" value="목록으로" onclick="location.href='boardList.jsp?pg=1'">
</body>
</html>