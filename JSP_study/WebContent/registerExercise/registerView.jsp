<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="memberInfo" class="study.MemberInfo" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Details</title>
</head>
<body>
<b>ID</b>
<!--
<jsp:getProperty name="memberInfo" property="id" /><br>
	getProperty 태그... 너무 길다...
		그래서 짧고 간단하게 쓰려고 사용하는게 EL (Expression Language, 표현언어)
		< %=memberInfo.getId()%> == <jsp:getProperty name="memberInfo" property="id" /><br> == ${memberInfo.id}
		JSP 사용하지 않으려고 액션태그 사용, 액션태그 사용하지 않으려고 EL 사용
-->
${memberInfo.id}

<b>NAME</b>
<jsp:getProperty name="memberInfo" property="name" /><br>
<b>PASSWORD</b>
<jsp:getProperty name="memberInfo" property="password" /><br>
<b>EMAIL</b>
<jsp:getProperty name="memberInfo" property="email" /><br>
</body>
</html>