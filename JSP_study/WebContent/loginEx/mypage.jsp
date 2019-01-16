<%@page import="member.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session에 loginInfo 데이터가 있는지 확인
	MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginInfo");
							//session 속성을 저장할 때 Object타입을 저장했기에 형변환 필요!
	boolean login = memberInfo == null ? false : true;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
	<%
		if(login) { %>
			<h3><a href="logout.jsp">로그아웃</a></h3>
			<h2><%= memberInfo.getName() %>&nbsp;(<%= memberInfo.getId() %>)님 안녕하세요.</h2>
			<h2> ${loginInfo.name} (${loginInfo.id})님 안녕하세요.</h2>
	<%	} else { %>
			<h2>회원 전용 페이지입니다. <a href="loginForm.jsp">로그인하기</a></h2>
	<%  }
	%>
</body>
</html>