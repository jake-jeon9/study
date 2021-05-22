<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 여기서 전 파라미터로 공유했는데, 사실 선생님이 하신것 처럼 어차피 request , response로 계속 데이터는 넘어가고있으니 굳이 java로 받지 않으시고 바로 el표현식으로 구현하셔도 됩니다.
	// 근데 전 그거 몰랐어요.. 이미 만들었는데, 그렇게 하셔서 바꾸기도 좀 애매하고, 그래서 그냥 썼습니다 ^^7
	// 무튼 su를 parameter로 넘겼으니 그걸 받아왔네요. 다만 int형을 써야하는데 parameter는 무조건 string형태로 넘어오기 때문에, integer클래스에 parstint라는 내장함수로 강제 형변환 시켰어요.
	int su = Integer.parseInt(request.getParameter("su"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- DAO부터 차근차근 따라오셨다면, 저장성공했을땐, 0보다 큰 값이 넘어온다는걸 아실겁니다. 해봤자 1이겠지만여, 무튼 1이 넘어오면 저장에 성공한거니 회원가입 성공을 출력합니다 --%>
<% if (su>0)  { %>
	회원 가입 성공
	<%-- 주의하실점, 저흰 계속 index.jsp에 include하는 형태기때문에 모든 기준은 index.jsp기준입니다. 이동하실 때 주의해주세요.
		그리고 index.jsp에 아무것도 안붙였죠? 이러면 그냥 req=null이니까 메인화면만 출력돼요. --%>
	<input type="button" value="메인화면으로 이동" 
	onclick="location.href='./index.jsp'" align="center">
<% } else { %>
<%-- else일경우는 뭐 0보다 안크면 0이져 -값 안나옵니다!, 저장 실패했다는거니까 잘 따져보세여, 오면서 어디썼는지는 모르겠는데 무튼 unique때문에 오류 많이떠요, 그거 안하고싶긴하네여 ㅎ 
	근데 그럼 중복검사하는 의미가 없으니까 패스할게여 무튼! 이렇게 출력시키게 되네요.
	그리고 else는 실행 안될겁니다 ㅎㅎ 제가 만약 저장실패하면 그냥 alert실행하고 이전페이지로 history.back 시켰기때문에, 다시 회원가입 작성하는 페이지가 나오지 이게 뜨진 않아여, 그냥 있는코드 복붙해서
	활용하다보니 남아있는거네요! 아무튼 무조건 이 페이지에서 else는 출력 안됩니다 제 코드에선 ㅎㅎ--%>
	회원 가입 실패
<% } %>

<%-- 아무튼 이제 회원가입 성공했으면 다시 메인페이지로 가지겠죠? 여기부터 계속 반복하는겁니다. 제가 어떤 ~.do로 요청을 보내면 servlet이 실행되고, 요청에 맞는 클래스를 동작시킵니다.
	그리고 클래스에 적혀있는 fowrard로 계속 페이지 include시키는거, 이해 다 하셨죠?
	그 순서만 잘 기억하시고, 제가 지금 주석 달아놓은 것 처럼, 하나하나 따라가면서 봐보세요. 아마 이해가 조금 되실겁니다.
	그럼 공부 화이팅하시고, 코드 질문있으면 언제든 카톡주세여 :) --%>
	
</body>
</html>