<%@page import="com.app.jdbc.guest.vo.GuestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<% GuestVO guestVO = (GuestVO)request.getAttribute("guest"); %>
	
	<form action="update/ok" method="post">
		<input type="text" name="guestName" placeholder="이름을 작성하세요." value="<%=guestVO.getGuestName()%>">
		<input type="date" name="guestBirth" value="<%=guestVO.getGuestBirth()%>">
		<input type="hidden" name="id" value="<%=guestVO.getId() %>">
		<button>수정 완료</button>
	</form>
</body>
</html>