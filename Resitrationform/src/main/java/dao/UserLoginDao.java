package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modal.User;

public class UserLoginDao {
    
    private Connection connection;
    
    public UserLoginDao(Connection connection) {
        this.connection = connection;
    }
    
    public boolean addUser(User user) throws SQLException {
        PreparedStatement stmt = null;
        boolean result=false;
        try {
            String sql = "INSERT INTO users (name, email, gender, dateofbirth, role, phonenumber) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getGender());
            stmt.setString(4, user.getDateofbirth());
            stmt.setString(5, user.getRole());
            stmt.setString(6, user.getPhonenumber());
            result= stmt.execute();
            int rowCount = stmt.getUpdateCount();
            if (rowCount == 0) {
                System.out.println("Insert failed");
            } else {
                System.out.println("Insert successful, " + rowCount + " rows affected");
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

	public List<User> getUser() throws SQLException {
		 PreparedStatement stmt = null;
	     List<User> users = null;
	     try {
	    	String sql = "select * from users";
	    	stmt = connection.prepareStatement(sql);
	    	ResultSet r =  stmt.executeQuery();
	    	users = new LinkedList<>();
	    	while(r.next())
	    	{
	    		User user = new User();
	    		user.setId(r.getInt(1));
	    		user.setName(r.getString(2));
	    		user.setEmail(r.getString(3));
	    		user.setGender(r.getString(4));
	    		user.setDateofbirth(r.getString(5));
	    		user.setRole(r.getString(6));
	    		user.setPhonenumber(r.getString(7));
	    		users.add(user);
	    	}
	     }catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     return users;
		
	}

	public User editUser(int id) throws SQLException {
		PreparedStatement stmt = null;
		User user = new User();
	     try {
	    	String sql = "SELECT * FROM users WHERE id=?";
	    	stmt = connection.prepareStatement(sql);
	    	stmt.setInt(1, id);
	    	ResultSet r =  stmt.executeQuery();
	    	while(r.next())
	    	{
	    		user.setId(r.getInt(1));
	    		user.setName(r.getString(2));
	    		user.setEmail(r.getString(3));
	    		user.setGender(r.getString(4));
	    		user.setDateofbirth(r.getString(5));
	    		user.setRole(r.getString(6));
	    		user.setPhonenumber(r.getString(7));
	    		
	    	}
	     }catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     return user;
	}
}
