package testweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodayServlet
 */
@WebServlet("/aboutme/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		//Get Time Now
		Calendar c = Calendar.getInstance();
		int year   = c.get(Calendar.YEAR);
		int month  = c.get(Calendar.MONTH) + 1; //0->JANUARY
		int day    = c.get(Calendar.DATE);
		int hour   = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		PrintWriter out = response.getWriter();
		out.write("<HTML>");
		out.write("<HEAD>");
		out.println("<form method='post' action='file:///C:/Users/YIKC-16008/Desktop/test-node/project_1.html'");
		//out.println("url : <input type='submit' url='url'><br>");
		out.println("<input type='submit'><br>");
		out.println("<input type='submit' value='HOME'><br>");
		out.write("</HEAD>");

		out.write("<BODY>");
		out.write("<h1>NOW : " + year+"/" + month + "/" + day + " " + hour +":"+minute + "</h1>");
		out.write("</BODY>");
		out.write("</HTML>");
	    
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name"); 
	    out.println("<h1> hello " + name + "</h1>");
		out.close();
	}
}
