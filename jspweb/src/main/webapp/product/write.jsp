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
	
		<form class="writeForm">		
			제품명 : <input type="text" name="pname">				<br>
			제품설명 :	<input type="text" name="pcomment">			<br>
			제품가격 : <input type="text" name="pprice">			<br>
			위치 : 
			<div id="map" style="width:100%;height:350px;"></div>
			<button onclick="onwrite()" type="button">제품등록</button>
		</form>
	
	
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=77b53e93c5d9cf2ebe80bd4233a66965"></script> 
	<script src="/jspweb/js/product/write.js" type="text/javascript"></script>
</body>
</html>