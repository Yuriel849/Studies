<%@page import="member.Member_NameEmail"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<Member_NameEmail> members = new ArrayList<> ();
    members.add(new Member_NameEmail("홍길동101","hhh11@naver.com"));
    members.add(new Member_NameEmail("홍길동102","hhh12@naver.com"));
    members.add(new Member_NameEmail("홍길동103","hhh13@naver.com"));
    members.add(new Member_NameEmail("홍길동104",null));
    members.add(new Member_NameEmail("홍길동105","hhh15@naver.com"));
    members.add(new Member_NameEmail("홍길동106","hhh16@naver.com"));
    members.add(new Member_NameEmail("홍길동107","hhh17@naver.com"));
    members.add(new Member_NameEmail("홍길동108","hhh18@naver.com"));
    members.add(new Member_NameEmail("홍길동109",null));
    members.add(new Member_NameEmail("홍길동110",null));
    
    // members 객체(ArrayList)를 통채로 속성 값으로 넣기
    application.setAttribute("members", members);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- BTW if you write a JSP action tag within HTML comments, it is read by the server and an exception occurs! -->
<!-- [c:forEach] JSTL 태그의 속성들
		var 변수   						-- *필수 요소
		items 객체 (List, ArrayList)		-- *필수 요소
		begin
		end
		step
		varStatue => count 1번부터, index 0번 부터  개수 세거나 인덱스 값 처리할때 유용!
			* 지정된 횟수 반복할땐  필수 요소 대신 begin, end로  강제로 돌리면 됨
-->

	<!-- EL을 이용해서 members 속성을 찾아 반복문으로 읽는다. 반복문 돌릴 때마다의 값을 member 변수에 담아서 작업한다. -->
	<c:forEach items="${members}" var="member">
	<h3>${member.name} : <c:out value="${member.email}" default="이메일 정보 없음" />
		<!-- EL에 담긴  null값은 브라우저에서 아무일도 안 일어나기에 default 속성을 넣어서 null값일 때의 처리 해주는 것이 좋다! -->
    <br>
    	<!-- escapeXml ="true"로  하면 HTML 태그로 인식하지 않고 그냥 문자로 출력한다! -->
	/ <c:out value="${member.email}" escapeXml="false">
		<span style="color:red"> 등록된 이메일이 없습니다.</span>
	  </c:out>
	/
	<!-- [c :if]
			test 속성에 boolean 값이 들어가는데 EL 넣어서 비교 할 수도 있다 
   		
   		  비교 연산자 == 대신 eq 쓸 수 있다 (short for "equal")
   			     != 대신 ne (short for "not equal")  
	-->
	<c:if test="${member.email eq null}"> <!-- ${member.email eq null} IS THE SAME AS ${member.email == null}-->
   		<span style="color:blue">이메일 정보가 없습니다</span>
	</c:if>
	<c:if test="${member.email ne null }">
   		<span style="color:pink">null값이 아닙니다</span>
	</c:if>
	</h3>
	</c:forEach>
   
<!-- JSTL에서 [c:if]는 if만 가능, else OR else if는 불가능!
		INSTEAD [c:choose] => [c:when] =>[c:otherwise] 사용! if-else if OR switch와 개념이 똑같다! -->
</body>
</html>