<!-- The bulletin board (게시판),
		requires the user to be logged in before accessing,
		so redirects to the login form if not logged in.
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<%
	if(null == session.getAttribute("id")) {
		Cookie cookie = new Cookie("msg", URLEncoder.encode("<script>alert(\"로그인하셔야 합니다.\");</script>", "utf-8"));
		response.addCookie(cookie);

		response.sendRedirect("/loginExercise/loginForm06_hidden.jsp?uri=" + request.getRequestURI()); 
	}
%>

<!--
원래 HTML 아래에 response.sendRedirect 놓으면 안된다!
	HTML 페이지 출력 중 다른데로 보내는 것은 말이 안되니까!
	BUT 버퍼를 사용하기에 HTML 페이지를 바로 출력하지 않고 버퍼에 데이터를 저장한다 -> 버퍼는 redirect하면서 지워진다 -> 여기서는 에러 없다!
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        table {
            border: 5px solid black;
            border-collapse: collapse;
            width: 60%;
            max-width: 80%;
            min-width: 20%;
            text-align: center;
        }

        th {
            background-color: gray;
        }
        th, td {
            border: 1px solid black;
            padding: 15px;
        }

        tr:hover {
            background-color: gray;
        }
    
    </style>
</head>
<body>
    <table>
        <tr>
            <th>NUMBER</th>
            <th>TITLE</th>
            <th>WRITER</th>
            <th>DATE</th>
            <th>VIEWS</th>
        </tr>
        <tr>
            <td>1</td>
            <td>EXAMPLE EXAMPLE EXAMPLE EXAMPLE</td>
            <td>John Doe</td>
            <td>December 17, 2018</td>
            <td>1</td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
    
    </table>
</body>
</html>