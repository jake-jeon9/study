<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 보기</title>
<style type="text/css">
tr {
	background: #ffffcc;
}
#tr_top {
	background: orange;
	text-align: center;
}
</style>
</head>
<body>
	<table border="1">
		<tr id="tr_top">
			<td colspan="6">
				<font size="5">${dto.name}</font>
			</td>
		</tr>
		
		<tr align="center">
			<td width="100">학번</td>
			<td width="100">국어</td>
			<td width="100">영어</td>
			<td width="100">수학</td>
			<td width="100">총점</td>
			<td width="100">평균</td>
		</tr>
		
		<tr align="center">
			<td width="100">${dto.studNo}</td>
			<td width="100">${dto.kor}</td>
			<td width="100">${dto.eng}</td>
			<td width="100">${dto.mat}</td>
			<td width="100">${dto.tot}</td>
			<td width="100">${dto.avg}</td>
		</tr>
	</table>
	
	<input type="button" value="목록" 
		onclick="location.href='scoreList.do?pg=${pg}'">
	<input type="button" value="성적 수정" 
		onclick="location.href='scoreModifyForm.do?studNo=${studNo}&pg=${pg}'">
	<input type="button" value="성적 삭제" 
		onclick="location.href='scoreDelete.do?studNo=${studNo}'">
</body>
</html>







