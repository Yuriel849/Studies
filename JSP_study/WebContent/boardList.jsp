<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<%
	if(null == session.getAttribute("id")) {
		Cookie cookie = new Cookie("msg", URLEncoder.encode("<script>alert(\"로그인하셔야 합니다.\");</script>", "utf-8"));
		response.addCookie(cookie);

		response.sendRedirect("/loginForm06_hidden.jsp?uri=" + request.getRequestURI()); 
	}
%>

<!--
원래 HTML 아래에 response.sendRedirect 놓으면 안된다!
	HTML 페이지 출력 중 다른데로 보내는 것은 말이 안되니까!
	BUT 버퍼를 사용하기에 HTML 페이지를 바로 출력하지 않고 버퍼에 데이터를 저장한다 -> 버퍼는 redirect하면서 지워진다 -> 여기서는 에러 없다!
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
THIS IS THE BOARD<br>
( ...if you can't take a hint, it's incomplete :p )
</body>
</html>