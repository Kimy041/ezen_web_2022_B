/*
	// 1. 버거객체
	let burger = {
		name : ,		// 버거 이름
		price : ,		// 버거 가격
		img : ,			// 버거 이미지
		category : 		// 버거 카테고리
	}
	
	// 2. 주문객체
	let order = {
		no :  ,
		items : ,		// 카트배열 ---> 새로운 배열
		time : ,		// new Date() : 현재 날짜/시간
		state :  ,		// true : 일단 주문	// false : 주문완료
		complete :  ,	// 아직 주문 완료 되기전
		price :  ,		// cartlist 배열내 버거객체들의 총금액 합계
}

*/
/*---------------- 공통데이터 : 모든 함수에서 공통으로 사용 할 예정 : 전역변수 [ js 열렸을때 선언 1번 ] ----------------------*/
// 등록된 카테고리 '문자열' 목록/배열
let categoryList = [ '프리미엄' , '스페셜' , '와퍼' , '올데이킹' , '치킨버거' ]
// 등록된 '버거객체' 목록/배열
let burgerList =[
	{ name : '몬스트X' , price : 9500 , img : '몬스터x.png' , category : '프리미엄' } ,
	{ name : '콰트로치즈X' , price : 8000 , img : '콰트로치즈X.png' , category : '프리미엄' } ,
	{ name : '통새우와퍼' , price : 13000 , img : '통새우와퍼.png' , category : '스페셜' }
]
// 카트 등록된 '버거객체' 목록/배열
let cartList = [] //카트 목록
// '주문객체' 목록/배열
let orderList = [] //주문 목록
/*------------------ 공통 - DB end -------------------------------------------------*/
/*-------------------js 열렸을때 1번 실행되는 함수들------------------------------------*/
category_print();		// 카테고리 출력하는 함수 호출
catagory_select( 0 ); // 카테고리 선택시 css 변경/카테고리별 제품출력 함수 호출 / 기본값 : 프리미엄
/*-------------------------------------------------------------------------------*/

// 1. 카테고리 출력하는 함수		//[ 1. JS 열렸을때 ]
function category_print(){
	// 1. HTML 구성
	let html = `<ul>`
	//*
	for( let i = 0 ; i < categoryList.length ; i++ ){
		html += `<li class="categoryli" onclick="catagory_select(${i})">${ categoryList[i] }</li>`
	} // for end
	html += `</ul>`
	// 2. 해당 마크업에 html 출력
	document.querySelector('.categorybox').innerHTML = html
}// f e

// 2. 카테고리 선택 함수
function catagory_select( i ){ // i : 선택된 li의 인덱스
	// 1. 모든 li 가져와서 배열 저장
	let categoryli = document.querySelectorAll('.categoryli')
	// 2. 모든 li 배열 반복문
	for( let j = 0 ; j < categoryli.length ; j++ ){
		if( j == i ){ // 만약에 li배열에서 내가 선택한 li의 인덱스와 같으면
			 categoryli[j].classList.add('catagoryselect') ; // 해당 마크업의 class 식별자 추가
		}else{ // 선택되지 않은 li
			categoryli[j].classList.remove('catagoryselect') ; // 해당 마크업의 class 식별자 제거
		}
	}
	// 3. 제품목록 렌더링 [ 화면 업데이트 ]
	product_print( i )// i : 선택된 li의 인덱스를 product_print 함수로 전달 [ 함수 호출 ]
}

