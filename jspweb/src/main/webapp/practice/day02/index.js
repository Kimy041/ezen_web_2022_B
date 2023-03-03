
// 1. JS 열렸을때
// document.querySelector('.data1').value

// 2. 특정 행동[이벤트] 있을때 코드집합소[함수] 실행
function ex1(){ // 함수 정의
	
	// 변수 10개 ---------> 객체 { 필드명 : 값 , 필드명 : 값 , 필드명 : 값 } 1개
	let info = {
		data1 : document.querySelector('.data1').value ,
		data2 : document.querySelector('.data2').value ,
		data3 : document.querySelector('.data3').value ,
		data4 : document.querySelector('.data4').value ,
		data5 : document.querySelector('.data5').value ,
		data6 : document.querySelector('.data6').value ,
		data7 : document.querySelector('input[name="data7"]:checked').value ,	// radio 에서 선택된 버튼의  value
		data8 : document.querySelector('.data8').checked ,					// 체크여부 [ true / false ]
		data9 : document.querySelector('.data9').value ,
		data10 : document.querySelector('.data10').value 
	}
	
	console.log( info ); // data8 외 모두 문자열 임.... [ 추후 형 변환 ]
	
	// 비동기 통신
	$.ajax({			// *. jquery 라이브러리 필
		url : "/jspweb/Ex2" ,		// 1. 서블릿 주소 [ /프로젝트명/서블릿주서(@WedServlet("/서블릿주소")) ]
		method : "post" ,			// 2. 메소드 방식 [ doGet vs doPost ]
		data : info ,				// 3. 보낼 데이터 [ 객체 vs { } ]
		success : function(result){
			console.log( result );
			if( result == 'true'){
				alert('등록성공');
				getData();
			}else{
				alert('등록실패');
			}
		} // 4. 받을 데이터
	});
	
}
getData();
function getData(){
	$.ajax({
		url : "/jspweb/Ex2" ,
		method : "get" ,
		success : function( result ){
			// console.log( result );
			// document.querySelector('.ex1_box').innerHTML = result;
			let html = `<table border="1">
							<tr>
								<th> data1 </th><th> data2 </th><th> data3 </th><th> data4 </th><th> data5 </th>
								<th> data6 </th><th> data7 </th><th> data8 </th><th> data9 </th><th> data10 </th>
							</tr>	
						`
			result.forEach( (o,i)=>{ // 객체명,forEach( (반복변수 , 반복인덱스) => { 실행문 } )
			
				html += `
							<tr>
								<th> ${ o.data1 } </th><th> ${ o.data2 } </th><th> ${ o.data3 } </th><th> ${ o.data4 } </th><th> ${ o.data5 } </th>
								<th> ${ o.data6 } </th><th> ${ o.data7 } </th><th> ${ o.data8 } </th><th> ${ o.data9 } </th><th> ${ o.data10 } </th>
							</tr>
						`
			})
			html += `</table>`
			document.querySelector(".ex1_box").innerHTML = html;
			
		}
	});
}

function singup(){
	
	let student_list = {
		이름 : document.querySelector('.이름').value ,
		전화번호 : document.querySelector('.전화번호').value ,
		키 : document.querySelector('.키').value ,
		나이 : document.querySelector('.나이').value ,
		등록일 : document.querySelector('.등록일').value ,
		성별 : document.querySelector('input[name="성별"]:checked').value ,
		개인정보동의 : document.querySelector('.개인정보동의').checked ,
		사는지역 : document.querySelector('.사는지역').value ,
		자기소개 : document.querySelector('.자기소개').value 
	}
	console.log( student_list );
	
	$.ajax({			
		url : "/jspweb/Q2" ,		
		method : "post" ,			
		data : student_list ,			
		success : function(result){
			console.log( result );
			if( result == 'true'){
				alert('등록성공');
				student();
			}else{
				alert('등록실패');
			}
		}
	});

}
student();
function student(){
	$.ajax({
		url : "/jspweb/Q2" ,
		method : "get" ,
		success : function( result ){
			let html = `<table border="1">
							<tr>
								<th> 이름 </th> <th> 전화번호 </th> <th> 키 </th> <th> 나이 </th> <th> 등록일 </th> <th> 성별 </th>
								<th> 개인정보동의 </th> <th> 사는 지역 </th> <th> 자기소개 </th>
							</tr>
						`
			result.forEach( ( o , i ) => {
				html += `
							<tr>
								<td> ${ o.이름 } </td> <td> ${ o.전화번호 } </td> <td> ${ o.키 } </td> <td> ${ o.나이 } </td> <td> ${ o.등록일 } </td> <td> ${ o.성별 } </td>
								<td> ${ o.개인정보동의 } </td> <td> ${ o.지역 } </td> <td> ${ o.자기소개 } </td>
							</tr>
						`
			})
			html += `</table>`
			document.querySelector('.student_box').innerHTML = html;
		}
	});
}