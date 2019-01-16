<!-- The first simple jsp file, to show how jsp files work -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
%>

<h1>Hello!!!, <%=id%>.</h1>
<h1>Your password is <%=pwd%>.</h1>

</body>
</html>