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

@WebServlet("/update")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	private Connection con;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dateofbirth = request.getParameter("dateofbirth");
		String role = request.getParameter("role");
		String phonenumber = request.getParameter("phonenumber");
		 try {
				con=ConnectionUtil.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		 System.out.println(con);
	        userService = new UserService(con);
	        boolean success=false;
			try {
				success = userService.updateUser(id,name, email, gender, dateofbirth, role, phonenumber);
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
