<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 정보 보기</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	
		// 여기서는 내가 직접 만든 배열이니까 내용물을 알지만, 꼭 그렇지는 않다. 남이 만든 배열을 사용해야할 수도 있다. 그래서 null인지, 비었는지 확인해야 한다.
		if(cookies != null && cookies.length > 1) {
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("name")) { %>
					<%= cookies[i].getName() %> : <%= URLDecoder.decode(cookies[i].getValue(), "UTF-8") %> <br>	
	<%			}
			}
		} else { %>
			저장된 쿠키 정보가 없습니다.	
	<%	}
	%>
	<h3>
		<a href="modifyCookie.jsp">쿠키 수정하기</a>
	</h3>
	<h3>
		<a href="deleteCookie.jsp">쿠키 삭제하기</a>
	</h3>
</body>
</html>