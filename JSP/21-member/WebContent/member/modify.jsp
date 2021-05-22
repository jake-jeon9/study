<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("memId");

	String password = request.getParameter("pwd");
	String num1 = request.getParameter("tel1");
	String num2 = request.getParameter("tel2");
	String num3 = request.getParameter("tel3");
	String addr = request.getParameter("addr");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	
	MemberDAO memberDAO = new MemberDAO();
	String currentPwd = memberDAO.passCheck(id);
	
	int su = memberDAO.modify(password, num1, num2, num3, email1, email2, addr, id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(su>0) { %>
		현재 비밀번호는 <%=currentPwd %>
		바꿀 아이디는 : <%=id %> 입니다. <br>
		비밀번호는 : <%=password %>로 변경했고 <br>
		핸드폰 번호는 : <%=num1 %> - <%=num2 %> - <%=num3 %><br>
		이메일 주소는 : <%=email1 %> @ <%=email2 %><br>
		주소는 : <%=addr %> 로 바뀌었습니다. <br>
	<% } else { %>
		정상적으로 업데이트가 안됐습니다.
	<% } %>
	
	<input type="button" value="목록으로" onclick="location.href='../main/index.jsp'">
</body>
</html>