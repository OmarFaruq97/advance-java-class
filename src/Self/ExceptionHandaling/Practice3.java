package Self.ExceptionHandaling;

public class Practice3 {
    public static void main(String[] args) {
        int arr[] = new int[5];

        try {   //  outer try block
            try {   // Inner try block
                arr[6] = 0;   // This will throw ArrayIndexOutOfBoundsException
                System.out.println(arr);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner Catch: " + e.getMessage());
            }
            double result = 10 / 0;    // This will throw ArithmeticException
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Outer Catch: " + e.getMessage());

        }
    }
}
