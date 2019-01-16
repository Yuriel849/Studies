<!-- Connects to src > login > LoginAction.java -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style>
	#avatar {
		width: 300px;
		height: 300px;
	}
</style>
</head>
<body>
<h2>Login Form</h2>
<%
String msg = (String) request.getAttribute("msg");
if(msg!=null) {
%>
<label><b><%=msg%></b></label>
<%} %>

<form action="/LoginAction" method=post> <!-- "method=get(OR post)"라고 적지 않으면 기본값이 "method=get"! -->
	<div class="imgcontainer">
		<img id="avatar" src="http://www.compressedairspares.com.au/dashboard/assets/images/img_ninja.png" alt="Avatar" class="avatar"><br><br>
	</div>
	
	<div class="container">
		<label><b>Username</b></label>
		<input type="text" placeholder="Enter Username" name="id" required><br>
			<!-- name="X"에서의 X와 LoginAction.java의 request.getParameter("X")에서의 X가 일치해야 한다! -->
		
		<label><b>Password</b></label>
		<input type="password" placeholder="Enter Password" name="pw" required><br>
		
		<button type="submit">Login</button>
		<input type="checkbox" checked="checked"> Remember me
	</div>

	<div class="container" style="background-color:#f1f1f1"><br>
		<button type="button" class="cancelbtn">Cancel</button>
		<span class="psw">Forgot <a href="#">password?</a></span>
	</div>
		
</form>
</body>
</html>