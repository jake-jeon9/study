<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	int pg=Integer.parseInt(request.getParameter("pg"));
                            
                            MemberDAO memberDAO = new MemberDAO();


                           	
                            int endNum = pg*5;//보여줄 목록에 마지막 번호
                            int startNum = endNum-4;//보여줄 목록에 첫 번호
                            //여기서 5는 5명을 보여주기 위해서 
                            
                            List<MemberDTO> list = new ArrayList<MemberDTO> ();
                            list = memberDAO.memberList(startNum,endNum); 
                         
                        	int setPagePoint = 3;
                         	
                        //	System.out.print("startPage : " +startPage);
                        // 	System.out.print("endPage : " +endPage);
                        // 	System.out.print("totalP : " +totalP);
                           	
                         
                            
                            //페이징 처리
                            int totalMember = memberDAO.getTotalMember();   
                            int totalPage = (totalMember+4)/5; 
                          	int startPage = (pg-1)/setPagePoint*setPagePoint+1;
                         	int endPage = startPage + setPagePoint-1;
                         	if(endPage>totalPage) endPage = totalPage;
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#subjectAQ:link{ color: black; text-decoration: none;}
#subjectAQ:visited{ color: black; text-decoration: none;}
#subjectAQ:bover{color: blue; text-decoration: underline; }
#subjectAQ:active{color: black; text-decoration: none; }

#paging{color : blue ; text-decoration: none; }

#currentpaging{ color: red; text-decoration: unerline; }

</style>
</head>
<body>
	<table border="1">
		<tr style="background : orange">
		<th width="70">이름</th>
		<th width="100">아이디</th>
		<th width="50">성별</th>
		<th width="150">이메일</th>
		<th width="150">전화번호</th>
		<th width="150">가입일</th>
		</tr>
	<%
		//for(int i =0; i<list.size();i++) {
			//	MemberDTO memberDTO = list.get(i);
	%>
	<%
		for(MemberDTO memberDTO : list){
	%>
		<tr bgcolor="ffffcc" align="center">
			<td><%=memberDTO.getName() %></td>
			<td><%=memberDTO.getId() %></td>
			<td><%if(memberDTO.getGender().equals("0")) {%>
				남자
			<%}else{ %>
				여자
			<%} %>
			</td>
			<td><%=memberDTO.getEmail1() %>@<%=memberDTO.getEmail2() %></td>
			<td><%=memberDTO.getTel1() %>-<%=memberDTO.getTel2() %>-<%=memberDTO.getTel3() %></td>
			<td><%=memberDTO.getLogtime() %></td>
		</tr>
	<%} %>
		<tr>
	<td colspan="6" align="center">
		<%if(startPage>setPagePoint){ %>
		[<a id="paging" href="memberList.jsp?pg=<%=startPage-1%>">이전]</a>
		<%} %>
		<% for(int i=startPage; i<=endPage;i++){ %>
			<% if(	i==pg  ){//현재페이지 %>
			[<a id="currentpaging" href="memberList.jsp?pg=<%=i%>"><%=i %></a>]
		<%}else{ //현재페이지 아님 %>
		[<a id="paging"  href="memberList.jsp?pg=<%=i%>"><%=i %></a>]
		<%} %>
		<%} %>
		<% if(endPage<totalPage){ %>
		[<a id="paging"  href="memberList.jsp?pg=<%=endPage+1%>">다음]</a>
		<%} %>
		</td>
	</tr>
	
	</table>
	
	<a href="../main/index.jsp" >메인화면가기</a>
</body>
</html>