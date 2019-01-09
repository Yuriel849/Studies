<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="member.MemberInfo"/>
<%
	member.setId("humo?");
	member.setName("humo humo?!");
%>

<jsp:forward page="useObjectTest.jsp"/>