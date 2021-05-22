<%@page import="board.bean.BoardBean"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	request.setCharacterEncoding("utf-8");  

            int seq= Integer.parseInt(request.getParameter("seq"));
            String subject= request.getParameter("subject1");
            String content= request.getParameter("content1");
            int result;
            
            BoardBean boardDTO = new BoardBean();
            BoardDAO boardDAO = new BoardDAO();
            result = boardDAO.boardModify(subject,content,seq);
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

if(<%=result%> > 0){
	alert("수정성공");
	
}else{
	alert("수정실패");
	
}

</script>
</head>
<body>
	<%if (result>0){ %>
	등록되었습니다.
	<a href="boardView.jsp?seq=<%=seq %>&pg=1">수정된 글 보기</a>
	<%}else{ %>
	등록되지 않았습니다.
	<a href="boardModifyForm.jsp?seq=<%=seq %>&pg=1">다시 시도하러 가기</a>
	<%} %>
</body>
</html>