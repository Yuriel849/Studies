<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- This is an exercise in following paths -->

<body>
	<%
		String path = "/notice/this.txt";
			/* Starting from the location of this file (followPath.jsp),
				find the directory "notice" and access the file "this.txt" within the directory "notice" */
	
		String realPath = application.getRealPath(path);
	%>
	
	자원의 실제 경로: <%= realPath %><br>
	<!-- 출력결과 => "자원의 실제 경로: C:\Users\Yuriel\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\test\file\notice\this.txt" -->
	
	<%
	BufferedReader br = null;
	char[] buff = new char[512];
	int len = -1;
	try {
		/* BufferedReader는 보조스트림, 자기 혼자 작동할 수 없다 => InputStreamReader는 기반스트림, 자기 혼자 작동할 수 있지만 스트림을 매개변수로 제공해줘야 한다 => application.getResourceAsStream()은 지정된 경로에 위치한 자원을 읽어올 수 있는 input stream을 반환한다. */
		br = new BufferedReader(new InputStreamReader(application.getResourceAsStream(path)));
			/* 원형은 br.read(char[] buff, int offset, int length) => buff is the destination buffer, offset is the offset at which to start storing characters in buff, length is the maximum number of characters to read */
		while((len = br.read(buff)) != -1) { /* br.read() returns to the number of characters read, or -1 if the end of the stream has been reached */
			out.println(new String(buff,0,len));
		}
	} catch(IOException e) {
		out.println("익셉션 발생 : " + e.getMessage());
	} finally {
		if(br != null)
			try {
				br.close();
			} catch(IOException e) {}
	}
	%>
</body>
</html>