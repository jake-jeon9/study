
//입력검사를 진행함
//회원가입에서의 입력검 이름,아이디, 비밀번호
function checkWrite(){
	var frm = document.writeForm;
	//var name = document.getElementByName("name");
	//var id = document.getElementByName("id");
	//var pw1 = document.getElementByName("pw1");
	//var pw2 = document.getElementByName("pw2");
	
	if(!frm.name.value){
		alert("이름을 입력하세요");
		frm.name.focus();
	}else if(!frm.id.value){
		alert("아이디를 입력하세요");
		frm.id.focus();
	}else if(!frm.pw1.value){
		alert("비밀번호를 입력하세요");
			frm.pw1.focus();
	}else if(!frm.pw2.value){
		alert("재확인을 입력하세요");
			frm.pw2.focus();
	}else if(frm.pw1.value != frm.pw2.value){
		alert("비밀번호와 재확인이 일치하지 않습니다.");
		frm.pw1.focus();
	}else{
		frm.submit();//데이터 전송
	}
	
}
//로그인 화면에서 입력검사
function checkLogin(){
	var frm = document.writelogin;//form객체 생성
	
	if(!frm.id.value){
		alert("아이디를 입력해주세요");	
		frm.id.focus();
		
	}else if(!frm.pw.value){
		alert("비밀번호를 입력해주세요.");
		frm.pw.focus();
	}else{
		frm.submit();
	}
	
	}
	
	//아이디 중복확인
function checkId(){
	//아이디 읽어오기
	var sId = document.writeForm.id.value;
	//값이 있는지 먼저 입력검사
	if(sId==""){
		alert("아이디 입력해라~")
		document.writeForm.id.focus();
	}else{
		window.open("checkid.jsp?id="+sId,"","width=350 height=100 left=500 top=200");
	}
	
}


	function checkModify(){
		
		var frm = document.modifyForm;
		alert("수정하기버튼 클릭됨");
		
		if(!frm.name.value){
			alert("이름을 입력하세요");
			frm.name.focus();
		}else if(frm.pw1.value != frm.pw2.value){
			alert("비밀번호와 재확인이 일치하지 않습니다.");
			frm.pw1.focus();
		}else if(!frm.tel1.value){
			alert("번호 앞3자리를 입력하세요");
			frm.tel1.focus();
		}else if(!frm.tel2.value){
			alert("번호 중간4자리를 입력하세요");
			frm.tel2.focus();
		}else if(!frm.tel3.value){
			alert("번호 끝4자리를 입력하세요");
			frm.tel3.focus();
		}else{
			frm.submit();//데이터 전송
		}
	}

function reset1(){
	alert("리셋?")
	var frm=document.modifyForm;
	frm.pw1.value="";
	frm.pw2.value="";
	frm.email1.value="";
	frm.tel2.value="";
	frm.tel3.value="";
	frm.addr.value="";
	
	
}









