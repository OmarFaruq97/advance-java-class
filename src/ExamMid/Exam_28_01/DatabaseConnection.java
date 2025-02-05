package ExamMid.Exam_28_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    private static final String URL = "jdbc:postgresql://localhost:5432/DemoDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";


    public static Connection getPostgresConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
