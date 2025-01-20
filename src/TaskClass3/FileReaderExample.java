package TaskClass3;

import java.io.*;
import java.util.*;

public class FileReaderExample {

    public static void main(String[] args) {
        // Path to the CSV file
        String inputFile = "C:\\GIT\\advance-java-class\\src\\TaskClass3\\Information.csv"; // CSV file path

        try {
            // Step 1: Read data from the CSV file
            List<Transaction> transactions = readDataFromFile(inputFile);

            // Step 2: Print the data to verify
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}
