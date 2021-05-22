<%@page import="board.bean.BoardBean"%>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        	//데이터
            int pg = Integer.parseInt(request.getParameter("pg"));

            int seeList=5;
            if(request.getParameter("sl")!=null){
            	seeList=Integer.parseInt(request.getParameter("sl"));
            }
            BoardDAO boardDAO = new BoardDAO();
            //페이징 영역
            //글수 23 ->글수 5개씩 보여주면 총 5페이지  (총글수 + 4)/5
            //글수 12 ->글수 5개씩 보여주면 총 3페이지 (총글수 + 4)/5
            //글수 25 ->글수 5개씩 보여주면 총 5페이지 (총글수 + 4)/5
            
         	int totalA = boardDAO.getTotalA();   
           	int totalP = (totalA+4)/5; 
            //페이지 번호를 몇개씩 보여줄지 설정
            //블럭 3표시
            //총 페이지수 8
            // 123 다음
            //이전 456 다음
            // 이전 7 8
            int startPage = (pg-1)/3*3+1; //(1-1)/3*3+1 ->1, (2-1)/3*3+1 = 1, (3-1)/3*3+1=1
         								 //(4-1)/3*3+1 ->4, (5-1)/3*3+1 = 4, (6-1)/3*3+1=4
         	// 공식 ( pg-1)/보여줄 페이징뷰 *보여줄 페이징뷰+1
         	int endPage = startPage+2;
         	//엔드 페이지는 총  보여줄 리스트 갯수 startpage + 갯수(2);
         	if(endPage>totalP) endPage = totalP; //엔드페이지가 total 페이지보다클때 초과하는 값을 방지하기 위해서
            
            int endNum = pg*seeList;
            int startNum = endNum-seeList+1;
            
           
            List<BoardBean> list = boardDAO.boardList(startNum,endNum);
            int number= ((int)(boardDAO.getDataNumber()/seeList))+2;
            int endNumber=0;

            int breakNumber=0;
            int totalNum = boardDAO.getDataNumber();
            
            if(totalNum%seeList != 0){
            	breakNumber=((int)(totalNum/seeList))+1;
            }else{
            	breakNumber=((int)(totalNum/seeList));
            	
            }
            int startPoint=1;
            if(request.getParameter("startPoint")!=null&&Integer.parseInt(request.getParameter("startPoint"))>0){
            	startPoint=Integer.parseInt(request.getParameter("startPoint"));
            
            }
            endNumber=startPoint+seeList;
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

</style>
<script type="text/javascript">

function action(){
	var sl = document.getElementsByName("chooseGetList")[0].value;
		location.href="boardList.jsp?pg=1&sl="+sl;
}

function action1(pg1){
		location.href="boardList.jsp?pg="+pg1+"&sl="+<%=seeList%>+"&startPoint="+ <%=startPoint%>;
}

function isLogin(seq){
	<%if(session.getAttribute("memId")==null){%>
			alert("로그인부터해")
	<%}else{%>
		location.href="boardView.jsp?seq="+seq+"&pg="+<%=pg%>;
	<%}%>
}

function moveNext(pg2){
	var pointer = <%=startPoint%>+1;
	location.href="boardList.jsp?pg="+pg2+"&sl="
			+<%=seeList%>+"&startPoint="+pointer;
}

function moveBack(pg2){
	var pointer = <%=startPoint%>-1;
	location.href="boardList.jsp?pg="+pg2+"&sl="
			+<%=seeList%>+"&startPoint="+pointer;
}

</script>

</head>
<body>
리스트 갯수 보기<select name="chooseGetList" onchange="action()">
		<option>보기</option>
		<option value="5">5</option>
		<option value="10" >10</option>
		<option value="15" >15</option>
		<option value="50" >50</option>
	</select>
	<table border="1">
		<tr bgcolor="ffff00">
			<th width="70">글번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>
	
	<%
			for(BoardBean boardDTO : list){
		%>
		<tr bgcolor="ffffcc" align="center">
			<td><%=boardDTO.getSeq()%></td>
			<td><a href="#" id="subjectAQ" 	onclick="isLogin(<%=boardDTO.getSeq()%> )">
			<%=boardDTO.getSubject()%></a></td>
			<td><%=boardDTO.getName()%></td>
			<td><%=boardDTO.getLogtime()%></td>
			<td><%=boardDTO.getHit()%></td>
		</tr>
	<%
		}
	%>
	<%--for(int i =0; i<list.size();i++) {
			BoardBean boardDTO = list.get(i);i); %>
		<tr align="center">
			<td><%=boardDTO.getSeq() %></td>
			<td><%=boardDTO.getSubject() %></td>
			<td><%=boardDTO.getName() %></td>
			<td><%=boardDTO.getLogtime() %></td>
			<td><%=boardDTO.getHit() %></td>
		</tr>
	<%} %> --%>
	
	<!--  페이징 작업 -->
	<tr>
	<td colspan="5" align="center">
	<% if(startPoint>1) {%>
	<a href="#" onclick="moveBack(<%=pg%>)"> &lt;&lt;</a>
	<%} %>
	  <%for(int i=startPoint;i<endNumber;i++) {%>
	<% if(i>breakNumber) break; %>
	
		<a href="#" onclick="action1(<%=i%>)">[<%=i %>]</a>
	<%} %>
	<% if(breakNumber>=endNumber) {%>
	<a href="#" onclick="moveNext(<%=pg%>)">&gt;&gt;</a>
	<%} %>
	</td>		
	</table>

	<!--  강사님 페이징 작업 boardListVerIns 에 있음.-->
	
<% if(session.getAttribute("memId")==null){%>
	<a href="../member/loginForm.jsp">로그인</a>
	<%} %>
	
	<a href="boardWriteForm.jsp">새 글쓰기</a>
	<a href="../main/index.jsp">메인화면 가기</a>
	
</body>
</html>