<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //세션 삭제
    session.removeAttribute("memName");
    session.removeAttribute("memId");
    
    session.invalidate();//무효화 : 모두 지우기
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//<body onload="함수명"> 와 같은 동작
	window.onload = function(){
		alert("로그아웃");
		location.href="../main/index.jsp";
	}

</script>
</head>
<body>
	<p>로그아웃 되었습니다.</p>
	
</body>
</html>