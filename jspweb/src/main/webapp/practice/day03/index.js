alert('JS열림')
// 1.
function doPOST(){
	alert('http POST 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "post" ,
		success : ( result ) => { }
	});
}
// 2.
function doGET(){
	alert('http GET 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "get" ,
		success : ( result ) => { }
	});
}
// 3.
function doPUT(){
	alert('http PUT 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "put" ,
		success : ( result ) => { }
	});
}
// 4.
function doDELETE(){
	alert('http DELETE 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "delete" ,
		success : ( result ) => { }
	});
}
/*--------------------------------------------------------*/
// 1. 등록
function onwrite(){
	console.log('함수 s')
	let info = {
		content : document.querySelector('.content').value ,
		writer : document.querySelector('.writer').value
	}
	console.log( info )
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "post" ,
		data : info ,
		success : ( r ) => {
			console.log('post 응답성공')
			if( r == 'true' ){ 
				alert('등록성공'); 
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value ='';
				onlist();
			}
			else{ alert('등록실패'); }
		 }
	});
}

// 2. 모든 게시물출력 [ 1.js열릴때 [랜더링] 2.글작성할때마다 3.삭제할때마다 4.수정할때마다]
onlist();
function onlist(){
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "get" ,
		success : (r)=>{
			console.log( 'get 응답성공' );
			console.log( r );
			// 1. 테이블 제목
			let html = `
						<tr>
							<th> 번호 </th>
							<th> 내용 </th> 
							<th> 작성자 </th> 
							<th> 비고 </th>
						</tr>`
			// 2. 테이블 내용
			r.forEach( (o,i) => {
					html += `
							<tr>
								<td> ${ o.bno } </td> 
								<td> ${ o.bcontent } </td> 
								<td> ${ o.bwriter } </td> 
								<td> 
									<button onclick="onupdate(${o.bno})" type="button" > 수정 </button>
									<button onclick="ondelete(${o.bno})" type="button" > 삭제 </button>
								</td>
							</tr>`
			});
			// 3. 구성된 html 대입
			document.querySelector('.boardtable').innerHTML = html;
			
		}
	});
}
// 3. 특정 게시물 삭제
function ondelete( bno ){
	console.log('ondelete() 열림'+ bno)
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "delete" ,
		data : { "bno" : bno } ,
		success : ( r ) => {
			console.log('delete 응답성공');
			console.log( r );
			if( r == 'true' ){ 
				alert('삭제성공');
				onlist();
			}
			else{ alert('삭제실패'); }
			
		 }
	});
}
// 4. 특정 게시물 수정
function onupdate( bno ){
	console.log('onupdate() 열림'+ bno );
	let newContent = prompt('수정할 내용 입력');
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "put" ,
		data : { "bno" : bno , "newContent" : newContent } ,
		success : ( r ) => {
			console.log('put 응답성공');
			console.log( r );
			if( r == 'true' ){ 
				alert('수정성공');
				onlist();
			}
			else{ alert('수정실패'); }
			
		 }
	});
}
/*-------------------------------------------------------------------------------*/
// 1. 등록
function onsignup(){
	let info = {
		pname : document.querySelector('.pname').value ,
		pprice : document.querySelector('.pprice').value
	}
	console.log( info )
	
	$.ajax({
		url : "/jspweb/Q3/Product" ,
		method : "post" ,
		data : info ,
		success : (r) => {
			console.log('post 응답성공')
			if( r == 'true' ){
				alert('제품 등록 성공');
				document.querySelector('.pname').value = '' ;
				document.querySelector('.pprice').value = '';
				plist();
			}else{ alert('제품 등록 실패'); }
		}
	});
}
// 2. 테이블
plist();
function plist(){
	$.ajax({
		url : "/jspweb/Q3/Product" ,
		method : "get" ,
		success : (r) => {
			console.log('get 응답성공')
			console.log( r )
			
			let html = `
						<tr>
							<th> 번호 </th> <th> 제품명 </th> <th> 제품가격 </th> <th> 수정/ 삭제 </th>
						</tr>`
						
			r.forEach( (o) => {
				html += `
						<tr>
							<td> ${o.pno} </td> <td> ${o.pname} </td> <td> ${o.pprice} </td>
							<td>
								<button onclick="pupdate(${o.pno})" type="button"> 수정 </button>
								<button onclick="pdelete(${o.pno})" type="button"> 삭제 </button>
							</td>
						</tr>
						`
			})
			document.querySelector('.producttable').innerHTML = html	
		}
	});
}
// 3. 삭제
function pdelete( pno ){
	
	$.ajax({
		url : "/jspweb/Q3/Product" ,
		method : "delete" ,
		data : { "pno" : pno } ,
		success : (r) => {
			console.log('delete 응답성공')
			if( r == 'true' ){
				alert('제품 삭제 성공');
				plist();
			}else{ alert('제품 삭제 실패'); }
		}
	});
}
// 4. 수정
function pupdate( pno ){
	let newpname = prompt('새로운 제품명 : ')
	let newpprice = prompt('새로운 제품가격 : ')
	
	$.ajax({
		url : "/jspweb/Q3/Product" ,
		method : "put" ,
		data : { "pno" : pno , "newpname" : newpname , "newpprice" : newpprice } ,
		success : (r) => {
			console.log('put 응답성공')
			if( r == 'true' ){
				alert('제품 수정 성공');
				plist();
			}else{ alert('제품 수정 실패'); }
		}
	});
}
