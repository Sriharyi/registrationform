package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/registration";
            String username = "root";
            String password = "karpagam17";
            connection = DriverManager.getConnection(url, username, password);
            return connection;
    }
}
