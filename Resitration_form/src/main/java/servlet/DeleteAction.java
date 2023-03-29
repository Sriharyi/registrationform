package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import util.ConnectionUtil;

/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/DeleteAction")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	private Connection con;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("inside delete action");
		 try {
				con=ConnectionUtil.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
	        System.out.println(con);
	       boolean success = false;
			try {
					userService = new UserService(con);
			       success = userService.removeuser(id);
			        con.close();
			} catch (SQLException e) {
				e.printStackTrace();     
			}
			if(success)
			{
				response.sendRedirect("registrationRecords.jsp");
			}
	}

}
