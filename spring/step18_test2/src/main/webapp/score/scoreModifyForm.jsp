<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
<script type="text/javascript" src="../script/scoreScript.js?v=3"></script>
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
	<h2>성적 수정</h2>
	<form action="scoreModify.do" method="post" name="scoreForm">
		<input type="hidden" name="pg" value="${pg}">
		<table>
			<tr align="center">
				<td class="td_left">학번</td>
				<td class="td_right"><input type="text" name="studNo" value="${scoreDTO.studNo}"
											readonly="readonly"></td>
			</tr>
			<tr align="center">
				<td class="td_left">이름</td>
				<td class="td_right"><input type="text" name="name" value="${scoreDTO.name}"
											readonly="readonly"></td>
			</tr>
			<tr align="center">
				<td class="td_left">국어</td>
				<td class="td_right"><input type="text" name="kor" value="${scoreDTO.kor}"></td>
			</tr>
			<tr align="center">
				<td class="td_left">영어</td>
				<td class="td_right"><input type="text" name="eng" value="${scoreDTO.eng}"></td>
			</tr>
			<tr align="center">
				<td class="td_left">수학</td>
				<td class="td_right"><input type="text" name="mat" value="${scoreDTO.mat}"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="button" value="수정" onclick="checkScoreModify()">
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>







