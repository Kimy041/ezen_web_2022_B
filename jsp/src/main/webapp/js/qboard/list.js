
qboard_print( null , null );

function qboard_print( keyword , key ){
	let qboardlist = [
		{ no : 5 , title : '문의합니다5' , writer : '유재석' , date : '2023-01-30' , view:321 , state : '[ 접수 ]' , end : '-'  } ,
		{ no : 4 , title : '문의합니다4' , writer : '강호동' , date : '2023-01-29' , view:456 , state : '[ 접수 ]' , end : '-'  } ,
		{ no : 3 , title : '문의합니다3' , writer : '신동엽' , date : '2023-01-28' , view:789 , state : '[ 완료 ]' , end : '2023-01-29'  } ,
		{ no : 2 , title : '문의합니다2' , writer : '서장훈' , date : '2023-01-27' , view:147 , state : '[ 완료 ]' , end : '2023-01-27'  } ,
		{ no : 1 , title : '문의합니다1' , writer : '김희철' , date : '2023-01-26' , view:258 , state : '[ 완료 ]' , end : '2023-01-27'  } 
	]
	
	let html = ''
	qboardlist.forEach( (qboard) => {
		html += `<tr>
					<td>${ qboard.no }</td><td><a href="view.html">${ qboard.title }</a></td>
					<td>${ qboard.writer }</td><td>${ qboard.date }</td>
					<td>${ qboard.view }</td><td>${ qboard.state }</td>
					<td>${ qboard.end }</td>
				</tr>`
	})
	document.querySelector('.qboardlist').innerHTML = html;
}

document.querySelector('.searbtn').addEventListener( 'click' , ()=>{
	console.log('검색클릭')
	
	let keyword = document.querySelector('.keyword').value
	let key = document.querySelector('.key').value
	console.log( 'keyword : '+ keyword ); console.log( 'key : '+ key )
	
	qboard_print( keyword , key )
})