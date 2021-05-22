<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	request.setCharacterEncoding("utf-8");  
                            
                            String name=request.getParameter("name");
                            String id=request.getParameter("id");
                            String pw1=request.getParameter("pw1");
                            String pw2=request.getParameter("pw2");
                            String gender=request.getParameter("gender");
                            String email1=request.getParameter("email1");
                            String email2=request.getParameter("email2");
                            String tel1=request.getParameter("tel1");
                            String tel2=request.getParameter("tel2");
                            String tel3=request.getParameter("tel3");
                            String addr=request.getParameter("addr");
                            
                            
                            if(gender=="0"){
                            	gender = "남자";
                            }else if(gender=="1")
                            	gender = "여자";
                            
                            //DB작업
                            MemberDTO memberDTO = new MemberDTO();
                            memberDTO.setName(name);
                            memberDTO.setId(id);
                            memberDTO.setPw(pw1);
                            memberDTO.setGender(gender);
                            memberDTO.setEmail1(email1);
                            memberDTO.setEmail2(email2);
                            memberDTO.setTel1(tel1);
                            memberDTO.setTel2(tel2);
                            memberDTO.setTel3(tel3);
                            memberDTO.setAddr(addr);
                            
                            MemberDAO memberDAO = new MemberDAO();
                            int su = memberDAO.write(memberDTO);
                          
                            String result="";
                            
                            if(su>0){
                            	result="서버저장에 성공!";	
                            }else{
                            	result="서버 저장 실패";
                            }
        %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% if(su>0){ %>
회원가입 성공
<%}else{ %>
회원가입 실패
<%} %>

<%--
<p>	이름 : <%=name %></p>
<p>	아이디 : <%=id %></p>
<p>	비밀번호 : <%=pw1 %></p>
<p>	성별 : <%=gender %></p>
<p>	이메일 : <%=email1 %>@<%=email2 %></p>
<p>	핸드폰 : <%=tel1 %>-<%=tel2 %>-<%=tel3 %></p>
<p> 주소 : <%=addr %></p>
 --%>
 
 
 
</body>
</html>