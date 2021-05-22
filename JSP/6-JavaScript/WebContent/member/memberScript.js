function checkWrite() {
	var frm = document.writeForm; // form 객체 얻기
	
	if(!frm.name.value) {
		alert("이름을 입력하세요.");
		frm.name.focus();
	} else if(!frm.id.value) {
		alert("아이디를 입력하세요.");
		frm.id.focus();
	} else if(!frm.pwd.value) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
	} else if(frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.");
		frm.repwd.focus();
	} else if(!frm.gender[0].checked && !frm.gender[1].checked) {
		alert("성별을 선택하세요.");
		frm.gender[0].focus();
	} else if(!frm.email.value) {
		alert("이메일을 입력하세요.");
		frm.email.focus();
	} else if(!frm.tel2.value || !frm.tel3.value) {
		alert("핸드폰 번호를 입력하세요.");
		frm.tel2.focus();
	} else if(!frm.addr.value) {
		alert("주소를 입력하세요.")
		frm.addr.focus();
	} else {
		frm.submit();
	}
}












