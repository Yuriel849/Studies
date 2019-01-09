<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 저장할 데이터를 가지는 쿠기 객체 생성
	Cookie cookie = new Cookie("name", URLEncoder.encode("심연", "UTF-8"));
									 // 쿠키에 저장되는 값은 한글 처리 불가 => URLEncoder 사용 후 저장!
	// 응답 객체에 쿠키를 전달
	response.addCookie(cookie);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 만들기</title>
</head>
<body>
	<h1>쿠키 생성</h1>
	<h3>
		<%= cookie.getName() %> 쿠키에 저장된 값 : <%= URLDecoder.decode(cookie.getValue(), "UTF-8") %>
		<!-- EL로 찾기는 어렵다
				EL는 기본적으로 속성을 참조하는 것
				속성으로 기본객체에 추가한다고 해도 배열이기에 처리가 귀찮아진다.
		 -->
		 
		<br><br>
		<a href="viewCookie.jsp">쿠키 정보 보기</a>
	
	</h3>
</body>
</html>