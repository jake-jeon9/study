<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	String id = (String)session.getAttribute("memId");

	MemberDAO memberDAO = new MemberDAO();
	String currentPwd = memberDAO.passCheck(id);
	
	MemberDTO memberDTO = memberDAO.userInfo(id).get(0);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "../script/memberScript.js?v=3"></script>
<script type="text/javascript">
	function curcheckpass() {
		var form = document.modifyForm;
		var pwd = form.pwd.value;
		if(pwd != <%=currentPwd %>) {
			alert("현재 비밀번호가 일치하지 않습니다.");
		}
	}
</script>
</head>
<body>
<form action="modify.jsp?v=1" method="post" name="modifyForm" >
		<table border="1">
			<tr>
				<td width="70" align="center">현재</td>
				<td><input type="password" name="curpwd"></td>
			</tr>
			<tr>
				<td width = "70" align="center">바꿀</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width = "70" align="center">재확인</td>
				<td><input type="password" name="repwd"></td>
			</tr>
			<tr>
				<td width = "70" align="center">핸드폰</td>
				<td>
					<select name="tel1" style="width: 70px;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
					</select>	
					<input type="text" name="tel2" size="10">-
					<input type="text" name="tel3" size="10">
				</td>
			</tr>
			<tr>
				<td width = "70" align="center">주소</td>
				<td><input type="text" name="addr" size="50"></td>
			</tr>
			<tr>
				<td width = "70" align="center">이메일</td>
				<td>
					<input type="text" name="email1">@
					<select name="email2" style="width: 100px;">
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.com">hanmail.com</option>
						<option value="nate.com">nate.com</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td width = "70" align="center" colspan="2">
					<input type="button" value="정보 수정" onclick="checkModify();">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>