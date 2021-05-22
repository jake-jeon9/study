<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#passForm{
		margin : auto;
		width : 400px;
		border : 1px solid lightgray;
}

</style>
<title>글삭제</title>
</head>
<body>
	<div  id="passForm">
		<form  action ="boardDeleteProAction.do" name = "deleteform" method="post">
		<table >
			<tr>
			<td> 글 비밀번호 입력 : 
			<input type="password" name="form_password">
			<input type="hidden" name="board_num"  value="${ param.board_num}">
			<input type="hidden" name="pageInfo"  value="${ param.pageInfo}">
			</tr>
			<tr>
			<td colspan="2" align="center">
			<input type="submit" value="실행" >
			<input type="button" value="돌아가기"	onclick="history.back();">	
		</table>
		</form>
		</div>
</body>
</html>