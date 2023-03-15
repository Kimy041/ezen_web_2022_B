console.log('js열림')

getBoard();
function getBoard(){
	console.log('getBoard()');
	
	let bno = document.querySelector('.bno').innerHTML;
	console.log(" bno : "+ bno )
	
	$.ajax({
		url : "/jspweb/board/info",
		method : "get" ,
		data : { "type" : 2 , "bno" : bno } ,	// 1:전체출력 2:개별출력
		success : (r)=>{
			console.log('통신');
			console.log(r);
			
			let html = `
						${ r.bdate } /
						${ r.bview } /
						${ r.bup } /
						${ r.bdown } /
						`
			document.querySelector('.infobox').innerHTML = html;
			document.querySelector('.pimgbox').innerHTML = r.mid;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			
			if( r.bfile == null ){
				document.querySelector('.bfile').innerHTML = '첨부파일없음';
			}else{ // 첨부파일 있을때
				html = `${ r.bfile } <button onclick="bdownload( '${ r.bfile }' )" type="button"> 다운로드 </button>`
				document.querySelector('.bfile').innerHTML = html;
			}
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