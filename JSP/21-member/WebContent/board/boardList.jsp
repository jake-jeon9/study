<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	// 데이터
    	int pg = Integer.parseInt(request.getParameter("pg"));
    
    
    	// 목록보기 => 한 페이지당 목록을 몇개 보여줄지 설정
    	// 1페이지당 5개씩 (5의 배수 -4, 5의 배수)
    	// pg=1 : rn>=1 and rn<=5
		// pg=2 : rn>=6 and rn<=10
		// pg=3 : rn>=11 and rn<=15
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
    	
		// 페이징처리 : 1페이지당 목록 5개 표시
		// 총 글 수 : 12
	    // 총 페이지수 : 3        [1][2][3]    => (총글수+4)/5
	    
	    // 총 글 수
	    
	    
		
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<script type="text/javascript">
	function isLogin(seq) {
		<%	if(session.getAttribute("memId") == null) {%>  // 널이면, logout 상태
			alert("먼저 로그인 하세요.")
		<% } else { %>									   // login 상태
			location.href = "boardView.jsp?seq=" + seq + "&pg=" + <%=pg%>;
		<% }  %>
	}
</script>

<style type="text/css">
	#subjectA:link { text-decoration: none; color:black;}
	#subjectA:visited { text-decoration: none; color:black;}
	#subjectA:hover { text-decoration: underline; color:black; font-size: 1.2em;}
	#subjectA:active { text-decoration: none; color:black;}
	
	#paging {color: blue; text-decoration: none;}
	#currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<table border="1">
		<tr bgcolor="ffff00">
			<th width="70">글번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>
		<% for (BoardDTO boardDTO : list) { %>
		<tr align="center" bgcolor="ffffcc">
			<td><%=boardDTO.getSeq() %></td>
			<td><a href="#" id="subjectA" onclick="isLogin(<%=boardDTO.getSeq()%>)">
				<%=boardDTO.getSubject() %></a></td>
			<td><%=boardDTO.getId() %></td>
			<td><%=boardDTO.getLogtime() %></td>
			<td><%=boardDTO.getHit() %></td>
		</tr>
		<%} %>
		
		<tr align="center"> 
		<!-- 
			<% // 선생님이 작성하신 코드
		 	//		int pageNum = indexNum/3; // 넘겨야할 페이지 갯수
		 			// (1-1)/3 * 3 + 1 = 1, (2-1)/3 * 3 + 1 = 1, (3-1)/3 * 3 + 1 = 1
		 			// (4-1)/3 * 3 + 1 = 4, (5-1)/3 * 3 + 1 = 4, (6-1)/3 * 3 + 1 = 4
		 	//		int startPage = (pg-1)/3*3 + 1;
		 	//		int endPage = startPage + 2;
		 	//		if(endPage > indexNum) {
		 				
		 	//		}
		 		int totalA = boardDAO.getTotalA();   
      			int totalP = (totalA+4)/5; 
 				int startPage = (pg-1)/3*3+1; 
				int endPage = startPage+2;
				if(endPage>totalP) endPage = totalP;
		 	%>		
		 	
		 -->
		 	<td colspan="5">
		 		
    	     <%if(startPage > 3) {%>
	            [<a id="paging" href="boardList.jsp?pg=<%=startPage-1 %>">이전</a>]
        	 	<%} %>
            
         		<% for(int i=startPage; i<=endPage; i++) {%>   
        			 <% if(pg == i) { %>
        			 	[<a id="currentPaging" href="boardList.jsp?pg=<%=i %>"><%=i %></a>]
        			 <% } else { %>
        			 	[<a id="paging" href="boardList.jsp?pg=<%=i %>"><%=i %></a>]
        			 <% } %>
    	     		<%} %>   
	         <%if(endPage < totalP) { %>
	         	[<a id="paging" href="boardList.jsp?pg=<%=endPage+2 %>">다음</a>]
	         <% } %>	
         
		 	
		 	<!-- // 여긴 내가 작성한 코드
		 		<% 
		 			int listNum = boardDAO.getTotalA();
		 			int indexNum = listNum/5;
		 		%>
		 		
		 		<% 	 if(listNum%5 == 0) { %>
		 		<%		for(int i = 0 ; i < indexNum ; i++) { %>
		 			[<a href="../board/boardList.jsp?pg=<%=i+1 %>"><%=i+1 %></a>]
		 		<% 		} %>
		 		<% 	} 
		 			 else { %>
		 		<%		for(int i = 0 ; i <= indexNum ; i++) { %>
		 			[<a href="../board/boardList.jsp?pg=<%=i+1 %>"><%=i+1 %></a>]
		 		<% 		} %>
		 		<% 	 } %>
		 		 -->
		 	</td>
		 </tr>

<%-- 
<% for(int i=0; i<list.size(); i++) {
			BoardDTO boardDTO = list.get(i);
		%>
		<tr align="center">
			<td><%=boardDTO.getSeq() %></td>
			<td><%=boardDTO.getSubject() %></td>
			<td><%=boardDTO.getId() %></td>
			<td><%=boardDTO.getLogtime() %></td>
			<td><%=boardDTO.getHit() %></td>
		</tr>
		<%} %>


--%>			
	</table>
<% if(session.getAttribute("memId") == null) { %>			<!-- 로그아웃 상태 -->
	<a href="../member/loginForm.jsp">로그인 페이지로 이동</a>
<% } else {%>												<!-- 로그인 상태 -->
	<a href="boardWriteForm.jsp">글쓰기</a>
	<a href="../main/index.jsp">메인 화면으로 이동</a>	
<% } %>	
</body>
</html>





















