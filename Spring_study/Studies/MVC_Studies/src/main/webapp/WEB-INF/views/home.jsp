<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello Spring World! 스프링의 세계에 어세오세요~!!
	</h1>

	<P>  The time on the server is ${serverTime}. </P>
	
	<ul>
		<li><a href="<%= request.getContextPath() %>/hello">/hello</a></li>
		<li><a href="/mvc/member/regForm">/member/regForm</a></li>
		<li><a href="/mvc/member/memberReg">/member/memberReg</a></li>
	</ul>
</body>
</html>