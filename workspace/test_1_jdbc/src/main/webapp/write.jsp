<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
</head>
<body>
	<form action="write/ok" method="post">
		<input type="text" name="userName" placeholder="이름을 작성하세요.">
		<input type="text" name="userEmail" placeholder="이메일을 작성하세요.">
		<input type="text" name="userNickname" placeholder="닉네임을 작성하세요.">
		<input type="text" name="userPhone" placeholder="폰번호를 작성하세요.">
		<input type="text" name="userSportKind" placeholder="스포츠종목을 작성하세요.">
		<input type="date" name="userBirth">
		<button>작성 완료</button>
	</form>
</body>
</html>