
let contentArray = []
//let 테이블행 = '<tr> <th>번호</th><th>방문록</th> </tr>';
//for( 초기값 ; 배열.length ; 증감식 ){ 실행문 } 
function addContent(){
	let text = document.querySelector('.text').value
	contentArray.push( text )
	
	let 테이블행 = '<tr> <th>번호</th><th>방문록</th> </tr>';
	for(let n = 1 ; n <= contentArray.length ; n++ ){
		
		테이블행 += '<tr> <th>'+n+'</th><th>'+contentArray[n-1]+'</th> </tr>';
	}
	
	document.querySelector('.content_table').innerHTML = 테이블행
	document.querySelector('.text').value = ''
}