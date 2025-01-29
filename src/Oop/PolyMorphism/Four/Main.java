package Oop.PolyMorphism.Four;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle;
        System.out.print
                ("To Know my favorite vehicle choose '1 for Car' and '2 for bike': ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            vehicle = new Car();
            vehicle.favorite();

        } else if (choice == 2) {
            vehicle = new Bike();
            vehicle.favorite();
        }
        scanner.close();
    }
}
