package kr.or.connect.BE2;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       RoleDao dao = new RoleDao();
       Role role = dao.getRole(100);
       System.out.println(role);
	}

}
