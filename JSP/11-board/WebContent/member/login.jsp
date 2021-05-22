<%@page import="java.net.URLEncoder"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); // 한글 설정

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO memberDAO = new MemberDAO();
	String name = memberDAO.login(id, pwd);
	
	// 페이지 이동 
	// 세션으로 공유 데이터 사용
	if(name != null) {	// 로그인 성공
		// 세션에 데이터 저장
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		
		response.sendRedirect("loginOk.jsp");
	} else {			// 로그인 실패
		response.sendRedirect("loginFail.jsp");
	}
	/* url get 방식으로 공유 데이터 사용
	if(name != null) {	// 로그인 성공
		response.sendRedirect("loginOk.jsp?name=" +
							   URLEncoder.encode(name, "utf-8") + "&id=" + id);
	} else {			// 로그인 실패
		response.sendRedirect("loginFail.jsp");
	}
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<% if(name != null) { %>
	<p><%= name %>님이 로그인</p>
<% } else {%>
	<p>아이디 또는 비밀번호가 틀렸으니 다시 로그인 하세요.</p>
<% } %>
--%>
</body>
</html>