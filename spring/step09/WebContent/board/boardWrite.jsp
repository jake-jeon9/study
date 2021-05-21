<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");
    String id = (String)session.getAttribute("memId");
    String name =(String)session.getAttribute("memName");
    int result = 0;
    BoardDAO dao = new BoardDAO();
    BoardDTO dto = new BoardDTO();
    dto.setId(id);
    dto.setName(name);
    dto.setContent(content);
    dto.setSubject(subject);
    
    result = dao.writeContent(dto);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	if(<%=result >0%>){
		alert("등록 성공..");
		location.href="./boardList.jsp";
	}else{
		alert("등록실패..");
		location.href="./boardList.jsp";
	}
	
	

</script>
</head>
<body>

</body>
</html>