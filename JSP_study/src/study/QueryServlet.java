/* Shows on screen the id and pw parameters from the request,
 *     also shows the value of the count variable on this servlet file,
 *     IMPORTANT a servlet is reused, meaning the value of count is NOT reinitialized!
 */

package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // 인스턴스 변수 (iv) 선언
    int count = 0;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 시 넘어온 값을 읽는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 응답을 작성한다.
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <h1>Hello, "+id+".</h1>");
		out.println("    <h1>Your password is "+pw+".</h1>");
		out.println("    <h1>The count is "+ ++count +".</h1>");
			// servlet은 1회용이 아니다! 그렇기 때문에 iv인 count가 초기화되지 않는다!
				// servlet에서는 iv 사용하지 말고 lv 쓰거나, iv 쓰더라도 동기화처리가 필수!
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); 
	}

}
