<%@page import="dao.ScoreDAO"%>
<%@page import="bean.ScoreVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String studNo = (String)request.getParameter("studNo");
    
    int pg= Integer.parseInt(request.getParameter("pg"));
    ScoreVO vo = new ScoreVO();
    ScoreDAO dao = new ScoreDAO();
    
    vo = dao.getData(studNo);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

table{
margin : auto;
	width : 500px;
}
#body{
margin : auto;
 text-align: center;
 align-content: center;
 align-items: center;
}
#header{
background: orange;
}
#content{
background: mistyrose;
text-align: center;
}

</style>
</head>
<body>
	<div id="body">
	<table border="1">
	<tr>
	<th id="header" colspan="6"align="center"><%=vo.getName() %></th>
	</tr>
	<tr id="content">
	<th>학번</th>
	<th>국어</th>
	<th>영어</th>
	<th>수학</th>
	<th>총점</th>
	<th>평균</th>
	</tr>
	<tr id="content">
	<td><%=vo.getStudNo() %></td>	
	<td><%=vo.getKor()%></td>	
	<td><%=vo.getEng() %></td>	
	<td><%=vo.getMat() %></td>	
	<td><%=vo.getTot() %></td>	
	<td><%=vo.getAvg() %></td>	
	</tr>
	</table>
	<br>
	<input type="button" value="목록" onclick="location.href='scoreList.jsp?pg=<%=pg%>'">
	<input type="button" value="성적수정" onclick="#">
	<input type="button" value="성적삭제" onclick="location.href='scoreDelete.jsp?studNo=<%=vo.getStudNo()%>&pg=<%=pg%>'">
	</div>
	
	
</body>
</html>