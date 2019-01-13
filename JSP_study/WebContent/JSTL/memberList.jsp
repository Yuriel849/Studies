<%@page import="member.Member_NameEmail"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원리스트</h1>
	<c:url value="c_out.jsp" var="url1"></c:url>
	<c:url value="/jstl/c_out.jsp" var="url2"/>
	<c:url value="/jstl/c_out.jsp" var="url3">
		<c:param name="sel">A</c:param>
	</c:url>
	<h2>
		경로 1 :<a href="${url1}">${url1}</a>
		<br>
		경로 2 :${url2}
		<br>
		경로 3 :${url3}
	</h2>
	
	<table>
		<tr>
			<th>INDEX</th>
			<th>COUNT</th>
			<th>NAME</th>
			<th>EMAIL</th>
		</tr>
<!-- c_out.jsp 파일에서 application 기본객체에 "members" 속성을  추가해 놓은 상태이기 때문에 현재 페이지에서도 속성을 가져 올 수 있다!  -->
		<c:forEach var="i" items="${members}" varStatus="status">
			<tr>
				<!-- "INDEX" column -->
				<td style="text-align:center;">
					<a href="detailvies.jsp?no=${status.index}">${status.index}</a>
				</td>
				<!-- "COUNT" column -->
				<td style="text-align:center">${status.count}</td>
				<!-- "NAME" column -->
				<td>${i.name }</td>
				<!-- "EMAIL" column -->
					<!-- if email is null -->
				<c:if test="${i.email eq null}">
					<td style="color: pink; padding-left:20px">이메일 정보가 없습니다</td>
				</c:if>
					<!-- if email is not null -->
				<c:if test="${i.email ne null}">
					<td style="color: blue; padding-left:20px">${i.email}</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>