<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 반응형 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 부트스트랩 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 모든페이지 공통 css -->
	<link href="/jspweb/practice/과제1/css/index.css" rel="stylesheet" >
</head>
<body>

	<div class="wrap">	<!-- 전체 -->
		<div class="container"> <!-- 사원등록 입력구현 -->
			<form class="signupForm">
				<h3> 사원 등록 </h3>
				<div class="emimgbox">	<!-- 사원사진 -->
					<img class="emimg" alt="" src="/jspweb/member/pimg/default.webp">		</br> 
					<input class="changeemimg" name="changeemimg" onchange="emimg(this)" type="file">	
				</div>
				사원명 : 	<input onkeyup="namecheck()" class="emname" name="emname" type="text"> </br>
				<div class="checkconfirm" ></div>
				직급 	: 	<select class="emrank" name="emrank">
							<option> 부장 </option>
							<option> 차장 </option>
							<option> 과장 </option>
							<option> 대리 </option>
							<option> 사원 </option>
							<option> 인턴 </option>
						</select>	</br>
				고용형태 : <select class="emtype" name="emtype">
							<option> 임원 </option>
							<option> 정규직 </option>
							<option> 일용직 </option> 
						</select>	</br>
				부서 : 	<select class="emdepartno" name="emdepartno">
							<option> 인사팀 </option>
							<option> 영업팀 </option>
							<option> 개발팀 </option> 
						</select>	</br>
				입사일 : <input onkeyup="indatecheck()" class="emindate" name="emindate" type="date">	</br>
				퇴사일 : <input class="emoutdate" name="emoutdate" type="date">	</br>
				퇴사 사유 : <input class="emoutreason" name="emoutreason" type="text">	</br>
				
				<button class="signupbtn" onclick="signup()" type="button">사원 등록</button>
			</form>
		</div>
		
		
		<div class="container"> <!-- 인사 출력 구현 -->
			<button onclick="employeeList()" type="button"> 전체출력 </button>
			<button onclick="employeeinList()" type="button"> 근무자 </button>
			<button onclick="employeeoutList()" type="button"> 퇴사자 </button>
			<table class="emtable" border="2">
			</table>
		</div>
	</div>
	

	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- 모든페이지 공통 js -->
	<script src="/jspweb/practice/과제1/js/index.js" type="text/javascript"></script>
</body>
</html>