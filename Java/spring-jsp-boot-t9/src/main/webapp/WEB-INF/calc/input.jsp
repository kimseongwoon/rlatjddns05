<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form의 기본method값은 get방식 -->
	<form method="post" action="/spring-jsp-boot-t9/calc/makeResult">
		<input type="number" name="num1" />
		<input type="number" name="num2" />
		<input type="text" name="txt1" />
		<input type="text" name="txt2" />
		<button type="submit">SEND</button>
	</form>
</body>
</html>