<%@page import="bean.ScoreVO"%>
<%@page import="dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("UTF-8");
    
    String studNo = request.getParameter("studNo");
    String name =  request.getParameter("name");
	int kor =  Integer.parseInt(request.getParameter("kor"));
	int eng =  Integer.parseInt(request.getParameter("eng"));
	int mat =  Integer.parseInt(request.getParameter("mat"));
	int tot = kor+eng+mat;
	double avg = tot/3.0;
    
    ScoreDAO dao = new ScoreDAO();
    ScoreVO vo = new ScoreVO();
    vo.setStudNo(studNo);
    vo.setName(name);
    vo.setKor(kor);
    vo.setEng(eng);
    vo.setMat(mat);
    vo.setTot(tot);
    vo.setAvg(avg);
    
    int result = dao.insertData(vo);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/scoreScript.js?v=1">
</script>

</head>
<body onload="getResult()">
	<%if (result>0){ %>
	작성하진 성적을 저장하였습니다.
	<%}else{ %>
	저장 실패..
	<%} %>
	<form name="checkResult">
	<input type="hidden" name ="result" value="<%=result %>">
	</form>
</body>
</html>