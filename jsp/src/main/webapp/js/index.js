let productList = [
	{ img: 'p1.gif' , title : '물랑루즈!' , size : '블루스퀘어 신한카드홀' , price : 180000 , discount : 0.23 , like : 7081 , review : 999 } ,
	{ img: 'p2.gif' , title : '윤하(YOUNHA)' , size : '공식 팬클럽' , price : 30000 , discount : 0.2 , like : 396 , review : 52 } ,
	{ img: 'p3.gif' , title : '행오버' , size : '정극장' , price : 40000 , discount : 0.3 , like : 46 , review : 15 } ,
	{ img: 'p4.gif' , title : '유니버설발레단 〈코리아 이모션〉' , size : '국립극장 해오름극장' , price : 100000 , discount : 0.5 , like : 80 , review : 0 } ,
	{ img: 'p5.gif' , title : '모네 인사이드' , size : '그라운드시소 명동' , price : 15000 , discount : 0.1 , like : 2942 , review : 231 } ,
	{ img: 'p6.gif' , title : '원마운트 스노우파크' , size : '원마운트 스노우파크' , price : 50000 , discount : 0.36 , like : 49 , review : 0 } 
]

product_print()
// 1. 제품 출력 // 1. js 열릴때
function product_print(){
	let html = ``
	productList.forEach( ( o , i ) => {
		html += `
			<div class="item"> <!-- 제품 1개 -->
				<img src="img/${ o.img }"> <!-- 제품이미지 -->
				<div class="item_info"> <!-- 재품정보 구역 -->
					<div class="item_title"> ${ o.title } </div> <!-- 제품명 -->
					<div class="item_size"> ${ o.size } </div> <!-- 제품사이즈 -->
					<div class="item_price"> ${ o.price.toLocaleString() } </div> <!-- 원가 -->
					<div>
						<span class="item_sale"> ${ ( o.price - parseInt( o.price*o.discount) ).toLocaleString() } </span> <!-- 판매가 -->
						<span class="item_discount"> ${ parseInt(o.discount*100) }% </span> <!-- 할인율 -->
					</div>
				</div>
				<div class="item_bottom"> <!-- 제품정보 하단 구역 -->
					<div>
						<span class="badge rounded-pill text-bg-warning">ISSUE</span>
						<span class="badge rounded-pill text-bg-danger">HOT</span>
					</div>
					<div class="item_review"> 찜 ${ o.like } · 리뷰수 ${ o.review } </div>
				</div>
			</div>
	`
	})
	
	
	document.querySelector('.itembox').innerHTML = html;
}