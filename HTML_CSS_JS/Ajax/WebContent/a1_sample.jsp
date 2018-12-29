<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name=request.getParameter("name");
	String age=request.getParameter("age");
%>
<div>name : <%=name%></div>
<div>age : <%=age%></div>
</body>
</html>