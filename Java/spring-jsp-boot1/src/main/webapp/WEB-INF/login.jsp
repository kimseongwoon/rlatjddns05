<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	Cookie[] cookies = request.getCookies();
	Cookie remeberMeCookie = null;
	
	if(cookies != null && cookies .length > 0) {
		for(Cookie ck : cookies) {
			if(ck.getName () .equals ("remember-me")) {
				remeberMeCookie = ck;
				break;
			}
		}
	}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- url이 /login?result=error값으로 오면 아래 코드 실행 -->
	<c:if test="${param.result == 'error' }">
		<h1 style="color: red;">로그인 에러</h1>
	</c:if>
	로그인 페이지
	<form action="/spring-jsp-boot1/login" method="post">
	    <input type="text" name="mid">
	    <input type="text" name="mpw">
	    <br>
	    <input type="checkbox" name="auto"> Remember Me
	    <br>
	    <button type="submit">LOGIN</button>
	</form>
	
<%
	// 자동 로그인이 체크되어져 쿠키값이 존재한다면 바로 리스트 페이지로 이동
	//if(remeberMeCookie != null) {
%>	
<script>
	//location.href = '/spring-jsp-boot1/todo/list';
</script>
<%
	//}
%>	
</body>
</html>