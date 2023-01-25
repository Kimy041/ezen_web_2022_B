
let contentArray = []

function addContent(){
	let content = document.querySelector('.content').value
	contentArray.push( content )
	
	printContent()
}// f e

// 2, 삭제 버튼을 클릭했을때 함수
function onDelete( dno ){
	contentArray.splice( dno , 1 )
	printContent()
}

// 3. 배열내 존재하는 요소들을 출력하는 함수[ 1. 등록했을때 2.삭제했을때]
function printContent(){
	
	let html = '<tr><th>번호</th><th>방문내용</th><th>비고</th> </tr>'
	
	for(let i = 0 ; i < contentArray.length ; i++ ){
		
		html += `<tr> <th>${i+1}</th><th>${contentArray[i]}</th><th><button onclick="onDelete( ${i} )">삭제 </button></th></tr>`
				/* onDelete(삭제할번호)*/
	}// for end
	document.querySelector('.contentTable').innerHTML = html
}















