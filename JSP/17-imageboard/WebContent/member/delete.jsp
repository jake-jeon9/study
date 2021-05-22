<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String id = request.getParameter("id");
    
    
    
    MemberDAO memberDAO = new MemberDAO();
    
    boolean checkid = memberDAO.checkId(id);
    int result = memberDAO.DeleteMyInfo(id);
	if(checkid){    
		
    if(result >0){
    	session.removeAttribute("memId");
    	session.removeAttribute("memName");
    	session.invalidate();
    	
    }
	}
    //System.out.println("result ? " + result);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	if(<%=result%>>0){
		location.href="../main/index.jsp"
	}else{
		alert("입력하신 아이디를 확인해주세요.");
		location.href="deleteForm.jsp";
	}

</script>
</head>
<body>
	
	<%if(result >0) {%>
		삭제되었습니다.
		id 속성의 값은 <%=session.getAttribute("memId") %>이고<br>
		name 속성의 값은 <%=session.getAttribute("memName") %>이다.
	<%}else{ %>
		오류발생
		id 속성의 값은 <%=session.getAttribute("memId") %>이고<br>
		name 속성의 값은 <%=session.getAttribute("memName") %>이다.
	<%} %>
	<br>
	<a href="../main/index.jsp">메인으로 가기</a>
</body>
</html>