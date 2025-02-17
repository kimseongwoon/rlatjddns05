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
	<h1>Todo List</h1>
	<h2>${appName}</h2>
    <h2>${loginInfo}</h2>
	<h2>${loginInfo.mname}</h2>
    <ul>
		<c:forEach items="${dtoList}" var="dto">
       	  <li>
       	  	<span><a href="/spring-jsp-boot1/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
      	  </li>
        </c:forEach>
    </ul>
    <a href="/spring-jsp-boot1/todo/register">등록</a>
    
    <form action="/spring-jsp-boot1/logout" method="post">
    	<button>LOGOUT</button>
    </form>
</body>
</html>