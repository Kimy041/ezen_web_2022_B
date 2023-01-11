// 테이블의 첫행[제목] html 마크업 대입된 변수 
// let html변수명 = 'HTML마크업작성'		//! : 마크업 문자처리

//let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';	// 1번 실행 [ 결과 누적O ]


function onResult(){
	console.log('클릭')// 3, 확인
	
	let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';	// 클릭할때마다 실행 [ 결과 누적X ]
	
	//4. 단<input> 곱<input> 에 입력된 value 각 변수에 저장 
	let dan = document.querySelector('.dan').value
	let gob = document.querySelector('.gob').value
	
	/* 3. <table>의 행<tr> 반복문으로 만들기 */
	for( let 곱 = 1 ; 곱 <= gob ; 곱++  ){ // for s 
	// 곱은 1부터 9까지 1씩증가 반복 처리
	// 곱은 1부터 입력받은 값까지 1씩증가 반복처리
	 
	
	테이블행 += '<tr> <th>'+dan+'</th> <th>'+곱+'</th> <th>'+(dan*곱)+'</th> </tr>';
	
} // for e
document.querySelector('.gu_table').innerHTML = 테이블행	
}



















