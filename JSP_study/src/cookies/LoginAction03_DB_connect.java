package cookies;

import java.io.*;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// LoginAction03.java servlet & DB를 연동하기

@WebServlet("/LoginAction03")
public class LoginAction03 extends HttpServlet { // HttpServlet 상속
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 시 넘어온 값을 읽는다.
//		System.out.println("getting");
		String id = "dolphin";
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String chk = request.getParameter("checked");
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(chk);
		
		UserDAO udao = UserDAO.getInstance();
        User user = udao.selectUser(id);
        System.out.println(user);
        
        String compareId = user.getUserId();
        String comparePwd = user.getPassword();
        System.out.println(compareId);
        System.out.println(comparePwd);
		
//		if((id!=null) && (pw!=null) && id.equals(compareId) && pw.equals(comparePwd)) {
//			// id & pw가 일치하는 경우
//			response.sendRedirect("/");
//		} else {
//			// id & pw가 일치하지 않는 경우
//			request.setAttribute("msg", "아이디 또는 비밀번호가 틀립니다."); // request 객체에 메시지를 저장
//		
//			if(chk!=null && chk.equals("on")) {
//				Cookie cookie = new Cookie("id", URLEncoder.encode(id, "utf-8"));
//				response.addCookie(cookie);
//			} else {
//				Cookie cookie = new Cookie("id", "");
//				cookie.setMaxAge(0);
//				response.addCookie(cookie);
//			}
//		
//			response.sendRedirect("loginForm02.jsp");
			// forward로는 cookie가 보내지지만 자동으로 로딩되지 않는다 (내가 새로고침해야 된다) -> redirect 사용할 것!
//			RequestDispatcher reqDis = request.getRequestDispatcher("/loginForm02.jsp");
//			reqDis.forward(request, response);
		} // 안쪽 if-else문 끝.
//	} // doGet() 끝.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 요청이 GET 요청과 동일하게 처리되는 경우.
		// doPost()를 작성하는 대신, doGet()을 호출한다.
//		System.out.println("posting");
		doGet(request, response);
	} // doPost() 끝.
}