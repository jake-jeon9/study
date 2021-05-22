<%@page import="member.bean.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
 // <<<<<<< 데이터 >>>>>>>
   int pg = Integer.parseInt(request.getParameter("pg"));

   // 목록보기 => 한 페이지당 목록을 몇개 보여줄지 설정
   // 1페이지당 7개씩 (7의 배수 -6, 7의 배수)
   // pg=1 : rn>=1 and rn<=7
   // pg=2 : rn>=8 and rn<=14
   // pg=3 : rn>=15 and rn<=21
   
   int endNum = pg * 5;
   int startNum = endNum - 4;
   
   MemberDAO memberDAO = new MemberDAO();
   List<MemberDTO> list = memberDAO.selectList(startNum, endNum);
   
   //=================================================================
   // 페이징처리 : 1페이지당 목록 7개 표시
   // 총 글 수 : 36
    // 총 페이지수 : 8        [1][2][3][4][5][6][7][8]    => (총 글수+4)/5
    
    int totalMem = memberDAO.countList();  // 총 글 수 구하기 (36개)
    int totalMemP = (totalMem + 4)/5;      // 총 페이지수 계산 
           
    /** 페이지 번호를 몇개씩 보여줄지 설정**/
    // 3블럭 표시
    // 총 페이지수 : 8
    //        [1][2][3][다음]
    // [이전][4][5][6][다음]
    // [이전][7][8]
    // >>> startPage 계산결과
    // (1-1)/3*3 => 1, (2-1)/3*3 => 1, (3-1)/3*3 => 1 
   // (1-1)/3*3 => 1, (2-1)/3*3 => 1, (3-1)/3*3 => 1 
   
    int startPage = (pg-1)/3*3 +1;       
    int endPage = startPage + 2;
    if(endPage > totalMemP) endPage = totalMemP;
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">   
   #paging {color:black; text-decoration: none;}
   #currentPaging {color: blue; text-decoration:none; font-weight: bold; font-size: 1.2em;}
   
</style>

</head>
<body>
<!-- <%=list.size() %> -->
   <table border="1">
      <tr bgcolor="ffcccc">
         <th width="120">이름</th>
         <th width="100">아이디</th>
         <th width="70">성별</th>
         <th width="250">이메일</th>
         <th width="200">전화번호</th>
         <th width="200">가입일</th>
      </tr>
      <% for (MemberDTO memberDTO : list) {%>
      <tr align="center" bgcolor="ffeeee">
         <td><%=memberDTO.getName() %></td>
         <td><%=memberDTO.getId() %></td>
         <td>
      
         <% if (memberDTO.getGender().equals("W")) {           // if넣을때는 =하면안되고 %만! equals 안에는 ""큰따옴표 %>
            여자
            <% } else { %>
            남자
         <% } %>
         </td>
         <td><%=memberDTO.getEmail1()%>
            @<%=memberDTO.getEmail2()%>
         </td>
         <td><%=memberDTO.getTel1()%>
            -<%=memberDTO.getTel2()%>
            -<%=memberDTO.getTel3()%>
         </td>
         <td><%=memberDTO.getLogtime().substring(0,10)%></td>
      </tr>
      <%} %>
      
      <!-- 페이징! -->
      <tr>
      <td colspan="6" align = "center">
         <% if(startPage>3) {%>
            [<a id="paging" href="memberList.do?pg=<%=startPage-1%>">이전</a>]
         <%} %>
         
         <% for (int i=startPage; i<=endPage; i++) {%>
         <% if(pg == i) {%>             <!-- 현재페이지 -->      
            [<a id="currentPaging" href="memberList.do?pg=<%=i%>"><%=i %></a>]
         <%} else {%>               <!-- 현재페이지 아닐때 -->   
            [<a id="paging" href="memberList.do?pg=<%=i%>"><%=i %></a>]
            <%} %>
         <%} %>   
         
         <% if(endPage< totalMemP) {%>
            [<a id="paging" href="memberList.do?pg=<%=endPage+1%>">다음</a>]
         <% } %>
      </td>
   </tr>      
   </table>
   <a href="./index.jsp">메인 화면으로 이동</a>
      
</body>
</html>