<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<%
		// JSP 이용한 서블릿 대체
		
		// 1. 마지막번호+1 호출
		Dao dao = new Dao();
		int custno = dao.getcustno();
		// 2. 오늘날짜
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(date);
	%>
	
		<center>
			<h3>홈쇼핑 회원 등록</h3>
			<form name="joinForm" action="/hrd_exam1/join" method="post">
				<table border="1">
					<tr>
						<th> 회원번호(자동발생) </th> 
						<td> <input value="<%=custno %>" name="custno" type="text"> </td>
					</tr>
					<tr>
						<th> 회원성명 </th> 
						<td> <input name="custname" type="text"> </td>
					</tr>
					<tr>
						<th> 회원전화 </th> 
						<td> <input name="phone" type="text"> </td>
					</tr>
					<tr>
						<th> 회원주소 </th> 
						<td> <input name="address" type="text"> </td>
					</tr>
					<tr>
						<th> 가입일자 </th> 
						<td> <input value="<%=now %>" name="joindate" type="text"> </td>
					</tr>
					<tr>
						<th> 고객등급[A:VIP,B:일반,C:직원] </th> 
						<td> <input name="grade" type="text"> </td>
					</tr>
					<tr>
						<th> 도시코드 </th> <td> <input name="city" type="text"> </td>
					</tr>
					<tr> 
						<td colspan="2">
							 <center>
							 	 <button onclick="join()" type="button">등록</button> 
							 	 <a href="view.jsp"><button type="button">조회</button></a> 
							 </center>
						</td> 
					</tr>
				</table>
			</form>
		</center>
		<script src="join.js" type="text/javascript"></script>
	<%@include file="footer.jsp" %>
</body>
</html>