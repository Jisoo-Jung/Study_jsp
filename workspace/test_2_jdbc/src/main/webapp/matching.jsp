<%@page import="com.app.jdbc.matching.vo.MatchingVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matching</title>
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
<% List<MatchingVO> matchings = (List<MatchingVO>)request.getAttribute("matchings");%>
	<button id="go-write">등록하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>매칭상태</th>
		</tr>
		<%for(MatchingVO matchingVO: matchings) {%>
		<tr>
			<td><%=matchingVO.getId()%></td>
			<td><a href="read?id=<%=matchingVO.getId() %>"><%=matchingVO.getMatchingStatus()%></a></td>
		</tr>
		<%} %>
	</table>
</body>
<script>
	const goWriteButton = document.getElementById("go-write");
	goWriteButton.addEventListener("click", (e) => {
		location.href = "write";
	});
</script>
</html>




