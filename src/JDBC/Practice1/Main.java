package JDBC.Practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/DemoDB";
    private static final String UserName = "postgres";
    private static final String Password = "1234";

    public static void main(String[] args) {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        try {
            Connection connection = DriverManager.getConnection(URL, UserName, Password);
            Statement statement = connection.createStatement();
            String query = "select * from student ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("ID: " + id);
                System.out.println("NAME: " + name);
                System.out.println("AGE: " + age);
                System.out.println("MARKS : " + marks);
                System.out.println("------------------");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
