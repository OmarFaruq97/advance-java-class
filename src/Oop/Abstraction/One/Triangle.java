package Oop.Abstraction.One;

public class Triangle extends Shape{
    Triangle(double dimOne, double dimTwo) {
        super(dimOne, dimTwo);
    }

    @Override
    void area() {
        double result = .5* dimOne*dimTwo;
        System.out.println("Triangle area: "+result);
    }
}
