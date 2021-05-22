<%@page import="member.dao.MemberDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");  
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    
    MemberDAO memberDAO = new MemberDAO();
    
    String name = memberDAO.login(id,pw);
    
    String result="";
    
    //페이지 이동 //경로는 상대 경로로 호출.
	//세션으로 공유데이터 사용
	if(name !=null){ //로그인 성공
		//세션에 데이터저장
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		
		response.sendRedirect("loginOk.jsp");
	
	}else{ //로그인 실패
		response.sendRedirect("loginFail.jsp");		
	}
    
    
    
    //url get방식으로 공유 데이터 사용
	/*if(name != null){//로그인 성공
		response.sendRedirect("loginOk.jsp?name="+URLEncoder.encode(name,"utf-8")+ "&id="+id );
	}else{//로그인 실패
		response.sendRedirect("loginFail.jsp");		
	
	}
    */
//    if(memberDAO.searchId(id,pw)==null){
//    	result="데이터가 없습니다";
//    else{
//  	 result = memberDAO.searchId(id,pw)+ " 님 환영합니다!";
//    }
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	
	
	
	
	
<!--	<% if(name !=null){ %>
		<p><%=name %>님이 로그인 </p>
		<%}else{ %>
		<p>아이디 또는 비밀번호가 틀렸으니 다시 확인하시고 로그인하세요</p>
		<%} %>
		
 <p><%=result %>dd</p> -->

</body>
</html>