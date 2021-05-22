<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript" src="../script/boardScript.js"></script>
</head>
<body>
	<form action="boardWrite.jsp" method="post" name="boardWriteForm">
		<table border="1">
			<tr>
				<th width="50">제목</th>
				<td><input type="text" name="subject" size="43"></td>
			</tr>
			<tr>
				<th width="50">내용</th>
				<td><textarea rows="15" cols="45" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="checkBoardWrite()">
					<input type="reset" value="다시 작성">
					<input type="button" value="처음으로" onclick="location.href='../main/index.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>