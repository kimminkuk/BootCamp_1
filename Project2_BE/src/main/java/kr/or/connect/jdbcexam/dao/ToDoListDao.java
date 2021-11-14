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
	
	public int addToDoAuto(Date toDoDate, String toDoWork, String toDoWho,Integer toDoPriority) {
		int insertCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,dbUser, dbpassword);
			String sql = "INSERT INTO TODOLIST2 ( tl_date, tl_work, tl_who, tl_priority)"
					+ "VALUES ( now(), ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1,toDoWork );
			ps.setString(2, toDoWho);
			ps.setInt(3,  toDoPriority);
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

    public List<ToDoList> getAllToDoLists() {
    	List<ToDoList> list = new ArrayList<>();
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException el) {
    		el.printStackTrace();
    	}
    	
    	int todolistId = 0;
    	String sql = "SELECT tl_num, tl_date, tl_work, tl_who, tl_priority from TODOLIST2 order by tl_num desc";
    	
    	try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
    		 PreparedStatement ps = conn.prepareStatement(sql))
    	{
    		try(ResultSet rs = ps.executeQuery()) {
    			while(rs.next()) {
       				Date todolist_date = rs.getDate(2);
       				String todolist_work = rs.getString(3);
       				String todolist_who = rs.getString(4);
       				int todolist_prio = rs.getInt(5);
       				todolistId = rs.getInt("tl_num");
       				
       				ToDoList todolist = new ToDoList(todolistId, todolist_date, todolist_work, todolist_who, todolist_prio);
    			    list.add(todolist);
    			}
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    public ToDoList getToDoList(Integer ToDoId) {
    	ToDoList todolist = null;
    	String sql = "SELECT tl_num, tl_date, tl_work, tl_who, tl_priority from TODOLIST2 WHERE tl_num = ?";
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException el) {
    		el.printStackTrace();
    	}
    	
    	try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
       		 PreparedStatement ps = conn.prepareStatement(sql))
       	{
    		ps.setInt(1, ToDoId);
       		try(ResultSet rs = ps.executeQuery()) {
       			if(rs.next()) {
       				Date todolist_date = rs.getDate(2);
       				String todolist_work = rs.getString(3);
       				String todolist_who = rs.getString(4);
       				int todolist_prio = rs.getInt(5);
       				
       				int id = rs.getInt("tl_num");
       				todolist = new ToDoList(id, todolist_date, todolist_work, todolist_who, todolist_prio );
       			}
       		} catch(Exception e) {
       			e.printStackTrace();
       		}
       	} catch(Exception e) {
       		e.printStackTrace();
       	}
    	return todolist;
    }
    
    public int getToDoIdCount() {
    	ToDoList todolist = null;
    	int num = 0;
    	String sql = "SELECT COUNT(tl_num) FROM TODOLIST2";
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException el) {
    		el.printStackTrace();
    	}
    	
    	try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
       		 PreparedStatement ps = conn.prepareStatement(sql))
       	{
       		try(ResultSet rs = ps.executeQuery()) {
       			if(rs.next()) {
       				num = rs.getInt(1);
       			}
       		} catch(Exception e) {
       			e.printStackTrace();
       		}
       	} catch(Exception e) {
       		e.printStackTrace();
       	}
    	return num;
    }
    
}
