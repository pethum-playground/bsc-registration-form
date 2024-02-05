import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }

        return instance;
    }

    //Make Connection Singleton
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/registration";
            String password = "mysql";
            String username = "root";

            if (this.connection == null) this.connection = DriverManager.getConnection(url, username, password);

            return this.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
