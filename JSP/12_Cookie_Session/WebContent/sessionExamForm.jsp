<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션</title>
</head>
<body>
	<h2>정보입력</h2>
	<form action ="sessionExamPro.jsp" method="post">
		아이디 : <input type="text" name="id" maxlength="16"><br>
		패스워드 : <input type="password" name="pw" maxlength="16"><br>
		<input type="submit" value="정보입력">
	</form>
</body>
</html>