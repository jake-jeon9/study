<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	MemberDTO memberDTO = new MemberDTO();
                            MemberDAO memberDAO = new MemberDAO();
                            
                            String myid = (String)session.getAttribute("memId");
                            
                            memberDTO = memberDAO.getMyInfo(myid);
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script type="text/javascript" src="../script/memberScript.js?v=5"></script>
</head>
<body>
	<form action="modify.jsp" method="post" name="modifyForm">
		<table border="1">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" 
				 name="name" disabled="disabled" value="<%=memberDTO.getName() %>">
				</td><!-- disabled를 하면 데이터 값도 죽음. 이땐 readonly를 사용함 -->
			</tr>
			<tr>
				<td width="70" align="center">아이디</td>
				
				<td><%=memberDTO.getId() %><input type="hidden" name="id" value="<%=myid %>">
				</td>
			</tr>
			<tr>
			<td width="70" align="center">비밀번호</td>
				<td><input type="password" name="pw1" value="<%=memberDTO.getPw()%>"></td>
			</tr>
			<tr>
			<td width="70" align="center">재확인</td>
				<td><input type="password" name="pw2" value="<%=memberDTO.getPw()%>"></td>
			</tr>
			<tr>
				<td width="70" align="center">성별</td>
				<td>
				<%if(memberDTO.getGender().equals("0")) {%>
				<input type="radio" name="gender" value="0" checked="checked">남자
				<input type="radio" name="gender" value="1">여자
				<%}else{ %>
				<input type="radio" name="gender" value="0" >남자
				<input type="radio" name="gender" value="1" checked="checked">여자
				<%} %>
				</td>
			</tr>
			<tr>
				<td width="70" align="center">이메일</td>
				<td>
					<input type="text" name="email1" placeholder="<%=memberDTO.getEmail1()%>">@
					<select name="email2" style="width: 100px">
					<%if(memberDTO.getEmail2().equals("gmail.com")){ %>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com" selected="selected">gmail.com</option>
					<option value="nate.com">nate.com</option>
					<%}else if(memberDTO.getEmail2().equals("naver.com")) {%>
					<option value="naver.com" selected="selected">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gamil.com</option>
					<option value="nate.com">nate.com</option>
					<%}else if(memberDTO.getEmail2().equals("daum.net")) {%>
					<option value="naver.com">naver.com</option>
					<option value="daum.net" selected="selected">daum.net</option>
					<option value="gmail.com">gamil.com</option>
					<option value="nate.com">nate.com</option>
					<%}else if(memberDTO.getEmail2().equals("nate.com")) {%>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gamil.com</option>
					<option value="nate.com" selected="selected">nate.com</option>
					<%} %>
					
					
					</select>
				</td>
			</tr>
			<tr>
				<td width="70" align="center">핸드폰</td>
				<td>
				<select name="tel1">
				<%if(memberDTO.getTel1().equals("010")){ %>
				<option value="010" selected="selected">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017" >017</option>
				<%}else if(memberDTO.getTel1().equals("011")) {%>
				<option value="010" >010</option>
				<option value="011" selected="selected">011</option>
				<option value="016">016</option>
				<option value="017" >017</option>
				<%}else if(memberDTO.getTel1().equals("016")) {%>
				<option value="010" >010</option>
				<option value="011">011</option>
				<option value="016"  selected="selected">016</option>
				<option value="017" >017</option>
				<%}else if(memberDTO.getTel1().equals("017")) {%>
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017" selected="selected">017</option>
				<%} %>
				</select>-
				<input type="text" name="tel2"  size="10" value="<%=memberDTO.getTel2()%>" >-
				<input type="text" name="tel3" size="10" placeholder="<%=memberDTO.getTel3()%>">
				</td>
			</tr>
			<tr>
				<td width="70" align="center">주소</td>
				<td><input type="text" name="addr" placeholder="<%=memberDTO.getAddr()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
				<input type = "button" value="수정하기" onclick="checkModify()">
				<input type = "reset" value="다시작성" onclick="reset1()">
				</td>
			</tr>
		</table>
	</form>
		<input type="button" value="메인화면 이동" onclick="location.href='../main/index.jsp'">
</body>
</html>