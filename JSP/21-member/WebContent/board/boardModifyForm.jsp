<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//데이터
	String id = (String)session.getAttribute("memId");
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	// DB (DAO를 생성하고 DTO 값을 DAO에 저장) 
	BoardDAO boardDAO = new BoardDAO();
	
	BoardDTO boardDTO = boardDAO.boardView(seq);
	
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "../script/boardScript.js?v=1"></script>
<style type="text/css">
	table {
		
	}
</style>
</head>
<body> 
	<form name="modify" action="boardModify.jsp" method="get">
		<table border="1">
		<tr>
		<td colspan="3">
			<font size="5">
				<textarea name="subject" cols="60" rows="1" ><%=boardDTO.getSubject()%></textarea>
			</font>
		</td>
		</tr>
		<tr align="center">
		<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
		<td width="150">작성자 : <%=boardDTO.getName() %></td>
		<td width="150">조회수 : <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
		<td colspan="3" height="200" valign="top">
			<textarea name="content" cols="60" rows="25"  ><%=boardDTO.getContent() %></textarea>
		</td>
		</tr>
		<tr>
			<td align="center" colspan = "3">
				<input type="button" value="수정 완료" onclick = "checkBoardModify();">
				<input type="hidden" name="seq" value="<%=seq %>">
				<input type="reset" value = "다시 작성">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>