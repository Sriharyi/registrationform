package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modal.User;

public class UserUpdateDao {
	private Connection connection;
	public UserUpdateDao(Connection connection) {
		 this.connection = connection;
	}
	public boolean updateUser(User user) throws SQLException {
		 PreparedStatement stmt = null;
	        boolean result=false;
	        try {
	            String sql = "UPDATE users SET name=?, email=?, gender=?, dateofbirth=?, role=?, phonenumber=? WHERE id=?";
	            stmt = connection.prepareStatement(sql);
	            stmt.setString(1, user.getName());
	            stmt.setString(2, user.getEmail());
	            stmt.setString(3, user.getGender());
	            stmt.setString(4, user.getDateofbirth());
	            stmt.setString(5, user.getRole());
	            stmt.setString(6, user.getPhonenumber());
	            stmt.setInt(7,user.getId());
	            int rowCount  = stmt.executeUpdate();
	            if (rowCount == 0) {
	                System.out.println("update failed");
	            } else {
	                System.out.println("update successful, " + rowCount + " rows affected");
	                result=!result;
	            }  
	        }
	            finally {
	            if (stmt != null) {
	                stmt.close();
	            }
	        }
	        return result;
	}

}
