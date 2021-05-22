function finishWrite() {
	//alert("test");
	var frm = document.boardWriteForm;		// form 내장객체 생성
	
	if(!frm.subject.value) {
		alert("제목을 입력하세요.");
		frm.subject.focus();
		
	} else if (!frm.content.value) {
		alert("내용을 입력하세요.");
		frm.content.focus();
		
	} else {
		
		frm.submit();
		
	}
		
	
}

function updateWrite() {
	var frm = document.boardUpdateForm;		// form 내장객체 생성
	
	if(!frm.subject.value) {
		alert("제목을 입력하세요.");
		frm.subject.focus();
		
	} else if (!frm.content.value) {
		alert("내용을 입력하세요.");
		frm.content.focus();
		
	} else {
		
		frm.submit();
		
	}
}

function checkBoardModify() {
	var frm = document.modify;		// form 내장객체 생성
	
	if(!frm.subject.value) {
		alert("제목을 입력하세요.");
		frm.subject.focus();
		
	} else if (!frm.content.value) {
		alert("내용을 입력하세요.");
		frm.content.focus();
		
	} else {
		
		frm.submit();
		
	}
}