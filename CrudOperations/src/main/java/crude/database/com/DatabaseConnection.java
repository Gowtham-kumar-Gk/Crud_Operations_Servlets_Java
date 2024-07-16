package crude.database.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private static final java.lang.String URL = "jdbc:mysql://localhost:3306/ems";
    private static final java.lang.String USER = "root";
    private static final java.lang.String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
