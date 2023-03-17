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
		<h3> 모든 회원 명단 </h3>
		<button onclick="setsearch()" type="button"> 전체보기[검색제거] </button>
		<div class="searchcount"></div>
		<select onchange="setlistsize()" class="listsize">
			<option> 3 </option>
			<option> 5 </option>
			<option> 10 </option>
		</select>
		<table class="mListTable table table-hover" border="1">
		</table>
		<!-- 페이징처리 -->
		<div class="adminPagebox ">
		</div>
		
		<!-- 검색창 -->
		<div>	
			<select class="key">	<!-- select 시 사용되는 조건의 필드명 -->
				<option value="mno"> 번호 </option>
				<option value="mid"> 회원 </option>
				<option value="memail"> 이메일 </option>
			</select>
			<input class="keyword" type="text"> <!-- select 시 사용되는 조건의 데이터 -->
			<button onclick="getonsearch()" type="button"> 검색 </button>
		</div>
	</div>
	

	
	
	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
</body>
</html>