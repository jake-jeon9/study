<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");  
                //String id = request.getParameter("id");//데이터가 disabled라서 안날라옴 이땐 세션으로 처리
                String id = (String)session.getAttribute("memId");
                String tel1 = request.getParameter("tel1");
                String tel2 = request.getParameter("tel2");
                String tel3 = request.getParameter("tel3");
                String name = request.getParameter("name");
                String email1 = request.getParameter("email1");
                String email2 = request.getParameter("email2");
                String gender = request.getParameter("gender");
                String pw = request.getParameter("pw2");
                String addr = request.getParameter("addr");
                
                MemberDTO memberDTO = new MemberDTO();
                
                memberDTO.setId(id);
                memberDTO.setTel1(tel1);
                memberDTO.setTel2(tel2);
                memberDTO.setTel3(tel3);
                memberDTO.setName(name);
                memberDTO.setEmail1(email1);
                memberDTO.setEmail2(email2);
                memberDTO.setGender(gender);
                memberDTO.setAddr(addr);
                
                MemberDAO memberDAO = new MemberDAO();
                
                
                int result = memberDAO.EditMyInfo(memberDTO);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	if(<%=result%> >0){
		alert("업데이트 완료");
		location.href="../main/index.jsp"
	}else{
		alert("실패.. 다시 시도");
		location.href="modifyForm.jsp"
	}

</script>
</head>
<body>

</body>
</html>