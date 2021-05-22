<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

if(${su>0}){
	alert("수정 성공")
}else{
	alert("수정 실패...!")
	
}

</script>
</head>
<body>
	<c:if test="${su>0 }">
		아이디는 : ${ memberDTO.id  } 입니다. <br>
		현재 비밀번호는 ${ currentPwd   } 에서
		비밀번호는 : ${  memberDTO.pwd  }로 변경했고 <br>
		핸드폰 번호는 : ${  memberDTO.tel1  } -${ memberDTO.tel2   }- ${ memberDTO.tel3   }<br>
		이메일 주소는 : ${  memberDTO.email1  }@ ${ memberDTO.email2   }<br>
		주소는 : ${  memberDTO.addr  } 로 바뀌었습니다. <br>
	</c:if>
	<c:if test="${su==0 }">
		정상적으로 업데이트가 안됐습니다.
</c:if>	
	<input type="button" value="목록으로" onclick="location.href='../main/index.jsp'">
</body>
</html>