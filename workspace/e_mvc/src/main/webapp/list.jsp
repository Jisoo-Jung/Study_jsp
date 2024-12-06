<%@page import="com.app.mvc.domain.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	table {
		border-collapse: collapse;
		border: 1px solid black;
		width: 700px;
		margin: 0 auto;
	}
	
	th, td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<% List<ProductVO> products = (List<ProductVO>)request.getAttribute("products"); %>
	<table>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>생성 날짜</th>
			<th>수정 날짜</th>
		</tr>
		<%for(ProductVO product: products) {%>
			<tr>
				<td><%=product.getId() %></td>
				<td><%=product.getProductName() %></td>
				<td><%=product.getProductPrice() %></td>
				<td><%=product.getCreatedDate() %></td>
				<td><%=product.getUpdatedDate() %></td>
			</tr>
		<%} %>
	</table>
</body>
</html>