<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>Login Form</h1>
	
	<form action="login.jsp" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" id="pwd" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Log-In"></td>
			</tr>		
		</table>
	</form>
</body>
</html>