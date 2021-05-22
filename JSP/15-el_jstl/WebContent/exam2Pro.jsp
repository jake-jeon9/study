<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    double x = Double.parseDouble(request.getParameter("x"));
    double y = Double.parseDouble(request.getParameter("y"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--
	<h2>jsp 표현</h2>
	<%=x %> + <%=y %> = <%=x+y %><br>
	<%=x %> - <%=y %> = <%=x-y %><br>
	<%=x %> * <%=y %> = <%=x*y %><br>
	<%=x %> / <%=y %> = <%=x/y %><br>
	<br>
 	--%>

	<h2>EL식 표현</h2>
	${param['x']} + ${param['y'] } = ${param['x']+param['y'] } <br>
	${param['x']} - ${param['y'] } = ${param['x']-param['y'] }<br>
	${param.x} * ${param.y } = ${param.x*param.y }<br>
	${param.x} / ${param.y } = ${param.x/param.y }
	
</body>
</html>