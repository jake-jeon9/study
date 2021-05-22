<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("memId");
	
	// DB
	MemberDAO memberDAO = new MemberDAO();
	int su = memberDAO.delete(id);
	
	// 세션삭제
	if(su > 0) {
		session.removeAttribute("memId"); 
		session.removeAttribute("memName"); 
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=su > 0%>) {
		alert("회원탈퇴완료");
	} else {
		alert("회원탈퇴실패");
	}
	location.href="../main/index.jsp";
</script>
</head>
<body>
</body>
</html>