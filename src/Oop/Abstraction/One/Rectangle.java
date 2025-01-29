package Oop.Abstraction.One;

public class Rectangle extends Shape{

    Rectangle(double dimOne, double dimTwo){
        super(dimOne,dimTwo);
    }

    @Override
    void area() {
        double result = dimOne*dimTwo;
        System.out.println("Rectangle area: " + result);
    }
}
