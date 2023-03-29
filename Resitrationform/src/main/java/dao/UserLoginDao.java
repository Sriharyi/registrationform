package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.User;

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
	     boolean result=false;
	     List<User> users = null;
	     try {
	    	String sql = "select * from users";
	    	stmt = connection.prepareStatement(sql);
	    	ResultSet r =  stmt.executeQuery();
	    	int id = 0;
	    	users = new LinkedList<>();
	    	while(r.next())
	    	{
	    		User user = new User();
	    		user.setId(id++);
	    		user.setName(r.getString(1));
	    		user.setEmail(r.getString(2));
	    		user.setGender(r.getString(3));
	    		user.setDateofbirth(r.getString(4));
	    		user.setRole(r.getString(5));
	    		user.setPhonenumber(r.getString(6));
	    		users.add(user);
	    	}
	     }catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     return users;
		
	}
}
