<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	//한글 설정
	request.setCharacterEncoding("UTF-8"); 

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String addr = request.getParameter("addr");
	
	//String tel = request.getParameter("tel1")+"-"+request.getParameter("tel2")+
    //request.getParameter("tel3"); => 이렇게 한번에 쓸수도 있음!!
    
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName(name);
    memberDTO.setId(id);
    memberDTO.setPwd(pwd);
    memberDTO.setGender(gender);
    memberDTO.setEmail1(email1);
    memberDTO.setEmail2(email2);
    memberDTO.setTel1(tel1);
    memberDTO.setTel2(tel2);
    memberDTO.setTel3(tel3);
    memberDTO.setAddr(addr);
    
    MemberDAO memberDAO = new MemberDAO();
    int su = memberDAO.write(memberDTO);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (su>0)  { %>
	회원 가입 성공
	<input type="button" value="메인화면으로 이동" 
	onclick="location.href='../main/index.jsp'" align="center">
<% } else { %>
	회원 가입 실패
<% } %>
<%--
이름 : <%=name %> <br>
	아이디 : <%=id %> <br>
	비밀번호 : <%=pwd %> <br>
	성별 : <%=gender %> <br>
	이메일 : <%=email1 %>@<%=email2 %> <br>
	핸드폰 : <%=tel1 %>-<%=tel2%>-<%=tel3%> <br>
	주소 : <%=addr %> <br>
 --%>
	
</body>
</html>