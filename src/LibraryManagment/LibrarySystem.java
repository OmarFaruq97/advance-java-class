package LibraryManagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibrarySystem {

    static final String URL = "jdbc:postgresql://localhost:5432/DemoDB";
    static final String USER = "postgres";
    static final String PASSWORD = "1234";

    public void insertDummyData(String[][] Books) {
        String insertQuery = "INSERT INTO Books (title, author, year, page, price, isBorrowed) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

//            for (String[] books : Books) {
//                preparedStatement.setString(1, books[0]); // title
//                preparedStatement.setString(2, books[1]); // author
//                preparedStatement.setInt(3, Integer.parseInt(books[2])); // year
//                preparedStatement.setInt(4, Integer.parseInt(books[3])); //pagesNumber
//                preparedStatement.setInt(5, Integer.parseInt(books[4])); //price
//                preparedStatement.setBoolean(6, Boolean.parseBoolean(books[5])); //isAvailable
//
//                preparedStatement.addBatch();
//            }

            int[] rowsInserted = preparedStatement.executeBatch();

        } catch (SQLException e) {
           System.err.println("Error inserting data: " + e.getMessage());
        }
    }
}