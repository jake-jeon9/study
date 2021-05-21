<%@page import="dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String studNo = request.getParameter("studNo");
    int pg= Integer.parseInt(request.getParameter("pg"));
    String inform;
    
    boolean pageResult=false;
    ScoreDAO dao = new ScoreDAO();
    int result=0;
    
    if(request.getParameter("pageResult")!=null){
    	 result =  dao.deleteData(studNo);
    	pageResult=true;
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function working(){
		
	if(!<%=pageResult%>){
		var getResult = confirm("삭제할꺼야?");
	
		if(getResult){
			location.href="scoreDelete.jsp?studNo=<%=studNo%>&pg=<%=pg%>&pageResult="+getResult;
		} else {
			location.href="scoreView.jsp?studNo=<%=studNo%>&pg=<%=pg%>"
			}
		}else{
			if(<%=result>0%>){
				alert("삭제 성공");
				location.href="scoreList.jsp?pg=<%=pg%>";
			}else{
				alert("삭제 실패..");
				location.href="scoreView.jsp?studNo=<%=studNo%>&pg=<%=pg%>";
			}
		}
	}
	
</script>
</head>
<body onload="working()">

</body>
</html>