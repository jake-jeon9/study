<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String id = request.getParameter("id");
    MemberDAO memberDAO = new MemberDAO();
    
    boolean result = memberDAO.checkId(id);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function checkIdClose(){
		//opener 내장 객체 : 현재 브라우저 기준으로 부모 브라우저를 관리하는 객체
		
		opener.writeForm.id.value = "<%=id%>";
		window.close();
		opener.writeForm.pw1.focus();
		
	}
	
	function checkid(){
		
		var chid2= document.getElementsByName('id')[0].value;
		//alert(chid2);
		if(!chid2){
			alert("아이디를 입력해주세요");	
			document.formch.id.focus();
		}else{
			document.formch.submit();
		}
	}

</script>
</head>
<body>
	<form action="checkid.jsp" method="post" name="formch">
	<%if(result){//true이면 이미 사용중이기 때문에 사용 불가 %>
		<p><%=id %>는 이미 사용중입니다.</p>
		아이디 : <input type="text" name="id" >
		<input type="button" value="중복체크" onclick="checkid()">
	<%}else{//false 이면 조회된 아이디가 없음 = 사용가능 %>
		<p><%=id %>는 사용 가능합니다!</p>
		<input type="button" value="사용" onclick="checkIdClose()">
		
	<% } %>
	
	</form>
</body>
</html>