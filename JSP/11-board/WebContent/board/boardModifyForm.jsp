<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB
	// 1줄 데이터 얻어옴
	BoardDAO boardDAO = new BoardDAO();
	BoardDTO boardDTO = boardDAO.boardView(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script type="text/javascript" src="../script/boardScript.js?v=3"></script>
<script type="text/javascript">
	function re() {
		var frm = document.boardModifyForm;
		frm.subject.value="";
		frm.content.value="";
	}
</script>
</head>
<body>
	<form action="boardModify.jsp" method="post" name="boardModifyForm">
		<input type="hidden" name="seq" value="<%=seq%>">
		<input type="hidden" name="pg" value="<%=pg%>">
		<table border="1">
			<tr>
				<th width="50">제목</th>
				<td><input type="text" name="subject" size="43" value="<%= boardDTO.getSubject()%>"></td>
			</tr>
			<tr>
				<th width="50">내용</th>
				<td><textarea rows="15" cols="45" name="content"><%= boardDTO.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="checkBoardModify()">
					<input type="button" value="다시 작성" onclick="re()">
					<input type="button" value="취소" 
					onclick="location.href='boardView.jsp?seq=<%=seq%>&pg=<%=pg%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>