<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 관리</title>
<script type="text/javascript">
	if(${result > 0}) {
		alert("작성하신 성적을 수정하였습니다.");
	} else {		
		alert("작성하신 성적을 수정하지 못하였습니다.");
	}
	location.href = "scoreView.do?studNo=${studNo}&pg=${pg}";
</script>
</head>
<body>

</body>
</html>