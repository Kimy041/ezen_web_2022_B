/*
과제1 : 입력상자에 학번[8자리] 입력후 로그인 버튼 클릭시
     배열에 존재하면  로그인성공 출력 / 로그인 실패 

   [조건1]
   const studentArray = [ '20230110' , '20230109' , '20230108' ]
   [조건2]
   입력 <input> 사용 해서 학번 입력받기 
   [조건3]
   로그인 <button> 사용해서 로그인 이벤트 실행

-------------------------------------------------------------------

과제2 : 입력상자에 학번[8자리] 등록 입력후에 
   배열에 저장했으면  성공 출력 , 아니면 실패 출력 

   [조건1]
      studentArray 배열에 push 등록한다.
   [조건2]
      만약에 배열에 존재하는 학번이면 '실패'
   [조건3]
   등록 <button> 사용해서 등록 이벤트 실행 
   
------------------------------------------------------------------------
추가 
   1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~       [ ' ' ]
   2. 등록이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화   [ value ]
   3. 입력상자[input]에 입력한 데이터가 8자리가 아니면 8자리로 입력해주세요.   [ length  ]
------------------------------------------------------------------------
*/
/*
	*오류메시지 : ~~ is not drfined
	1.정의X  2.이름오타 3.저장/새로고침 적용X
*/
/*
	*카멜 표기법 :
		studentarray 	-> studentArray
		loginup			-> Loginup
*/
/*
	4. 배열선언
		1. 함수안에서 선언(함수실행마다 선언 - 누적 저장X)
		2. 함수밖에서 선언(JS실행마다 선언 - 누적 저장O)
*/
// 4. 배열 선언과 동시에 3개의 요소 저장
let studentArray = [ '20230110' , '20230109' , '20230108' ]
//-----------------------------1.과제 1함수------------------------------
// 3. HTML : onclick="loginup()"에 대한 함수 정의[만들기]
// 과제1.
function onLogin(){ //함수[Loginup] 시작 점
	// 5. <input> 마크업을 js변수로 가져오기[DOM객체]
	let sno = document.querySelector('.sno')
	// 5. <input> 마크업에 입력된 데이터 호출
	let snoValue = sno.value;
		// *확인
		console.log('5번체크 : ' + snoValue )
	// 6. 찾기 [ 만약에 배열내 입력한 값이 존재하면 인덱스 / 존재하지않으면 -1 ]
	let sIndex = studentArray.indexOf( snoValue );
		// *확인
		console.log('6번체크 : ' + sIndex )
	//7. 논리
	if( sIndex == -1 ){ 
		//alert('로그인실패')
		document.querySelector('.resultBox').innerHTML = '로그인실패!'
	}
	else{
		//alert('로그인성공');
		document.querySelector('.resultBox').innerHTML = '로그인성공!'
	}
	
}//함수[Loginup] 끝점



// 과제2.
function save(){
	let sno2 = document.querySelector('.sno2')
	let snoValue2 = sno2.value
	let sIndex2 = studentArray.indexOf( snoValue2 );	
	
	if(sIndex2 !== -1 ){
		document.querySelector('.resultBox2').innerHTML = '이미 등록된 학번입니다.'}
	else if(sIndex2 == -1 && snoValue2.length == 8){
		studentArray.push(snoValue2); 
		sno2.value = '';
		document.querySelector('.resultBox2').innerHTML = '등록되었습니다.'}
	else if(snoValue2.length != 8 && snoValue2 != '' ){
		document.querySelector('.resultBox2').innerHTML = '8자리로 입력해주세요'}
	else if(snoValue2.length != 8 && snoValue2 == '' ){
		document.querySelector('.resultBox2').innerHTML = '학번을 입력해주세요~'}
	
	console.log(studentArray)	
}


/*	
function onAdd(){ // 1. 함수 시작 

		console.log('1.함수 실행') // 1. 확인
	
	// 2. <input> 마크업 가져와서 변수에 저장 [ Dom 객체 ]
	let sno2 = document.querySelector('.sno2')
	
		console.log( sno2 ) //2. 확인
	
	// 2.2 <input> 마크업 에 입력된 value[값] 가져와서 변수에 저장 
	let sno2Value = sno2.value
	
		console.log('2. 입력값 : ' + sno2Value ) //2. 확인
	
	// ! 검사 변수 [ 유효성검사 체크리스트 ]
	let confirm = 0;
	// ! 추가코드 1. 만약에 입력된 값이 공백이면 
	if( sno2Value == '' ){ console.log('공백이네요.~'); confirm++; }
	// ! 추가코드 2. 만약에 입력된 값이 8자리 아니면 
		console.log('2. 입력값 길이 : ' + sno2Value.length );
	if( sno2Value.length !=8 ){ console.log('8자리 아니네요~'); confirm++; }
	// 3. 유효성검사[ 중복체크 ]
		// 입력받은 값[sno2Value]이 있고 기존에 있는 값들[studentArray] 과 비교
		// 경우의수 2가지 [ 중복이 있다 or 없다 ] 
	// 지역변수 : 해당 지역{ } 에서 선언되면 { } 안으로 이동가능 / { } 밖으로 이동 불가능 
	// if{} 와 else {} 에서 같이 사용할 변수 이기에 if 밖에 선언 
	let resultBox2 = document.querySelector('.resultBox2') 
	
	if( confirm == 0 ){ // 만약에 confirm 0 일때만 아래 코드  실행
		if( studentArray.indexOf(sno2Value) == -1 ){ // 중복 없다 
				console.log('학번 등록했습니다.')
			studentArray.push( sno2Value )
				console.log( resultBox2 )
			resultBox2.innerHTML = '학번 등록했습니다.'
			// !추가코드 3. 만약에 등록을 성공했으면 <input> value 초기화
			sno2.value = ''
		} // if end 
		else{ // 중복 있다.
			console.log('이미 등록된 학번 입니다.') 
			resultBox2.innerHTML = '이미 존재하는 학번입니다..' // resultBox2 is not defined
		}// else end 
	}
} // 함수 끝

*/




