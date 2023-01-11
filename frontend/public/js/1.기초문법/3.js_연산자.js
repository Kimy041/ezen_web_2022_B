/*
	JS 연산자
		1. 산수연산자 : +더하기 -빼기 *곱하기 /나누기 %나머지
		2. 연결연산자 : +
				숫자+숫자 : 산술 / 문자+숫자 : 연결 / 문자+문자 : 연결
		
		3. 비교연산자 : 결과는 항상 true/false 참/거짓 맞다/틀리다
						>초과[크다] 				<미만[작다] 
					  	>=이상[크거나같다] 			<=이하[작거나같다]
					  	==같다[데이터만비교]		===같다[데이터/자료형 비교]
					  	!=같지않다[아니다/제외]		!==같지않다[데이터/자료형 비교]
		
		4. 관계연산자 : 비교연산자가 2개 이상일때
						&& : and 이면서 면서 이고 모두 그리고	[비교연산자 결과가 모두 참이면 참]
							10<a<20 [x] -> a>10 && a<20 []
 						|| : or 이거나 거나 또는 하나라도		[비교연산자 결과가 하나라도 참이면 참]						
						! : 부정 반대						[비교연산자 결과가 참이면 거짓]
		5. 대입연산자 : 
					= 대입[오른쪽에서 왼쪽으로 대입]
					+= 더한후에 대입[오른쪽 데이터를 왼쪽에 더한후 대입]
						변수명 = 변수명 +3		vs 	변수명 += 3
					-= *= /= %=
		6. 증감연산자 :
					변수++	[후위 1증가]		변수--	[후위 1감소]
					++변수	[선위 1증가]		--변수	[선위 1감소]
					변수+=1
		7. 삼항연산자 : 만약에 조건이 참[true]이면 참 반환 / 거짓[false]이면 거짓 반환
					1. 조건 ? 참 : 거짓
						ex) 나이 >= 19 ? '성인' : '청소년'
					2. 중첩
							조건1 ? 참1 : 
							조건2 ? 참2 :
							조건3 ? 참3 : 거짓
							
						ex) 나이 <= 19 ? '청소년' :
							나이 <= 40 ? '청년' :
							나이 <= 60 : '중년' : '노년' 
*/
// 1. 산수연산자
console.log( 3+3 )	// 숫자+숫자 => 숫자
console.log( '더하기 : ' + 10 + 3 ) // 문자+숫자 => 문자 + 숫자 => 문자
console.log( '더하기 : ' + (10+3) ) // (숫자+숫자) => 숫자 + 문자 => 문자
console.log( '빼기 : '  + (10-3) )
console.log( '곱하기 : ' + (10*3) )
console.log( '나누기 : ' + (10/3) )
console.log( '나머지 : ' + (10%3) )	// 몫 제외한 나머지 !!
// 2. 비교연산자
console.log( '초과 : ' + (10>3) )		//t
console.log( '미만 : ' + (10<3) )		//f
console.log( '이상 : ' + (10>=3) )		//t
console.log( '이하 : ' + (10<=3) )		//f
console.log( '같다 : ' + (10==3) )		//f
console.log( '같지않다 : ' + (10!=3) )	//t
// 3. 관계연산자
console.log( '이면서 : ' + ( 10>3 && 10>5 ) )	// T and T -> T		/ t and F -> F
console.log( '이거나 : ' + ( 10>3 || 3>5 ) )	// T or F -> T
console.log( '부정 : ' + !( 10>3 ) )			// T-> F	/	F -> T

/*	
	-문제1 : 국어, 영어, 수학 점수를 입력받아 각 변수에 저장하고 총점 출력, 평균 출력
	-문제2 : prompt 함수로 반지름 입력받아서 원넓이 [ 반지름*반지름*3.14 ] 출력
	-문제3 : prompt 함수로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
		-53.5	84.3	결과	: 64%
	-문제4 : prompt 함수로 정수를 입력받아 홀수[true] / 짝수[false] 여부 출력
	-문제5 : prompt 함수로 정수를 입력받아 7배수이면 true / 아니면 false 출력
	-문제6 : prompt 함수로 십만원 단위의 금액을 입력받아 지폐 개수 세기
		- 356789 		결과 : 십만원3장 만원5장 천원6장
	-문제7 : prompt 함수로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 이면 
			true 출력 아니면 false 출력
	-문제8 : prompt 함수로 두 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력
*/

/*1. 문제
let 국어 = Number(prompt('국어 점수를 입력해주세요') )	// '국어' 라는 이름으로 변수 선언하고 prompt 입력받은 문자 데이터를 저장 
let 영어 = Number(prompt('영어 점수를 입력해주세요') )
let 수학 = Number(prompt('수학 점수를 입력해주세요') )
console.log( '총점 : ' + (국어 + 영어 + 수학) )
console.log( '평균 : ' + (국어 + 영어 + 수학)/3 )
*/
/*//2. 문제
let 반지름 = Number(prompt('반지름을 입력해주세요'))	// 숫자형 입력받아서 변수에 저장
console.log( '원넓이 : ' + (반지름*반지름)*3.14)*/
/*//3. 문제
let 실수1 = Number(prompt('실수1'))
let 실수2 = Number(prompt('실수2'))
console.log( '실수2의 실수1 백분율 : '+ (실수1/실수2)*100 + '%' )	// 1:100% 0.1:10% 0.01:1%*/
/*//4. 문제
let 정수1 = Number(prompt('정수1'))
console.log( '문제4 홀/짝 판단 : ' + (정수1%2==1 ))
			// 홀수찾기 : 수%2 ==1 나머지가 1이면 홀수 0이면 짝수
			// 짝수찾기 : 수%2 ==0 나머지가 0이면 짝수 1이면 홀수*/
