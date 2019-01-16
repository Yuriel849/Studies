<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>회 원 가 입</title>
<style>
	h1 {
    	margin-left: 5px;
    }
    .container {
    	border: 1px solid black;
        width: 520px;
        padding: 15px 7px;
	}
    .container label {
    	display: inline-block;
        width: 110px;
        margin: 10px;
	}
	.container p {
    	display: inline-block;
	}
    .container .userHobby {
    	float: left;
    }
	.container ul {
    	margin-top: 8px;
    }
    .container ul li {
    	display: inline-block;
    	margin: -3px;
    	list-style: none;
    }
    .container .userText {
    	float: left;
    	margin-top: 10px;
    }
    .container textarea {
    	height: 100px;
    	width: 350px;
    	margin-top: -25px;
    }
    .container .search {
    	background-color: lightgray;
    	color: black;
    	border: 0px;
    	padding: 10px 18px 5px;
	    text-decoration: none;
    	font-size: 12px;
    }
    .container .end {
	    text-align: center;
    	margin: 15px auto;
    }
    .container .end input, a {
    	padding: 15px 25px 12px;
    	border: 0px;
    	background-color: #03cf5d;
    	color: white;
    	text-decoration: none;
    	font-size: 12px;
    }
</style>
</head>
<body>
    <h3>회원가입이 완료되었습니다!</h3>
    <div class="container">
        <label>이름</label>
        	<p><%=request.getParameter("userName") %></p><br>
        <label>ID</label>
        	<p><%=request.getParameter("userID") %></p><br>
        <label>비밀번호</label>
        	<p><%=request.getParameter("userPwd") %></p><br>
        <label>주민등록번호</label>
        	<p><%=request.getParameter("userSN01") + request.getParameter("userSN02") %></p><br>
        <label>우편번호</label>
        	<p><%=request.getParameter("userPost") %></p><br>
        <label>주소</label>
       		<p><%=request.getParameter("userAddr") %></p><br>
        <label>직업</label>
       		<p><%=request.getParameter("userJob") %></p><br>
        <label>취미</label>
        <%
        	String[] hobbies = request.getParameterValues("userHobby");
    		String hobby = "";
    		if(hobbies != null) {
    			for(String str : hobbies) {
    				hobby += str + " ";
    			}
    		}
        %>
        <p><%=hobby %></p><br>
        <label>자기소개</label>
		<p><%=request.getParameter("userText") %></p><br>
		<div class="end">
        	<a href="index.jsp"id="ok" name="ok">&nbsp;&nbsp;&nbsp;확인&nbsp;&nbsp;&nbsp;</a>
		</div>
    </div>
</body>
</html>