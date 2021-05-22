<%@page import="java.util.List"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// 목록은 5개씩
	// pg=1 : rn>=1 and rn<=5
	// pg=2 : rn>=6 and rn<=10 : 10 -> pg * 5
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	MemberDAO memberDAO = new MemberDAO();
	List<MemberDTO> list = memberDAO.selectList(startNum, endNum);
	
	// 페이징 처리
	// 총 페이지수 = (총 회원수 + 4) / 5;
	int totalMember = memberDAO.getTotalMember();	// 총 회원수
	int totalP = (totalMember + 4) / 5;				// 총 페이지수
	
	// 3블럭으로 나눠서 보여주기
	// 총 페이지수 : 8
	//		[1][2][3][다음]
	// [이전][4][5][6][다음]
	// [이전][7][8]
	// pg=1 : (1-1)/3*3+1 -> 1
	// pg=2 : (2-1)/3*3+1 -> 1
	// pg=3 : (3-1)/3*3+1 -> 1
	// pg=4 : (4-1)/3*3+1 -> 4
	// pg=5 : (5-1)/3*3+1 -> 4
	// pg=6 : (6-1)/3*3+1 -> 4
	int startPage = (pg-1)/3*3 + 1;
	int endPage = startPage + 2;
	if(endPage > totalP) endPage = totalP;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style type="text/css">
#paging {color: blue; text-decoration: none;}
#currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<table border="1">
			<tr style="background: orange;">
				<th width="70">이름</th>
				<th width="100">아이디</th>
				<th width="50">성별</th>
				<th width="200">이메일</th>
				<th width="150">전화번호</th>
				<th width="150">가입일</th>
			</tr>
			<% for(MemberDTO memberDTO : list) { %>
				<tr align="center" style="background: yellow;">
					<td><%= memberDTO.getName() %></td>
					<td><%= memberDTO.getId() %></td>
					<td><%= memberDTO.getGender() %></td>
					<td><%= memberDTO.getEmail1() %>@<%= memberDTO.getEmail2() %></td>
					<td><%= memberDTO.getTel1() %>-<%= memberDTO.getTel2() %>-<%= memberDTO.getTel3() %></td>
					<td><%= memberDTO.getLogtime() %></td>
				</tr>
			<% } %>
			<!-- 페이징 -->
			<tr>
				<td colspan="6" align="center">
			<% if(startPage > 3) { %>
					[<a id="paging" href="memberList.jsp?pg=<%=startPage-1%>">이전</a>]
			<% } %>
					
			<% for(int i=startPage; i<=endPage; i++) { %>
				<% if(pg == i) {	// 현재 페이지 %>
					[<a id="currentPaging" href="memberList.jsp?pg=<%=i%>"><%=i%></a>]
				<% } else { 		// 현재 페이지 아님 %>
					[<a id="paging" href="memberList.jsp?pg=<%=i%>"><%=i%></a>]
				<% } %>	
			<% } %>
			
			<% if(endPage < totalP) { %>	
					[<a id="paging" href="memberList.jsp?pg=<%=endPage+1%>">다음</a>]
			<% } %>
				</td>
			</tr>
	</table>
	<a href="../main/index.jsp">메인화면</a>
</body>
</html>