package Oop.PolyMorphism.Two;

public class Car {

    public void carDetails(String name) {
        System.out.println("Car Name: " + name);
    }

    //Method must be different parameter. If parameter same it will error
    public void carDetails(int model) {
        System.out.println("Car Model: " + model);
    }

    //        Method overloading
    public void carDetails(double price) {
        System.out.println("Car Price: " + price);
    }

    public void carDetails(boolean isRun) {
        System.out.println("The car is running " + isRun);
    }
}
