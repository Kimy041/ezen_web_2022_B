console.log('js열림');

// 로그인한 회원정보 호출
getlogin();
function getlogin(){
	
	$.ajax({
		url : "/jspweb/login",
		method : "get",
		success : (r)=>{
			console.log('ajax 통신');
			console.log(r);	// Dto1개회원 --> r 객체1개 회원
			
			
			let html = ``;// 1. html 구성
			if( r == null ){ // 2. 로그인 안했으면
				html += `<a href="/jspweb/member/signup.jsp" > 회원가입 </a>`
				html += `<a href="/jspweb/member/login.jsp"> 로그인 </a>`
			
			}else{ // 3. 로그인 했으면
				
				html += `<img src="/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" class="hpimg">`
				html += `<br> ${ r.mid }님 안녕하세요`
				if( r.mid == 'admin' ){ // 관리자이면
					html += `<br> <a href="/jspweb/admin/info.jsp" > 관리자페이지 </a>`
				}
				html += `<br> <a href="/jspweb/member/logout.jsp"> 로그아웃 </a>`
			}
			console.log( html );
			document.querySelector('.header').innerHTML = html;
		}
	})
}