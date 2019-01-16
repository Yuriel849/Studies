<!-- Connects to src > join > SignUpAction.java -->

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
	<%
	// 메시지 출력하기
	String message = "";
	
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0) {
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("msg")) {
				message = URLDecoder.decode(cookies[i].getValue(), "utf-8");
			} // cookies에서 필요한 쿠키를 찾는 if문 끝.
		} // for문 끝.
	} // cookies null 체크하는 if문 끝.
	%>
	<%=message%>

    <h1>회원가입</h1>
    <div class="container">
        <form action="/SignUpAction" method="post">
            <label for="userName">*이름</label>
                <input type="text" name="userName" maxlength="20" required><br>
            <label for="userID">*ID</label>
                <input type="text" name="userID" maxlength="20" required>
                <a href="chkDupl.jsp" class="search">중복검사</a>
            <label for="userPwd">*비밀번호</label>
                <input type="password" name="userPwd" maxlength="20" required><br>
            <label for="userPwdChk">*비밀번호 확인</label>
                <input type="password" name="userPwdChk" maxlength="20" required><br>
            <label for="userSN01">*주민등록번호</label>
                <input type="text" name="userSN01" maxlength="6" required>-<input type="password" name="userSN02" maxlength="7" required><br>
            <label for="userPost">*우편번호</label>
                <input type="text" name="userPost" maxlength="8" value="010101" readonly required>
                <a href="findPost.jsp" class="search">우편번호검색</a>
            <label for="userAddr">*주소</label>
                <input type="text" name="userAddr" maxlength="50" required><br>
            <label for="userJob">*직업</label>
                <select name="userJob" id="userJob" required>
                    <option value="학생">학생</option>
                    <option value="직장인">직장인</option>
                    <option value="무직">무직</option>
                </select><br>
            <label class="userHobby" for="userHobby">*취미</label>
                <ul>
                    <li><input type="checkbox" name="userHobby" value="독서">독서</li>
                    <li><input type="checkbox" name="userHobby" value="드라이브">드라이브</li>
                    <li><input type="checkbox" name="userHobby" value="영화">영화</li>
                    <li><input type="checkbox" name="userHobby" value="콘서트">콘서트</li>
                    <li><input type="checkbox" name="userHobby" value="쇼핑">쇼핑</li>
                    <li><input type="checkbox" name="userHobby" value="놀이동산">놀이동산</li>
                </ul><br>
            <label class="userText" for="userText">자기소개</label>
                <textarea name="userText" id="userText" cols="30" rows="10" placeholder="자기소개를 입력해주세요."></textarea><br>
            <div class="end">
                <input type="submit" id="submit" name="submit" value="가입완료">
                <a href="index.jsp"id="cancel" name="cancel">&nbsp;&nbsp;취소&nbsp;&nbsp;&nbsp;</a>
            </div>
        </form>
    </div>
</body>
</html>