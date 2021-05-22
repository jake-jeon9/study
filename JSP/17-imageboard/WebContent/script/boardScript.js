 //글쓰기 입력검사
	function makeNewContent(){
		var frm = document.NewContent;
		
		if(!frm.subject.value){
			alert("제목을 입력하세요");
			frm.subject.focus();
		}else if(!frm.content.value){;
		 	alert("내용을 작성하세요");
		frm.content.focus();
		}else{
			frm.submit();
		}
	}
	
	//체크 보드 스크립트
	
	function checkBoardModify(){
		alert("진입?");
		var frm1= document.NewContent1;
		
		if(!frm1.subject1.value){
			alert("제목을 입력하세요");
			frm1.subject1.focus();
		}else if(!frm1.content1.value){;
		 	alert("내용을 작성하세요");
		frm1.content1.focus();
		}else{
			frm1.submit();
			alert("전송되었습니다.");
		}
		
	}
	
