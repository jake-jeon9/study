<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int pg = Integer.parseInt(request.getParameter("pg")); // ?pg=1 를가져옴
	
	// 목록보기 => 1페이지당 몇개의 목록을 보여줄지를 설정해야함.
	// 1페이지당 5개씩 (pg * 5)
	// pg=1 : rn>=1 and rn<=5
	// pg=2 : rn>=6 and rn<=10
	// pg=3 : rn>=11 and rn<=15
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	BoardDAO boardDAO = new BoardDAO();
	List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	
	// 페이징 처리
	// 총 글수 : 12
	// 총 페이지수 : 3		[1][2][3]	=> (총 글수+4)/5
	
	// 페이징 처리
	// 총 글수 : 23
	// 총 페이지수 : 5		[1][2][3][4][5]	=> (총 글수+4)/5
	
	// 페이징 처리
	// 총 글수 : 25
	// 총 페이지수 : 5		[1][2][3][4][5]	=> (총 글수+4)/5
	int totalA = boardDAO.getTotalA();	// 총 글수 구하기
	int totalP = (totalA + 4) / 5;		// 총페이지수 계산
	
	/** 페이지 번호를 몇개씩 보여줄지 설정 **/
	// 3블럭 표시
	// 총페이지수 :8
	// 		[1][2][3][다음]
	// [이전][4][5][6][다음]
	// [이전][7][8]

	
	//startPage 계산 결과
	// (1-1)/3*3 + 1 => 1, (2-1)/3*3 + 1 => 1, (3-1)/3*3 + 1 => 1
	// (4-1)/3*3 + 1 => 4, (5-1)/3*3 + 1 => 4, (6-1)/3*3 + 1 => 4
	int startPage = (pg-1)/3*3 + 1;
	// 공식 ( pg-1) / 보여줄 페이징뷰 * 보여줄 페이징뷰 + 1
	int endPage = startPage + 2;
	// 엔드 페이지는 총  보여줄 리스트 갯수 startpage + 갯수(2);
	if(endPage > totalP) endPage = totalP;	// 엔드페이지가 total 페이지보다클때 초과하는 값을 방지하기 위해서
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<script type="text/javascript">
	function isLogin(seq) {
		<% if(session.getAttribute("memId") == null) { %>
			alert("먼저 로그인 하세요");
		<% } else { %>
			location.href = "boardView.jsp?seq=" + seq + "&pg=" + <%=pg%>;
		<% } %>
	}
</script>
<style type="text/css">
#subjectA:link {color: black; text-decoration: none;}
#subjectA:visited {color: black; text-decoration: none;}
#subjectA:hover {color: green; text-decoration: underline;}
#subjectA:active {color: black; text-decoration: none;}
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
			<%-- for(int i=0; i<list.size(); i++) {
				BoardDTO boardDTO = list.get(i); 
			--%>
			<% for(BoardDTO boardDTO : list) { %>
				<tr align="center" bgcolor="ffffcc">
					<td><%= boardDTO.getSeq() %></td>
					<td><a href="#" id="subjectA" onclick="isLogin(<%=boardDTO.getSeq()%>);"><%= boardDTO.getSubject() %></a></td>
					<td><%= boardDTO.getId() %></td>
					<td><%= boardDTO.getLogtime() %></td>
					<td><%= boardDTO.getHit() %></td>
				</tr>
			<% } %>
			<!-- 페이징 -->
			<tr>
				<td colspan="5" align="center">
			<% if(startPage > 3) { %>
					[<a id="paging" href="boardList.jsp?pg=<%=startPage-1%>">이전</a>]
			<% } %>
					
			<% for(int i=startPage; i<=endPage; i++) { %>
				<% if(pg == i) {	// 현재 페이지 %>
					[<a id="currentPaging" href="boardList.jsp?pg=<%=i%>"><%=i%></a>]
				<% } else { 		// 현재 페이지 아님 %>
					[<a id="paging" href="boardList.jsp?pg=<%=i%>"><%=i%></a>]
				<% } %>	
			<% } %>
			<% if(endPage < totalP) { %>	
					[<a id="paging" href="boardList.jsp?pg=<%=endPage+1%>">다음</a>]
			<% } %>
				</td>
			</tr>
		</table>
		<% if(session.getAttribute("memId") == null) { // 로그아웃 상태 %>
			<a href="../member/loginForm.jsp">로그인</a>
		<% } else { // 로그인 상태 %>
			<a href="boardWriteForm.jsp">글쓰기</a>
		<% } %>
		&nbsp; <a href="../main/index.jsp">메인화면</a>	
</body>
</html>