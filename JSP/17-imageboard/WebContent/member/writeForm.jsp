<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="../script/memberScript.js"></script>
</head>
<body>
	<form action="write.jsp" method="post" name="writeForm">
		<table border="1">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" placeholder="이름입력" name="name">
				</td>
			</tr>
			<tr>
				<td width="70" align="center">아이디</td>
				<td><input type="text" placeholder="아이디" name="id">
				<input type="button" value="중복체크" onclick="checkId()">
				</td>
			</tr>
			<tr>
			<td width="70" align="center">비밀번호</td>
				<td><input type="password" name="pw1"></td>
			</tr>
			<tr>
			<td width="70" align="center">재확인</td>
				<td><input type="password" name="pw2"></td>
			</tr>
			<tr>
				<td width="70" align="center">성별</td>
				<td>
				<input type="radio" name="gender" value="0" checked="checked">남자
				<input type="radio" name="gender" value="1">여자
				</td>
			</tr>
			<tr>
				<td width="70" align="center">이메일</td>
				<td>
					<input type="text" name="email1">@
					<select name="email2" style="width: 100px">
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gamil.com</option>
					<option value="nate.com">nate.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="70" align="center">핸드폰</td>
				<td>
				<select name="tel1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				</select>-
				<input type="text" name="tel2"  size="10">-
				<input type="text" name="tel3" size="10">
				</td>
			</tr>
			<tr>
				<td width="70" align="center">주소</td>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
				<input type = "button" value="회원가입" onclick="checkWrite()">
				<input type = "reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
		<input type="button" value="메인화면 이동" onclick="location.href='../main/index.jsp'">
</body>
</html>