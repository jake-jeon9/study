<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#listForm{
 		width:600px;
 		height:280px;
 		border : 1px solid lightgray;
 		margin : auto;
}
h2{
		text-align: center;
}

table {
		margin : auto;
		width : 600px;
		
}

#tr_top{
		background: orange;
		text-align: center;
}

#pageList{
	margin :auto;
	width : 650px;
	text-align:center; 
}
#currentPaging{
		color : red;
		text-decoration: underline;
		
}

#paging{
		color:blue;
		text-decoration: none;
}

</style>
</head>
<body>

		<h2> 글 목록</h2>
		<div id="listForm">
			<table>
				<tr id="tr_top">
					<td width="45">번호</td>
					<td>제목</td>
					<td width="80">작성자</td>
					<td width="150">날짜</td>
					<td width="50">조회수</td>
			</tr>
			<c:forEach var="boardBean" items="${list }">
					<tr align="center">
						<%--변수명은 ${boardBean.변수명}=> 톰캣이 boardBean.getter함수 호출함. --%>
						<td>${boardBean.board_num}</td>					
						<td align="left">&nbsp;
						<c:if test="${boardBean.board_re_lev !=0 }"><%--레벨 값만큼 들여쓰기 --%>
								<c:forEach var="i" begin="0" end="${boardBean.board_re_lev*2 }" step="1">
								&nbsp;
								</c:forEach>
								↘
						</c:if>
						<a href="boardDetail.do?board_num=${boardBean.board_num }&page=${pageInfo.page}">${boardBean.board_subject}</a></td>					
						<td>${boardBean.board_name}</td>					
						<td>${boardBean.board_date}</td>					
						<td>${boardBean.board_readcount}</td>					
					</tr>
			</c:forEach>
			</table>
		</div>
		<div id="pageList">
			<c:if test="${pageInfo.page > 3 }">
				[<a id="paging" href="boardList.do?page=${pageInfo.startPage-1 }">이전</a>]
			</c:if>
			
			<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
					
					<c:if  test="${pageInfo.page==i }">
					[<a id="currentPaging"  href="boardList.do?page=${i }">${i }</a>]
					</c:if>
					
					<c:if test="${pageInfo.page!=i }">
					[<a id="paging" href="boardList.do?page=${i }">${i }</a>]
					</c:if>
					
			</c:forEach>
			
			<c:if test="${pageInfo.endPage < pageInfo.maxPage }">		
				[<a id="paging" href="boardList.do?page=${pageInfo.endPage +1 }">다음</a>]
			</c:if>
		</div>
		<br>
		<div align="center">
		<a href="/20-board/index.jsp">메인화면으로 이동</a> &nbsp; &nbsp; &nbsp;
		<a href="boardWriteForm.do">게시판 글쓰기</a>
		</div>
</body>
</html>