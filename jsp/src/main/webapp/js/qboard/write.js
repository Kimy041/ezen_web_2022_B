
let 문의임시저장소 = []

function qboard_write(){
	let qboard = {
		qtitle : document.querySelector('.qtitle').value ,
		qcontent : document.querySelector('.qcontent').value ,
		qwriter : document.querySelector('.qwriter').value ,
		qpassword : document.querySelector('.qpassword').value
	}; console.log(qboard);
	
	let writeform = document.querySelector('.writeform');
	let formdata = new FormData( writeform );
	
	문의임시저장소.push( qboard );
	
	let result = true;
	if( result ){ alert('등록 완료'); location.href = 'list.html'; }
	else{ alert('등록 실패')}
	
}