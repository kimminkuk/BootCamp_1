package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	
	private static String dburl  = "jdbc:mysql://localhost:3306/connectdb";
	//private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser3";
	private static String dbpassword = "connect123!@#";
		
	public int addRole(Integer roleId, String description) {
		int insertCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			String sql = "INSERT INTO role (role_id, description) VALUES(? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			ps.setString(2, description);
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
	
	public List<Role> getRoles() {
	    List<Role> list = new ArrayList<>();
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    int roleId = 0;
	    String description = "";
	    String sql = "SELECT description, role_id FROM role order by role_id desc";
	    
	    try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
	    	 PreparedStatement ps = conn.prepareStatement(sql))
	    {
	    	try(ResultSet rs = ps.executeQuery()) {
	            while(rs.next()) {
	            	description = rs.getString(1);
	            	roleId = rs.getInt("role_id");
	            	Role role = new Role(roleId, description);
	            	list.add(role);
	            }
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return list;
	}
	
    public Role getRole(Integer roleId) {
    	Role role = null;
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		System.out.println("get2?");
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		//Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
    		String sql = "SELECT description, role_id FROM role WHERE role_id = ?";
    		ps = conn.prepareStatement(sql);
    		ps.setInt(1, roleId);
    		rs = ps.executeQuery();
    		
    		if(rs.next()) {
    			String description = rs.getString(1);
    			int id = rs.getInt("role_id");
    			role = new Role(id, description);
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		if(rs != null) {
    			try {
    				rs.close();
    			} catch(SQLException e) {
    				e.printStackTrace();
    			}
    		}
    		if(conn != null) {
    			try {
    				conn.close();
    			} catch(SQLException e) {
    				e.printStackTrace();
    			}
    		}
    		if(ps != null) {
    			try {
    				ps.close();
    			} catch(SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	
    	
    	return role;
    }
}
