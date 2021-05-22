<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    session.removeAttribute("memId");
    session.removeAttribute("memName");
    
    session.invalidate();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	window.onload = function() {
		document.getElementById("id").innerHTML = "로그아웃 완료";
		alert("로그아웃 완료");
		
	}

</script>
</head>
<body>
		<p id="id">로그아웃 진행중입니다. </p>
	<a href="../main/index.jsp">메인으로 이동</a>
</body>
</html>