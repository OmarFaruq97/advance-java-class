package Oop.PolyMorphism.Two;

public class Bike {

    public void bikeDetails(String name) {
        System.out.println("My Favorite bike: " + name);
    }
    //Method must be different parameter. If parameter same it will error
    public void bikeDetails(String name, int model) {
        System.out.println(name + "Bike Model N" + model);
    }

    public void bikeDetails(String name, int model, double price) {
        System.out.println(name + model + " Price: " + price + " Taka");
    }
}
