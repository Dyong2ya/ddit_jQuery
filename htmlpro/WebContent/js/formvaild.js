/**
 * 
 */

function vaild() {
   
   // form name = 'ff' 임
   f = document.ff;
   
   // 입력한 값을 가져옴 - value(입력한값)
   vname = f.name.value.trim();
   vaddr = f.addr.value.trim();
   vbirth = f.birthday.value.trim();
   vid = f.id.value.trim();
   vemail = f.email.value.trim();
   vtel = f.phone.value.trim();
   vpass = f.pass.value.trim();
   
   
   // 공백 검증 , 길이 검증, 정규식
   
   if(vid.length < 1) {
	      alert("ID 입력")
	      return false;
	   }
	   
	   if(vid.length > 6 || vid.length > 8) {
	      alert("id는 6 ~ 8 사이로 입력");
	      return false;
	   }
	   
	   
	   // 정규식 - 영문 소문자 시작, 영문 대소문자 숫자를 조합
	   idReg = /^[a-z][a-zA-z0-9]{5,10}$/;
	   
	   if(!(idReg.test(vid))) {
	      alert("id 형식 오류입니다.");
	      return false;
     }
 
	//------------------------------------------------------
	   
   if(vid.length < 1) {
	  alert("비밀번호 입력")
	  return false;
   }	 
   //비밀번호 - 8 ~ 12 사이 - 영문소문자 대문자 숫자 특수문자가 반드시 한 글자 이상씩
   //전방탐색
   passReg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,12}$/; //?= : 전방탐색의 시작 & .* : 문자가 0또는 1번이상 와야 한다. & [] : 범위지정 & {} : 시작,끝 자리수 & $ : 전방탐색 끝
	   if(!(passReg.test(vid))) {
		      alert("비밀번호 형식 오류입니다.");
		      return false;
	     }
	 
	 
   
   // 이름
   if(vname.length < 1) {
      alert("이름 입력");
      return false;
   }
   
   if(vname.length < 2 || vname.length > 5) {
      alert("이름은 2 ~ 5 글자로 작성하세요");
      return false;
   }
   
   // 정규식
   nameReg = /^[가-힣]+$/; // ^ 시작 $ 끝
   
   // 정규식.test(value)
   if(!(nameReg.test(vname))) {
      alert("이름 형식 오류입니다.");
      return false;
      
   }
   
   //------------------------------------------------------
   
   
   if(vaddr.length < 1) {
      alert("주소 입력")
      return false;
   }
   
   //------------------------------------------------------
   
   
   if(vbirth.length < 1) {
      alert("생일 입력");
      return false;
   }
   
   //------------------------------------------------------
   
  
   if(vemail.length < 1) {
      alert("이메일 입력");
      return false;
   }
   emailReg = /^([a-zA-Z][a-zA-Z0-9]+)@([a-zA-Z][a-zA-Z0-9_-]+)(\.[a-zA-Z]+){1,2}$/
   if(!(emailReg.test(vemail))){
	   alert("이메일 형식 오류");
	      return false;	   
   }
	   
   //------------------------------------------------------
   
   if(vtel.length < 1) {
      alert("전화번호 입력")
      return false;
   }
   telReg=/^\d{2,3}\d{4}\d{4}$/
   if(!(telReg.test(vtel))){
	   alert("전화번호 형식 오류");
	      return false;	
   }
   //------------------------------------------------------
   
   // 다 성공했으면
   return true;
   
   
}

/*
 
valid = function() {
   
}

varid = () => {
   
}

*/