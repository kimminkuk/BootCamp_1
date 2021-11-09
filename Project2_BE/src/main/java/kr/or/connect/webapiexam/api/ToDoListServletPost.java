package kr.or.connect.webapiexam.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbcexam.dao.ToDoListDao;
import kr.or.connect.jdbcexam.dto.ToDoList;

/**
 * Servlet implementation class ToDoListServletPost
 */
@WebServlet("/todolistpost")
public class ToDoListServletPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoListServletPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		System.out.println("heelo\n");
		String pathInfo = request.getPathInfo(); //todolistpost/{?}
		String[] pathParts = pathInfo.split("/");
		
		ToDoListDao dao = new ToDoListDao();
		
		
		
		//dao.addToDo(null, null, getServletName(), getServletInfo(), null)
	}
    
	
}
