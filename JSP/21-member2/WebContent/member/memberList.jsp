<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
   <table border="1">
      <tr bgcolor="ffcccc">
         <th width="120">이름</th>
         <th width="100">아이디</th>
         <th width="70">성별</th>
         <th width="250">이메일</th>
         <th width="200">전화번호</th>
         <th width="200">가입일</th>
      </tr>
      <c:forEach var="list" items="${memberDTO }" >
      <tr align="center" bgcolor="ffeeee">
      <td> ${list.name } </td>
      <td>${list.id }</td>
      <td>
      <c:if test="${list.gender==0 }">
      남자
      </c:if>
      <c:if test="${list.gender==1 }">
      여자
      </c:if>
        </td>
        <td>${list.email1 }@${list.email2 }</td>
         <td> ${list.tel1 }- ${list.tel2 }- ${list.tel3 }</td>
         <td>  ${list.logtime }</td>
         </tr>
    </c:forEach>
      
      <!-- 페이징! -->
      <tr>
      <td colspan="6" align = "center">
      <c:if test="${startPage>3 }">
            [<a id="paging" href="memberList.do?pg=${startPage-1 }">이전</a>]
		</c:if>         
		<c:forEach var="i"  begin="${startPage }" end="${endPage }" step="1">
         <c:if test="${pg==i }">      
            [<a id="currentPaging" href="memberList.do?pg=${i }">${i }</a>]
        </c:if>
          <c:if test="${pg!=i }">
        <!-- 현재페이지 아닐때 -->   
            [<a id="paging" href="memberList.do?pg=${i }">${i }]</a>
		</c:if>
        </c:forEach>
        <c:if test="${endPage<totalMemP }"> 
            [<a id="paging" href="memberList.do?pg=${endPage+1 }">다음</a>]
		</c:if>
      </td>
   </tr>      
   </table>
   <a href="../main/index.jsp">메인 화면으로 이동</a>
      
</body>
</html>