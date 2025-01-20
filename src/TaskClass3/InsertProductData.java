package TaskClass3;import java.io.*;
import java.sql.*;
import java.util.*;

class fileReaderExample {

    // Database credentials
    private static final String URL = "jdbc:postgresql://localhost:5432/MyDB"; // Change this to your DB URL
    private static final String USER = "postgre"; // Change this to your DB username
    private static final String PASSWORD = "1245"; // Change this to your DB password


    // Transaction data class
    static class Transaction {
        private int id;
        private String name;
        private String buyer;
        private String seller;
        private double price;
        private String buyDate;
        private String sellDate;

        public Transaction(int id, String name, String buyer, String seller, double price, String buyDate, String sellDate) {
            this.id = id;
            this.name = name;
            this.buyer = buyer;
            this.seller = seller;
            this.price = price;
            this.buyDate = buyDate;
            this.sellDate = sellDate;
        }

        @Override
        public String toString() {
            return "Transaction{id=" + id + ", name='" + name + "', buyer='" + buyer + "', seller='" + seller + "', price=" + price + ", buyDate='" + buyDate + "', sellDate='" + sellDate + "'}";
        }
    }

    // Step 1: Read data from the CSV file
    private static List<Transaction> readDataFromFile(String inputFile) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;

        // Skip the header line
        br.readLine();

        // Read the data lines
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length == 7) {
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                String buyer = values[2];
                String seller = values[3];
                double price = Double.parseDouble(values[4]);
                String buyDate = values[5];
                String sellDate = values[6];

                // Create and add Transaction object to the list
                transactions.add(new Transaction(id, name, buyer, seller, price, buyDate, sellDate));
            }
        }
        br.close();
        return transactions;
    }

    // Step 2: Insert data into PostgreSQL database
    private static void insertDataToDatabase(List<Transaction> transactions) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // SQL insert statement
        String insertSQL = "INSERT INTO transactions (id, name, buyer, seller, price, buy_date, sell_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(insertSQL)) {
            for (Transaction transaction : transactions) {
                pst.setInt(1, transaction.id); // ID
                pst.setString(2, transaction.name); // Name
                pst.setString(3, transaction.buyer); // Buyer
                pst.setString(4, transaction.seller); // Seller
                pst.setDouble(5, transaction.price); // Price
                pst.setString(6, transaction.buyDate); // Buy Date
                pst.setString(7, transaction.sellDate); // Sell Date
                pst.addBatch(); // Add to batch
            }

            // Execute the batch insert
            pst.executeBatch();
        } finally {
            connection.close();
        }
    }
}
