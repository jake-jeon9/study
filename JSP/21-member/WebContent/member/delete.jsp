<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		넘겨진 값 : 1. 리절트  ${param.result } , 2. id : ${param.id }
		
		<br>
		<br>s

		<c:if test="${param.result>0 }">
		고객님 아이디 : ${param.id } 회원탈퇴작업이 성공적으로 이루어졌습니다.
		</c:if>
		<c:if test="${result==0 }">
		고객님아이이 : ${param.id }회원탈퇴에 실패했습니다.
		</c:if>
	<br>
	<a href="../main/index.jsp">메인 화면으로 이동</a>
</body>
</html>