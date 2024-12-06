<%@page import="com.app.jdbc.matching.vo.MatchingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
<style>
	table {
		width: 500px;
		margin: 5px 5px;
		text-align: center;
		border-collapse: collapse;
		border: 1px solid blue;
	}
	
	th, td {
		border: 1px solid blue;
	}
</style>
</head>
<body>
	<%MatchingVO matchingVO = (MatchingVO)request.getAttribute("matching"); %>
	<button id="go-update">수정하기</button>
	<button id="go-delete">삭제하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>매칭상태</th>
		</tr>
		<tr>
			<td><%=matchingVO.getId()%></td>
			<td><%=matchingVO.getMatchingStatus()%></td>
		</tr>
	</table>
	<form action="update" name="go-update-form">
		<input type="hidden" name="id" value="<%=matchingVO.getId()%>">
	</form>
	<form action="delete" name="go-delete-form">
		<input type="hidden" name="id" value="<%=matchingVO.getId()%>">
	</form>
</body>
<script>
	const goUpdateButton = document.getElementById("go-update");
	const goDeleteButton = document.getElementById("go-delete");
	
	goUpdateButton.addEventListener("click", () => {
		document["go-update-form"].submit();
	})
	goDeleteButton.addEventListener("click", () => {
		document["go-delete-form"].submit();
	})
</script>
</html>















