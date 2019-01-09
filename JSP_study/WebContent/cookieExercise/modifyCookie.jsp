<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	Cookie[] cookies = request.getCookies();
	
	// 여기서는 내가 직접 만든 배열이니까 내용물을 알지만, 꼭 그렇지는 않다. 남이 만든 배열을 사용해야할 수도 있다. 그래서 null인지, 비었는지 확인해야 한다.
	if(cookies != null && cookies.length > 1) {
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("name")) {
				// "name"이라는 이름을 가진 쿠키가 존재한다면 그 값을 바꾼다.
					// (사실 이렇게 확인할 필요없이 일방적으로 바꿔도 된다. 그렇게하면 "name"이라는 쿠키가 있으면 값을 바꾸고 없어도 그냥 새로 만든다.)
				Cookie cookie = new Cookie("name", URLEncoder.encode("JSP & Java Servlet", "UTF-8"));
				response.addCookie(cookie);
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 정보 수정</title>
</head>
<body>
	<h3>
		name 쿠키의 값을 변경합니다.
	</h3>
	<a href="viewCookie.jsp">쿠키 정보 보기</a>
</body>
</html>