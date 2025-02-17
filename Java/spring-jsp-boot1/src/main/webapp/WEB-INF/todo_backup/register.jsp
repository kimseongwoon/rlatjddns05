<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<form action="/spring-jsp-boot1/todo/register" method="post">
		<div>
			<input type="text" name="title" placeholder="할일을 적으세요">
		</div>
		<div>
			<input type="date" name="dueDate">
		</div>
		<div>
			<button type="reset">초기화</button>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>