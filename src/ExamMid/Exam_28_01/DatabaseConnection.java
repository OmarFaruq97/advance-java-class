package ExamMid.Exam_28_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    private static final String URL = "jdbc:postgresql://localhost:5432/MyDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1245";


    public static Connection getPostgresConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
