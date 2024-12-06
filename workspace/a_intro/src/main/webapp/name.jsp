<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Name</title>
</head>
<body>
	<%-- <h1><%=request.getAttribute("name") %></h1> --%>
	<h1><%=request.getParameter("name") %></h1>
</body>
</html>


