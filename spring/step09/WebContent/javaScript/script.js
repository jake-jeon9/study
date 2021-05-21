
 
 function check(){
		
		var frm = document.table;
		
		if(!frm.subject.value){
			alert("제목을 입력");
			frm.subject.focus;
		}else if(!frm.content.value){
			alert("내용을 입력");
			frm.content.focus;
		}else{
			frm.submit();
		}
		
	}
 