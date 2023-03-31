<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/header.jsp" %>

	<div class="container">
		
		<h3> 포인트 결제</h3>
		<button onclick="setPay(10000)" type="button"> 10000 원 </button>
		<button onclick="setPay(50000)" type="button"> 50000 원 </button>
		<br>
		<button onclick="requestPay()" type="button">카드결제</button>
		
		<h3> 본인인증 </h3>
	</div>
	
	<!-- 포트원 결제 JS -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	
	<script src="/jspweb/js/member/point.js" type="text/javascript"></script>
</body>
</html>