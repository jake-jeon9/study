<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${result > 0}) {
		alert("작성하신 성적을 저장하였습니다.")
		location.href = "scoreList.do?pg=1";
	} else {
		alert("작성하신 성적을 저장하지 못하였습니다.")
		location.href = "scoreWriteForm.do";
	}
</script>
</head>
<body>

</body>
</html>




