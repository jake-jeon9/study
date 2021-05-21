<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/scoreScript.js?v=1"></script>
<style type="text/css">

body{
width : 100%;
align-items: center;
}
table{
margin : auto;
 background: orange;
 text-align: center;
 width:300px;
}
#left{
	width:80px;
}
</style>
</head>
<body>
	<br>
	<h3 align="center">성 적 입력</h3>
	<br>
	<form action="scoreWrite.jsp" method="post" name="socreTable">
		<table border="1">
			<tr>
			<th id="left">학 번 : </th>
			<th><input type="text" name="studNo" size="20"></th>
			</tr>
			<tr>
			<th>이 름 : </th>
			<th><input type="text" name="name" size="20"></th>
			</tr>
			<tr>
			<th>국 어 : </th>
			<th><input type="text" name="kor" size="20"></th>
			</tr>
			<tr>
			<th>영 어 : </th>
			<th><input type="text" name="eng" size="20"></th>
			</tr>
			<tr>
			<th>수 학 : </th>
			<th><input type="text" name="mat" size="20"></th>
			</tr>
			<tr>
			<th colspan="2" align="center">
			<input type="button" value="등록" onclick="check()">
			<input type="reset" value="다시쓰기" >
			</th>
			</tr>
		</table>
	</form>
	<a href="scoreList.jsp">리스트 보기</a>
</body>
</html>