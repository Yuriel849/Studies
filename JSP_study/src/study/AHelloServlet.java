/* The first simple servlet, to show how servlets work.
 */

package study;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name="/HelloServlet", urlPatterns= {"/hello", "*.do", "/login/*"})
public class AHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AHelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>");
//		out.println("Hello!!!");
//		out.println("</h1>");
//		out.println("</body>");
//		out.println("</html>");
		
//		out.println("<!DOCTYPE html>");
//		out.println("<html lang=\"en\">");
//		out.println("<head>");
//		out.println("    <meta charset=\"UTF-8\">");
//		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//		out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
//		out.println("    <title>Document</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("    <h1>Hello</h1>");
//		out.println("</body>");
//		out.println("</html>");
		
		out.println("<!DOCTYPE html>");
				out.println("<html lang=\"en\">");
				out.println("<head>");
				out.println("    <meta charset=\"UTF-8\">");
				out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
				out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
				out.println("    <title>Document</title>");
				out.println("");
				out.println("    <style>");
				out.println("        /* 하나의 HTML 문서 내에서 ID는 하나만 존재해야 한다. */");
				out.println("        #second { /* id=\"second */");
				out.println("            color: blue;");
				out.println("        }");
				out.println("        /* 하나의 HTML 문서에서 class는 여러개 존재해도 된다. */");
				out.println("        .odd { /* class=\"odd\" */");
				out.println("            color: brown;");
				out.println("        }");
				out.println("");
				out.println("        .yellowBack {");
				out.println("            background-color: green;");
				out.println("        }");
				out.println("    </style>");
				out.println("</head>");
				out.println("<body>");
				out.println("    <!-- h1{Hello$}*10 -->");
				out.println("    <h1>Hello1</h1>");
				out.println("    <h1 id=\"second\">Hello2</h1>");
				out.println("    <h1>Hello3</h1>");
				out.println("    <h1>Hello4</h1>");
				out.println("    <h1 class=\"odd yellowBack\">Hello5</h1> <!-- 여러개의 클래스를 동시에 적용할 수 있다 -> 단, 이러면 클래스 명을 공백으로 구분한다. -->");
				out.println("    <h1 class=\"yellowBack\">Hello6</h1>");
				out.println("    <h1 class=\"odd\">Hello7</h1>");
				out.println("    <h1>Hello8</h1>");
				out.println("    <h1 class=\"odd\">Hello9</h1>");
				out.println("    <h1>Hello10</h1>");
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
