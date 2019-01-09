<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="member.MemberInfo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Use_Object_Test</title>
</head>
<body>
	<h1>
		<%= member.getName() %> (<%= member.getId() %>) 회원님
	</h1>
</body>
</html>