package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbcexam.dao.ToDoListDao;

/**
 * Servlet implementation class ToDoListServlet
 */
@WebServlet("/todolists")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		//response.setContentType("application/json");
		response.setContentType("text/html; charset=utf-8");
		
	    ToDoListDao ToDoDao = new ToDoListDao();
	       
	    long millis = System.currentTimeMillis();
	    Date date = new Date(millis);
	    
	    String w1 = request.getParameter("WhatWork_id");
	    String w2 = request.getParameter("WhoWork_id");
	    System.out.println(w1 + "," + w2);
	    //int result = ToDoDao.addToDo(11, date, "Working22", "kim22", 1);
	    int result = ToDoDao.addToDo(18, date, w1, w2, 1);
	    System.out.println(result);
	}

}
