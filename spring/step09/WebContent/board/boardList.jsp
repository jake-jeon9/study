<%@page import="java.util.ArrayList"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int pg = 1;
	int seeListNum = 5;
	if (request.getParameter("pg") != null) {
		pg = Integer.parseInt(request.getParameter("pg"));

	}
	if (request.getParameter("sl") != null) {
		seeListNum = Integer.parseInt(request.getParameter("sl"));
		session.setAttribute("sl", seeListNum);
	}
	if (session.getAttribute("sl") != null) {
		seeListNum = (int) session.getAttribute("sl");
	}

	int endNum = pg * seeListNum;
	int startNum = endNum - seeListNum + 1;

	BoardDAO boardDAO = new BoardDAO();
	List<BoardDTO> list = new ArrayList<BoardDTO>();

	int totalNum = boardDAO.getTotalA();

	int startPage = (pg - 1) / 3 * 3 + 1;

	int endPage = startPage + 2;

	int maxPage = (totalNum + seeListNum - 1) / seeListNum;

	if (endPage > maxPage)	endPage = maxPage;

	list = boardDAO.boardList(startNum, endNum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#subject:link{color:black; text-decoration: none}
#subject:visited{color:black; text-decoration: none;}
#subject:hover{color:red; text-decoration:underline;}
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
<script type="text/javascript">
	
	function islogin(seq){
		<% if(session.getAttribute("memId")==null){%>
		alert("먼저 로그인하세요.")
		<%}else{ %>
		location.href="../board/boardView.jsp?seq="+seq+"&pg="+<%=pg%>;
		<%} %>
	}

</script>
</head>
<body>

	<%	if (session.getAttribute("memId") != null) { %>
	<select id="list" name="list" onchange="location.href=this.value">
		<option>리스트보기</option>
		<option value="../board/boardList.jsp?pg=<%=pg%>&sl=5">5</option>
		<option value="../board/boardList.jsp?pg=<%=pg%>&sl=10">10</option>
		<option value="../board/boardList.jsp?pg=<%=pg%>&sl=20">20</option>
	</select>
	<table border="1">
		<tr bgcolor="ffff00">
			<th width="70">글번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>

		<%	for (BoardDTO boardDTO : list) {%>
		<tr bgcolor="ffffcc" align="center">
			<td><%=boardDTO.getSeq()%></td>
			<td><a id="subject" href="#" onclick="islogin(<%=boardDTO.getSeq() %>)">
			<%=boardDTO.getSubject()%></a></td>
			<td><%=boardDTO.getName()%></td>
			<td><%=boardDTO.getLogtime()%></td>
			<td><%=boardDTO.getHit()%></td>
		</tr>
		<%}%>

		<!--  페이징 작업 -->
		<tr>
			<td colspan="5" align="center">
			<%	if (pg > 3) {%>
			 <a id="paging" href="../board/boardList.jsp?pg=<%=startPage - 1%>">[이전]</a> 
			 <%}%>
			 <%	for (int i = startPage; i <= endPage; i++) { %>
			  	<% if(i == pg){ %>
			  	 <a id="currentPage" href="../board/boardList.jsp?pg=<%=i%>"><%=i%></a>
			  <%}else{ %>
			  <a id="paging" href="../board/boardList.jsp?pg=<%=i%>"><%=i%></a>
			  <%} %> 
			  <%} %>
			  <%if (endPage < maxPage) { %>
			  <a id="paging" href="../board/boardList.jsp?pg=<%=endPage + 1%>">[다음]</a>
			   <%}%>
			</td>
	</table>



	<%	} else {%>
	<a href="../member/loginForm.jsp">로그인</a>
	<%	}	%>

	<a id="paging" href="../board/boardWriteForm.jsp">새 글쓰기</a>
	<a id="paging" href="#">메인화면 가기</a>
</body>
</html>