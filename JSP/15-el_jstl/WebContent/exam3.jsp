<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> JSP 표현</h3>
	<% String name="홍길동";
	int age = 25;
	%>
	내이름은 <%=name %>입니다.<br>
	내이름은 <%=age %>살 입니다.<br>
	내 나이는 <%//=height %>입니다.<br>
	이때, jsp는 변수가 없으면 오류가 발생하지만, el은 없으면 없는대로 표현한다.
	<br>
	<h3> **변수 설정**</h3>
	<c:set var="name">홍길동</c:set>
	<c:set var="age" value="25"/>
	나의 이름은 ${name } 입니다.<br>
	내 나이는 ${age }살 입니다.<br>
	내키는 ${height }입니다.<br>
	<hr>
	<h3> **변수 삭제**</h3>
	<c:remove var="name"/>
	나의 이름은 ${name } 입니다.<br>
	내 나이는 ${age }살 입니다.<br>
	내키는 ${height }입니다.<br>
	<hr>
	
	<h3>**forEach(for문 대체)**</h3>
	<!--  for(int i =0;i<=10;i++) -->
	<c:forEach var="i" begin="1" end="10" step="1">
		${i } &nbsp;&nbsp;
		<c:set var="sum" value="${sum+i }"/>
	</c:forEach>
	1~10까지의 합은?: ${sum }<br>
	<hr>
	<c:set var="arr" value="10,20,30,40,50"/>
	<!-- for(int data : arr) 확장 포문 -->
	<c:forEach var="data" items="${arr}">
		${data } &nbsp;&nbsp;
		
	</c:forEach>	
	<hr>
	
	<h3>**if**</h3>
	<c:set var="age" value="15"/>
	<c:if test="${age>=20 }">
		성인
	</c:if>
	<c:if test="${age<20 }">
		청소년
	</c:if>
	
	<c:if test="true">
		트루 출력
	</c:if>
	<c:if test="false">
		펠스 출력
	</c:if>
	<!--  연산식에 true / false값을 이용해서 출력도 가능  -->
	<hr>
	
	<h3>**switch**</h3>
	<c:set var="color" value="red"/>
	<c:choose>
		<c:when test="${color=='red'}">빨강</c:when>
		<c:when test="${color=='green'}">초록</c:when>
		<c:when test="${color=='blue'}">파랑</c:when>
		<c:when test="${color=='magenta'}">보라</c:when>
		<c:otherwise>하늘</c:otherwise>
	</c:choose>
	<%--
		switch(color){
		case "red" : 빨강; break;
		case "green" : 초록; break;
		case "blue" : 파랑; break;
		case "magenta" : 보라; break;
	
	 --%>
	<hr>
	
	<h3>**다중if**</h3>
	
	
	
</body>
</html>