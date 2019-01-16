/* Uses a cookie to send a message that either the ID or the password was entered incorrectly,
 * 	   uses a cookie to set the checked attribute on the login form,
 * 	   uses a DB connection to obtain the ID and password,
 *     and uses a cookie to figure out where the request came from
 *         (whether the user is trying to login from the main page or the bulletinBoard)
 *     connects to WebContent > loginExercise > loginForm04_cookies.jsp
 */

package login;

import java.io.*;
import java.net.URLEncoder;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction04_cookies")
public class LoginAction04_cookies extends HttpServlet { // HttpServlet 상속
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 시 넘어온 값을 읽는다.
		HttpSession session = request.getSession();
		
		// DB 연동이 제대로 되는지 확인하는 코드
//		String id = "dolphin";
//		String pw = "22";
		
		// id & pw가 null이 될 수 없다 -> loginForm에서 "required" 속성을 지녔기에
		String id = request.getParameter("userName");
		String pw = request.getParameter("pw");
		String chk = request.getParameter("checker");
		String compareId = "";
		String comparePwd = "";

		UserDAO udao = UserDAO.getInstance(); // UserDAO 객체를 만든다.
        User user = udao.selectUser(id); // id와 일치하는 user_id를 가진 정보를 DB에서 받아온다.
        if(user!=null) {
        	compareId = user.getUserId();
        	comparePwd = user.getPassword();
        }
		
		if(user!=null && id.equals(compareId) && pw.equals(comparePwd)) {
			// DB에서 정보를 가져왔고, 해당 정보와 id & pw가 일치하는 경우
			session.setAttribute("id", id);

			// 만약 index.jsp에서 "board" 버튼을 눌러서 loginForm으로 넘어간 것이라면, loginFrom 쿠키가 있을 것이다
				// loginFrom 쿠키가 있으면 board.jsp로 가도록 한다.
			boolean flag = false;
			String addr = "";
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0) {
				for(int i = 0; i < cookies.length; i++) {
					if(cookies[i].getName().equals("msg") ||
							cookies[i].getName().equals("loginFrom") || cookies[i].getName().equals("userName")) {
						if(cookies[i].getName().equals("loginFrom")) {
							addr = cookies[i].getValue();
							flag = true;
						}
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
					}
				}
			}
			if(flag == true)
				response.sendRedirect("/" + addr);
			else
				// loginFrom 쿠키가 없으면 index.jsp(메인페이지)로 가도록 한다.
				response.sendRedirect("/");
		} else { // DB에서 정보를 가져오지 못했거나 (user==null) DB에서 정보를 가져왔으나 해당 정보와 id & pw가 일치하지 않을 경우
			if(chk!=null && chk.equals("on")) {
				Cookie cookie = new Cookie("userName", URLEncoder.encode(id, "utf-8"));
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("userName", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		
		Cookie cookie = new Cookie("msg", URLEncoder.encode("<script>alert(\"아이디 또는 비밀번호를 잘못 입력했습니다.\");</script>", "utf-8"));
		response.addCookie(cookie);

		response.sendRedirect("/loginExercise/loginForm04_cookies.jsp");
		// forward로는 cookie가 보내지지만 자동으로 로딩되지 않는다 (내가 새로고침해야 된다) -> redirect 사용할 것!
//		RequestDispatcher reqDis = request.getRequestDispatcher("/Haven/loginForm_DB_connect.jsp");
//		reqDis.forward(request, response);
		}
	} // doGet() 끝.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 요청이 GET 요청과 동일하게 처리되는 경우.
		// doPost()를 작성하는 대신, doGet()을 호출한다.
		doGet(request, response);
	} // doPost() 끝.
}