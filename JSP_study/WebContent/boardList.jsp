<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
THIS IS THE BOARD<br>
( ...if you can't take a hint, it's incomplete :p )
<%
	if(null == session.getAttribute("id")) {
		Cookie cookie = new Cookie("msg", URLEncoder.encode("<script>alert(\"로그인하셔야 합니다.\");</script>", "utf-8"));
		response.addCookie(cookie);
		
		cookie = new Cookie("loginFrom", URLEncoder.encode("board", "utf-8"));
		response.addCookie(cookie);
		response.sendRedirect("/loginForm04_DB_cookies.jsp");

		// 어디서 오는지를 쿠키로 전달하는 대신, document.referer를 이용하기
//		response.sendRedirect("/Haven/loginForm_DB_cookies.jsp?refer=boardList.jsp");
	}
%>
</body>
</html>