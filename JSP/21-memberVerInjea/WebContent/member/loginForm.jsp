<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
	<script type="text/javascript" src="../script/memberScript.js?v=11"></script>
	<style type="text/css"> 
	table {
		background: #FAED7D;
	}
	</style>
</head>
<body>
	<form action="memberLoginPro.do" method="post" name="loginForm">
		<table border="1">
			<tr>
				<td width="70" align="center">아이디</td>
				<td><input type="text" name="id" size="30"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" size="30"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='writeForm.jsp'">
				</td>
				
			</tr>
		</table>
	
	</form>
	<a href="../main/index.jsp">메인화면으로 이동</a>
	
</body>
</html>