// 1. userbox/logbox/monbox Dom객체 가져오기
let userbox = document.querySelector('.userbox');
let logbox = document.querySelector('.logbox');
let monbox = document.querySelector('.monbox');
let logbox2 = document.querySelector('.logbox2');
let userHP = document.querySelector('.userHP');
let monHP = document.querySelector('.monHP');
let monster = [ 
	{ img : '주황버섯.gif' , hp : 100 , left : 910 , exp : 50 } , 
	{ img : '스펙터주황버섯.gif' , hp : 200 , left : 910 , exp : 150 } , 
	{ img : '변형된주황버섯.gif' , hp : 300 , left : 910 , exp : 300 }
]

// *userbox [기본/처음] 위치
let u_left = 10;
let m_left = 910;
let mH_width = monster[0].hp
let uH_width = 100;
// 몬스터
monbox.style.backgroundImage = `url(img/${monster[0].img})`

console.log(monster[0+1].hp)

// 2.  문서 안에서 키 입력 이벤트
document.addEventListener('keydown' , (e)=>{
	let key = e.keyCode;	// 입력된 키 코드를 변수에 저장
	if( key == 37 ){// 왼쪽키
		u_left -= 10	// 왼쪽 좌표 -10 차감
		u_left = u_left < 0 ? 0 : u_left ; // 만약에 차감된 왼쪽 좌표가 0보다 작으면 0 아니면 적용
	}else if( key == 39 ){	// 오른쪽키
		u_left += 10
		u_left = u_left > 910 ? 910 : u_left ;
		userbox.style.backgroundImage = `url(img/캐릭터2_이동.png)` // 이동 모션 
		userbox.style.backgroundSize = `110%`;
	}else if( key == 65 ){ // a키 -> 공격 
			userbox.style.backgroundImage = `url(img/캐릭터2_이동.png)` // 공격 모션
			// 공격
			let attack = monster[0].left - u_left 
			if( monster[0] && mH_width >= 0 && attack <= 50 && attack >= -10 ){	
				mH_width -= 20
				monHP.style.width = `${mH_width}px`}
			if( mH_width <= 0 ){
				monbox.style.backgroundImage = `url(img/${monster[1].img})`
				mH_width= monster[1].hp
				monHP.style.width = mH_width
			}
			attack = monster[1].left - u_left 
			if( monster[1] && mH_width >= 0 && attack <= 50 && attack >= -10 ){	
				mH_width -= 20
				monHP.style.width = `${mH_width}px`}
			if( mH_width <= 0 ){
				monbox.style.backgroundImage = `url(img/${monster[2].img})`
				mH_width= monster[2].hp
				monHP.style.width = mH_width
			}
			attack = monster[2].left - u_left 
			if( monster[2] && mH_width >= 0 && attack <= 50 && attack >= -10 ){	
				mH_width -= 20
				monHP.style.width = `${mH_width}px`
			}
		
	}
	
	userbox.style.left = `${ u_left }px`	// * 키 입력후 css : left 변경
	// * 현재 좌표를 로그에 출력 
	logbox.innerHTML = `<div> 캐릭터 좌표 : ${ u_left } </div>`
	
	
})
// 2. 문서 안에서 키 떼였을때 이벤트 keyup
document.addEventListener( 'keyup' , (e)=>{ 
	userbox.style.backgroundImage = `url(img/캐릭터1.png)`
	userbox.style.backgroundSize = `90%`;
})
// 3. 몬스터 이동 난수[랜덤 -> 1초]
	// 특정 시간마다 함수 실행해주는 함수 : setInterval ( ()=>{} , 밀리초(1000/1초) )
let S =setInterval( mon_moving , 1000 );
function mon_moving(){
	for(let i = 0 ; i<monster.length ; i++){
		// 1. 난수 +-10
		let rand = parseInt( Math.random()*100+1 ); // 1~100 // 이동거리
		let rand2 = parseInt( Math.random()*2 ); // 0 또는 1 // 이동방향
		if( rand2 == 1 ) monster[i].left += rand // 
		else monster[i].left -= rand
		// 2. 게임 화면 고정
		if( monster[i].left < 0 )monster[i].left = 0;
		if( monster[i].left > 910 )monster[i].left = 910;
		// 공격
		let attack = monster[i].left - u_left 
		if( attack <= 20 && attack >= -10 )
		{uH_width -= 10
		userHP.style.width = `${uH_width}px`}
		if( uH_width <= 0){ alert('game over');
		 uH_width = 100
		} 
		// 3. 몬스터 이동
		monbox.style.left = `${ monster[i].left }px`
		// * 현재 좌표를 로그에 출력
		logbox2.innerHTML = `<div> 몬스터 좌표 : ${ monster[i].left } </div>`
	
	} 
	
}




/*
	함수 형태
		1. 일반함수 : function 함수명(){}
		2. 익명함수 : function(){}
		3. 람다식함수 : () => {}
		4. 변수함수 : let 변수명 = () => {}
	Math.random()
		Math.random() : 0~1 사이의 실수
		Math.random()*10 : 0~10 사이의 실수
*/











	
	
	
	
	
	
	
	