<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<script type="text/javascript">
	if(confirm("회원탈퇴, 확실합니까?")) {
		location.href="delete.jsp";
	} else {
		location.href="../main/index.jsp"
	}
</script>
</head>
<body>
	<!--  
	<h2>회원 탈퇴 하시겠습니까?</h2>
	<input type="button" value="확인" onclick="location.href='delete.jsp'">
	<input type="button" value="취소" onclick="location.href='../main/index.jsp'">
	-->
</body>
</html>