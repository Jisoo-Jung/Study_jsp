<%@page import="com.app.jdbc.matching.vo.MatchingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<%MatchingVO matchingVO = (MatchingVO)request.getAttribute("matching"); %>
	
	<form action="update/ok" method="post">
		<input type="checkbox" name="matchingStatus" value="<%=matchingVO.getMatchingStatus()%>">
		<input type="hidden" name="id" value="<%=matchingVO.getId()%>"> 
		<button>수정 완료</button>
	</form>
</body>
</html>