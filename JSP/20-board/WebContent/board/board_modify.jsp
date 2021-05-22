<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#registForm{
	width :500px;
	height : 380px;
	border : 1px solid lightgray;
	margin : auto;
	}
h2{
	text-align:  center;
}	
table {
	margin : auto;
	width : 450 px;
}
.td_left{
		width : 150px;
		background : orange;
}
.td_right{
		width:300px;
		background : skyblue;
}

</style>
</head>
<body>
<h2>글 내용 상세보기 </h2>
		<form action="boardModifyPro.do"  method="post"
			name="boardform" id=registForm>
			<table>
				<tr>
					<td class="td_left"> <label for="board_name">글쓴이</label></td>
					<td class="td_right">
					<input type="text" name="board_name"  id="board_name"  readonly="readonly" required ="required" value="${boardBean.board_name }">
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="board_pw">비밀번호</label></td>
					<td class="td_right"> 
					<input type="password" name="board_pw" id="board_pw"  required ="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="">제목</label></td>
					<td class="td_right">
					<input type="text" name="board_subject" id="board_subject" required ="required"
					value="${boardBean.board_subject }" >
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="">내용</label></td>
					<td class="td_right">
					<textarea rows="15" cols="40" name="board_content" 
					required ="required" id = "board_content"
					  style="text-align: center;">
					 ${boardBean.board_content }"</textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"> <label for="">업로드 된 파일 </label></td>
					<td class="td_right">
					<input type="hidden"  name="board_file"  id="board_file" value="${boardBean.board_file }" >
					<c:if test="${ boardBean.board_file !=null}">  
					<a href="fileDown.do?downFile=${boardBean.board_file }">
					${boardBean.board_file }</a>
					</c:if>
					<c:if test="${boardBean.board_file ==null }"> 첨부된 파일 없음 </c:if>
					</td>
				</tr>
				<tr>
					<td colspan ="2" align ="center">
					<input type="submit" value="수정" >
					<input type="button" value="뒤로" onclick="history.back();">
					<input type="hidden" name="pageInfo" id="pageInfo" value="${pageInfo }">
					<input type="hidden" name="board_num" id="board_num" value="${boardBean.board_num }">
					</td>
				</tr>			
			</table>
			</form>
</body>
</html>