<%@page import="member.dao.MemberDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% 
	// 인풋으로 입력받은 id와 패스워드를 받기
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// DAO 중 login 함수에 id와 pwd 값 전달해주기! (name을 얻음)
	MemberDAO memberDAO = new MemberDAO();
	String name = memberDAO.login(id, pwd);
	
	// 페이지 이동 (html에서는 a태그, 자바코드에서는 response)
	// 세션으로 공유데이터 사용
	if(name != null) {				//로그인 성공
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		response.sendRedirect("loginOk.jsp");
	} else {						//로그인 실패
		response.sendRedirect("loginFail.jsp");
	}
	
	/* url get 방식으로 공유데이터 사용
	if(name != null) {				//로그인 성공 (URL주소에 전달하기! 물음표 네임= 이거로!)
		response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name,"utf-8") + "&id=" +id);
	} else {						//로그인 실패
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

<%-- loginOk와 loginFail 로 나누기 위해 주석처리해줌!
<% if(name != null) {%>
	<%=name %> 님이 로그인하셨습니다.
	<%} else {%>
	로그인에 실패하였습니다.
	<%} %>
--%>
	
</body>
</html>