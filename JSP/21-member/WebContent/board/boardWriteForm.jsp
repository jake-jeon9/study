<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "../script/boardScript.js"></script>
<style type="text/css">
	table {
		background: lightskyblue;
	}
	
	
</style>
</head>
<body>
								<!-- 인풋타입 텍스트는 size로, textarea는 cols, row로 -->
	<form action="boardWrite.jsp" name="boardWriteForm" method="post">
		<table border = "1">
			<tr>
				<th align="center" width="60">제목</th>
				<td><textarea name="subject" cols="60" rows="1"></textarea></td>
			</tr>
			<tr>
				<th align="center">내용</th>
				<td><textarea name="content" cols="60" rows="25" ></textarea></td>
			</tr>
			<tr>
				<td align="center" colspan = "2">
					<input type="button" value="글쓰기" onclick = "finishWrite()">
					<input type="reset" value = "다시 작성">
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>