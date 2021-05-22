<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
body{
width : 800px;
}
#top{
width :100%
margin-top : 10px;
border : 1px solid;
}
#container{
width : 800px;
height : 500px;
}

.nav {
float : left;
width : 20%;
background: orange;
height : 100%;

}
.section {
float : left;
width: 80%;

}
#container:after{
clear : both;
}

#bottom{
clear : both;
width : 100%;
text-align: center;
}
#mian:link{ color : black;text-decoration: none;}
#mian:visited{ color : black;text-decoration: none;}
#mian:action{ color : black;text-decoration: none;}
#mian:hover{ color : black;text-decoration: none;}

</style>
</head>
<body>
	<!-- top -->
	<div id="top">
		<h2 align="center">이미지 게시판</h2>
	</div>
	<!-- content -->
	<div id="container">
	<!-- nav -->
	<div class="nav">
		<h3><a id="main" href="../main/index.jsp">***메인화면***</a></h3>
		<br>
		<a href="#">회원가입</a><br>
		<a href="#">로그인</a><br>
		<a href="#">로그아웃</a><br>
		<a href="#">회원정보수정</a><br>
		<a href="#">글쓰기</a><br>
		<a href="../main/index.jsp?req=imageboardWriteForm">이미지 등록</a><br>
		<a href="#">목록</a><br>
		<a href="../imageboard/imageboardList.jsp?pg=1">이미지 목록</a><br>
	</div>
	<!-- article -->
	<div class="section">
	<c:if test="${param.req == null}">
	<jsp:include page="../main/body.jsp"/>
	</c:if>
	<c:set var="imageboardWriteForm" value="imageboardWriteForm"></c:set>
	<c:if test="${param.req == imageboardWriteForm }">
	<jsp:include page="../imageboard/imageboardWriteForm.jsp"/>
	</c:if>

	<c:if test="${param.req == 'imageboardWrite'}">
	<jsp:include page="../imageboard/imageboardWrite.jsp"/>
	</c:if>
	<c:if test="${param.req == 'imageboardWriteResult'}">
	<jsp:include page="../imageboard/imageboardWriteResult.jsp"/>
	</c:if>
	<c:if test="${param.req == 'imageboardListResult'}">
	<jsp:include page="../imageboard/imageboardListResult.jsp"/>
	</c:if>
	<c:if test="${param.req == 'imageboardViewResult'}">
	<jsp:include page="../imageboard/imageboardViewResult.jsp"/>
	</c:if>
	<c:if test="${param.req == 'imageboardDelete'}">
	<jsp:include page="../imageboard/imageboardDeleteResult.jsp"/>
	</c:if>
	<c:if test="${param.req == 'imageboardModifyForm'}">
	<jsp:include page="../imageboard/imageboardModifyForm.jsp"/>
	</c:if>
	<c:if test="${param.req == 'imageboardModify'}">
	<jsp:include page="../imageboard/imageboardModifyResult.jsp"/>
	</c:if>
	</div>
	</div>
	
	<!-- bottom -->
	<div id="bottom">
		<p>KGITBANK</p>
	</div>
</body>
</html>