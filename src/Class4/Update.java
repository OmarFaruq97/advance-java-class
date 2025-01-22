package Class4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    private static final String URL = "jdbc:postgresql://localhost:5432/MyDB"; // Replace with your DB URL
    private static final String USER = "postgres"; // Replace with your DB username
    private static final String PASSWORD = "1245"; // Replace with your DB password

    // Update student data by id
    public void updateStudentData() {
        String updateQuery = "UPDATE STUDENTJDBC SET name = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, "Mbappe"); // Set the new name
            preparedStatement.setInt(2, 2);
            preparedStatement.setString(1, "Messi");
            preparedStatement.setInt(2, 3);
            // Set the id of the student to update

            int rowsUpdated = preparedStatement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("Student with ID " + id + " updated successfully.");
//            } else {
//                System.out.println("No student found with ID " + id);
//            }
            System.out.println(rowsUpdated+" row updated");
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }
    }
}