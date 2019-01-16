<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="memberInfo" class="study.MemberInfo" scope="request"/>
<jsp:setProperty name="memberInfo" property="*" />
<jsp:forward page="/registerExercise/registerView.jsp" />