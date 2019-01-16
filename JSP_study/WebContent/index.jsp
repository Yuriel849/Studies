<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>HAVEN</title>
<style>
	input[type=text], input[type=password] { /* Applies to the "text" & "password" type input tags */
		width: 100%;
		padding: 12px 20px;
		margin: 8px;
		border: 3px solid #ccc;
		box-sizing: border-box;
	}

	button { /* Applies to all buttons  */
		background-color: #4CAF50;
		color: white;
		padding: 14px 20px;
		margin: 8px 0px;
		border: none;
		cursor: pointer;
		width: 100%
	}
	
	button:hover { /* Buttons become semi-transparent when the cursor hovers */
		opacity: 0.7;
	}

	.cancelbtn { /* Only applies to the cancel button  */
		width: auto;
		padding: 10px 18px;
		background-color: #F44336;
	}
	
	.imgcontainer { /* Sets the location of the imgcontainer, which contains img tags */
		text-align: center;
		margin: 30px 0px 15px 0px;
		position: relative;
	}
	
	img.avatar { /* Applies to the "avatar" class in an img tag, reducing size and rounding it */
		width: 40%;
		height: 40%;
		border-radius: 50%;
		/* border-radius is the attribute making something rounder -> width and height are the same, so becomes circular */
	}
	
	.container {
		padding: 16px;
	}

	span.psw { /* Only applies to the "forgot password?" part */
		float: right;
  		padding-top: 16px;
	}

	#signup {
		text-align: right;	
	}
	
	/* Modal (background) */
	.modal {
  		display: none; /* Hidden by default */
  		position: fixed; /* Stay in place */
  		z-index: 1; /* Sit on top */
  		left: 0;
  		top: 0;
  		width: 100%;
  		height: 100%;
  		overflow: auto; /* Enable scroll if needed */
  		background-color: rgb(0,0,0); /* Fallback color */
  		background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  		padding-top: 60px;
	}

	/* Modal Content/Box */
	.modal-content {
  		background-color: #fefefe;
  		margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  		border: 1px solid #888;
  		width: 30%;
	}
	
	/* Close button (X) */
	.close {
  		position: absolute;
  		right: 25px;
  		top: 0;
  		color: #000;
  		font-size: 35px;
  		font-weight: bold;
	}

	.close:hover,
	.close:focus {
  		color: red;
  		cursor: pointer;
	}
	
	.sidenav {
		height: 100%;
  		width: 0;
  		position: fixed;
  		z-index: 1;
  		top: 55px;
  		right: 0;
  		background-color: #111;  		
  		overflow-x: hidden;
  		transition: 0.5s;
  		padding-top: 60px;
	}

	.sidenav a {
  		padding: 8px 8px 8px 32px;
  		text-decoration: none;
  		font-size: 25px;
  		color: #818181;
  		display: block;
  		transition: 0.3s;
	}

	.sidenav a:hover {
  		color: #f1f1f1;
	}
	
	.sidenav .closebtn {
  		position: absolute;
  		top: 0;
  		right: 25px;
  		font-size: 36px;
  		margin-right: 50px;
	}

	#main {
  		transition: margin-right .5s;
  		padding: 16px;
	}
</style>

</head>
<body>
<div id="main">
<!-- Navbar (sit on top) -->
<div class="w3-top">
	<div class="w3-bar w3-white w3-wide w3-padding w3-card">
		<!-- Link back to the index page (home page) -->
		<a href="/" class="w3-bar-item w3-button"><b>HAVEN</b> Main Page</a>
		<!-- Float links to the right. -->
    	<div class="w3-right w3-hide-small">
    		<!-- Button to the modal login form -->
    		<a href="#login" onclick="document.getElementById('login').style.display='block'" class="w3-bar-item w3-button">Login</a>
    		<a href="/logout.jsp" class="w3-bar-item w3-button">Logout</a>
    		<a href="#projects" class="w3-bar-item w3-button">Projects</a>
      		<a href="/loginExercise/bulletinBoard.jsp" class="w3-bar-item w3-button">Board</a>
      		<a href="#about" class="w3-bar-item w3-button">About</a>
      		<a href="#contact" class="w3-bar-item w3-button">Contact</a>
      		<a href="#menu" class="w3-bar-item w3-button" onclick="openNav()">Menu</a>
    	</div>
  	</div>
</div>

<!-- Modal login form -->
<div id="login" class="modal">
	<form class="modal-content animate" action="/LoginAction06_hidden">
		<div class="imgcontainer">
			<span onclick="document.getElementById('login').style.display='none'" class="close" title="close">
				&times;
			</span>
			<img src="Pictures\loginPic.jpg" alt="Avatar" class="avatar"><br><br>
		</div>
	
		<div class="container">
			<label><b>Username</b></label>
			<input type="text" placeholder="Enter Username" name="userName" value="" required><br>
		
			<label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="pw" required><br>
		
			<button type="submit">Login</button>
			<label>
				<input type="checkbox" name="checker"> Remember me
			</label>
			<button type="button" onclick="document.getElementById('login').style.display='none'" class="cancelbtn">Cancel</button>
			<span class="psw"><a href="#">Forgot password?</a></span>
			<br>
			<div id="signup">Not a member yet? <a href="#">No problem.</a></div>
		</div>
	</form>
</div>

<!-- Header -->
<div id="header" class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
	<img class="w3-image" src="Pictures\Firenze2018.JPG" alt="Firenze" style="opacity:0.8;" width="1500" height="600">
  	<div class="w3-display-middle w3-margin-top w3-center">
    	<h1 class="w3-xxlarge w3-text-white"><span class="w3-padding w3-black w3-opacity-min"><b>Yuriel's</b></span> <span class="w3-hide-small w3-text-black"><b>  Home (Starkhaven)</b></span></h1>
	</div>
</div>

<!-- Navigation sidebar with push-open -->
<div id="sidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>

<!-- Close the tag with the id="main" -->
</div>

<%
Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length > 0) {
	for(int i = 0; i < cookies.length; i++) {
		if(cookies[i].getName().equals("userName")) {
%>
<script>
			document.getElementsByName("userName")[0].value = "<%=URLDecoder.decode(cookies[i].getValue(), "utf-8")%>";
		    document.getElementsByName("checker")[0].checked = true;
</script>
<%
		} // cookies에서 필요한 쿠키를 찾는 if문 끝.
	} // for문 끝.
} // cookies null 체크하는 if문 끝. 
%>

<script>
	var modal = document.getElementById("login");

	window.onclick = function(event) {
		if(event.target == modal) {
			modal.style.display="none";
		}
	}
	
	function openNav() {
		document.getElementById("sidenav").style.width = "250px";
		document.getElementById("main").style.marginRight = "250px";
		document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
	}

	function closeNav() {
		document.getElementById("sidenav").style.width = "0";
		document.getElementById("main").style.marginRight= "0";
		document.body.style.backgroundColor = "white";
	}

</script>

</body>
</html>