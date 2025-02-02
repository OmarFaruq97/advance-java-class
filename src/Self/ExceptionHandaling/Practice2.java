package Self.ExceptionHandaling;

public class Practice2 {
    public static void main(String[] args) {

        int arr[] = new int[5];
//        multiple catch block handling
        try {
            arr[6] = 10;
            System.out.println(arr);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
