<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
	body { 
		width: 1000px;
		border: 0;
		margin: 0 auto;
	}
	
	#header {
		border-bottom: 1px solid;
	}
	
	#body {
		width: 1000px;
		height: 800px;
	}
	
	#nav {
		width: 200px;
		height: 800px;
		background: orange;
		float: left;
	}
	
	#maincontent {
		width: 800px;
		height: 800px;
		float: left;
	}
	#footer {
		background: mistyrose;
		height: 100px;
		clear: both;
	}
	
	#main:link {
		color: black;
		text-decoration: none;
	}
	#main:visited {
		color: black;
		text-decoration: none;
	}
	#main:action {
		color: black;
		text-decoration: none;
	}
	#main:hover {
		color: black;
		text-decoration: none;
	}
</style>
</head>
<body>
	<div id="header" align="center">
	<%-- 이부분은 메인 페이지 위쪽에 내가 뭘 클릭할 때 마다 표시되는 제목이 달라질 수 있게 처리했어요
		maincontent 쪽에 임포트 되는 jsp 파일이 뭐냐에따라 내용이 바뀌니까 천천히 확인해주세요.
	 --%>
		<c:if test="${param.req == null }">
					<h1>*** 메인 화면 ***</h1>
		</c:if>
		<c:if test="${param.req == 'memberWriteForm' }">
					<h1>*** 회원가입하기 ***</h1>
		</c:if>
		<c:if test="${param.req == 'memberLoginForm' }">
					<h1>*** 로그인 페이지 ***</h1>
		</c:if>
		<c:if test="${param.req == 'LoginOK' }">
					<h1>*** 로그인 성공 ***</h1>
		</c:if>
		<c:if test="${param.req == 'memberList' }">
					<h1>*** 회원 목록 확인 ***</h1>
		</c:if>
		<c:if test="${param.req == 'memberDelete' }">
					<h1>*** 회원탈퇴하기 ***</h1>			
		</c:if>
		<c:if test="${param.req == 'memberDeletePro' }">
					<h1>*** 회원탈퇴하기 ***</h1>	
		</c:if>
		<c:if test="${param.req == 'memberModifyForm' }">
					<h1>*** 회원정보 수정 ***</h1>
		</c:if>
		<c:if test="${param.req == 'memberModifyPro' }">
					<h1>*** 회원정보 수정 ***</h1>
		</c:if>
	</div>
	
	<div id="body">
		<div id="nav" align="center">
			<h3><a id="main" href="./index.jsp">*** 메인화면 ***</a></h3>
			
			<%--기억해주세요. if조건문에 보시면 로그인을 했냐 안했냐에 따라 다르게 표시되는 내용들이에요. 추후에 시험을 볼 때나 프로젝트 할 때 도움이 조금이나마 되시길 바라면서 작성해요. --%>
		
			<% if(session.getAttribute("memId") == null) { %>
			<h4>처음이세요? 우리 홈페이지에 가입해보세요 !</h4>
			<a href="memberWriteForm.do">회원가입</a><br>
			<%--~.do의 요청이니 member.controller 패키지에 있는 Controller로 이동해보세요. 
				다 읽으셨으면 이제 차근차근 설명드릴게요.
				우리가 memberWriteForm.do라는 요청을 보냈기때문에 서블릿으로 이동하게되고. 서블릿에서 map에 저장된 클래스를 불러와서 실행하게돼요.
				여기선 MemberWriteFormAction.java로 이동하겠네요. member.action 패키지에 있는 MemberWriteFormAction.java로 이동해주세요.
			--%>
			<h4>회원이세요? 로그인 해주세여</h4>
			<a href="memberLoginForm.do">로그인</a><br>
			<% } else { %>	
			<%-- href="#"이라면 그냥 이 화면의 맨 위로 보내는 역할이에요. 그냥 로그인하면 바뀌는데 좀 다이나믹하게 바뀌는걸 원해서 이렇게 작성해봤어요. --%>
			<a href="#">게시판보기</a><br>
			<a href="#">로그인 후 화면</a><br>
			<a href="#">여긴 의미 x</a><br>
			<a href="#">여길 보드로 수정</a><br><hr>
			<h4>로그인하고는 여기 밑에만 신경쓰면 됩니다.</h4>
			<a href="memberLogout.do">로그 아웃</a><br>
			<a href="memberModifyForm.do">회원정보수정</a><br>
			<a href="memberDeleteForm.do">회원 탈퇴</a><br>
			<p>여러 목록들을 보여주는곳</p>
			<a href="memberList.do">회원 전체 목록</a>
		<% } %>
		</div>
	
		<div id="maincontent">
		<%-- 제가 한 방식은 if조건문을 계속 다는 방식으로 선생님이 하신 코드와는 달리 의존성이 좀 높아요.(= 화면이 추가될때마다 여기 계속 수정해야됌. 개귀찮...) --%>
			<c:if test="${param.req == null }">
					<img width="800px" height="500px" alt="login" src="./boardUpload/lion.jpg">
			</c:if>
			<%-- 맨처음에 이 위를 보시면 아무것도 없는 초기값 즉 메인화면이에요. 맨 위에 header도 같이 바뀌니까 확인하시면서 따라가보는것도 좋은 방법이실듯. --%>
			<c:if test="${param.req == 'memberWriteForm' }">
					<%-- 최초에 모든 동작은 do로 이동해요 여기서 다시 103번째 줄로 가보죠. 그럼 .do로 요청내용이 있죠? 그럼 servlet으로 가는거에요. 우리가 servlet은 ~.do의 요청이 있을때만 동작하는겁니다.
						일단 103번째 줄에서 다시 설명 시작하죠. --%>
					
					<%-- MemberWriteForemAction.java 클래스에서 리턴값으로 req를 memberWriteForm으로 줬죠?
						그럼 조건문 c:if중에서 132번째 줄이 맞기때문에 아래페이지가 include 되는거에요. 모든 내용은 공통되어있고, 선생님 코드도 의존성을 낮춘거지 똑같은 동작인걸 생각하고 하나하나 따라가보세요.
						우선 포함된 member폴더에 writeForm.jsp로 이동해보죠. --%>
					<jsp:include page="./member/writeForm.jsp"></jsp:include>
			</c:if>
			<%-- 와 이제 드디어 memberWritePro로 넘어왔어요. 여기까지 읽으시느라 고생 많으셨는데, 아직 좀 남았으니까 더 보세요.
				아까 MemberWriteProAction.java에서 su라는 데이터를 setattribute로 공유했죠? 그걸 el표현식(${})으로 받아올 수 있어요. --%>
			<c:if test="${param.req == 'memberWritePro' }">
					<%-- 자 이제 su를 받아왔으니 parameter로 전송해서 write.jsp로 이동해보져! --%>
					<jsp:include page="./member/write.jsp?su=${su }"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'memberLoginForm' }">
					<jsp:include page="./member/loginForm.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'LoginOK' }">
					<jsp:include page="./member/loginOk.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'memberList' }">
					<jsp:include page="./member/memberList.jsp?pg=${pg }"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'memberDelete' }">
					<jsp:include page="./member/deleteForm.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'memberDeletePro' }">
					<jsp:include page="./member/delete.jsp?result=${result }"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'memberModifyForm' }">
					<jsp:include page="./member/modifyForm.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'memberModifyPro' }">
					<jsp:include page="./member/modify.jsp?su=${su }"></jsp:include>
			</c:if>
			
		</div>
	</div>
	
	<div id="footer" align="center">
		KGITBANK
	</div>
</body>
</html>