console.log( memberInfo );
// * 로그인이 안되어있으면
if( memberInfo.mid == null ){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.rcontent').value = '로그인후 작성 가능합니다.';
	document.querySelector('.rwritebtn').disabled = true;
}

// * 현재 보고 있는 게시물 번호
let bno = document.querySelector('.bno').value;

// 1. 해당 게시물 호출
getBoard();
function getBoard(){
	console.log('getBoard()');
	console.log(" bno : "+ bno )
	

	$.ajax({
		url : "/jspweb/board/info",
		method : "get" ,
		data : { "type" : 2 , "bno" : bno } ,	// 1:전체출력 2:개별출력
		success : (r)=>{
			console.log('통신');
			console.log(r);
			
			let html = ``
			
				document.querySelector('.mimg').src = `/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }`
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.bdate').innerHTML = r.bdate;
				document.querySelector('.bview').innerHTML = r.bview;
				document.querySelector('.bup').innerHTML = r.bup;
				document.querySelector('.bdown').innerHTML = r.bdown;
				document.querySelector('.btitle').innerHTML = r.btitle;
				document.querySelector('.bcontent').innerHTML = r.bcontent;
				
				if( r.bfile == null ){ // 첨부파일 없을때
					
				}else{ // 첨부파일 있을때
					// html = ` ${ r.bfile } <button onclick="bdownload( '${ r.bfile }' )" type="button"> 다운로드 </button>`
					html = `<a href="/jspweb/filedownload?bfile=${ r.bfile }">
								<i class="fas fa-download"></i>${ r.bfile } 
							</a>`
					document.querySelector('.bfile').innerHTML = html;
				}
				
			// ---------------------------------------------------------- //
			// 로그인된 회원과 작성자가 일치하면 수정/삭제 버튼 출력
			if( memberInfo.mid == r.mid ){
				html = `
						<button onclick="bdelete(${bno} , ${r.cno} )" type="button" class="bbtn"> 삭제 </button>
						<button onclick="bupdate(${bno})" type="button" class="bbtn"> 수정 </button>
						`
				document.querySelector('.btnbox').innerHTML = html;
			}
			// 댓글 출력
			getReplyList();
		}
	})
}
// 2. 다운로드 [ 다운로드할 파일명을 인수로 받기 ]
function bdownload( bfile ){
	console.log('선택한 파일명 : '+ bfile )
	
	
	 /*
	 $.ajax({
		url : "/jspweb/filedownload" ,
		method : "get" ,
		data : { "bfile" : bfile } ,
		success : (r)=>{
			console.log('통신');
			console.log(r)
		}
	})
	*/
	
	location.href="/jspweb/filedownload?bfile="+bfile;
}

// 3. 조회수[1] 좋아요수[2] 싫어요수[3]
bIncrease( 1 ); // 해당 jsp/js가 열리는 순가 [ 조회수 증가 ]
function bIncrease( type ){
	// 1. 현재 게시물의 번호 [ 증가할 대상 ]
	
	let bno = document.querySelector('.bno').value;
	// 2. 
	$.ajax({
		url : "/jspweb/board/view" ,
		method : "get" ,
		data : { "type" : type , "bno" : bno } ,
		success : (r)=>{
			console.log('통신');
			console.log(r);
			// 새로고침
			getBoard();
		}
	})
}
// 4. 삭제
function bdelete( bno , cno ){
	
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "delete" ,
		data : { "bno" : bno , "type" : 1 } ,
		success: (r)=>{
			console.log(r)
			if( r == 'true'){
				alert('[삭제 성공]');
				location.href = "/jspweb/board/list.jsp?cno="+cno;
			}else{
				alert('[삭제 실패]')
			}
		}
	})
}
// 5. 수정 페이지로 아동
function bupdate( bno ){
	location.href = "/jspweb/board/update.jsp?bno="+bno;
}
// 6. 댓글 쓰기
function rwrite( ){
	$.ajax({
		url : "/jspweb/reply" ,
		method : "post" ,
		data : { "type" : 1 , "bno" : bno , "rcontent" : document.querySelector('.rcontent').value } ,
		success : (r)=>{
			console.log(r);
			if( r == 'true'){
				alert('[ 댓글 작성 성공 ]')
				document.querySelector('.rcontent').value = '';
				// 특정 div만 새로고침[랜더링]
				// $(".replylistbox").load( location.href+'.replylistbox');
				// js : 현재페이지 새로고침[랜더링]
				location.reload();
			}else{
				alert('[ 댓글 작성 실패 ]')
			}
		}
	});
}
// 7. 댓글 출력
function getReplyList(){
	$.ajax({
		url : "/jspweb/reply",
		method : "get" ,
		data : { "type" : 1 , "bno" : bno } ,
		success : (r)=>{
			console.log(r);
			
			let html = ''
			r.forEach( (o,i)=>{
				html += `
						<div>
							<span> ${ o.mimg } </span>
							<span> ${ o.mid } </span>
							<span> ${ o.rdate } </span>
							<span> ${ o.rcontent } </span>
							<button onclick="rereplyview(${ o.rno })" type="button"> 답변보기 </button>
							<div class="rereplybox${ o.rno }">
							
							</div>
						</div>
						`
			})
			document.querySelector('.replylistbox').innerHTML = html;
		}
	})
}
// 8. 하위 댓글 구역 표시
function rereplyview( rno ){
	$.ajax({
		url : "/jspweb/reply",
		async : "false" ,	// 동기식 통신
		method : "get" ,
		data : { "type" : 2 , "bno" : bno , "rindex" : rno } ,
		success : (r)=>{
			console.log(r);
			let html = ''
			
			r.forEach( (o,i)=>{
				html += `------------
						<div>
							<span> ${ o.mimg } </span>
							<span> ${ o.mid } </span>
							<span> ${ o.rdate } </span>
							<span> ${ o.rcontent } </span>
						</div>
						`
				 });
			html +=`
				<textarea class="rrcontent${rno}"> </textarea>
				<button type="button" onclick="rrwirte(${rno})"> 대댓글 작성 </button>
				`
			document.querySelector('.rereplybox'+rno ).innerHTML = html;
		}
	})
}
// 9. 하위댓글 쓰기
function rrwirte(rno){
	// bno , mno , rrcontent , rindex(상위댓글번호)
	$.ajax({
		url : "/jspweb/reply" ,
		method : "post" ,
		data : { "type" : 2 , "bno" : bno , "rindex" : rno , "rcontent" : document.querySelector('.rrcontent'+rno).value } ,
		success : (r)=>{
			console.log(r);
			if( r == "true" ){
				alert('대댓글 쓰기');
				location.reload();
			}
			
		}
	})
}

/*
	1. onclick = JS코드 작성구역
		1. bdownload( 춘식이.png )	: .파일확장자 구분기호가 아닌 .접근연산자로 사용됨
		2. bdownload( '춘식이.png' )	: .접근연산자를 파일확장자 구분기호
	<button onclick="bbownload(${ r.bfile })" type="button">
		<button onclick="bbownload( 춘식이.png )" type="button">
		
	<button onclick="bdownload( '${ r.bfile }' )" type="button">
		<button onclick="bdownload( '춘식이.png' )" type="button">
	
	2. 
		전송 방법
			HTML 	:	1.<form>			2.<a href="">
			JS		:	1.location.href=""
			JQUERY	:	1.$.ajax({})
			servlet	:	
					1. response.getwriter.point(문자데이터);
					2. response.sendRedirect('경로');
*/