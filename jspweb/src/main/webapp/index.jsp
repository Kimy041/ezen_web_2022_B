<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> <!-- 가로/세로 사이즈 생략시 auto( 내용물크기만큼 ) -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %> <!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class="searchbox">
		검색창
	</div>
	
	
	<div class="contentbox">
		<!-- 지도 -->
		<div id="map" style="width:75%;height:80%;"></div>
		<!-- 사이드바 -->
		<div class="produclistbox" >
			
			
		</div>
	</div>
	
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=77b53e93c5d9cf2ebe80bd4233a66965&libraries=clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>