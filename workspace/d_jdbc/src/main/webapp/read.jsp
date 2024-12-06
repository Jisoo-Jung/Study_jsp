<%@page import="com.app.jdbc.guest.vo.GuestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
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
	<%
	GuestVO guestVO = (GuestVO) request.getAttribute("guest");
	%>
	<button id="go-update">수정하기</button>
	<button id="go-delete">삭제하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>생년월일</th>
		</tr>
		<tr>
			<td><%=guestVO.getId()%></td>
			<td><%=guestVO.getGuestName()%></td>
			<td><%=guestVO.getGuestBirth()%></td>
		</tr>
	</table>
	<form action="update" name="go-update-form">
		<input type="hidden" name="id" value="<%=guestVO.getId()%>">
	</form>
	
	<form action="delete/ok" name="go-delete-form">
		<input type="hidden" name="id" value="<%=guestVO.getId()%>">
	</form>
</body>
<script>
	const goUpdateButton = document.getElementById("go-update");
	const goDeleteButton = document.getElementById("go-delete");

	goUpdateButton.addEventListener("click", (e) => {
		document["go-update-form"].submit();
	});
	
	goDeleteButton.addEventListener("click", (e) => {
		document["go-delete-form"].submit();
	});
</script>
</html>