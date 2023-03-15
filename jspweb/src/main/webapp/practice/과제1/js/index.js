console.log('js열림')

/* 사원 이미지 미리보기 */
function emimg( object ){
	let file = new FileReader();
	file.readAsDataURL( object.files[0] )
	file.onload = (e)=>{
		document.querySelector('.emimg').src = e.target.result;
	}
}

let checkconfirm = document.querySelectorAll('.checkconfirm');
// 이름 유효성검사
function namecheck(){
	
	let emname = document.querySelector('.emname').value;
	let emnamej = /^[a-zA-Z가-힣]{1,10}$/
	
	if( emnamej.test(emname)){
		checkconfirm[0].innerHTML = 'O';	
	}else{
		checkconfirm[0].innerHTML = '영소문자+한글 조합 1~10사이로 입력해주세요.';	
	}
}

// 사원 등록
function signup(){
	console.log('signup() 함수')
	
	// 입사일 필수 입력
	let emindate = document.querySelector('.emindate').value;
	if( emindate == "" ){
		alert('[필수] 입사일을 입력해주세요.')
		return;
	}
	
	// [ 첨부파일 ]
	let signupForm = document.querySelectorAll('.signupForm')[0];
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData );
	
	// ajax
	$.ajax({
		url : "/jspweb/employee",
		method : "post" ,
		data : signupFormData ,
		contentType : false ,
		processData : false ,
		success : (r)=>{
			console.log('통신')
			if( r == 'true' ){
				alert('사원이 등록되었습니다.')
				location.href = "/jspweb/practice/과제1/index.jsp";
			}else{
				alert('사원등록에 실패하였습니다.')
			}
		}
	})
}
// 사원 출력
employeeList();
function employeeList(){
	$.ajax({
		url : "/jspweb/employee" ,
		method : "get" ,
		success : (r) =>{
			console.log('통신')
			
			// 테이블
			let html = `
						<tr>
							<th> 사원번호 	</th>
							<th> 사원사진	</th>
							<th> 사원명	</th>
							<th> 직급		</th>
							<th> 고용형태	</th>
							<th> 부서		</th>
							<th> 입사일	</th>
							<th> 퇴사일	</th>
							<th> 퇴사사유	</th>
							<th> 비고		</th>
						</tr>
						`
			r.forEach( (o)=>{
				console.log( o )
				let departname = '';
				if( o.emdepartno == 1 ){ departname = '인사팀' }
				if( o.emdepartno == 2 ){ departname = '영업팀' }
				if( o.emdepartno == 3 ){ departname = '개발팀' }
				html += `
						<tr>
							<td> ${ o.emno } </td>
							<td> <img src="/jspweb/member/pimg/${ o.emimg == null ? 'default.webp' : o.emimg }" width="50%"> </td>
							<td> ${ o.emname }	</td>
							<td> ${ o.emrank }		</td>
							<td> ${ departname }	</td>
							<td> ${ o.emtype }		</td>
							<td> ${ o.emindate }	</td>
							<td> ${ o.emoutdate }	</td>
							<td> ${ o.emoutreason }	</td>
							<td>
								<button type="button" > 수정 </button>
								<button type="button" > 삭제 </button>
							</td>
						</tr>
				`
			});
			
			document.querySelector('.emtable').innerHTML = html;
		}
	})
}

function employeeinList(){
	$.ajax({
		url : "/jspweb/employee" ,
		method : "get" ,
		success : (r) =>{
			console.log('통신')
			
			// 테이블
			let html = `
						<tr>
							<th> 사원번호 	</th>
							<th> 사원사진	</th>
							<th> 사원명	</th>
							<th> 직급		</th>
							<th> 고용형태	</th>
							<th> 부서		</th>
							<th> 입사일	</th>
							<th> 비고		</th>
						</tr>
						`
			r.forEach( (o)=>{
				console.log( o )
				let departname = '';
				if( o.emdepartno == 1 ){ departname = '인사팀' }
				if( o.emdepartno == 2 ){ departname = '영업팀' }
				if( o.emdepartno == 3 ){ departname = '개발팀' }
				if( o.emoutdate == null ){
					html += `
						<tr>
							<td> ${ o.emno } </td>
							<td> <img src="/jspweb/member/pimg/${ o.emimg == null ? 'default.webp' : o.emimg }" width="50%"> </td>
							<td> ${ o.emname }	</td>
							<td> ${ o.emrank }		</td>
							<td> ${ departname }	</td>
							<td> ${ o.emtype }		</td>
							<td> ${ o.emindate }	</td>
							<td>
								<button type="button" > 수정 </button>
								<button type="button" > 삭제 </button>
							</td>
						</tr>
					`
				}
			});
			document.querySelector('.emtable').innerHTML = html;
		}
	})
}
function employeeoutList(){
	$.ajax({
		url : "/jspweb/employee" ,
		method : "get" ,
		success : (r) =>{
			console.log('통신')
			
			// 테이블
			let html = `
						<tr>
							<th> 사원번호 	</th>
							<th> 사원사진	</th>
							<th> 사원명	</th>
							<th> 직급		</th>
							<th> 고용형태	</th>
							<th> 부서		</th>
							<th> 입사일	</th>
							<th> 퇴사일	</th>
							<th> 퇴사사유	</th>
							<th> 비고		</th>
						</tr>
						`
			r.forEach( (o)=>{
				console.log( o )
				let departname = '';
				if( o.emdepartno == 1 ){ departname = '인사팀' }
				if( o.emdepartno == 2 ){ departname = '영업팀' }
				if( o.emdepartno == 3 ){ departname = '개발팀' }
				if( o.emoutdate != null ){
					html += `
						<tr>
							<td> ${ o.emno } </td>
							<td> <img src="/jspweb/member/pimg/${ o.emimg == null ? 'default.webp' : o.emimg }" width="50%"> </td>
nf							<td> ${ o.emname }	</td>
							<td> ${ o.emrank }		</td>
							<td> ${ departname }	</td>
							<td> ${ o.emtype }		</td>
							<td> ${ o.emindate }	</td>
							<td> ${ o.emoutdate }	</td>
							<td> ${ o.emoutreason }	</td>
							<td>
								<button type="button" > 수정 </button>
								<button type="button" > 삭제 </button>
							</td>
						</tr>
					`
				}
			});
			document.querySelector('.emtable').innerHTML = html;
		}
	})
}