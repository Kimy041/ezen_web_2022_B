<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="/header.jsp" %>
	
	<div class="container">
		<h3> 회원정보 </h3>
		<form class="updateForm">
			<div>
				<img width="20%" class="mimg" alt="" src="/jspweb/member/pimg/default.webp">
				<br>프로필변경 : <input type="file" name="newmimg">
				<br> <input class="defaultimg" type="checkbox"> 기본프로필 사용
			</div>
			<div>
				<div> 아이디 </div>
				<div class="mid"></div>
			</div>
			<div>
				<div> 현재 비밀번호 </div>
				<input class="mpw" name="mpw"> 
			</div>
			<div>
				<div> 새 비밀번호 </div>
				<input class="newmpw" name="newmpw"> 
			</div>
			<div>
				<div> 새 비밀번호 확인 </div>
				<input class="newmpwconfirm" name="newmpwconfirm">
			</div>
			<div>
				<div> 새 이메일 </div>
				<input class="memail" name="memail"> 
				<button type="button"> 인증 </button>
			</div>
			<button onclick="setUpdate()" type="button"> 회원수정 </button>
		</form>
	</div>
			
	
	
	<script src="/jspweb/js/member/update.js" type="text/javascript"></script>
</body>
</html>