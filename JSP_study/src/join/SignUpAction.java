/* Receives data from the signUpForm.jsp and adds a new user to the DB,
 *     connects to WebContent > joinExercise > signUpForm.jsp & success.jsp
 */

package join;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignUpAction")
public class SignUpAction extends HttpServlet { // HttpServlet 상속
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// request를 디코딩할 때 UTF-8 사용하도록
		request.setCharacterEncoding("UTF-8");
		
		// SignUpForm에서 "required" 속성을 지녔기에 null체크 불필요
		String name = request.getParameter("userName");
		String id = request.getParameter("userID");
		String pwd = request.getParameter("userPwd");
		String SN = request.getParameter("userSN01") + request.getParameter("userSN02");
		String post = request.getParameter("userPost");
		String addr = request.getParameter("userAddr");
		String job = request.getParameter("userJob");
		String[] hobbies = request.getParameterValues("userHobby");
		String hobby = "";
		if(hobbies != null) {
			for(String str : hobbies) {
				hobby += str + " ";
			}			
		}
		String text = "";
		if(request.getParameter("userText") != null) {text = request.getParameter("userText");}
		
		// request로 값이 제대로 넘어왔는지 확인하는 코드
//		System.out.println(name);
//		System.out.println(id);
//		System.out.println(pwd);
//		System.out.println(SN);
//		System.out.println(post);
//		System.out.println(addr);
//		System.out.println(job);
//		for(String x : hobbies) {
//			System.out.println(x);
//		}
//		System.out.println(text);

		if(name == null || id == null || pwd == null || SN == null || post == null || addr == null || job == null || hobbies == null) {
			Cookie cookie = new Cookie("msg", URLEncoder.encode("<script>alert(\"입력이 안 된 사항이 있습니다.\");</script>", "utf-8"));
			response.addCookie(cookie);
			response.sendRedirect("/signUpForm.jsp");
		} else {
			User user = new User();
			user.setUserName(name);
			user.setUserID(id);
			user.setUserPwd(pwd);
			user.setUserSN(SN);
			user.setUserPost(post);
			user.setUserAddr(addr);
			user.setUserJob(job);
			user.setUserHobbies(hobby);
			user.setUserText(text);
			
			UserDAO udao = UserDAO.getInstance();
			int result = udao.join(user);
			if(result == -2) {
				Cookie cookie = new Cookie("msg", URLEncoder.encode("<script>alert(\"회원가입에 실패했습니다.\");</script>", "utf-8"));
				response.addCookie(cookie);
				response.sendRedirect("/joinExercise/signUpForm.jsp");
			} else { // 성공적으로 회원가입한 경우
				session.setAttribute("userID", user.getUserID());
				
				Cookie[] cookies = request.getCookies();
				if(cookies != null && cookies.length > 0) {
					for(int i = 0; i < cookies.length; i++) {
						if(cookies[i].getName().equals("msg")) {
							cookies[i].setMaxAge(0);
							response.addCookie(cookies[i]);
						}
					}
				}
				
				RequestDispatcher reqDis = request.getRequestDispatcher("/joinExercise/success.jsp");
				reqDis.forward(request, response);
			}		
		}
	} // doGet() 끝.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} // doPost() 끝.
}