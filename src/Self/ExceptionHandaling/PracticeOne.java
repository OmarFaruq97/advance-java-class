package Self.ExceptionHandaling;
import java.util.Scanner;

public class PracticeOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Exception Handling");

        System.out.print("Dividend number: ");
        int dividend = scanner.nextInt();

        System.out.print("Divisor number: ");
        int divisor = scanner.nextInt();

        try {
            int result = dividend / divisor;
            System.out.println("Your result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Divisor can't be '0' ");
        }
        scanner.close();
    }
}
