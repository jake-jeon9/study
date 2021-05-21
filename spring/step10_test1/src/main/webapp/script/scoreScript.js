
 	function check(){

	var frm=document.socreTable;
	 	
 	if(!frm.studNo.value){
 		alert("학번을 입력하세요");
 		frm.studNo.focus;
 	}else if(!frm.name.value){
 		alert("이름을 입력하세요");
 		frm.name.focus;
 	}else if(!frm.kor.value){
 		alert("국어를 입력하세요");
 		frm.kor.focus;
 	}else if(!frm.eng.value){
 		alert("영어를 입력하세요");
 		frm.eng.focus;
 	}else if(!frm.mat.value){
 		alert("수학을 입력하세요");
 		frm.mat.focus;
 	}else{
 		frm.submit();
 	}
 	
 	}
 	
 	
 	function getResult(){
 	var frm = document.checkResult;
 	
 	var result = frm.result.value;
 	
 	if(result>0){
 		alert("저장성공");
 		location.href="./scoreList.jsp"
 	}else{
		alert("저장실패");
 		location.href="./scoreWriteForm.jsp"
 		}
 	}