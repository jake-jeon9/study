<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
	//int req = Integer.parseInt((String)request.getAttribute("req"));
	//String imageName = (String)request.getAttribute("imageName");
	
	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${requestScope.req == 1 }">
	<p>${requestScope.imageName}이(가) 등록되었습니다.</p>
	</c:if>
	<c:if test="${req==0 }">
	<p>${imageName }이(가) 등록에 실패!!되었습니다.</p>
	</c:if>

<%--
	request.setAttribute("변수명",데이터); 
	request 객체는   1. requestScope.변수명  or 2. 변수명 으로   호출할 수 있다.
--%>

<%--
	<%if(req>0){ %>
	<p><%=imageName %>이(가) 등록되었습니다.</p>
	<%}else{ %>
	<p><%=imageName %>이(가) 등록 실패 되었습니다.</p>
	<%} %>
 --%>



 
</body>
</html>