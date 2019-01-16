/* A basic servlet for processing logins,
 *     connects to WebContent > loginExercise > loginForm.jsp
 */

package login;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 시 넘어온 값을 읽는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if((id!=null) && (pw!=null) && id.equals("asdf") && pw.equals("1234")) {
			// id & pw가 일치하는 경우
			response.sendRedirect("/");
		} else {
			// id & pw가 일치하지 않는 경우
			request.setAttribute("msg", "아이디 또는 비밀번호가 틀립니다."); // request 객체에 메시지를 저장
			
			RequestDispatcher reqDis = request.getRequestDispatcher("/loginExercise/loginForm.jsp");
			reqDis.forward(request,  response);
		}
			
		// 응답을 작성한다.
//		PrintWriter out = response.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html lang=\"en\">");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>Hello, "+id+".</h1>");
//		out.println("<h1>Your password is "+pw+".</h1>");
//		out.println("</body>");
//		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
