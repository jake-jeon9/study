<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#registForm{
	width :500px;
	height : 380px;
	border : 1px solid lightgray;
	margin : auto;
	}
h2{
	text-align:  center;
}	
table {
	margin : auto;
	width : 450 px;
}
.td_left{
		width : 150px;
		background : orange;
}
.td_right{
		width:300px;
		background : skyblue;
}

</style>
</head>
<body>
		<h2>게시판 글 등록 </h2>
		<form action="boardWritePro.do" enctype="multipart/form-data" method="post"
			name="boardform" id=registForm>
			<table>
				<tr>
					<td class="td_left"> <label for="board_name">글쓴이</label></td>
					<td class="td_right">
					<input type="text" name="board_name"  id="board_name"  required ="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="board_pw">비밀번호</label></td>
					<td class="td_right">
					<input type="password" name="board_pw" id="board_pw"  required ="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="">제목</label></td>
					<td class="td_right">
					<input type="text" name="board_subject" id="board_subject" required ="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="">내용</label></td>
					<td class="td_right">
					<textarea rows="15" cols="40" name="board_content" required ="required" id = "board_content"></textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="">파일</label></td>
					<td class="td_right">
					<input type="file"  name="board_file"  id="board_file" required ="required">
					</td>
				</tr>
				<tr>
					<td colspan ="2" align ="center">
					<input type="submit" value="등록">
					<input type="reset" value="다시쓰기">
 					
					</td>
				</tr>			
			</table>
		</form>
</body>
</html>