package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.UserLoginDao;
import model.User;

public class UserService {
    
    private UserLoginDao userLoginDao;
    
    public UserService(Connection connection) {
        userLoginDao = new UserLoginDao(connection);
    }
    public boolean registerUser(String name, String email, String gender, String dateofbirth ,String role, String phonenumber) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setDateofbirth(dateofbirth);
        user.setRole(role);
        user.setPhonenumber(phonenumber);
       return userLoginDao.addUser(user);
    }
    
    public List<User> getUsers() throws SQLException {
		return userLoginDao.getUser();
    	
    }
}

