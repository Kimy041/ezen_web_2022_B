console.log('열림')

// 페이징처리 객체 : 현재페이지 , 검색
let adminpageObject = {
	page : 1 ,
	listsize : 3 ,
	key : "" ,
	keyword : "" 
}

getMemberList(1);
function getMemberList( page ){
	console.log('해당 페이지 : '+ page );
	adminpageObject.page = page;
	console.log( adminpageObject );
	
	
	$.ajax({
		url : "/jspweb/member",	
		method : "get" ,
		data : adminpageObject,
		success : (r)=>{
			console.log('ajax통신')
			console.log( r ) // 응답 결과 데이터 확인
			// --------------------- 테이블 -----------------
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `
						<tr>
							<th width="10%" > 번호 </th>
							<th width="10%" > 프로필 </th>
							<th width="10%" > 아이디 </th>
							<th width="10%" > 이메일주소 </th>
							<th width="10%" > 비고 </th>
						</tr>`
			r.memberList.forEach( (o,i)=>{
				// 2. 테이블 내용물 추가 구성
					// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용
				html += `
						<tr>
							<td> ${ o.mno } </td>
							<td> <img src="/jspweb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }" width="100%">  </td>
							<td> ${ o.mid } </td>
							<td> ${ o.memail } </td>
							<td>  </td>
						</tr>`
			} )
			// 3. 구성된 html를 table 대입
			document.querySelector('.mListTable').innerHTML = html;
			// --------------------- 페이지 -------------------------
			html = '';
			// 이전페이지
			html += page <= 1 ?
				`<button onclick="getMemberList( ${page} )" type="button"> 이전 </button>`
				:
				`<button onclick="getMemberList( ${page-1} )" type="button"> 이전 </button>`
			// 페이지 번호 버튼
			for( let i = r.startbtn ; i<=r.endbtn; i++ ){
				html +=`<button onclick="getMemberList( ${i} )" type="button"> ${i} </button>`
			}
			// 다음페이지
			html += page >= r.totalpage ?
				`<button onclick="getMemberList( ${page} )" type="button"> 다음 </button>`
				:
				`<button onclick="getMemberList( ${page+1} )" type="button"> 다음 </button>`
		
			document.querySelector('.adminPagebox').innerHTML = html;
			// --------------------- 페이지 수 -------------------------
			document.querySelector('.searchcount').innerHTML = `총 페이지수 : ${r.totalsize}`
		}
	})
}

// 검색
function getonsearch(){
	console.log('getonsearch() 함수');
	// 입력받은 데이터 전역객체 대입
	adminpageObject.key = document.querySelector('.key').value;
	adminpageObject.keyword = document.querySelector('.keyword').value;
	// 리스트 호출
	getMemberList(1);
}
// 검색풀기 : 전체보기
function setsearch(){
	adminpageObject.key = '';
	adminpageObject.keyword = '';
	// 리스트 호출
	getMemberList(1);
	document.querySelector('.key').value = 'mno';
	document.querySelector('.keyword').value = adminpageObject.keyword;
}
// 화면에 표시할 페이지수 변경
function setlistsize(){
	let listsize = document.querySelector('.listsize').value;
	adminpageObject.listsize = listsize;
	// 리스트 호출
	getMemberList(1);
}