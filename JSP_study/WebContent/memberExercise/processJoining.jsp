<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!-- 빈즈 객체 생성 -->
<jsp:useBean id="memberInfo" class="member.MemberInfo"/>
<!-- 사용자 입력 데이터 받기 -->
<!-- 빈즈 클래스(MemberInfo)의 변수명과 입력폼 name 속성의 값이 같아야 한다! -->
<jsp:setProperty name="memberInfo" property="*"/>
<!-- 빈즈의 멤버에 값을 명시적으로 입력하기 -->
<jsp:setProperty name="memberInfo" property="password" value="<%= memberInfo.getId() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입</title>
</head>
<body>
	<table width="800" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty name="memberInfo" property="id" /></td>
			<td>암호</td>
			<td><jsp:getProperty name="memberInfo" property="password" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				액션태그 사용 : <jsp:getProperty name="memberInfo" property="name" /><br>
				표현식 사용 : <%= memberInfo.getName() %><br>
				EL 사용 : ${memberInfo.name}
			</td>
			<td>이메일</td>
			<td><jsp:getProperty name="memberInfo" property="email" /></td>
		</tr>
		<tr>
			<td>주소</td>
			<td colspan="3"><jsp:getProperty name="memberInfo" property="address" /></td>
		</tr>
	</table>
</body>
</html>