<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
	input {
		outline: none;
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<form action="age" method="get" name="age-form">
		<input type="text" name="age" value="10" placeholder="나이를 입력하세요.">
		<input type="button" id="send-button" value="전송">
	</form>
</body>
<script>
	const inputAge = document["age-form"].age;
	const button = document.getElementById("send-button");
	
	button.addEventListener("click", (e) => {
		if(!inputAge.value){
			inputAge.style.border = "1px solid red";
			return;
		}
		
		inputAge.style.border = "1px solid gray";
		document["age-form"].submit();
	});
	
	
</script>
</html>