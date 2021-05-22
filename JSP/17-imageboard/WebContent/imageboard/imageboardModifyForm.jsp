<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
function HandleBrowseClick(){
  var fileinput = document.getElementById("browse");
  fileinput.click();

}

function Handlechange(){
var fileinput = document.getElementById("browse");
var textinput = document.getElementById("filename");

textinput.value = fileinput.value;
var textline = document.getElementById("changeTag");
var substring = textinput.value.substr(12);

var original = document.getElementById("image1").value;
alert("sub?"+substring);
alert("original?"+original);


textline.innerHTML = substring;


}

</script>
</head>
<body>

<form action="../imageboard/imageboardModify.jsp" enctype="multipart/form-data" method="post" name = "writeForm">
	<table border="1">
		<tr>
		<th>상품코드</th>
		<td><input type="text" name="imageId" value="${imageboardDTO.imageId }" size="20"></td>
		</tr>
		<tr>
		<th>상품명</th>
		<td><input type="text" name="imageName" value="${imageboardDTO.imageName }"size="30"></td>
		</tr>
		<tr>
		<th>단가</th>
		<td><input type="text" name="imagePrice" value="${imageboardDTO.imagePrice }"size="15"></td>
		</tr>
		<tr>
		<th>개수</th>
		<td><input type="text" name="imageQty" value="${imageboardDTO.imageQty }"size="15"></td>
		</tr>
		<tr>
		<th>내용</th>
		<td><textarea name="imageContent" rows="20" cols="76" placeholder="${imageboardDTO.imageContent }"></textarea></td>
		</tr>
		<tr>
		<td colspan="2" align="left">
		<input type="file" name="image1" id="image1" value="${imageboardDTO.image1 }"><p style="text-align:right; display:inline-block; margin:0;">
		현재 파일 : ${imageboardDTO.image1 }</p></td>
		</tr>
		
		
		<tr>
		
  		<td colspan="2">
  		<input type="file" id="browse" name="fileupload" style="display: none" onChange="Handlechange();"/>
 		<input type="hidden" id="filename" readonly="true"/>
 		<input type="button" value="파일 업로드" id="fakeBrowse" onclick="HandleBrowseClick();"/>
  		<label id="changeTag">${imageboardDTO.image1 }</label>
  		</td>
		</tr>
		<tr>
		<td colspan="2" align="center" >
		<input type="submit" value="수정하기">
		<input type="reset" value="다시작성">
		<input type="hidden" value=${seq } name="seq">
		<input type="hidden" value=${pg } name="pg">
		</td>
		</tr>
	</table>
	</form>

</body>
</html>