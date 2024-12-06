<%@page import="com.app.jdbc.place.vo.PlaceVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>place</title>
<style>
	table {
		width: 700px;
		margin: 0 auto;
		text-align: center;
		border-collapse: collapse;
		border: 1px solid pink;
	}
	
	td, th {
		border: 1px solid pink;
	}
</style>
</head>
<body>
<% List<PlaceVO> places = (List<PlaceVO>)request.getAttribute("places"); %>
	<button id="go-write">등록하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>상세주소</th>
			<th>장소가격</th>
		</tr>
		<%for(PlaceVO placeVO: places) {%>
		<tr>
			<td><%=placeVO.getId()%></td>		
			<td><a href=""><%=placeVO.getPlaceDistrict()%></a></td>		
			<td><%=placeVO.getPlacePrice() %></td>		
		</tr>
		<%} %>
	</table>
</body>
</html>