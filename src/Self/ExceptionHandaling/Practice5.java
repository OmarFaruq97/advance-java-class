package Self.ExceptionHandaling;

public class Practice5 {
    public static void divisionDemo(int dividend,int divisor) throws ArithmeticException {
        System.out.println("The result is :" + dividend / divisor);
    }
        public static void main(String[] args) throws Exception {
        divisionDemo(10,0);
        }
    }