/*//5. 문제
let 정수2 = Number(prompt('정수2'))
console.log('문제5 7배수 찾기 : ' + (정수2%7==0))
			// 배수찾기 : 수/값 == 0 나머지가 0이면 수는 해당 값은 그 수의 배수*/
/*//6. 문제 [ 몫 : parseInt(40/3) ]
let 금액 = Number(prompt('금액 입력'))
console.log( '입력받은 금액 :' + 금액 )
console.log( '십만원권 : ' + parseInt(금액/100000) +'장' )
		// 356789 / 100000 -> 3.56789
		// parseInt( 3.56789 ) -> 3
// ! : 금액에서 십만원 제외
금액 = 금액 - parseInt(금액/100000) *100000
	// 356789 - 300000 -> 56789
		// 연산순서  
		//		1. (금액/100000)				3.56789
		//		2. parseInt( 금액/100000)	3
		//		3. * 100000					300000
		//		4. 금액 - 300000				56789
		//		5. 금액 = 56789				새로운값 변경
		
console.log( '만원권 : ' + parseInt(금액/10000) + '장' )
금액 = 금액 - parseInt(금액/10000) *10000
console.log( '천원 : ' + parseInt(금액/1000) + '장' )
*/
/*//7. 문제
let id = prompt('아이디를 입력하세요.')
let pw = prompt('비밀번호를 입력하세요.')
console.log( '로그인 여부 :'+ ( id=='admin' && pw==1234 )) */
/*//8.문제
let 정수3 = Number(prompt('정수'))
console.log( '홀수이면서 7의배수 : ' + (정수3%2==1 && 정수3%7==0))*/


// 4. 대입연산자
let data1 = 10	//1. = 대입	[선언과 동시에 대입 = 초기화]

data1 += 2		// vs data1 = data1 + 2
				// 1. 10+2 ---> 12
				// 2. data1 = 12
console.log( ' += 대입 후 : ' + data1)	// 10+2 -> 12
data1 -= 5
console.log( ' -= 대입 후 : ' + data1)	// 12-5 -> 7
data1 *= 2
console.log( ' *= 대입 후 : ' + data1)	// 7 * 2 -> 14
data1 /= 3
console.log( ' /= 대입 후 : ' + data1)
data1 %= 3
console.log( ' %= 대입 후 : ' + data1)

let html = '<h3> JS 작성된 코드 </h3>'		// html 마크업 저장할 변수 선언
html += '<div> 안녕하세요 </div>'			// 변수에 마크업 추가
document.write( html );					// 해당 변수 값를 html 출력

// 5. 증감연산자 [data++ , data+=1 , data = data+1]
let data2 = 10;
console.log( '변수의 값 : ' + data2 )		// 10
console.log( '변수++ : ' + (data2++) )	// 10 : 출력후 증가
console.log( '변수 값 : ' + data2 )		// 확인 : 11
console.log( '++변수 : ' + (++data2) )	// 12 : 출력전 증가

console.log( '변수-- : ' + (data2--) )	// 12 : 출력후 감소
console.log( '변수 값 : ' + data2 )		// 확인 : 11
console.log( '--변수 : ' + (--data2) )	// 10 : 출력전 감소

// 6. 삼항연산자 [조건 ? 참 : 거짓]
let age = 38;
let 나이대 = age <=19 ? '청소년' : '성인'	// 조건[38<=19]이 false 이까 '성인' 대입
console.log( ' 38의 나이대 : ' + 나이대 )

let 점수 = 78;
let 등급 = 	점수>=90 ? 'A등급' :			// 점수가 90점이상이면 a등급
			점수>=80 ? 'B등급' : 			// 아니면 점수가 80점이상이면 b등급
			점수>=70 ? 'C등급' : '탈락'	// 아니면 점수가 70점이상이면 c등급 그외 탈락
console.log( ' 78점수의 등급 : ' + 등급 )


/*
	문제9 : 정수를 입력받아서 '홀수'인지 '짝수' 출력
	문제10 : 정수 2개를 입력받아 더 큰수를 출력
	문제11 : 정수 3개를 입력받아 가장 큰수를 출력
	문제12 : 정수 3개를 입력받아 오름차순으로 출력	[ 7 5 9 -> 5 7 9 ]
	
*/

//문제9
let value1 = Number(prompt('정수 입력'))
console.log( value1+'의 홀/짝 판단 : ' + (value1%2==0 ? '짝수' : '홀수') )
//문제10
let value2 = Number(prompt('정수2'))
let value3 = Number(prompt('정수3'))
console.log( value2 + '과' + value3 + '중 더 큰수는 :' +
			( value2>value3 ? value2 : value2<value3 ? value3 : ' 두 수는 같다')
			)
// 첫번째값이 더 크면 첫번째 값출력 아니면 두번째값이 더크면 두번째값 출력 아니면 두 수는 같다
// 변수 + 문자 + 변수 + 문자 + (삼항연산자 중첩)

//문제11
let value4 = Number(prompt('정수4'))
let value5 = Number(prompt('정수5'))
let value6 = Number(prompt('정수6'))
let max = value4	// 가장 큰수 변수에 첫번째 값 대입 / max : 가장 큰수를 저장하는 변수
max = max < value5 ? value5 : max // 만약에 max보다 더크면 max에 대입
max = max < value6 ? value6 : max
console.log( ' 가장 큰 수는 : ' + max)



