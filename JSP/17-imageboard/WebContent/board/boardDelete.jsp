<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    int seq= Integer.parseInt(request.getParameter("seq"));
    int pg= Integer.parseInt(request.getParameter("pg"));
    
    BoardDAO boardDAO = new BoardDAO();
    int result= boardDAO.boardDelete(seq);

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		if(<%=result%>>0){
			alert("삭제되었습니다.")
			location.href="boardList.jsp?pg=<%=pg%>";
		}else{
			alert("오류발생")
			location.href="boardView.jsp?seq=<%=seq%>&pg=<%=pg%>";
		}
	}

</script>
</head>
<body>
	<h2> 아하~</h2>
</body>
</html>