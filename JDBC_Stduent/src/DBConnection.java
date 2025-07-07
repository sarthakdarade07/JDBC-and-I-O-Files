import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection con;
        String host="jdbc:mysql://localhost:3306/Student";
        String username="root";
        String password="";
        try {
            con= DriverManager.getConnection(host,username,password);
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
