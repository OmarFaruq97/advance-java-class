package Self.ExceptionHandaling;
import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your age: ");
        int age = scanner.nextInt();
        if (age<18){
            throw new RuntimeException("Sorry your must age 18");
        }else {
            System.out.println("You have been successfully registered");
        }

        scanner.close();
    }

}
