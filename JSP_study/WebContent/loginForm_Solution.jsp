<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 강사님 설명하신 템플릿
	// 1. 쿠키가 있는지 확인
	Cookie[] cookies = request.getCookies();
	String id = "";
	String checked = ""; // 체크박스 체크

	for(int i = 0; i < cookies.length; i++) {
		// 쿠키 중에 name이 id인 것의 값을 가져온다.
		if(cookies[i].getName().equals("id")) {
			id = cookies[i].getValue();
			checked = "checked"; // 체크박스가 체크되게 한다/
		}
	}
	
	// 1-1. 있으면 - id필드에 쿠키의 id를 뿌려주고, 체크박스도 체크한다
	// 1-2. 없으면 - id에 값이 없고 체크박스도 해제되어 있어야 한다

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h2>Login Form</h2>
<%
String msg = (String) request.getAttribute("msg");
System.out.println(msg);
if(msg!=null) {
%>
<label><b><%=msg%></b></label>
<%} %>

<form action="/Haven/LoginAction02" method="post">
	<div class="imgcontainer">
		<img src="Pictures\loginPic.jpg" alt="Avatar" class="avatar"><br><br>
	</div>
	
	<div class="container">
		<label><b>Username</b></label>
		<input type="text" id="userName" placeholder="Enter Username" name="id" value="<%=id%>" required><br>
		
		<label><b>Password</b></label>
		<input type="password" placeholder="Enter Password" name="pw" required><br>
		
		<button type="submit">Login</button>
		<input type="checkbox" id="check" name="checked" <%=checked%>> Remember me<br><br>
		<button type="button" class="cancelbtn">Cancel</button>
		<span class="psw"><a href="#">Forgot password?</a></span>
	</div>
</form>

<%
Cookie[] cookies2 = request.getCookies();
if(cookies2 != null && cookies2.length > 0) {
	for(int i = 0; i < cookies2.length; i++) {
		if(cookies2[i].getName().equals("id")) {
%>
<script>
			userName.value = "<%=cookies2[i].getValue()%>";
			check.checked = "checked";
</script>
<%
		} // cookies에서 필요한 쿠키를 찾는 if문 끝.
	} // for문 끝.
} // cookies null 체크하는 if문 끝. 
%>
</body>
</html>