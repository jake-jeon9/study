<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function checkIdClose() {
		// 내장객체 opener: 현재 브라우저 기준으로 부모 브라우저를 관리하는 객체
		opener.writeForm.id.value = "${param.id}";
		window.close();
		opener.writeForm.pwd.focus();
	}
	
	function checkId() {
		var frm = document.checkIdForm;
		if(!frm.id.value) {
			alert("사용하실 아이디를 입력하세요.")
			frm.id.focus();
		} else {
			frm.submit();
		}
	}
</script>
</head>
<body>
	<form action="memberCheckId.do" method="post" name="checkIdForm">
		
		요청하신 아이디 : " ${param.id }" 는 ${result } // exist : ${exist }
	<br>
	
	<c:if test="${exist==false }">
	<input type="button" value="사용하기" onclick="checkIdClose()">
	</c:if>
	<c:if test="${exist }">
	<input type="text" name="id">
	<input type="button" value="중복체크" onclick="checkId()">
	</c:if>
	
	
	</form>

		
</body>
</html>