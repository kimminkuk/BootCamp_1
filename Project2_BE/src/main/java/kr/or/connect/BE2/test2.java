package kr.or.connect.BE2;

import java.sql.Date;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dao.ToDoListDao;
import kr.or.connect.jdbcexam.dto.Role;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ToDoListDao ToDoDao = new ToDoListDao();
       
       long millis = System.currentTimeMillis();
       Date date = new Date(millis);
       
       int result = ToDoDao.addToDo(4, date, "Working", "kim", 1);
       System.out.println(result);
	}

}
