package Oop.PolyMorphism.Two;

public class Main {
    public static void main(String[] args) {
//        Compile time polymorphism & static binding &
        Car carOne = new Car();
        carOne.carDetails("Toyota");
        carOne.carDetails(2015);
        carOne.carDetails(200.30);
        System.out.println("\n");


        Bike bike = new Bike();
        bike.bikeDetails("Pulsar");
//        Method overloading
        bike.bikeDetails("Pulsar ", 160);
        //        Method overloading
        bike.bikeDetails("Pulsar N", 160, 279500.20);

    }
}
