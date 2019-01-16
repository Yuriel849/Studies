<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("userName", "Scotty");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using EL objects</title>
</head>
<body>
	<h1>
		request attribute "name" : ${requestScope.userName} / ${userName}
		<br>
		<!-- pageContext.request.requestURL -> pageContext 기본 객체의 getRequest() 호출하여 거기서 또다시 getRequestURL() 호출 -->
		현재 요청 URL 			: ${pageContext.request.requestURL}<br>
		현재 요청 URI 			: ${pageContext.request.requestURI}<br>
		현재 요청 Context Path : ${pageContext.request.contextPath}
			<!-- the current project's context root is "/" so getContextPath() returns "/" -->
		<br>
		<!-- 쿼리문에 code를 작성하면 출력된다 (지금은 없기에 아무것도 안나온다!) -->
		파라미터 code의 값  : Using scriptlet : <%= request.getParameter("code") %> / 
					     Using EL : ${param.code}
	</h1>
</body>
</html>