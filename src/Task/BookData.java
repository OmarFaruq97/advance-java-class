package Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BookData {
    private static final String URL = "jdbc:postgresql://localhost:5432/MyDB"; // Replace with your DB URL
    private static final String USER = "postgres"; // Replace with your DB username
    private static final String PASSWORD = "1245"; // Replace with your DB password

    public void insertDummyData(String[][] BookData) {
        String insertQuery = "INSERT INTO BookData (Name, Author, Type, Price, Date) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (String[] bookData : BookData) {
                preparedStatement.setString(1, bookData[0]); // Name
                preparedStatement.setString(2, bookData[1]); //Author
                preparedStatement.setString(3, bookData[2]); // Type
                preparedStatement.setDouble(4, Double.parseDouble(bookData[3])); // Price Parse the string to a double
                preparedStatement.setDate(5, java.sql.Date.valueOf(bookData[4])); // Parse the date string



                preparedStatement.addBatch(); // Add to batch for batch execution
            }

            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }
}
