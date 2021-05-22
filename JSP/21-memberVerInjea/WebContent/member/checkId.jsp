<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//데이터 처리
	String id = request.getParameter("id");
	//DB 처리
	MemberDAO memberDAO = new MemberDAO();
	boolean exist = memberDAO.isExistedId(id);		// true : id가 있음, 사용불가
													// false: id가 없음, 사용가능
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkIdClose() {
		// 내장객체 opener: 현재 브라우저 기준으로 부모 브라우저를 관리하는 객체
		opener.writeForm.id.value = "<%=id %>";
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
	<form action="checkId.jsp" method="post" name="checkIdForm">
	<% if(exist) { // true: 사용불가 %>	
	<%=id %>는 이미 사용중인 아이디입니다. <br><br>
	아이디 <input type="text" name="id">
		<input type="button" value="중복체크" onclick="checkId()">
	<% } else {    // false: 사용가능 %>	
	<%=id %>는 사용가능한 아이디입니다. <br><br>
	<input type="button" value="사용하기" onclick="checkIdClose()">
	<%} %>
	
	</form>

		
</body>
</html>