package LibraryManagment;

import java.sql.*;
import java.util.Scanner;

import static LibraryManagment.LibrarySystem.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            // Connection to the PostgreSQL database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL database.");

            while (true) {
                System.out.println("\nWelcome to the Library System:");
                System.out.println("1. List of books");
                System.out.println("2. Borrow a book");
                System.out.println("3. Return a book");
                System.out.println("4. Terminate the program");

                System.out.print("======Choose an option======: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        listBooks(conn);
                        break;
                    case 2:
                        borrowBook(scanner, conn);
                        break;
                    case 3:
                        returnBook(scanner, conn);
                        break;
                    case 4:
                        System.out.println("Terminating the program...");
                        return; // Exit the program
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void listBooks(Connection conn) {
        String query = "SELECT * FROM books";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\nList of Books:");
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Year: " + rs.getInt("year"));
                System.out.println("Number of pages: " + rs.getInt("pageNumber"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Is borrowed: " + rs.getBoolean("isBorrewed"));
                System.out.println("*********************");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void borrowBook(Scanner scanner, Connection conn) {
        System.out.print("Enter the book name: ");
        String title = scanner.nextLine();

        String query = "SELECT * FROM books WHERE title = ? AND isBorrewed = false";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE books SET isBorrewed = true WHERE title = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, title);
                    updateStmt.executeUpdate();
                    System.out.println("You borrowed the book: " + title);
                }
            } else {
                System.out.println("Sorry, the book '" + title + "' is not available for borrowing at this time.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void returnBook(Scanner scanner, Connection conn) {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();

        String query = "SELECT * FROM books WHERE title = ? AND isBorrewed = true";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE books SET isBorrewed = false WHERE title = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, title);
                    updateStmt.executeUpdate();
                    System.out.println("Thanks for returning the book: " + title);
                }
            } else {
                System.out.println("This book was not borrowed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}