package TaskClass3;
import java.sql.*;
import java.util.List;

public class InsertData extends PSQL {

    public void insertAllProduct(List<String[]> product) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO Product (id, name, buyer, seller, price, buy_date, sell_date) values (?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'))";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (String[] row : product) {
                    preparedStatement.setInt(1, Integer.parseInt(row[0]));
                    preparedStatement.setString(2, row[1]);
                    preparedStatement.setString(3, row[2]);
                    preparedStatement.setString(4, row[3]);
                    preparedStatement.setDouble(5, Double.parseDouble(row[4]));
                    preparedStatement.setString(6, row[5]);
                    preparedStatement.setString(7, row[6]);
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Data insert into database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
