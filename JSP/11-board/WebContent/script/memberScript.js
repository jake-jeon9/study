// 회원가입화면 입력 검사 : 이름, 아이디, 비밀번호
function checkWrite() {
	var frm = document.writeForm; // form 내장객체 생성
	
	if(!frm.name.value) {
		alert("이름을 입력하세요");
		frm.name.focus();
	} else if(!frm.id.value) {
		alert("아이디를 입력하세요");
		frm.id.focus();
	} else if(!frm.pwd.value) {
		alert("비밀번호를 입력하세요");
		frm.pwd.focus();
	} else if(frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.");
		frm.repwd.focus();
	} else {
		frm.submit();
	}
}

// 로그인화면 입력 검사 : 아이디, 비밀번호
function checkLogin() {
	var frm = document.loginForm;	// form 객체 생성
	
	if(!frm.id.value) {
		alert("아이디를 입력하세요");
		frm.id.focus();
	} else if(!frm.pwd.value) {
		alert("비밀번호를 입력하세요");
		frm.id.focus();
	} else {
		frm.submit();
	}
}

// 아이디 중복 검사 버튼 클릭
function checkId() {
	// 아이디 읽어오기
	var sId = document.writeForm.id.value;
	
	// 입력값이 있는지 검사
	if(sId == "") {
		alert("먼저 아이디를 입력하세요.")
	} else {
		window.open("checkId.jsp?id=" + sId, "",
					"width=350 height=100 left=500 top=200");
	}
}

function checkModify() {
	var frm = document.modifyForm;
	
	if(!frm.name.value) {
		alert("이름을 입력하세요.");
		frm.name.focus();
	} else if(!frm.pwd.value) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
	} else if(frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.");
		frm.repwd.focus();
	} else if(!frm.email1.value) {
		alert("이메일을 입력하세요.");
		frm.email1.focus();
	} else if(!frm.tel2.value) {
		alert("핸드폰 번호를 입력하세요.");
		frm.tel2.focus();
	} else if(!frm.tel3.value) {
		alert("핸드폰 번호를 입력하세요.");
		frm.tel3.focus();
	} else if(!frm.addr.value) {
		alert("주소를 입력하세요.");
		frm.addr.focus();
	} else {
		frm.submit();
	}
}

function re() {
	var frm = document.modifyForm;
	
	frm.name.value="";
	frm.pwd.value="";
	frm.repwd.value="";
	frm.email1.value="";
	frm.email2.value="";
	frm.tel1.value="";
	frm.tel2.value="";
	frm.tel3.value="";
	frm.addr.value="";
}