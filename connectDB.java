import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    public Connection get_db() {
        Connection con = null;
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Replace with your actual URL, username, and password
            String url = "jdbc:postgresql://localhost:5432/Testdb";
            String user = "yourUsername";
            String password = "yourPassword";

            // Establish connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        connectDB db = new connectDB();
        Connection con = db.get_db();
        if (con == null) {
            System.out.println("Not Connected");
        }
    }
}
