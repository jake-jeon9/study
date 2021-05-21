function checkScoreWrite() {
	var frm = document.scoreForm;
	
	if(!frm.studNo.value) {
		alert("학번을 입력하세요");
		frm.studNo.focus();
	} else if(!frm.name.value) {
		alert("이름을 입력하세요");
		frm.name.focus();
	} else {
		frm.submit();
	}
}

function checkScoreModify() {
	//alert("test");
	var frm = document.scoreForm;
	
	if(!frm.kor.value) {
		alert("국어 점수를 입력하세요");
		frm.kor.focus();
	} else if(!frm.eng.value) {
		alert("영어 점수를 입력하세요");
		frm.eng.focus();
	} else if(!frm.mat.value) {
		alert("수학 점수를 입력하세요");
		frm.mat.focus();
	} else {
		frm.submit();
	}
}






