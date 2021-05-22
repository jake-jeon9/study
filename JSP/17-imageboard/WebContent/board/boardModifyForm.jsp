<%@page import="board.bean.BoardBean"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	//데이터 가져오기
            int seq= Integer.parseInt(request.getParameter("seq"));
            
            BoardBean boardDTO = new BoardBean();
            BoardDAO boardDAO = new BoardDAO();
            boardDTO=boardDAO.boardView(seq);
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js?v=2"></script>
<script type="text/javascript">

function reset1(){
	alert("리셋?")
	var frm=document.NewContent1;
	frm.content1.value="";
	frm.subject1.value="";
	
}
</script>
</head>
<body>
<form action="boardModify.jsp" name="NewContent1" method="post">
		<table border="1">
			<tr>
			<th width="50">제목</th>		
			<th><input type="text" name="subject1" size="50" value="<%=boardDTO.getSubject() %>" >
			
			</th>
			</tr>
			<tr>
			<th width="50">내용</th>
			<td><textarea rows="15" cols="52" name = "content1">
			<%=boardDTO.getContent() %></textarea></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
			<input type="button" value="저장하기" onclick="checkBoardModify()">
			<input type="button" value="다시작성" onclick="reset1()">
			<input type="hidden" value="<%=seq %>" name="seq">
			</td>
			</tr>
		</table>
	</form>
</body>
</html>