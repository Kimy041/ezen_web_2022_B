console.log('join.js열림')

function join(){
	console.log('join');
	// 유효성검사
	if( document.joinForm.custno.value == ""){
		alert('custno 입력해주세요');
		document.joinForm.custno.focus(); // 커서이동
		return
	}
	if( document.joinForm.custname.value == ""){
		alert('회원성명을 입력해주세요');
		document.joinForm.custname.focus(); // 커서이동
		return
	}
	if( document.joinForm.phone.value == ""){
		alert('phone 입력해주세요');
		document.joinForm.phone.focus(); // 커서이동
		return
	}
	if( document.joinForm.address.value == ""){
		alert('address 입력해주세요');
		document.joinForm.address.focus(); // 커서이동
		return
	}
	if( document.joinForm.joindate.value == ""){
		alert('joindate 입력해주세요');
		document.joinForm.joindate.focus(); // 커서이동
		return
	}
	if( document.joinForm.grade.value == ""){
		alert('grade 입력해주세요');
		document.joinForm.grade.focus(); // 커서이동
		return
	}
	if( document.joinForm.city.value == ""){
		alert('city 입력해주세요');
		document.joinForm.city.focus(); // 커서이동
		return
	}
	// 폼 전송
	document.joinForm.submit();
	alert('회원 등록이 완료 되었습니다!')
}