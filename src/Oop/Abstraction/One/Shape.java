package Oop.Abstraction.One;

public abstract class Shape {

    double dimOne,dimTwo;

    Shape(double dimOne, double dimTwo){
        this.dimOne = dimOne;
        this.dimTwo = dimTwo;
    }
    abstract void area();
}
