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
 * Servlet implementation class MoveToDoing
 */
@WebServlet("/movetodoing")
public class MoveToDoing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveToDoing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ToDoListDao ToDoDao = new ToDoListDao();
		List<ToDoList> list = new ArrayList<>();
		list.add(ToDoDao.getToDoList(10));
		
		request.setAttribute("movetodoinglist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/main1.jsp");
		rd.forward(request, response);
		System.out.println("movetodoing here");
	}
}
