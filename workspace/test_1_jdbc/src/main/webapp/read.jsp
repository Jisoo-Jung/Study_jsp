<%@page import="com.app.jdbc.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
<style>
	table {
		width: 800px;
		margin: 0 auto;
		text-align: center;
		border-collapse: collapse;
		border: 1px solid black;
	}
	
	th, td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<%
	UserVO userVO = (UserVO)request.getAttribute("user"); 
	%>
	<button id="go-update">수정하기</button>
	<button id="go-delete">삭제하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>닉네임</th>
			<th>폰번호</th>
			<th>스포츠종목</th>
			<th>생년월일</th>
		</tr>
		<tr>
			<td><%=userVO.getId()%></td>
			<td><%=userVO.getUserName()%></td>
			<td><%=userVO.getUserEmail()%></td>
			<td><%=userVO.getUserNickname()%></td>
			<td><%=userVO.getUserPhone()%></td>
			<td><%=userVO.getUserSportKind()%></td>
			<td><%=userVO.getUserBirth()%></td>
		</tr>
	</table>
	<form action="update" name="go-update-form">
		<input type="hidden" name="id" value="<%=userVO.getId()%>">
	</form>
	<form action="delete/ok" name="go-delete-form">
		<input type="hidden" name="id" value="<%=userVO.getId()%>">
	</form>
</body>
	<script>
	const goUpdateButton = document.getElementById("go-update");
	const goDeleteButton = document.getElementById("go-delete");
	
	goUpdateButton.addEventListener("click", () => {
		document["go-update-form"].submit();
	});
	goDeleteButton.addEventListener("click", () => {
		document["go-delete-form"].submit();
	});
	</script>
</html>


