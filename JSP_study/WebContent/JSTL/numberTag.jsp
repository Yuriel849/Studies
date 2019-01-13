<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- formatDate 사용하기 -->
	<h1>
		<c:set var="now" value ="<%=new Date() %>"/>
		<fmt:formatDate value="${now}" type ="date" dateStyle="full"/> <br>
		<fmt:formatDate value="${now}" type ="date" dateStyle="short"/> <br>
		<fmt:formatDate value="${now}" type ="time" timeStyle="short"/> <br>
		<fmt:formatDate value="${now}" type ="both" dateStyle="full"/> <br>
		<fmt:formatDate value="${now}" type ="both" dateStyle="short" timeStyle="full"/> <br>
		<fmt:formatDate value="${now}" pattern ="z a hh:mm:ss" /> <br>
		<fmt:formatDate value="${now}" pattern ="yyyy년 MM월 dd일" /> <br>
		<fmt:formatDate value="${now}" pattern ="yyyy.MM.dd." /> <br>
		<fmt:formatDate value="${now}" pattern ="yy년도 MM월 dd일 " /> <br>
<!-- BUT 국제 시간 표현할 때는 JS 사용할 것! JSTML의 fmt는 서버 기준이기에 의미가 없고, 클라이언트쪽 시간을 기준으로 해야한다! -->
	</h1>
	<hr>
	<!-- formatNumber 사용하기 -->
	<h1>
		<c:set value="1000000000" var ="price"/>
		<fmt:formatNumber value="${price}" type="number" var="num" /> <br>			  <!-- var="num"이면 아무것도 안나옴  -->
		<fmt:formatNumber value="${price}" type="currency" currencySymbol="\\"/> <br> <!-- \\ $ $10,000 -->
		<fmt:formatNumber value="${price}" type="percent"  groupingUsed="true"/> <br> <!-- 10,000,000%-->
		<fmt:formatNumber value="${price}" pattern="\\000,00000.0%"/> 				  <!-- 사용자 pattern에 맡게 형식 맞출 수 있음   -->
	</h1>
</body>
</html>