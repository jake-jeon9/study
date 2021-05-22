<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function result(){
		
	if(${result}>0){
		alert("삭제 성공");
	}else{
		alert("삭제 실패");		
	}
	
	}
	
</script>
</head>
<body onload="result()">
	<c:if test="${result>0 }">
	<p>${seq } 번 글이 삭제되었습니다.</p>
	</c:if>
	<c:if test="${resul==0 }">
	<p>오류 발생! ${seq }이 삭제 되지 않았습니다.</p> 
	</c:if>
	<input type="button" value="이전화면" onclick="location.href='../imageboard/imageboardList.jsp?pg=${pg}'">
</body>
</html>