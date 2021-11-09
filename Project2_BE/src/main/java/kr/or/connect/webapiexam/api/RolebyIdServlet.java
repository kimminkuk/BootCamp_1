package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

/**
 * Servlet implementation class RolebyIdServlet
 */
@WebServlet("/roles/*")
public class RolebyIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolebyIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		String pathInfo = request.getPathInfo(); // /roles/{roleId}
		String[] pathParts = pathInfo.split("/");
		String idStr = pathParts[1];
		
		int id = Integer.parseInt(idStr);
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(id);
		
		ObjectMapper ob = new ObjectMapper();
		String json = ob.writeValueAsString(role);
		
		PrintWriter out = response.getWriter();
		out.println(json);
		
		out.close();
	}
}
