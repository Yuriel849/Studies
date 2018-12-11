package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiceServlet
 */
@WebServlet("/DiceServlet")
public class DiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// JavaScript로 작성한 것!
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("    <div id=\"main\"></div>");
//		out.println("    <script>");
//		out.println("        var main = document.getElementById(\"main\");");
//		out.println("        var tmp = '';");
//		out.println("");
//		out.println("        for(var i = 0; i < 2; i++) {");
//		out.println("            var ran = Math.floor(Math.random() * 6) + 1;");
//		out.println("            tmp += '<img src=\"Dice/dice' + ran + '.jpg\">';");
//		out.println("        }");
//		out.println("            main.innerHTML = tmp;");
//		out.println("    </script>");
//		out.println("</body>");
//		out.println("</html>");
		
		// Java Servlet으로 작성한 것!
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
        out.println(".dice {");
        out.println("width: 150px;");
        out.println("height: 150px;");
    	out.println("</style>");	
    	out.println("</head>");
		out.println("<body>");
		int[] num = new int[4];
		int[] sum = new int[2];
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			num[i] = (int)(Math.random() * 6) + 1;
		}
		sum[0] = num[0] + num[1];
		sum[1] = num[2] + num[3];
		for(int i = 0; i < 4; i++) {
			out.println("<img src='Dice/dice" +num[i]+ ".jpg' class=\"dice\">");
			if(i==1 || i==3) {
				out.println("<br>");
				out.println("<h2>No." +(cnt+1)+ " player's score is... " +sum[cnt++]+ "</h2>");
			}			
		}
		out.println("<h2>The winner is the ");
		if(sum[0] > sum[1]) {
			out.println("1st");
		} else {
			out.println("2nd");
		}
		out.println("player.</h2>");
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
