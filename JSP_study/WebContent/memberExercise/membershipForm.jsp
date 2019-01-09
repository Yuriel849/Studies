<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/member/processJoining.jsp" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>아이디</td>
				<td colspan="3"><input type="text" name="id" size="1"></td>
					<!-- The "size" attribute of the "input" tag
								limits how many characters can be seen on the browser;
								it is not a limit of how many characters may be entered. -->
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="10"></td>
				<td>이메일</td>
				<td><input type="text" name="email" size="10"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td colspan="3"><input type="text" name="address" size="30"></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>