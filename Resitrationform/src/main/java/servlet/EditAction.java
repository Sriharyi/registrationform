package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modal.User;
import service.UserService;
import util.ConnectionUtil;


@WebServlet("/EditAction")
public class EditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private Connection con;
	private User user;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		 try {
				con=ConnectionUtil.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
	        System.out.println(con);
	       
			try {
					userService = new UserService(con);
			        user = userService.getuser(id);
			        con.close();
			} catch (SQLException e) {
				e.printStackTrace();     
			}
			if(user!=null)
			{
				session.setAttribute("user", user);
				response.sendRedirect("editRecords.jsp");
			}
		
	}

}
