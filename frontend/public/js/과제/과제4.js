
let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열형 C언어' ]
let 대여목록 = [ '혼자공부하는자바' ]
	
let html = '<tr><th>번호</th><th>도서</th><th>도서대여여부</th><th>비고</th></tr>'

for(let i = 0 ; i < 도서목록.length ; i++ ){
	html += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td><div class="btn"></div></td><td><button onclick="get()">대여버튼</button><button onclick="">반납버튼</button></td></tr>`
				}
document.querySelector('.customerTable').innerHTML = html

function 버튼클릭( 번호 ){// f s
	console.log( 번호+'번호를 선택했군요.')
	// 1. 중복검사/취소	[배열명.indexOf(찾을데이터) : 찾은 데이터의 인덱스번호 반환 , 없으면 -1 ]
	if(선택번호목록.indexOf(번호) >= 0 ){// if s
		alert('대여중인 도서입니다.')
		추첨버튼출력()// 함수호출
		return; // 반환값은 없지만 함수를 끝낼 수 있다. [ 더이상 아래로 코드가 실행되지 않는다. ]
	}// if e
	// 2. 6개까지만 저장 [ 배열명.length : 배열내 데이터 총 개수 ]
	if( 선택번호목록.length == 6 ){// if s //배열내 숫자가 6개 존재하면
		alert('이미 모두[6개]를 선택했습니다.')
		return;
	}// if e
	// 위 2가지 유효성검사를 충족하지 않았을때 저장
	선택번호목록.push(번호)
	추첨버튼출력();// 함수호출	
}// f e