package kr.or.connect.TODO.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.ToDoListDao;
import kr.or.connect.jdbcexam.dto.ToDoList;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/logic")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		ToDoListDao ToDoDao = new ToDoListDao();
		List<ToDoList> list = new ArrayList<>();
		list = ToDoDao.getAllToDoLists();

		
		List<ToDoList> list2 = new ArrayList<>();
		  
		//String w1 = request.getParameter("move_1");
		Integer w1_int = 0;
/*		
		try { 
			w1_int = Integer.parseInt(w1); 
	    } catch (IllegalArgumentException e) {
		    System.out.println("IllegalArgumentException error"); 
		}
 
		if (w1_int == 0) { 
			list2.add(ToDoDao.getToDoList(9));
			String w2 = list2.get(0).getToDoWork();
		    request.setAttribute("ori_list2", list2); 
		    System.out.println("move_1 ok" + "Work: " + w2 ); 
		}
*/
		ObjectMapper ob = new ObjectMapper();
		String json = ob.writeValueAsString(list);
		request.setAttribute("ori_list", list);
		System.out.println("LogicServlet ok");

		RequestDispatcher rd = request.getRequestDispatcher("/main1.jsp");
		rd.forward(request, response);
	}
}
