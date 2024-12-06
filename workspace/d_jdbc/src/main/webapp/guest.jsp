<%@page import="com.app.jdbc.guest.vo.GuestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest</title>
<style>
	table {
		width: 700px;
		margin: 0 auto;
		text-align: center;
		border-collapse: collapse;
		border: 1px solid black;
	}
	
	td, th {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<% List<GuestVO> guests = (List<GuestVO>)request.getAttribute("guests"); %>
	<button id="go-write">등록하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>생년월일</th>
		</tr>
		<%for(GuestVO guestVO: guests) {%>
			<tr>
				<td><%=guestVO.getId()%></td>
				<td><a href="read?id=<%=guestVO.getId() %>"><%=guestVO.getGuestName()%></a></td>
				<td><%=guestVO.getGuestBirth()%></td>
			</tr>
		<%} %>
	</table>
</body>
<script>
	const goWriteButton = document.getElementById("go-write");
	goWriteButton.addEventListener("click", (e) => {
		// 이동
		location.href = "write";
	});
</script>
</html>







