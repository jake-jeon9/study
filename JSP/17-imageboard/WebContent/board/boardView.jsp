<%@page import="board.bean.BoardBean"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	//데이터
            int seq= Integer.parseInt(request.getParameter("seq"));
            int pg= Integer.parseInt(request.getParameter("pg"));
            boolean editable=false;
            if(Boolean.parseBoolean(request.getParameter("Editable"))){
            editable=Boolean.parseBoolean(request.getParameter("Editable"));
            }
            
            //DB
            
            BoardBean boardDTO = new BoardBean();
            BoardDAO boardDAO = new BoardDAO();
            boardDTO=boardDAO.boardView(seq);
            boardDAO.updateHit(seq);
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function sendData(){
		
		var subject = document.getElementsByName("subject")[0].value;
		var content = document.getElementsByName("content")[0].value;
		var seq = <%=seq%>
		document.formediter.submit(seq);
	}
	

	function reset1(){
		alert("리셋?")
		var frm=document.formediter;
		frm.content.value="";
		frm.subject.value="";
		
	}
	


</script>
</head>
<body>
	<%if(editable){ %>
	<form action="boardEdit.jsp" name=formediter>
	<table border="1">
		<tr>
		<td colspan="3"><input type="text" name="subject" size="80" placeholder="<%=boardDTO.getSubject() %>"></td>
		</tr>
		<tr align="center">
		<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
		<td width="150">작성자 : <%=boardDTO.getName() %></td>
		<td width="150">조회수 : <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
		<td colspan="3" height="200" valign="top"><textarea  rows="15" cols="82" name="content" placeholder="<%=boardDTO.getContent() %>"></textarea></td>
		</tr>
	</table>
	<input type="button" value="목록보기" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
		<%if(session.getAttribute("memId").equals(boardDTO.getId())){ %>
	<input type="button" value="글수정 등록" onclick="sendData()">
		<input type="button" value="다시작성하기" onclick="reset1()">
		<input type="hidden" value="<%=seq %>" name="seq">
		<input type="hidden" value="<%=pg %>" name="pg">
		<%} %>
	</form>

	<%}else{%>
	<table border="1">
		<tr>
		<td colspan="3"><font size="5"><%=boardDTO.getSubject() %></font></td>
		</tr>
		<tr align="center">
		<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
		<td width="150">작성자 : <%=boardDTO.getName() %></td>
		<td width="150">조회수 : <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
		<td colspan="3" height="200" valign="top"><%=boardDTO.getContent() %></td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
	<%if(session.getAttribute("memId").equals(boardDTO.getId())){ %>
	<input type="button" value="글수정" onclick="location.href='boardView.jsp?seq=<%=seq%>&pg=<%=pg %>&Editable=true'">
	<input type="button" value="글수정 신버전" onclick="location.href='boardModifyForm.jsp?seq=<%=seq%>'">
	<input type="button" value="글삭제" onclick="location.href='boardDelete.jsp?seq=<%=seq%>&pg=<%=pg %>'">
	<input type="hidden" value="<%=seq %>" name="seq">
	<%} %>
	<%} %>
</body>
</html>