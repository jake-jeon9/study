<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
<script type="text/javascript" src="../script/scoreScript.js"></script>
<style type="text/css">
h2 {text-align: center;}
table {
	margin: auto;
	width: 220px;
}
.td_left {
	width: 50px;
	background: orange;
}
.td_right {
	width: 150px;
	background: skyblue;
}
</style>
</head>
<body>
	<h2>성적 입력</h2>
	<form action="scoreWrite.do" method="post" name="scoreForm">
		<table>
			<tr align="center">
				<td class="td_left">학번</td>
				<td class="td_right"><input type="text" name="studNo"></td>
			</tr>
			<tr align="center">
				<td class="td_left">이름</td>
				<td class="td_right"><input type="text" name="name"></td>
			</tr>
			<tr align="center">
				<td class="td_left">국어</td>
				<td class="td_right"><input type="text" name="kor"></td>
			</tr>
			<tr align="center">
				<td class="td_left">영어</td>
				<td class="td_right"><input type="text" name="eng"></td>
			</tr>
			<tr align="center">
				<td class="td_left">수학</td>
				<td class="td_right"><input type="text" name="mat"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="button" value="등록" onclick="checkScoreWrite()">
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>







