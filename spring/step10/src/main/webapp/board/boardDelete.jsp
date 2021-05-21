<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    int seq = Integer.parseInt(request.getParameter("seq"));
    int pg = Integer.parseInt(request.getParameter("pg"));
    boolean result=false;
   
    BoardDAO dao = new BoardDAO();
    
    if(request.getParameter("result")!=null){
    	int k = dao.boardDelete(seq);
    	String forward = "boardList.jsp?pg="+pg;
    	result=true;
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
    	dispatcher.forward(request,response);	
		
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	if(!<%=result%>){
	var result = confirm("삭제할꺼야?");
		
		if(result){
			location.href="boardDelete.jsp?seq=<%=seq%>&pg=<%=pg%>&result="+result;
		} else {
			location.href="boardView.jsp?seq=<%=seq%>&pg=<%=pg%>"
		}
	}

</script>
</head>
<body>

</body>
</html>