package Oop.Abstraction.One;

public class Circle extends Shape{
    Circle(double radius) {
        super(radius,radius);
    }

    @Override
    void area() {
        double result = Math.PI *dimOne*dimTwo;
        System.out.println("Circle area: "+ result);
    }
}
