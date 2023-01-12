/*

	함수 :
		1. 함 : 상자  수 : 숫자
			- 상자안에 들어있는 수/코드
			- 누군가 미리 상자에 넣어둔 수/코드
			- 미리 정의[만들어진]된 수/코드
		
		2. 역할
			1. 재활용성 : 한번 만들면 반복적으로 사용가능
			
			2. 인수/반환 : 인수에 따른 서로 다른 반환값 얻을 수 있다.
				인수 : 들어갈 수/코드 : 상자 안으로 들어오는 수
				
				반환 : 나오는 수/코드 : 상자 밖으로 나가는 수
					- 함수가 종료되면서 돌려주는 값 [ turn 안하면 그 안에 있는 메모리 다 사라짐 ]
					
			3. 메모리의 효율성이 높을때 :
				함수{ } 안에서 '{' 실행되 시작되고 '}' 끝나면 메모리 초기화
				- 지역변수
				- 전역변수
				
				*메모리증가 -> 속도 감소 -> 개발비 증가
				
		3. 함수 선언방법
			1.
			
			function 함수명( 인수1 ,인수2, 인수){
				
				코드 정의
				
				return 값;
			}
		4. 함수 호출 방법
			1. 함수명( 인수1 , 인수2 , 인수3 )
			2. 주의할점 : 정의된 인수의 개수와 동일
				function 함수1( x ){}	------> 함수1( x )
				function 함수2( x , y ){} -----> 함수2( x , y )
				function 함수3( x , y , z ){} -> 함수3( x , y , z)
*/

// 1. 함수의 선언 [ 1. 재활용성 ]
console.log( 2*1 )
function 함수1( x ){ console.log( 2*x )}

// ------> 위 코드를 다시 호출시
console.log( 2*2 )
함수1( 2 )

// 2. 함수의 호출 [ 2. 인수에 따른 서로 다른 결과물 ]
function 함수2( x , y ){ // 인수[함수 안으로 들어오는 수/코드] 2개 함수 정의
	console.log( '함수2에서 실행된 결과'+ (x + y) )
} // 함수 end
함수2( 3 , 5 )			// 함수 호출시 = 함수명( 전달할 인수 , 전달할 인수 )
함수2( 9 , 8 )

// 3. 함수의 반화 [ 3. ]
function 함수3( x , y , z ){ // 인수 3개 함수 정의
	let 결과 = x + y + z ; // 함수정의
	return 결과;
}// 함수 end
//console.log('함수안에서 선언된 변수를 함수 밖에서 호출 : ' + 결과 ) // 결과 is not defined
let 결과 = 함수2( 1 , 2 , 3 )
console.log( '함수실행후 return[반환값] 출력 : ' + 결과)





