package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.or.connect.jdbcexam.dto.ToDoList;

public class ToDoListDao {
	private static String dburl  = "jdbc:mysql://localhost:3306/BE2";
	private static String dbUser = "BE2_WORKSHEET";
	private static String dbpassword = "connect123"; 
	
	public int addToDo(Integer toDoId, Date toDoDate, String toDoWork, String toDoWho,Integer toDoPriority) {
		int insertCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,dbUser, dbpassword);
			String sql = "INSERT INTO TODOLIST2 ( tl_num, tl_date, tl_work, tl_who, tl_priority) "
					+ "VALUES ( ?, now(), ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, toDoId);
			ps.setString(2,toDoWork );
			ps.setString(3, toDoWho);
			ps.setInt(4,  toDoPriority);
			rs = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs == 2) {
			    System.out.println("Update Query Error");
			} else {
				System.out.println("Update Query OK");
			}
			if (ps != null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return rs;
	}
}
