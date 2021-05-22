<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = (String)session.getAttribute("memId");
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = memberDAO.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script type="text/javascript" src="../script/memberScript.js"></script>
</head>
<body>
	<form action="modify.jsp" method="post" name="modifyForm">
		<table border="1">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" name="name" value="<%=memberDTO.getName()%>"></td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" value="<%=id%>" disabled="disabled">
					<!-- <input type="button" value="중복체크" onclick="checkId()"> -->
				</td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" value="<%=memberDTO.getPwd()%>"></td>
			</tr>
			<tr>
				<td align="center">재확인</td>
				<td><input type="password" name="repwd" value="<%=memberDTO.getPwd()%>"></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td>
					<% if(memberDTO.getGender().equals("0")) { %>
					<input type="radio" value="0" name="gender" checked="checked">남
					<input type="radio" value="1" name="gender">여
					<% } else { %>
					<input type="radio" value="0" name="gender">남
					<input type="radio" value="1" name="gender" checked="checked">여
					<% } %>
				</td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td>
					<input type="text" name="email1" value="<%=memberDTO.getEmail1()%>">@
					<input type="text" name="email2" style="width: 100px;" 
							value="<%=memberDTO.getEmail2()%>">
				</td>
			</tr>
			<tr>
				<td align="center">핸드폰</td>
				<td>
					<input type="text" name="tel1" size="10" value="<%=memberDTO.getTel1()%>">-
					<input type="text" name="tel2" size="10" value="<%=memberDTO.getTel2()%>">-
					<input type="text" name="tel3" size="10" value="<%=memberDTO.getTel3()%>">
				</td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="addr" size="50" value="<%=memberDTO.getAddr()%>"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="button" value="수정" onclick="checkModify()">
					<input type="button" value="다시 작성" onclick="re()">
					<input type="button" value="취소" onclick="location.href='../main/index.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>