<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.getParameter("num1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>NUM1 ${param.num1}</h1>
	<h1>NUM2 ${param.num2}</h1>
	
	<h1>SUM ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
	<h1>SUM ${param.num1 + param.num2}</h1>
	<br>
	<h1>txt1 ${param.txt1}</h1>
	<h1>txt2 ${param.txt2}</h1>
	<h1>SUM ${Integer.parseInt(param.txt1) + Integer.parseInt(param.txt2)}</h1>
	<h1>SUM ${param.txt1 + param.txt2}</h1>
	<h1>SUM ${param.txt1}${param.txt2}</h1>
</body>
</html>