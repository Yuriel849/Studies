<%@page import="dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDAO"%>
<!--
To import Java classes that you need...
	ctrl + space bar -> select what you want to import -> enter
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDAO dao = new MemberDAO();
	List<MemberDTO> list = dao.list();
%>

	<table>
		<thead>
			<tr><th>이름</th><th>직책</th><th>급여</th></tr>
		</thead>
		<tbody>
<%  for(int i = 0; i < list.size(); i++) {
		MemberDTO data = list.get(i);
%>
			<tr><th><%=data.getName()%></th>
				<th><%=data.getTitle()%></th>
				<th><%=data.getSalary()%></th></tr>
<%	} %>
	</table>

</body>
</html>