// 3. 제품 출력 함수	// [ 1.js열렸을때[0:프리미엄] 2.카테고리 바뀌었을때 ]
function product_print( index ){ //catagory_select 함수로부터 받은 i -> index
	// 1. html 구성
	let html = '';
	// *
	for( let i = 0 ; i<burgerList.length ; i++){
		// i는 0번째 인덱스부터 마지막인덱스까지 버거 객체 가져온다.	
		if( burgerList[i].category == categoryList[index] ){
			// i번째 버거객체의 카테고리와 선택된 카테고리와 같으면
			html += `<div onclick="cartadd(${i})" class="product">
						<img src="img/${ burgerList[i].img }" width="100%">
						<div class="productinfo">
							<div class="ptitle"> ${ burgerList[i].name } </div>
							<div class="pprice"> ${ burgerList[i].price.toLocaleString() } 원 </div>
						</div>
					</div>`
		}
	}
	// 2. 구성된 html를 마크업 대입
	document.querySelector('.productbox').innerHTML = html
}
// 4. 선택한 제품을 카트에 담기
function cartadd(i){
	cartList.push( burgerList[i]) // 1. 선택한 i번째 버거의 객체를 cartlist에 추가
	cart_print(); // 카트내 제품 화면 렌더링[새로고침]
}// f e

// 5. 주문 취소 버튼
function cancel(){ // 모든 취소이므로 i번째 인덱스 필요없음
	alert('주문 취소합니다.'); cartList.splice(0); // 개수 생략시 모두 삭제
	cart_print(); // 카트내 제품 화면 렌더링[새로고침]
}
// 6. 주문 하기 버튼
function order(){
	alert('주문 합니다.');
	console.log( '-------주문하기 전 카트 ----')
	//1. 고유 한 주문번호 만들기 [// 마지막인덱스 : 배열명.length-1]
	let no = 0;
	if( orderList.length == 0 ){ no = 1; }	// 1. 만약에 길이가 0이면 [ 주문 하나도 없으면 주문번호 1 ]
	else{ no = orderList[ orderList.length-1 ].no+1 }	// 2. 아니면 마지막인덱스 주문객체의 주문번호+1 를 다음 주문번호 사용
	
	// 2. 카트배열[전역변수] -> 새로운배열 [ 주문객체에 카트배열 대입시 카드배열 초기화시 주문객체내 카트배열도 초기화 = 메모리 통일하기 때문에 ]
	//let for배열 = cartList.forEach( (o)=>{ console.log (o);  return o; } ) 
	//console.log( for배열 )
	//console.log("-----------------------------------------")
	let map배열 = cartList.map( (o)=>{ console.log (o); return o; } ) // map함수에서 return 객체를 하나씩 새로운배열 대입
	console.log( map배열 )
	// 3. 총가격 만들기
	let total =0;
	for(let i = 0 ; i<map배열.length ; i++ ){ total += map배열[i].price }
	// 1. 주문
		// 1. order 객체 만들기
		let order = {
			no : no ,			// 고유한 주문번호 [ 인덱스사용X ]
			items : map배열 ,	// 카트배열 ---> 새로운 배열
			time : new Date(),	// new Date() : 현재 날짜/시간
			state : true ,		// true : 일단 주문	// false : 주문완료
			complete : 0 ,		// 아직 주문 완료 되기전
			price : total ,		// cartlist 배열내 버거객체들의 총금액 합계
		}
		// 2. order 객체 배열에 저장
		orderList.push( order ); console.log( orderList );
	// 2. 주문완료 후
	cartList.splice(0) // 전역변수내 초기화 // 그전에 안에 들어있는 데이터를 다른곳으로 옮기자 --> 2번 주석
	cart_print()
	orderlist_print()
}
// 7. 카트내 버거 출력 [ 1.제품 클릭할때마다 , 2.취소/주문 ]
function cart_print(){
	// 2. 버거 개수 카운트
	document.querySelector('.pcount').innerHTML = cartList.length
	// 3. 버거 총 금액
	let total = 0;
	for( let j = 0 ; j<cartList.length ; j++ ){ total += cartList[j].price }
	document.querySelector('.ptotal').innerHTML = total.toLocaleString();
	// 4. 카트내 버거 출력	
	let html =''// 1. html 구성
	for( let j = 0 ; j<cartList.length ; j++ ){
		html += `<div class="item"> <!-- 제품 1개 -->
                   <div class="ititle">${ cartList[j].name }</div>
                   <div class="iprice">${ cartList[j].price.toLocaleString() }원</div>
                </div> `
	}
	document.querySelector('.cartbottom').innerHTML = html; // 2. 구성된 html 마크업에 대입
}

