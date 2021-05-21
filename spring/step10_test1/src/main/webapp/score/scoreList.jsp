<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ScoreDAO"%>
<%@page import="bean.ScoreVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    int pg = 1;
    int seeList =5;
    
    if(request.getParameter("pg")!=null){
    	pg= Integer.parseInt(request.getParameter("pg"));
    }
    
	if (request.getParameter("sl") != null) {
		seeList = Integer.parseInt(request.getParameter("sl"));
		session.setAttribute("sl", seeList);
	}
	if (session.getAttribute("sl") != null) {
		seeList = (int) session.getAttribute("sl");
	}
	
    //페이징
     
    ScoreVO vo = new ScoreVO();
    ScoreDAO dao = new ScoreDAO();
    int totalItem = dao.getTotalA();
    int totlaPage = (totalItem+seeList-1)/seeList;
  
    if((pg*seeList)>totalItem){
		pg=1;
	}
    
    int endNum = pg*seeList;
    int startNum = endNum - seeList+1;
    
    List<ScoreVO> list = new ArrayList<ScoreVO>();
    
    list = dao.ScoreList(startNum,endNum);
    
    int startPage = (pg-1)/3*3+1;
    int endPage = startPage+2;
    int maxPage = totlaPage;
    
    if(endPage>maxPage) endPage=maxPage;
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	body{
	
	width : 100%;
	align-self: center;
	align-content: center;
	
	}
	table{
	margin : auto;
	width : 800px;
	align-items: center;	
	background: lightgray;
	}
	#top{
	background: orange;
	text-align: center;
	}
	#body{
	background: mistyrose;
	text-align: center;
	}
	#bottom{
	background: white;
	}
#subject:link{color:black; text-decoration: none}
#subject:visited{color:black; text-decoration: none;}
#subject:hover{font-size:1.1em;color:red; text-decoration:underline;}
#subject:active{color:black; text-decoration: none;}

#paging:hover{color:red; text-decoration:underline;}

#currentPage {
	color: red;
	text-decoration: none;
}

#currentPage:bover {
	color: whtie;
	text-decoration: underline;
}

#paging {
	color: blue;
	text-decoration: none;
}
</style>

</head>
<body>
<hr>
<h2 align="center">성적 목록</h2>
	<table border="1">
	<tr>
	<td align="right" colspan="7">
	<select onchange="location.href=this.value">
	<option>리스트 목록</option>
	<option value="../score/scoreList.jsp?pg=<%=pg%>&sl=5">5</option>
	<option value="../score/scoreList.jsp?pg=<%=pg%>&sl=10">10</option>
	<option value="../score/scoreList.jsp?pg=<%=pg%>&sl=20">20</option>
	</select>
	</td>
	</tr>
		<tr id="top">
		<th>학번</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
		</tr>
		<%for(ScoreVO scoreVO : list){ %>
		<tr id="body">
		<td><%=scoreVO.getStudNo() %></td>
		<td><a id="subject" href="scoreView.jsp?studNo=<%=scoreVO.getStudNo()%>&pg=<%=pg%>"><%=scoreVO.getName() %></a></td>
		<td><%=scoreVO.getKor() %></td>
		<td><%=scoreVO.getEng() %></td>
		<td><%=scoreVO.getMat() %></td>
		<td><%=scoreVO.getTot() %></td>
		<td><%=scoreVO.getAvg() %></td>
		</tr>
		<%} %>
		<tr>
		<td id="bottom"colspan="7" align="center">
		<%if(startPage>1){ %>
		[<a id="paging" href="scoreList.jsp?pg=<%=startPage-1%>">이전</a>]
		<%} %> 
		<%for(int i = startPage; i<=endPage; i++){ %>
		 	<% if(i == pg){ %>
		<a id="currentPage" href="scoreList.jsp?pg=<%=i%>"><%=i %></a>
		<%}else{ %>
		<a id="paging" href="scoreList.jsp?pg=<%=i%>"><%=i %></a>
		<%} %>
		<%} %>
		<%if(endPage<maxPage){ %>
		[<a id="paging" href="scoreList.jsp?pg=<%=endPage+1%>">다음</a>]
		<%} %>
		</td>
		</tr>
		<tr>
		<td colspan="7" align="left"><input type="button" value="성적등록" onclick="location.href='scoreWriteForm.jsp'">
		</td>
		</tr>
		
	</table>
	
	
</body>
</html>