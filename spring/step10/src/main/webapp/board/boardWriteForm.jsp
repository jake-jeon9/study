<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../javaScript/script.js?v=2">
</script>
</head>
<body>
	<form action="boardWrite.jsp" method="post" name="table">
		<table border="1">
		<tr>
		<th> 제목</th>
		<td><input type="text" name="subject" size="48">
		</td>
		</tr>
		<tr>
		<th>내용</th>
		<td>
		<textarea rows="30" cols="50" name="content"></textarea>
		</td>
		</tr>
		<tr>
		<td colspan="2" align="center">
		<input type="button" value="글쓰기" onclick="check()">
		<input type="reset" value="다시작성">
		</td>
		</tr>		
		</table>
	</form>
</body>
</html>