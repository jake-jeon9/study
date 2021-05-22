<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
		<table border="1">
			
			<tr>
			<th width="50">제목</th>
			<td><input type="text" name="subject" size="43"></td>
			</tr>		
			<tr>
			<th>내용</th>
			<td><textarea name="content" cols="45" rows="15"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="file" name="upload1" size="50"></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="file" name="upload2" size="50"></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="submit" value="파일 업로드">
			<input type="reset" value="다시작성">
			</td>
			</tr>
		</table>
	</form>

</body>
</html>