// 입력 검사: 이름, 아이디, 비번

function checkWrite() {
	//alert("test");
	var frm = document.writeForm;		// form 내장객체 생성
	
	if(!frm.name.value) {
		alert("이름을 입력하세요.");
		frm.name.focus();
		
	} else if (!frm.id.value) {
		alert("아이디를 입력하세요.");
		frm.id.focus();
		
	} else if (!frm.pwd.value) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
	} else if(frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.");
		frm.repwd.focus();
	}
	
	//입력 확인하기
		else if(confirm("입력하신 내용이 맞습니까?")) {
			frm.submit();
	}
}

// 로그인 화면에서 입력검사

function checkLogin() {
	//alert("test");
	frm = document.loginForm;
	if(!frm.id.value) {
		alert("아이디를 입력하세요.")
		frm.id.focus();
	} else if (!frm.pwd.value) {
		alert("비밀번호를 입력하세요.")
		frm.pwd.focus();
	} else {
		frm.submit();
	}
}

// 중복체크 
function checkId() {
	var sId = document.writeForm.id.value;
	if(sId == "") {
		alert("아이디를 먼저 입력하세요.")
		
	} else  {
		// 브라우저창을 관리하는 내장객체   // 요청파일 이름 
		window.open("./member/checkId.jsp?id=" + sId, "",
					// 모니터 크기, 위치 
					"width=500 height=200 left=700 top=400")
	} 
}

// 회원정보 수정
function checkModify() {
	var frm = document.modifyForm;		// form 내장객체 생성
	if (!frm.pwd.value) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
	} else if(frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.");
		frm.repwd.focus();
	} else if(!frm.tel2.value) {
		alert("핸드폰 번호 두번째 자리를 정확하게 입력해주세요.");
	} else if(!frm.tel3.value) {
		alert("핸드폰 번호 세번째 자리를 정확하게 입력해주세요.");
	}
	
	//입력 확인하기
		else if(confirm("입력하신 내용이 맞습니까?")) {
			frm.submit();
	}
}












