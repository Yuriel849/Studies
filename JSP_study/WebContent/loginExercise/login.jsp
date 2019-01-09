<%@page import="member.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 다른 페이지로부터 데이터를 전달 받기
		request 기본 객체 사용하기
		useBean 액션태그 사용하기
		EL 사용하기
-->
<%
	String userId = request.getParameter("id");
	String userPwd = request.getParameter("pwd");
	
	if(userId != null && userPwd != null && userId.equals(userPwd)) {
		// 로그인 인증 성공 상태 -> session 객체의 속성으로 사용자 정보를 저장
		
		// id 값으로 DB에서 검색했다고 가정 (실제로 DB 연결 X) -> 결과가 null이 아니어야한다.
		// DB에 있는 pwd와 사용자가 입력한 pwd 비교 -> 같으면 인증 성공 -> session 객체에 사용자 정보를 저장
		
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setId("wolf");
		memberInfo.setName("husky");
		// 비밀번호는 보안 상 다른데로 이동시키면 안되고, 당연히 암호화가 기본!	
		memberInfo.setPassword(""); // 이 코드는 pwd를 없애는 목적
		
		session.setAttribute("loginInfo", memberInfo);
		
		response.sendRedirect("mypage.jsp");
	} else {
		response.sendRedirect("loginForm.jsp");
	}
%>