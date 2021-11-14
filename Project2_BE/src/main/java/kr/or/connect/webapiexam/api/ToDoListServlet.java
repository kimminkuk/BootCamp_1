package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.ToDoListDao;
import kr.or.connect.jdbcexam.dto.ToDoList;

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
		/*
		 * // TODO Auto-generated method stub response.setCharacterEncoding("utf-8");
		 * //response.setContentType("application/json");
		 * response.setContentType("text/html; charset=utf-8");
		 * 
		 * ToDoListDao ToDoDao = new ToDoListDao();
		 * 
		 * long millis = System.currentTimeMillis(); long t = System.nanoTime(); Date
		 * date = new Date(millis); Date date2 = new Date(t);
		 * 
		 * String w1 = request.getParameter("WhatWork_name"); String w2 =
		 * request.getParameter("WhoWork_name"); String w3 =
		 * request.getParameter("PriorityBtn_name"); System.out.println(date+"," + date2
		 * + "," + w1 + "," + w2 + ", rad: " + w3); int PriorityBtnValue =
		 * Integer.parseInt(w3); //int result = ToDoDao.addToDo(11, date, "Working22",
		 * "kim22", 1); int result = ToDoDao.addToDo(20, date, w1, w2,
		 * PriorityBtnValue); System.out.println(result);
		 */
		
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf8");
	    response.setCharacterEncoding("utf8");
	    
	    ToDoListDao ToDoDao = new ToDoListDao();
		long millis = System.currentTimeMillis(); 
		Date date = new Date(millis); 
		String w1 = request.getParameter("WhatWork_name"); 
		String w2 = request.getParameter("WhoWork_name"); 
		String w3 = request.getParameter("PriorityBtn_name"); 
		Integer w3_int = Integer.parseInt(w3);
		int result = ToDoDao.addToDoAuto(date, w1, w2, w3_int );
		System.out.println("result:"+result+" Who:"+w2);
	}

}
