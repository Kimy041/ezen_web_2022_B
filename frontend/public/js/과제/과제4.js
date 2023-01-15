
let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열형 C언어' ]
let 대여목록 = [ '혼자공부하는자바' ]

	
let html = '<tr><th>번호</th><th>도서</th><th>도서대여여부</th><th>비고</th></tr>'
for(let i = 0 ; i < 도서목록.length ; i++ ){// for s // 고객페이지 도서목록 출력
	html += `<tr>
				<td>${i+1}</td>
				<td>${도서목록[i]}</td>
				<td class="YorN"></td>
				<td>
					<button onclick="bookGet(${i})">대여버튼</button>
					<button onclick="bookReturn(${i})">반납버튼</button>
				</td>
			</tr>`
			
	}// for e
document.querySelector('.customerTable').innerHTML = html
console.log(html)


function 도서대여여부( YorN ){
	if(대여목록.indexOf(도서목록[YorN]) == -1 ){ // if s //대여목록에 도서목록에 있는 도서가 존재하지않는다면
		document.querySelector('.YorN').innerHTML='대여가능'
	}else{
		document.querySelector('.YorN').innerHTML='대여중' 
		}// if e
}


function bookGet( gbtn ){// f s
	if(대여목록.indexOf(도서목록[gbtn]) == -1 ){ // if s //대여목록에 도서목록에 있는 도서가 존재하지않는다면
		alert('대출되었습니다.')
		대여목록.push(도서목록[gbtn]) // 대여된 도서 대여목록에 추가
		console.log(대여목록)
	}else{
		alert('이미 대여중인 도서입니다.') 
		}// if e
	document.querySelector('.YorN').innerHTML='대여중' 
}// f e

function bookReturn(rbtn ){// f s
	if(대여목록.indexOf(도서목록[rbtn]) !== -1 ){// if s //대여목록에 도서목록에 있는 도서가 존재하다면
		alert('반납되었습니다.')
		대여목록.splice( 대여목록.indexOf(도서목록[rbtn]) , 1 )// 반납된 도서 대여목록에서 제거
		console.log(대여목록)
	}else{
		alert('대출된 도서가 아닙니다.') 
		} // if e
	document.querySelector('.YorN').innerHTML='대여가능'
}// f e




