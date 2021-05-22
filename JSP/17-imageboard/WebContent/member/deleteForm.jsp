<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function checkId(){
	
	var frm=document.deleteForm;
		
	if(!frm.id.value){
		alert("아이디를 입력하세요");
	
	}else{
		var reuslt = confirm("탈퇴하시겠습니까?");
		if(reuslt){
			frm.submit();
		}else{
			location.href="../main/index.jsp"
		}
		
	}
	}

</script>
</head>
<body>
	<form action = "delete.jsp" name="deleteForm">
	<table>
		<tr>
		<th> 탈퇴하고 싶은 아이디</th>
		<td><input type="text" name="id"></td>
		</tr>
		<tr>
		<td colspan="2">
		<input type="button" value="확인" onclick="checkId()">
		<input type="reset" value="다시입력" >
		</td>
		</tr>
	</table>
	</form>
</body>
</html>