package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.UserLoginDao;
import dao.UserUpdateDao;
import modal.User;

public class UserService {
    
    private UserLoginDao userLoginDao;
    private UserUpdateDao userUpdateDao;
    
    public UserService(Connection connection) {
        userLoginDao = new UserLoginDao(connection);
        userUpdateDao = new UserUpdateDao(connection);
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
	public User getuser(String id) throws NumberFormatException, SQLException {
		System.out.println(id);
		return userLoginDao.editUser(Integer.parseInt(id));
	}
	public boolean updateUser(String id,String name, String email, String gender, String dateofbirth, String role,
			String phonenumber) throws SQLException {
		User user = new User();
		user.setId(Integer.parseInt(id));
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setDateofbirth(dateofbirth);
        user.setRole(role);
        user.setPhonenumber(phonenumber);
		return userUpdateDao.updateUser(user);
	}
}

