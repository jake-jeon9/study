<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<%-- javaScript 파일을 import 시킬땐 꼭 주의해주세요. 저도 v=3 이런식으로 버전을 안높였을 때, js를 못읽어와서 오류난적이 많아요.
	혹시 만약 js로 작성한 어떤 함수가 동작이 안된다면, 우선적으로 버전을 확인하시는걸 추천드립니다. --%>
<script type="text/javascript" src="./script/memberScript.js?v=3"></script>
<style type="text/css">
	table {
		background:mistyrose;
	}
</style>
</head>
<body>
	<%--자 이제 지금 이 페이지가 index.jsp에 include 된거에요. 근데 주소를 잘보시면 저흰 writeForm.jsp가 아니라 index.jsp에서 해당 내용이 실행되는거에요. 모든 페이지가 다 index.jsp에서 나오는거니까
		이 점 주의하시고 봐주세요. --%>
	<!-- 비밀번호 포함했으니 post 방식으로 보내기 -->
	<%-- form은 action안에 있는 내용으로 데이터를 보내는 방식입니다.
		name = value 방식으로 보내게돼요. 받는쪽에선 request.getParameter("name"); 형식으로 받게 됩니다.
		이 부분은 따로 설명할 내용이 아니기 때문에 그냥 넘어가겠습니다. 
		action을 보시면 memberWritePro.do라고 되어있네요. 이제 form안에 table에 있는 데이터들은 memberWritePro.do로 공유되는겁니다.
		servlet은 다시 설명할 필요가 없으니 이제 해당 요청을 받고 MemberWriteProAction.java로 넘어가겠습니다. --%>
	<form action="memberWritePro.do" method="post" name="writeForm" >
		<table border="1">
			<tr>
				<td width = "70" align="center">이름</td>
				<td><input type="text" name="name" placeholder = "이름 입력"></td>
			</tr>
			<tr>
				<td width = "70" align="center">아이디</td>
				<td><input type="text" name="id">
				<input type="button" value="중복체크" onclick="checkId();">
				</td>
			</tr>
			<tr>
				<td width = "70" align="center">비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width = "70" align="center">재확인</td>
				<td><input type="password" name="repwd"></td>
			</tr>
			<tr>
				<td width = "70" align="center">성별</td>
				<td><input type="radio" name="gender" value="0" checked="checked">남
				<input type="radio" name="gender" value="1" >여
				</td>
			</tr>
			<tr>
				<td width = "70" align="center">이메일</td>
				<td>
					<input type="text" name="email1">@
					<select name="email2" style="width: 100px;">
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.com">hanmail.com</option>
						<option value="nate.com">nate.com</option>
				</td>
			</tr>
			<tr>
				<td width = "70" align="center">핸드폰</td>
				<td>
					<select name="tel1" style="width: 70px;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
					</select>	
					<input type="text" name="tel2" size="10">-
					<input type="text" name="tel3" size="10">
				</td>
			</tr>
			<tr>
				<td width = "70" align="center">주소</td>
				<td><input type="text" name="addr" size="50"></td>
			</tr>
			<tr>
				<td width = "70" align="center" colspan="2">
					<input type="button" value="회원가입" onclick="checkWrite();">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
	<input type="button" value="메인화면으로 이동" onclick="location.href='./index.jsp'" align="center">
</body>
</html>