/*--------------------------포스기 구현--------------------------*/
burgerlist_print();
// 1. 버거 등록
let burgeraddBtn = document.querySelector('.burgeraddBtn')
burgeraddBtn.addEventListener( 'click' , ()=> {
	
	// 1. 입력받은 값 객체화
	let burger = {
		name : document.querySelector('.bname').value ,
		img : document.querySelector('.bimg').value ,
		price : parseInt(document.querySelector('.bprice').value) ,
		category : document.querySelector('.bcategory').value
	}
	//console.log(burger)
	
	// 2. 유효성검사
	let check = true;
		// 1. 카테고리 체크
	if( !categoryList.includes( burger.category ) ){
		alert('등록이 불가한 카테고리입니다.'); check = false;
		}
		// 2. 가격 숫자 체크
	if( isNaN(burger.price)){ alert('숫자형식으로 입력해주세요'); check =false; }
	
	// 3. 저장
	if( check ){ burgerList.push( burger ); alert('버거가 등록되었습니다.')}
	
	console.log( burgerList ); burgerlist_print();
})
// 2. 등록된 버거 현황 출력
function burgerlist_print(){
	let html = `<tr>
					<th>번호</th><th>이미지</th><th>버거 이름</th>
					<th>카테고리</th><th>가격</th><th>비고</th>
				</tr>`
	for( let i = 0 ; i < burgerList.length ; i++){
		html += `<tr>
					<td>${i+1}</td><td><img src="img/${ burgerList[i].img }" widtd="100%"></td><td>${burgerList[i].name}</td>
					<td>${burgerList[i].category}</td><td>${burgerList[i].price.toLocaleString()}원</td>
					<td>
						<button onclick="Dbtn(${i})" type="button">삭제</button>
						<button onclick="Rbtn(${i})" type="button">가격수정</button>
					</td>
				</tr>`
	}
	document.querySelector('.burgerlistTable').innerHTML = html		
}
// 2-1. 삭제 함수
function Dbtn( D ){
	burgerList.splice( D , 1 );
	burgerlist_print();
	catagory_select( 0 );
}
// 2-2. 수정 함수
function Rbtn( R ){
	let newprice = Number(prompt('수정할 금액을 입력해주세요')) 
	if( isNaN(newprice)){ alert('숫자형식으로 입력해주세요'); }
	else{ burgerList[R].price = newprice 
			alert('수정되었습니다.') }
	burgerlist_print();
	catagory_select( 0 );
}
// 3. 주문된 주문 목록 현황 출력
orderlist_print();
function orderlist_print(){
	let html = `<tr>
					<th>주문번호</th><th>버거 이름</th>
					<th>상태</th><th>요청/완료일</th><th>비고</th>
				</tr>`
	for(let i = 0 ; i < orderList.length ; i++ ){
		for( let j = 0 ; j< orderList[i].items.length ; j++){
			console.log( orderList[i].items[j] )
			html += `<tr>
						<td>${orderList[i].no}</td>
						<td>${orderList[i].items[j].name}</td>
						<td>${orderList[i].state = true ? '주문요청' : '주문완료' }</td>
						<td>${orderList[i].time.getFullYear() +'-'+(orderList[i].time.getMonth()+1)+'-'+orderList[i].time.getDate()	  }</td>
						<td>
							<button onclick="Ebtn(${i})" type="button">주문완료</button>
						</td>
					</tr>`
		}
	}
	document.querySelector('.orderlistTable').innerHTML = html
}
//3-1. 버튼 클릭시 주문요청->주문완료 변경
function Ebtn(i){
	alert('주문이 완료되었습니다.')
	orderList[i].state = false
	orderlist_print();
}










