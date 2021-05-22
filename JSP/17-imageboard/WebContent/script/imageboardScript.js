/**
 * 
 */

function checkImageboardWriteForm(){
		var frm= document.writeForm;
		
		if(!frm.imageId.value || frm.imageId.value == "img_"){
			alert("상품코드 입력");
			frm.imageId.focus();
		}else if(!frm.imageName.value){
			alert("상품명 입력");
			frm.imageName.focus();
		}else if(!frm.imagePrice.value){
			alert("단가 입력");
			frm.imagePrice.focus();
		}else if(!frm.imageQty.value){
			alert("개수 입력");
			frm.imageQty.focus();
		}else if(!frm.imageContent.value){
			alert("컨텐츠 입력");
			frm.imageContent.focus();
		}else{
			frm.submit();
		}
	}