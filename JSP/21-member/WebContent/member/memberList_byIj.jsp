<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	MemberDAO memberDAO = new MemberDAO();	
	//전체 회원 갯수
	int listNum = memberDAO.countList();
	
	int endNum = pg * 5;
	int startNum = endNum - 4;
		
	List<MemberDTO> list = memberDAO.selectList(startNum, endNum);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		border: 1px solid;
	}
	
	tr,td {
		border: 1px solid;
	}
</style>
</head>
<body>
	<table>
		<tr style="background: orange;">
			<td>이름</td>
			<td>아이디</td>
			<td>성별</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>가입일</td>
		</tr>
		<% for(MemberDTO memberDTO : list ) { %>
			<tr>
				<td><%=memberDTO.getName() %></td>
				<td><%=memberDTO.getId() %></td>
				<td><%=memberDTO.getGender() %></td>
				<td><%=memberDTO.getEmail1() %>@<%=memberDTO.getEmail2() %></td>
				<td><%=memberDTO.getTel1() %>-<%=memberDTO.getTel2() %>-<%=memberDTO.getTel3() %></td>
				<td><%=memberDTO.getLogtime() %></td>
					
			</tr>
		<% } %>	
		<tr>
			<td colspan="6" align="center">
				<% 
		 			int indexNum = listNum/5;
					int i = 0;
					int indexListNum = i+2;
		 		%>
		 		
		 		<% 	 if(listNum%5 == 0) { %>
		 		<%     if(i > 3) { %>
		 				[이전]
		 		<%     } %>
		 		<%			for(i = i + 1 ; i <=indexNum; i++) { %>
		 				[<a href="../member/memberList.jsp?pg=<%=i %>"><%=i %></a>]
		 		<% 			} %>
		 		<% 	} 
		 			 else { %>
		 		<%			for(i = i + 1 ; i <= indexNum+1 ; i++) { %>
		 				[<a href="../member/memberList.jsp?pg=<%=i %>"><%=i %></a>]
		 		<% 			} %>
		 		<% 	 } %>
		 	</td>
		</tr>
	</table>
	<a href="../main/index.jsp">메인 화면으로 이동</a>
</body>
</html>