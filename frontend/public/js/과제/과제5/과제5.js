
/* 공통 - DB */
// 등록된 카테고리 목록
let categoryList = [ '프리미엄' , '스페셜' , '와퍼' , '올데이킹' , '치킨버거' ]
// 등록된 버거 목록
let burgerList =[
	{ name : '몬스트X' , price : 9500 , img : '몬스터x.png' , category : '프리미엄' } ,
	{ name : '콰트로치즈X' , price : 8000 , img : '콰트로치즈X.png' , category : '프리미엄' } ,
	{ name : '통새우와퍼' , price : 13000 , img : '통새우와퍼.png' , category : '스페셜' }
]
let cartList = []	//카트 목록
let orderList = [] //주문 목록

category_print();
catagory_select( 0 ); // 기본값 : 프리미엄
product_print( 0 ); // 기본값 : 프리미엄

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
	product_print( i )
}

// 3. 제품 출력 함수	// [ 1.js열렸을때[0:프리미엄] 2.카테고리 바뀌었을때 ]
function product_print( index ){
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
function cancel(){
	alert('주문 취소합니다.'); cartList.splice(0); // 개수 생략시 모두 삭제
	cart_print(); // 카트내 제품 화면 렌더링[새로고침]
}
// 6. 주문 하기 버튼
function order(){
	alert('주문 합니다.');
	console.log( '-------주문하기 전 카트 ----')
	//1. 주문번호 만들기
	// 마지막인덱스 : 배열명.length-1
	let no = 0;
	if( orderList.length == 0 ){ no = 1; }	// 1. 만약에 길이가 0이면 [ 주문 하나도 없으면 주문번호 1 ]
	else{ no = orderList[ orderList.length-1 ].no+1 }	// 2. 아니면 마지막인덱스 주문객체의 주문번호+1 를 다음 주문번호 사용
	
	// 2. 카트배열 -> 새로운배열 [ 주문객체에 카트배열 대입시 카드배열 초기화시 주문객체내 카트배열도 초기화 = 메모리 통일하기 때문에 ]
	let for배열 = cartList.forEach( (o)=>{ console.log (o);  return o; } ) 
	console.log( for배열 )
	console.log("-----------------------------------------")
	let map배열 = cartList.map( (o)=>{ console.log (o); return o; } )
	console.log( map배열 )
	// 3. 총가격 만들기
	let total =0;
	for(let i = 0 ; i<map배열.length ; i++ ){ total += map배열[i].price }
	// 1. 주문
		// 1. order 객체 만들기
		let order = {
			no : no ,
			items : map배열 ,	// 카트배열 ---> 새로운 배열
			time : new Date(),	// new Date() : 현재 날짜/시간
			state : true ,		// true : 일단 주문	// false : 주문완료
			complete : 0 ,		// 아직 주문 완료 되기전
			price : total ,		// cartlist 배열내 버거객체들의 총금액 합계
		}
		// 2. order 객체 배열에 저장
		orderList.push( order ); console.log( orderList );
	// 2. 주문완료 후
	cartList.splice(0)
	cart_print()
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
